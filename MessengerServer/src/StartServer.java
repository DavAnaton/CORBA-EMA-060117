/**
 *
 * @author David
 */
import MessengerApp.*;
 
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;
import java.util.Properties;
 
public class StartServer {
 
  public static void main(String args[]) {
    try{
      // create and initialize the ORB //// get reference to rootpoa &amp; activate the POAManager
      ORB orb = ORB.init(args, null);      
      POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
      rootpoa.the_POAManager().activate();
 
      // create servant and register it with the ORB
      MessengerImpl messImpl = new MessengerImpl();
      messImpl.setORB(orb); 
 
      // get object reference from the servant
      org.omg.CORBA.Object ref = rootpoa.servant_to_reference(messImpl);
      Messenger href = MessengerHelper.narrow(ref);
 
      org.omg.CORBA.Object objRef =  orb.resolve_initial_references("NameService");
      NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
 
      NameComponent path[] = ncRef.to_name( "ABC" );
      ncRef.rebind(path, href);
 
      System.out.println("Messenger Server ready and waiting ...");
      messImpl.connect("David");
      messImpl.connect("Ben");
      messImpl.connect("Math");
      messImpl.connect("David");
      String[] clients = messImpl.getClients();
      System.out.println(clients[0]);
      // wait for invocations from clients
      for (;;){
	  orb.run();
      }
    } 
 
      catch (Exception e) {
        System.err.println("ERROR: " + e);
        e.printStackTrace(System.out);
      }
 
      System.out.println("HelloServer Exiting ...");
 
  }
}