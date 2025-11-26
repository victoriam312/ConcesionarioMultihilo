# Concesionario Multihilo 

Trabajo de enfoque para la asignatura de **Programación de Servicios y Procesos (PSP)** del ciclo DAM.

## Descripción
Simulación de un sistema de gestión de recursos limitados utilizando programación concurrente en Java. El proyecto controla el acceso de **9 clientes** (hilos) a una flota de **4 vehículos** (recursos) disponibles.

## Tecnologías
* **Lenguaje:** Java
* **Concurrencia:** Clase `Thread`
* **Sincronización:** `Semaphore` y bloque `synchronized` (Monitores)

## Ejecución
El programa inicia 9 hilos simultáneos. Mediante un semáforo de 4 permisos, se gestiona la cola de espera para probar los vehículos, garantizando que nunca se supere el aforo máximo.
