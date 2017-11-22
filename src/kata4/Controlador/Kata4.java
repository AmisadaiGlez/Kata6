package kata4.Controlador;

import java.io.IOException;
import java.util.List;
import kata4.Modelo.Histogram;
import kata4.Modelo.Mail;
import kata4.Vista.HistogramDisplay;
import kata4.Vista.MailHistogramBuilder;
import kata4.Vista.MailListReader;

public class Kata4 {
    
/*
Se modifica la clase de Control, Kata4, usando el patrón de
diseño CIPO: se deben crear los módulos de control execute(), de
entrada input(), de proceso process() y de salida output().
*/

    
    private List<Mail> mailList;
    private Histogram<String> histogram;
   
    public static void main(String[] args) throws IOException {
      Kata4 kata4=new Kata4();
      kata4.execute();
    }
    
    void execute() throws IOException {
        input();
        process();
        output();
    }
    
    void input() throws IOException {
        String fileName="emails.txt";
        mailList=MailListReader.read(fileName);
    }
    
    void process() {
        histogram = MailHistogramBuilder.build(mailList);
    }
    
    void output() {
        HistogramDisplay histoDisplay = new HistogramDisplay(histogram);
        histoDisplay.execute();
    }
    
}
