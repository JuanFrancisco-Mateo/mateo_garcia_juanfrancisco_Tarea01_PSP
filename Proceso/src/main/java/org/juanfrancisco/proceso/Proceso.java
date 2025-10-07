package org.juanfrancisco.proceso;

import java.io.RandomAccessFile;
import java.io.File;
import java.io.IOException;
import java.nio.channels.FileLock;

//aqui nos encargaremos de la creacion del proceso y de como lee y escribe el archivo con FileLock para
//poder acceder de forma sincronizada al mismo aunque se ejecuten muchos procesos a la vez
public class Proceso {
    public static void main(String[] args) {
        //comrobamos que se hace uso correcto del programa
        if (args.length != 3) {
            System.out.println("Uso: java -jar ProcesoPares.jar <nombre> <cantidad> <archivo>");
            return;
        }
        //declaracion de variables
        String nombre = args[0];
        int numeropares = Integer.parseInt(args[1]);
        String archivo = args[2];

        File file = new File(archivo);
        //manejamos con loops y try para gestionar errores inesperados
        try {
            //si el archivo no existe lo creamos
            if (!file.exists()) {
                file.createNewFile();
            }

            // Escribir cada par con bloqueo de fichero, lo que nos permite que si hay muchos procesos
            // estos no quieran pisarse los unos con los otros
            for (int i = 1; i <= numeropares; i++) {
                int parActual = i * 2;

                try (RandomAccessFile raf = new RandomAccessFile(file, "rw")) {
                    //bloqueamos el fichero
                    FileLock bloqueo = raf.getChannel().lock();

                    try {
                        // Ir al final del archivo
                        raf.seek(raf.length());

                        // Escribimos nombre del proceso y el par
                        raf.writeBytes(nombre + System.lineSeparator());
                        raf.writeBytes(Integer.toString(parActual) + System.lineSeparator());

                    } finally {
                        // Liberar el bloqueo
                        if (bloqueo != null) {
                            bloqueo.release();
                        }
                    }

                } catch (IOException e) {
                    System.out.println("Error en proceso " + nombre + ": " + e.getMessage());
                }

                //Pequeña pausa entre pares para dar oportunidad a otros procesos, simplemente para rendimiento
                // optimo
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    // ignorar
                }
            }

        } catch (IOException e) {
            System.out.println("Error creando archivo: " + e.getMessage());
        }
    }
}
