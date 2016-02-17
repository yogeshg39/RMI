
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class FileServer {
   public static void main(String argv[]) {
      if(System.getSecurityManager() == null) {
         System.setSecurityManager(new RMISecurityManager());
      }
      try {
    	  Registry reg=LocateRegistry.createRegistry(2500);
         FileInterface fi = new FileImpl("FileServer");
         Naming.rebind("//127.0.0.1/FileServer", fi);
      } catch(Exception e) {
         System.out.println("FileServer: "+e.getMessage());
         e.printStackTrace();
      }
   }
}