
package kata6.Modelo;
public class Mail {
    
    private final String mail;
    private final Integer id;

    public Mail(Integer id,String mail) {
        this.mail = mail;
        this.id = id;
    }
    
    public Integer getId() {
        return id;
    }

    public String getMail() {
        return mail;
    }
    /*public String getDomain() {
        String[] res = mail.split("@");
        return res[1];
    }*/
}
