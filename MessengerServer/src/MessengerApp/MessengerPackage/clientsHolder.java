package MessengerApp.MessengerPackage;


/**
* MessengerApp/MessengerPackage/clientsHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Messenger.idl
* mardi 20 d�cembre 2016 15 h 09 CET
*/

public final class clientsHolder implements org.omg.CORBA.portable.Streamable
{
  public String value[] = null;

  public clientsHolder ()
  {
  }

  public clientsHolder (String[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = MessengerApp.MessengerPackage.clientsHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    MessengerApp.MessengerPackage.clientsHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return MessengerApp.MessengerPackage.clientsHelper.type ();
  }

}
