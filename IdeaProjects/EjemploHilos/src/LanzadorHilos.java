class TareaCompleja implements Runnable{
    @Override
    public void run() {
        Thread hiloActual=Thread.currentThread();
        String miNombre=hiloActual.getName();
        int n = Integer.parseInt(miNombre);

        for (int i=2; i<n;i++){
            if(n%i == 0) {
                System.out.println("EL número " + n + "No es primo");
                break;
            }
            if(n-1 == i) {
                System.out.println("EL número " + n + "Es primo");
                break;
            }
        }
        System.out.println(
                "Finalizado el hilo"+miNombre);
    }
}

public class LanzadorHilos {
    public static void main(String[] args) {
        int NUM_HILOS=100;
        Thread[] hilosAsociados;

        hilosAsociados=new Thread[NUM_HILOS];
        for (int i=0;i<NUM_HILOS;i++){
            TareaCompleja t=new TareaCompleja();
            Thread hilo=new Thread(t);
            hilo.setName(String.valueOf(i));

            hilo.start();
            System.out.println(
                    "Comenzado el hilo"+hilo.getName());
            hilosAsociados[i]=hilo;
        }

        for (int i=0; i<NUM_HILOS; i++){
            Thread hilo=hilosAsociados[i];
            try {
                hilo.join();
            } catch (InterruptedException e) {
                System.out.print("Algun hilo acabó ");
                System.out.println(" antes de tiempo!");
            }
        }
        System.out.println("El principal ha terminado");
    }
}