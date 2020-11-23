import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Separadora implements Runnable{
    private final Transporte trans;
    private Elemento el;
    Random random = new Random();

    public Separadora(Transporte trans) {
        this.trans = trans;
    }

    @Override
    public void run() {
        System.out.println("La separador ha empezado a funcionar");
        try{
            while (true){
                TimeUnit.SECONDS.sleep(random.nextInt(2)+1);
                el = trans.extractFromCinta();
                if (el == null){
                    System.out.println("La separadora ha extraído todos los elementos y, por tanto, dejará de funcionar.");
                    return;
                }else{
                    System.out.printf("La separadora ha clasificado el elemento %d de la tolva %d\n",el.numEl, el.numTol);
                }
            }
        }catch (InterruptedException e) {
            System.out.println("La separadora ha sido interrumpida mientras separaba elementos de la cinta");
            return;
        }
    }
}
