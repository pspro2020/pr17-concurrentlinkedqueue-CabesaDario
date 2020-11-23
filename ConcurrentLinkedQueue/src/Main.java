import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException{

        Random random = new Random();
        Transporte trans = new Transporte();

        for (int i=1;i < 6; i++){
            Thread hilo = new Thread(new Tolva(i, trans));
            hilo.start();
        }
        TimeUnit.SECONDS.sleep(random.nextInt(3)+1);

        Thread separThread = new Thread(new Separadora(trans));
        separThread.start();

    }
}
