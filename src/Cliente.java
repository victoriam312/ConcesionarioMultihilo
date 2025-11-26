import java.util.concurrent.Semaphore;

//Heredamos de Thread
public class Cliente extends Thread{
    
    private int idCliente;
    private Semaphore semaforo;
    private boolean[] coches; //Array para saber qué coches están libres (true) u ocupados (false)
    
    public Cliente(int idCliente, Semaphore semaforo, boolean[] coches){
        this.idCliente = idCliente;
        this.semaforo = semaforo;
        this.coches = coches;
    }
    
    @Override
    public void run(){
        try{
            //Si no hay permisos (0), el hilo se bloquea aquí esperando
            semaforo.acquire();
            
            int cocheSeleccionado = -1;
            
            synchronized(coches){
                for(int i = 0; i < coches.length; i++){
                    if(!coches[i]){
                        coches[i] = true;
                        cocheSeleccionado = i + 1;
                        System.out.println("Cliente " + idCliente + "... probando vehículo " + cocheSeleccionado);
                        break;
                    }
                }
            }
            //Sleep detiene el hilo unos milisegundos
            Thread.sleep((long) (Math.random() * 5000) + 1000); //entre 1 y 6 segundos
            
            synchronized (coches){
                coches[cocheSeleccionado - 1] = false;
                System.out.println("Cliente " + idCliente + "... terminó de probar el vehículo " + cocheSeleccionado);
            }
            
            semaforo.release();
            
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
