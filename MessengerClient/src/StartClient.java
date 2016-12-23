/**
 * @author David
 */
import MessengerApp.*;

import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;

public class StartClient {

	public static void main(String args[]) {
		try{
			// Initializing ORB and CORBA objects
			ORB orb = ORB.init(args, null);
			org.omg.CORBA.Object objRef =   orb.resolve_initial_references("NameService");
			NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
			Messenger messenger = (Messenger) MessengerHelper.narrow(ncRef.resolve_str("ABC"));

			Scanner c=new Scanner(System.in);
			System.out.println("Welcome to the messenger app:\n");
			
			// Nickname
			System.out.println("Enter your name:");
			String pseudo = c.nextLine();
			messenger.connect(pseudo);

			// Receiver
			System.out.println("Who do you want to text:");
			String reciever = c.nextLine();
			
			for(;;){ // Infinite loop
				System.out.print(pseudo + "@" + reciever + ">"); // Prompt
				String message = c.nextLine();
				
				switch(message){
					// Get my messages
					case "":
						Message[] messages = messenger.getMessages(pseudo);
						for(int i = 0; i < messages.length; i++){
							System.out.println(messages[i]);
						}
						break;
					case "#pseudo":
						messenger.disconnect(pseudo);
						System.out.println("Enter your name:");
						pseudo = c.nextLine();
						messenger.connect(pseudo);
						break;
					case "#exit":
						messenger.disconnect(pseudo);
						break;
					case "#to":
						System.out.println("Who do you want to text:");
						reciever = c.nextLine();
						break;
					case "#clients":
						String[] clients = messenger.getClients();
						for(int i = 0; i < clients.length; i++){
							System.out.println("\t" + clients[i]);
						}
						break;
					case "#help":
						System.out.println("\t#clients\tGets all connected clients");
						System.out.println("\t#exit\tDisconnects your client");
						System.out.println("\t#help\tGets help");
						System.out.println("\t#pseudo\tChanges your nickname");
						System.out.println("\t#to\tChange the reciever of your message");
						System.out.println("\tEmpty string\tGets your messages");
						System.out.println();
						break;
					default:
						messenger.sendMessage(new Message(pseudo, reciever, message, ""));
				}
			}
		}
		catch (Exception e) {
			System.out.println("Messenger Client exception: " + e);
			e.printStackTrace();
		}

	}

}