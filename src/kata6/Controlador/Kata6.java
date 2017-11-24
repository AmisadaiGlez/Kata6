package kata6.Controlador;

import java.io.IOException;
import java.util.List;
import kata6.Modelo.Histogram;
import kata6.Modelo.Mail;
import kata6.Vista.HistogramDisplay;
import kata6.Vista.HistogramBuilder;
import kata6.Vista.FileListReader;

public class Kata6 {
    
/*
Se modifica la clase de Control, Kata4, usando el patrón de
diseño CIPO: se deben crear los módulos de control execute(), de
entrada input(), de proceso process() y de salida output().
*/

    
    
    private Attribute attribute;
    String nameFile="";
    private List<Mail> fileList;
    private Histogram<String> histogram;
    private Histogram<String> firstChar;
    private HistogramBuilder<Mail> builder;
    private Histogram<String> domains;
    private Histogram<Character> letters; 
   
    public static void main(String[] args) throws IOException {
      Kata6 kata6=new Kata6();
      kata6.execute();
    }

    void execute() throws IOException {
        input();
        process();
        output();
    }
    
    void input() throws IOException {
        nameFile = "emails.txt";
        fileList=FileListReader.read(nameFile);
    }
    
    void process() {
        builder = new HistogramBuilder(fileList);
        domains = builder.build(new Attribute<Mail, String>() {
            @Override
            public String get(Mail item) {
                return item.getMail().split("@")[1];
            }
        });
        
        letters = builder.build(new Attribute<Mail,
        Character>() {
            @Override
            public Character get(Mail item) {
                return item.getMail().charAt(0);
            }
        });
    }
    
    void output() {
        HistogramDisplay histoDisplay = new HistogramDisplay(domains,"Dominios");
        histoDisplay.execute();
        histoDisplay = new HistogramDisplay(letters,"Caracteres");
        histoDisplay.execute();
    }
    
}
