import java.util.concurrent.Semaphore;

public class Concesionario {
    
    public static void main(String[] args){
        //Definición de constantes
        final int NUM_CLIENTES = 9;
        final int NUM_COCHES = 4;
        
        Semaphore semaforo = new Semaphore(NUM_COCHES);
        
        boolean[] coches = new boolean[NUM_COCHES];
        
        System.out.println("--- APERTURA DEL CONCESIONARIO ---");
        System.out.println("Disponemos de " + NUM_COCHES + " vehículos para " + NUM_CLIENTES + " clientes.");
        System.out.println("----------------------------");
        
        for (int i = 1; i<= NUM_CLIENTES; i++){
            Cliente c = new Cliente(i, semaforo, coches);
            
            c.start();
        }
        
    }
}
