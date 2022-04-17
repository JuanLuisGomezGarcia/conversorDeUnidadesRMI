
package conversorDeUnidadesRMI;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
public class ServerConversor {
    
public static void main(String args[]) throws RemoteException{
  
//Creamos el registro
Registry registry = LocateRegistry.createRegistry(5555);
//Creamos el objeto 
Conversor obj = new ImplConversor();
//Registramos el objeto
registry.rebind("Conversor", obj);
System.out.println("Conexion establecida");}}
