package org.juanfranciscomateo.generacadenas;

import java.util.Random;

public class GeneraCadenas {
    public static void main(String[] args) {
        //Comprobacines para excepciones
        //si no se indica un numero (Vacio).
        if (args.length != 1) {
            //imprimimos la excepcion
            System.err.println("ERROR: Vacio, indica un valor");
            return;
        }
        //si lo que se indica no es un numero
        int nCadenas;

        try {
            //pasamos el argumento proporcionado a int, de no ser posible return
            nCadenas = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            //imprimimos excepcion
            System.out.println("ERROR: El valor debe ser un número entero.");
            return;
        }
        //imprimimo mi nombre y apellidos
        System.out.println("Juan Francisco Mateo Garcia");
        //hacemos un loop, y ejecutamos el metodo donde elige aleatoriamente un palabra de una lista
        //de 10 palabras
        for (int i = 1; i < nCadenas; i++) {
            System.out.println(imprimirCadenaAleatoria());
        }
        //imprimimos FIN para mostrar la finalicacion exitosa del programa
        System.out.println("FIN");
    }

    private static String imprimirCadenaAleatoria() {
        //se utiliza random para generar un numero aleatorio cada vez que se ejecuta este metodo
        Random aleatorio = new Random();
        //de la colecion elegimos una de las cadenas con el numero aleatorio
        String cadenaAleatoria = Cadenas[aleatorio.nextInt(Cadenas.length)];
        //devolvemos la cadena con la palabra
        return cadenaAleatoria;
    }

    //coleccion de cadenas
    private static final String[] Cadenas = {
            "tecnologia",
            "programacion",
            "videojuegos",
            "blender",
            "godot",
            "java",
            "emulador",
            "procesador",
            "cadenas",
            "jar",
            "maven",
            "robot",
            "arduino",
            "servicio",
            "sistema",
            "caracter",
            "pantalla",
            "red",
            "consola",
            "internet",
            "C++",
            "ram",
            "Carlos III"
    };
}
