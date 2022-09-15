package model;
public class PayPal extends Payment {
    private String userName;
    private String email;

    public PayPal(String userName, String email, String accountNumber, float amount){
        super(accountNumber, amount);
        this.userName = userName;
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "PayPal [email=" + email + ", userName=" + userName + "]";
    }

}