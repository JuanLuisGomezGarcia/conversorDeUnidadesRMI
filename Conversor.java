
package conversorDeUnidadesRMI;
import java.rmi.Remote;
import java.rmi.RemoteException;
//Creamos la interfaz remota
public interface Conversor extends Remote{
//Creamos los metodos que usara el interfaz
public String conversionBinario(int numeroRecivido)throws RemoteException;
public String conversionOctal(int numeroRecivido)throws RemoteException;
public String conversionHexadecimal(int numeroRecivido)throws RemoteException;}



