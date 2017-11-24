package kata6.Vista;

import java.util.List;
import kata6.Controlador.Attribute;
import kata6.Modelo.Histogram;


public class HistogramBuilder<T> {
    
    private final List<T> items;
    
    public HistogramBuilder(List<T> items){
        this.items = items;
    }
    
    public <A>Histogram<A> build(Attribute<T,A> attribute) {
        Histogram<A> histo= new Histogram<>();
        for (T item : items) {
            A value = attribute.get(item);
            histo.increment(value);
        }
        return histo;
    }
    
}
