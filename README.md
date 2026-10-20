# Concesionario Multihilo 

Trabajo de enfoque para la asignatura de **Programación de Servicios y Procesos (PSP)** del ciclo DAM.

## Descripción
Simulación de un sistema de gestión de recursos limitados utilizando programación concurrente en Java. El proyecto controla el acceso de **9 clientes** (hilos) a una flota de **4 vehículos** (recursos) disponibles.

## Tecnologías
* **Lenguaje:** Java
* **Concurrencia:** Clase `Thread`
* **Sincronización:** `Semaphore` y bloque `synchronized` (Monitores)

## Cómo ejecutarlo

Con NetBeans: abrir el proyecto y ejecutar la clase principal `Concesionario`.

Desde la terminal:

```bash
javac -d out src/*.java
java -cp out Concesionario
```

Salida de ejemplo (el orden cambia en cada ejecución, porque los hilos compiten por los vehículos):

```
--- APERTURA DEL CONCESIONARIO ---
Disponemos de 4 vehículos para 9 clientes.
----------------------------
Cliente 1... probando vehículo 1
Cliente 4... probando vehículo 2
Cliente 3... probando vehículo 3
Cliente 2... probando vehículo 4
Cliente 1... terminó de probar el vehículo 1
```

## Funcionamiento
El programa inicia 9 hilos simultáneos. Mediante un semáforo de 4 permisos, se gestiona la cola de espera para probar los vehículos, garantizando que nunca se supere el aforo máximo.
