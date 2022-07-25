public class CreditCard extends Card {
    private final double maxOverDraft;

    public CreditCard(boolean isActive, String PIN, String cardNumber, String cardHolderName, double cardBalance, double maxOverDraft) {
        super(isActive, PIN, cardNumber, cardHolderName, cardBalance);
        this.maxOverDraft = maxOverDraft;
    }

    public double getMaxOverDraft() {
        return maxOverDraft;
    }


    @Override
    public void pay(double payment) {
        if (isActive() == false) {
            System.out.println("Cardul cu care doresti sa platesti este inactiv");
        } else if (payment <= (getCardBalance() + maxOverDraft)) {
            setCardBalance(getCardBalance() - payment);
        } else {
            System.out.println("Valoarea tranzactie depaseste plafonul creditului");
        }
    }
}
