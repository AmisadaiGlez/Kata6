package kata6.Controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import kata6.Modelo.Histogram;
import kata6.Modelo.Mail;
import kata6.Modelo.Person;
import kata6.Vista.DataBaseList;
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
    String nameFile;
    private List<Mail> fileList;
    private HistogramBuilder<Mail> builder;
    private Histogram<String> domains;
    private Histogram<Character> letters; 
    private HistogramDisplay histoDisplay;
    private List<Person> people;
    private HistogramBuilder<Person> builderPerson; 
    private Histogram<Character> genders;
    private Histogram<Float> weights;
   
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException{
      Kata6 kata6=new Kata6();
      kata6.execute();
    }

    void execute() throws IOException, ClassNotFoundException, SQLException {
        input();
        process();
        output();
    }
    
    void input() throws IOException, ClassNotFoundException, SQLException {
        nameFile = "emails.txt";
        fileList = FileListReader.read(nameFile);
        people = DataBaseList.read();
    }
    
    void process() {
        builder = new HistogramBuilder(fileList);
        builderPerson = new HistogramBuilder(people);
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
        
        genders = builderPerson.build(new Attribute<Person, Character>(){
            @Override
            public Character get(Person item) {
                return item.getGender();
            }
        });
        
        weights = builderPerson.build(new Attribute<Person, Float>(){
            @Override 
            public Float get(Person item) {
                return item.getWeight();
            }
        });
    }
    
    void output() {
        histoDisplay = new HistogramDisplay(domains,"Dominios");
        histoDisplay.execute();
        histoDisplay = new HistogramDisplay(letters,"Caracteres");
        histoDisplay.execute();
        histoDisplay = new HistogramDisplay(genders,"Géneros");
        histoDisplay.execute();
        histoDisplay = new HistogramDisplay(weights,"Pesos");
        histoDisplay.execute();
    }
    
}
