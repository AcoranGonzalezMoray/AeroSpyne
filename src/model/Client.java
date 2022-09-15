package model;


public class Client {
    
    private String name;
    private String surname;
    private String email;
    private String password;
    private String DNI;
    private String telephone;

    public Client(String name, String surname, String email, String password, String clienDNI, String telephone) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.DNI = clienDNI;
        this.telephone = telephone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getClientDNI(){
        return DNI;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Name: "+this.name+" "+this.surname+"  DNI: "+this.DNI+"\n  Email: "+this.email+" Password: "+this.password+"\n  Telephone: "+this.telephone;
    }

    

}
