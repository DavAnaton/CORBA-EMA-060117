package MessengerApp;


/**
* MessengerApp/MessengerHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Messenger.idl
* mardi 20 d�cembre 2016 15 h 09 CET
*/

abstract public class MessengerHelper
{
  private static String  _id = "IDL:MessengerApp/Messenger:1.0";

  public static void insert (org.omg.CORBA.Any a, MessengerApp.Messenger that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static MessengerApp.Messenger extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (MessengerApp.MessengerHelper.id (), "Messenger");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static MessengerApp.Messenger read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_MessengerStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, MessengerApp.Messenger value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static MessengerApp.Messenger narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof MessengerApp.Messenger)
      return (MessengerApp.Messenger)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      MessengerApp._MessengerStub stub = new MessengerApp._MessengerStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static MessengerApp.Messenger unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof MessengerApp.Messenger)
      return (MessengerApp.Messenger)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      MessengerApp._MessengerStub stub = new MessengerApp._MessengerStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
