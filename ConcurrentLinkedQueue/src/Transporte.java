import java.util.concurrent.ConcurrentLinkedQueue;

public class Transporte {
    private final ConcurrentLinkedQueue<Elemento> cinta = new ConcurrentLinkedQueue<>();

    public void addToCinta(Elemento el){
        cinta.add(el);
    }

    public Elemento extractFromCinta(){
        return cinta.poll();
    }
}
