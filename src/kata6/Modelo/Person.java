package kata6.Modelo;

public class Person {
    private final Integer id;
    private final String name;
    private final Character gender;
    private final String birthDate;
    private final Float weight;
    private final String mail;

    public Person(int id, String name, Character gender, String birthDate, Float weight, String mail) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.weight = weight;
        this.mail = mail;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Character getGender() {
        return gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public Float getWeight() {
        return weight;
    }
    
    public String getMail() {
        return mail;
    }
    
}
