public class Card implements Payable {
    private boolean isActive;
    private String PIN;
    private String cardNumber;
    private String cardHolderName;
    private double cardBalance;

    public Card(boolean isActive, String PIN, String cardNumber, String cardHolderName, double cardBalance) {
        this.isActive = isActive;
        this.PIN = PIN;
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.cardBalance = cardBalance;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getPIN() {
        return PIN;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public double getCardBalance() {
        return cardBalance;
    }

    public void setCardBalance(double cardBalance) {
        this.cardBalance = cardBalance;
    }

    public boolean changePin(String newPin) {
        if (newPin.length() != 4) {
            System.out.println("PIN-ul introdus nu contine 4 caractere");
            return false;
        }
        for (int i = 0; i < newPin.length(); i++) {
            if (!Character.isDigit(newPin.charAt(i))) {
                System.out.println("PIN-ul introdus contine 4 caractere, insa nu sunt toate cifre");
                return false;
            }
        }
        this.PIN = newPin;
        return true;
    }

    public void freezeCard() {
        isActive = false;
    }

    @Override
    public void pay(double payment) {
    }
}
