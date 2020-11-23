import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Tolva implements Runnable{
    private final Integer numTol;
    private final Elemento elOne, elTwo, elThree, elFour, elFive;
    private final Elemento lista[];
    Random random = new Random();
    Transporte trans;

    public Tolva(Integer numTol, Transporte trans) {
        this.numTol = numTol;
        this.trans = trans;
        elOne = new Elemento(1, numTol);
        elTwo = new Elemento(2, numTol);
        elThree = new Elemento(3, numTol);
        elFour = new Elemento(4, numTol);
        elFive = new Elemento(5, numTol);
        lista = new Elemento[]{elOne, elTwo, elThree, elFour, elFive};

    }

    @Override
    public void run() {
        for(Elemento el:lista){
            System.out.printf("Elemento %d de la tolva %d está listo\n", el.numEl, el.numTol);
        }
        try{
            for(Elemento el:lista){
                TimeUnit.SECONDS.sleep(random.nextInt(2)+1);
                trans.addToCinta(el);
                System.out.printf("La %da tolva ha añadido su elemento #%d a la cinta\n", el.numTol, el.numEl);
            }
        }catch (InterruptedException e) {
            System.out.printf("La tolva %d ha sido interrumpida mientras colocaba elementos en la cinta transportadora\n",numTol);
            return;
        }






    }
}
