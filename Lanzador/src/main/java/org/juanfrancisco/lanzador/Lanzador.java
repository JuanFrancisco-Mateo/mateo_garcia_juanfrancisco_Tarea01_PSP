package org.juanfrancisco.lanzador;

import java.io.File;

public class Lanzador {
    //lanzador principal, se encarga de lanzar los procesos en paralelo
    public static void main(String[] args) {
        //declarando variables para indicar el nombre del proceso.jar y el nombre del fichero de salida
        String proceso_jar = "Proceso.jar";
        String archivo_Salida = "ficheroResultado.txt";
        int numeroProcesos = 10; // numero de procesos que se van a abrir en este caso 10

        try {
            //Borrar archivo anterior, para que la salida sea limpia y facil de comprobar que hace lo que se pide,
            // se puede dejar comentado y la salida se agregara al final del archivo ya creado
            new File(archivo_Salida).delete();

            Process[] procesos = new Process[numeroProcesos];

            // Lanzar todos los procesos en paralelo
            for (int i = 1; i <= numeroProcesos; i++) {
                String nombreProceso = "proceso" + i;
                String numPares = Integer.toString(i);
                String comando = "java -jar " + proceso_jar + " " + nombreProceso + " " + numPares + " " + archivo_Salida;
                //ejecutamos
                procesos[i-1] = Runtime.getRuntime().exec(comando);
                System.out.println(comando);
            }

            // Esperar que todos terminen
            for (Process p : procesos) {
                p.waitFor();
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}