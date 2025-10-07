package org.juanfrancisco.mayusculas;

//vamos a usar un scanner, pues en el ejemplo de como debe funcionar el programa debe leer las cadenas que le
//introducimos hasta escribir "FIN"
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Mayusculas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> palabras = new ArrayList<>();
        //loop que se encargara de esperar la entrada del usuario (o la salida del otro programa) e ir almacenando
        //esto para luego imprimirlo de vuelta
        while (sc.hasNextLine()){
            //almacenamos la cadena del usuario
            String cadena = sc.nextLine();
            if (cadena.equals("FIN")){
                //si la palabra es FIN no guardamos esta y cortamos
                break;
            } else {
                //de lo contrario la guardamos en la coleccion
                palabras.add(cadena);
            }
        }
        //cerramos scanner
        sc.close();

        //imprimimos las cadenas que el usuario o el otro programa nos ha proporcionado
        for (String palabra : palabras){
            System.out.println(palabra.toUpperCase());
        }
    }
}
