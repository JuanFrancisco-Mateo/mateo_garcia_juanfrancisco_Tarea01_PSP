# Tarea Tuneles programacion de servicios
Tarea 01 de programacion de servicios y procesos.
Los programas se encuentran compilados en la carpeta JAR

El ejercicio 1 consiste en crear dos programas y conectarlos con un tunel por consola.
## Proyecto GeneraCadenas
Para ejecutar este programa necesitamos pasar obligatoriamente el numero de cadenas que queremos por argumentos, de lo contrario nos arroja un error.

Cuando ejecutes el programa si o si hay que usar un numero entero
	
## Proyecto Mayusculas
Cuando ejecutamos el programa de manera aislada, podemos escribir cadenas de texto y estas seran almacenadas en memoria para luego ser convertidas a mayusculas.

Una vez hayamos escrito todas las cadenas escribimos la palabra FIN para terminar de ejecutar el programa y que nos de las cadenas en mayusculas.

## Tunel entre ambos
Se pueden usar ambos programas con el siguiente comando:

	java -jar .\GeneraCadenas.jar 10 | java -jar .\Mayusculas.jar


El ejercicio 2 consiste en crear un lanzador y un proceso que sera lanzado con el primer programa.
# Tarea Lanzador + Proceso
## Proyecto Proceso
Este proyecto se puede ejecutar solo si se introducen 3 argumentos. El primero es el nombre del proceso que queremos crear, el segundo cuantos pares queremos para ese proceso, y el tercero el nombredel archivo de texto donde queremos escribir esta salida.

## Proyecto Lanzador + Proceso
Lanzador usa el programa “Proceso” para lanzar 10 procesos que cada uno estara encargado de producir su correspondiente numero de pares basado en el orden del proceso, por ejemplo:

	Proceso1 = proceso1 1 salida.txt
	Proceso2 = proceso2 2 salida.txt
	etc
	
Y los escribe en un fichero común, de manera paralela y según el orden que elija el SO.
