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

import java.util.ArrayList;
import java.util.Properties;

class MessengerImpl extends MessengerPOA {
	private ORB orb;

	private ArrayList<String> clients = new ArrayList();
	private ArrayList<Message> messages = new ArrayList();

	public void setORB(ORB orb_val) {
		orb = orb_val; 
	}

	public void connect (String pseudo){
		if(clients.indexOf(pseudo) == -1){
			clients.add(pseudo);
		}
	}
	public void disconnect (String pseudo){
		clients.remove(clients.indexOf(pseudo));
	}
	public String[] getClients (){
		String[] list = new String[clients.size()];
		list = clients.toArray(list);
		return list;
	}
	public void sendMessage (MessengerApp.Message message){
		messages.add(message);
	}
	public MessengerApp.Message[] getMessages (String pseudo){
		Message[] list = new Message[messages.size()];
		list = messages.toArray(list);
		return list;
	}
	public void shutdown (){
		orb.shutdown(false);
	}

}