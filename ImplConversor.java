
package conversorDeUnidadesRMI;
import java.rmi.*;
import java.rmi.server.*;

//Implementamos la interfaz remota y su constructor
public class ImplConversor extends UnicastRemoteObject implements Conversor{
public ImplConversor()throws RemoteException{super();}

//Esta funcion convierte el numero elegido en binario
@Override
public String conversionBinario(int numeroRecivido) throws RemoteException {
//Esta variable la iremos rellenando mientras dividimos el numero introducido
String binario = "";
//Mietras el numero introducido sea mayor de cero seguimos añadiendo numero al string a retornar
while (numeroRecivido > 0) {
//Dividimos el numero entre multiplo de dos recivido para obtener 0 o 1
short residuo = (short) (numeroRecivido % 2);
//Tambien dividimos el numero inicial para ir reduciendolo
numeroRecivido = numeroRecivido / 2;
// Insertamos el dígito al inicio de la cadena
binario = binario + residuo;}
return binario;}

//Esta funcion convierte el numero elegido en octal
@Override
public String conversionOctal(int numeroRecivido) throws RemoteException {
//Esta variable la iremos rellenando mientras dividimos el numero introducido
String octal = "";
//Este string contiene los caracteres que introduciremos al string a retornar
String caracteresOctales = "01234567";
//Mietras el numero introducido sea mayor de cero seguimos añadiendo numero al string a retornar
while(numeroRecivido > 0) {
//Conseguimos el numero multiplo de 8
int residuo = numeroRecivido % 8;
// El residuo es lo que se suma, y podemos usarlo como índice
octal = (caracteresOctales.charAt(residuo) + octal);
//Tambien dividimos el numero inicial para ir reduciendolo a cero
numeroRecivido /= 8;}return octal;}

@Override
public String conversionHexadecimal(int numeroRecivido) throws RemoteException {
//Esta variable la iremos rellenando mientras dividimos el numero introducido
String hexadecimal = "";
//Este string contiene los caracteres que introduciremos al string a retornar
String caracteresHexadecimales = "0123456789abcdef";
//Mietras el numero introducido sea mayor de cero seguimos añadiendo numero al string a retornar
while (numeroRecivido > 0) {
    //Conseguimos el numero multiplo de 16
int residuo = numeroRecivido % 16;
// El residuo es lo que se suma, y podemos usarlo como índice
hexadecimal = caracteresHexadecimales.charAt(residuo) + hexadecimal;
//Tambien dividimos el numero inicial para ir reduciendolo
numeroRecivido /= 16;}
return hexadecimal;}}
