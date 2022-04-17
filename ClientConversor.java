
package conversorDeUnidadesRMI;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientConversor {
private ClientConversor(){}
public static void main(String args[]) throws RemoteException, NotBoundException, IOException{

//Obtenemos registro
Registry registry = LocateRegistry.getRegistry("localhost",5555);
//Buscamos el objeto 
Conversor obj = (Conversor)registry.lookup("Conversor");
//Llamamos a los metodos
String claveSwitchWhile = "";

//Generamos un conjunto de variables que usaremos en el mecanismo de la aplicacion
int numeroElegido = -1;
String resultadoConversion = "";
//Este while controla el flujo para ponerle fin a al aplicacion
while(!"FIN".equals(claveSwitchWhile)){
System.out.println("B-Convertir numero a binario "
+ "\nO-Convertir numero a octal" 
+ "\nH-Convertir numero a hexadecimal"
+ "\nFIN-Para finalizar");
//Pedimos la letra           
claveSwitchWhile = pedirLetra();

//Introducimos la letra en un switch donde llamamos a la funcion relacionada
//con la letra y mostramos el resultado de la conversion por consola
switch(claveSwitchWhile){        
case "O": 
System.out.println("Introduce el numero que quieres convertir en octal");
numeroElegido = pedirInt();
resultadoConversion = obj.conversionOctal(numeroElegido);
System.out.println(resultadoConversion);;break;
case "B": 
System.out.println("Introduce el numero que quieres convertir en binario");
numeroElegido = pedirInt();
resultadoConversion = obj.conversionBinario(numeroElegido);
System.out.println(resultadoConversion);break;
case "H": 
System.out.println("Introduce el numero que quieres convertir en hexadecimal");
numeroElegido = pedirInt();
resultadoConversion = obj.conversionHexadecimal(numeroElegido);
System.out.println(resultadoConversion);break;}}}  
    
//Fucion para pedir la letra
public static String pedirLetra() throws IOException{
    String letraRetornar="";    
    while(!"O".equals(letraRetornar)&& !"H".equals(letraRetornar)&& !"B".equals(letraRetornar)&& !"FIN".equals(letraRetornar) ){        
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    letraRetornar = br.readLine(); 
    if(!"O".equals(letraRetornar)&& !"H".equals(letraRetornar)&& !"B".equals(letraRetornar)&& !"FIN".equals(letraRetornar) ){
    System.out.println("Por favor introusca un valor existente recuerde introducir el valor en mayusculas");}}
    return letraRetornar;} 

//Fucion para pedir int
public static int pedirInt() throws IOException{
int numeroRetornar=0;int clave_pedirInt;
do{ clave_pedirInt=0;
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
String brm = br.readLine();
numeroRetornar = Integer.parseInt(brm);
if(numeroRetornar<0){
System.out.println("Introdusca un valor positivo");
clave_pedirInt=-1;}
}while(!(clave_pedirInt==0));
return numeroRetornar;}}
