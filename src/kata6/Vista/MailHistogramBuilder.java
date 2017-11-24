package kata6.Vista;

import java.util.List;
import kata6.Modelo.Histogram;
import kata6.Modelo.Mail;


public class MailHistogramBuilder {
    
    public static Histogram<String> build(List<Mail> mail) {
        Histogram<String> histo= new Histogram<String>();
        for (Mail mail1 : mail) {
            histo.increment(mail1.getDomain());
        }
        return histo;
    }
    
}
