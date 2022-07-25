public class Shop {
    public static void main(String[] args) {
//        Clasa Shop va avea o metoda main unde vor fi testate functionalitatile implementate (se va crea un shopping account,
//        se vor adauga adrese si modalitati de plata in el, se va selecta o adresa, se va selecta o modalitate de plata, se va plati o
//        anumita suma de bani folosind metoda de plata selectata si apoi se va genera o factura)

        Card[] cardList = new Card[3];
        Address[] addressList = new Address[2];
        ShoppingAccount shoppingAccount = new ShoppingAccount(cardList, addressList, "Bianca", "Peter");

        CreditCard card1 = new CreditCard(true, "1234", "1234 5678 8765 4321", "Peter Bianca", 8000, 10000);
        DebitCard card2 = new DebitCard(true, "5678", "9876 5432 2345 6789", "Peter Bianca", 7000, 4000);
        CreditCard card3 = new CreditCard(true, "4567", "1234 5678 8765 8765", "Peter Bianca", 5000, 5000);

        if (card1.changePin("2345")) {
            System.out.println("PIN-ul a fost schimbat cu succes, noul PIN este: " + card1.getPIN());
        }

        card1.freezeCard();
        System.out.println(card1.isActive());

        card2.changeTransactionLimit(6000);

        shoppingAccount.addPaymentMethod(card1);
        shoppingAccount.addPaymentMethod(card2);
        shoppingAccount.addPaymentMethod(card3);

        Address address1 = new Address("Revolutiei", "15", "Targu Mures");
        Address address2 = new Address("Tineretului", "2", "Targu Mures");

        shoppingAccount.addAddress(address1);
        shoppingAccount.addAddress(address2);

        shoppingAccount.selectPaymentMethod("1234 5678 8765 8765");
        shoppingAccount.selectAddress("Tineretului");

        shoppingAccount.generateInvoice(500, shoppingAccount.getCurrentBillingAddress(), shoppingAccount.getCurrentPaymentMethod());

        shoppingAccount.getCurrentPaymentMethod().pay(500);
        System.out.println(shoppingAccount.getCurrentPaymentMethod().getCardBalance());


    }

}
