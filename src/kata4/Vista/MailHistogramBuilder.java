package kata4.Vista;

import java.util.List;
import kata4.Modelo.Histogram;
import kata4.Modelo.Mail;


public class MailHistogramBuilder {
    
    public static Histogram<String> build(List<Mail> mail) {
        Histogram<String> histo= new Histogram<String>();
        for (Mail mail1 : mail) {
            histo.increment(mail1.getDomain());
        }
        return histo;
    }
    
}
