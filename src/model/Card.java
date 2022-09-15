package model;
public class Card extends Payment{
    private String ownersName;
    private Date expirationDate;
    private int securityCode;


    public Card(String ownersName, Date expirationDate, int securityCode, String accountNumber, float amount){
        super(accountNumber, amount);
        this.ownersName = ownersName;
        this.expirationDate = expirationDate;
        this.securityCode = securityCode;
    }

    public String getOwnersName() {
        return ownersName;
    }

    public void setOwnersName(String ownersName) {
        this.ownersName = ownersName;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(int securityCode) {
        this.securityCode = securityCode;
    }



    public String toString() {
        return "Card ["+", expirationDate=" + expirationDate + ", ownersName=" + ownersName
                + ", securityCode=" + securityCode + "]";
    }

}