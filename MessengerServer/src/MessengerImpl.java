/**
 *
 * @author David
 */
import MessengerApp.*;
import MessengerApp.MessengerPackage.clientsHolder;

import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

class MessengerImpl extends MessengerPOA {
	private ORB orb;

	private ArrayList<String> clients = new ArrayList();
	private ArrayList<Message> messages = new ArrayList();

	public void setORB(ORB orb_val) {
		orb = orb_val; 
	}
	
	// addes a client
	public void connect (String pseudo){
		clients.add(pseudo);
		System.out.println("New client: " + pseudo);
	}
	
	// removes a client
	public void disconnect (String pseudo){
		clients.remove(clients.indexOf(pseudo));
	}
	
	// gets all clients
	public String[] getClients (){
		String[] list = new String[clients.size()];
		list = clients.toArray(list);
		return list;
	}
	
	// sends a message
	public void sendMessage (MessengerApp.Message message){

		SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yy-HH:mm:ss");
		message.date = formater.format(new Date());		
		messages.add(message);
		System.out.println(messages.get(messages.size() - 1));
	}
	
	// gets all messages sent to a specific user
	public MessengerApp.Message[] getMessages (String pseudo){
		ArrayList<Message> forPseudo = new ArrayList();
		for(int i = 0; i < messages.size(); i++){
			if((messages.get(i).to).equals(pseudo)){
				forPseudo.add(messages.get(i));
			}
		}
		Message[] list = new Message[forPseudo.size()];
		list = forPseudo.toArray(list);
		return list;
	}
	
	// shuts the server down
	public void shutdown (){
		orb.shutdown(false);
	}

}