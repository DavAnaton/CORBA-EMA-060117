package MessengerApp;


/**
* MessengerApp/Message.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Messenger.idl
* mardi 20 d�cembre 2016 15 h 09 CET
*/

public final class Message implements org.omg.CORBA.portable.IDLEntity
{
  public String from = null;
  public String to = null;
  public String message = null;
  public String date = null;

  public Message ()
  {
  } // ctor

  public Message (String _from, String _to, String _message, String _date)
  {
    from = _from;
    to = _to;
    message = _message;
    date = _date;
  } // ctor
  public String toString(){
	  return this.date + "\t" + this.from + "@" + this.to + ">" + this.message;
  }
} // class Message
