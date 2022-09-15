package model;
public class Payment { 
    private String cardNumber;
    private float amount;

    public Payment(String accountNumber, float amount){
        this.cardNumber = accountNumber;
        this.amount = amount;
    }

    

    public String getAccountNumber() {
        return cardNumber;
    }



    public void setAccountNumber(String accountNumber) {
        this.cardNumber = accountNumber;
    }



    public float getAmount() {
        return amount;
    }



    public void setAmount(float amount) {
        this.amount = amount;
    }



    @Override
    public String toString() {
        return "Payment [accountNumber=" + cardNumber + ", amount=" + amount + "]";
    }
    
}
