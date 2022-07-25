public class DebitCard extends Card {
    private double maxTransactionAmount;

    public DebitCard(boolean isActive, String PIN, String cardNumber, String cardHolderName, double cardBalance, double maxTransactionAmount) {
        super(isActive, PIN, cardNumber, cardHolderName, cardBalance);
        this.maxTransactionAmount = maxTransactionAmount;
    }

    public double getMaxTransactionAmount() {
        return maxTransactionAmount;
    }

    public void changeTransactionLimit(double newMaxTransactionAmount) {
        this.maxTransactionAmount = newMaxTransactionAmount;
    }

    @Override
    public void pay(double payment) {
        if (isActive() == false) {
            System.out.println("Cardul cu care doresti sa platesti este inactiv");
        } else if ((payment <= maxTransactionAmount) && (payment <= getCardBalance())) {
            setCardBalance(getCardBalance() - payment);
        } else {
            System.out.println("Plata pe care doresti sa o efectuezi depaseste valoarea maxima pe care o poti tranzactiona sau nu ai suficienti bani in cont");
        }
    }


}
