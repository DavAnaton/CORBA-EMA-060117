package MessengerApp;


/**
* MessengerApp/MessengerPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Messenger.idl
* mardi 20 d�cembre 2016 15 h 09 CET
*/

public abstract class MessengerPOA extends org.omg.PortableServer.Servant
 implements MessengerApp.MessengerOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("connect", new java.lang.Integer (0));
    _methods.put ("disconnect", new java.lang.Integer (1));
    _methods.put ("getClients", new java.lang.Integer (2));
    _methods.put ("sendMessage", new java.lang.Integer (3));
    _methods.put ("getMessages", new java.lang.Integer (4));
    _methods.put ("shutdown", new java.lang.Integer (5));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // MessengerApp/Messenger/connect
       {
         String pseudo = in.read_string ();
         this.connect (pseudo);
         out = $rh.createReply();
         break;
       }

       case 1:  // MessengerApp/Messenger/disconnect
       {
         String pseudo = in.read_string ();
         this.disconnect (pseudo);
         out = $rh.createReply();
         break;
       }

       case 2:  // MessengerApp/Messenger/getClients
       {
         String $result[] = null;
         $result = this.getClients ();
         out = $rh.createReply();
         MessengerApp.MessengerPackage.clientsHelper.write (out, $result);
         break;
       }

       case 3:  // MessengerApp/Messenger/sendMessage
       {
         MessengerApp.Message message = MessengerApp.MessageHelper.read (in);
         this.sendMessage (message);
         out = $rh.createReply();
         break;
       }

       case 4:  // MessengerApp/Messenger/getMessages
       {
         String pseudo = in.read_string ();
         MessengerApp.Message $result[] = null;
         $result = this.getMessages (pseudo);
         out = $rh.createReply();
         MessengerApp.MessengerPackage.messagesHelper.write (out, $result);
         break;
       }

       case 5:  // MessengerApp/Messenger/shutdown
       {
         this.shutdown ();
         out = $rh.createReply();
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:MessengerApp/Messenger:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Messenger _this() 
  {
    return MessengerHelper.narrow(
    super._this_object());
  }

  public Messenger _this(org.omg.CORBA.ORB orb) 
  {
    return MessengerHelper.narrow(
    super._this_object(orb));
  }


} // class MessengerPOA
