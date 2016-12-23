package MessengerApp;


/**
* MessengerApp/MessengerOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Messenger.idl
* mardi 20 d�cembre 2016 15 h 09 CET
*/

public interface MessengerOperations 
{
  void connect (String pseudo);
  void disconnect (String pseudo);
  String[] getClients ();
  void sendMessage (MessengerApp.Message message);
  MessengerApp.Message[] getMessages (String pseudo);
  void shutdown ();
} // interface MessengerOperations
