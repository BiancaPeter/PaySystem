public class ShoppingAccount {
    private Card[] cardList;
    private Address[] addressList;
    private String firstName;
    private String lastName;
    private Card currentPaymentMethod;
    private Address currentBillingAddress;
    private int numberOfCards = 0;
    private int numberOfAddresses = 0;

    public ShoppingAccount(Card[] cardList, Address[] addressList, String firstName, String lastName) {
        this.cardList = cardList;
        this.addressList = addressList;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Card[] getCardList() {
        return cardList;
    }

    public void setCardList(Card[] cardList) {
        this.cardList = cardList;
    }

    public Address[] getAddressList() {
        return addressList;
    }

    public void setAddressList(Address[] addressList) {
        this.addressList = addressList;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Card getCurrentPaymentMethod() {
        return currentPaymentMethod;
    }

    public void setCurrentPaymentMethod(Card currentPaymentMethod) {
        this.currentPaymentMethod = currentPaymentMethod;
    }

    public Address getCurrentBillingAddress() {
        return currentBillingAddress;
    }

    public void setCurrentBillingAddress(Address currentBillingAddress) {
        this.currentBillingAddress = currentBillingAddress;
    }

    public void addPaymentMethod(Card aCard) {
        cardList[numberOfCards] = aCard;
        numberOfCards++;
    }

    public void addAddress(Address anAddress) {
        addressList[numberOfAddresses] = anAddress;
        numberOfAddresses++;
    }

    public void removePaymentMethod(String removeCard) {
        int withdrawalCardPosition = searchCard(removeCard);
        if (withdrawalCardPosition == -1) {
            System.out.println("Acest card nu se afla in lista");
        } else {
            for (int i = withdrawalCardPosition; i < numberOfCards - 1; i++) {
                cardList[i] = cardList[i + 1];
            }
            cardList[numberOfCards - 1] = null;
            numberOfCards--;
        }
    }

    public void removeAddress(String street, String number, String city) {
        int withdrawalAddressPosition = searchAddress(street, number, city);
        if (withdrawalAddressPosition == -1) {
            System.out.println("Aceasta adresa nu se afla in lista");
        } else {
            for (int i = withdrawalAddressPosition; i < numberOfAddresses - 1; i++) {
                addressList[i] = addressList[i + 1];
            }
            addressList[numberOfAddresses - 1] = null;
            numberOfAddresses--;
        }
    }

    private int searchCard(String cardNumber) {
        for (int i = 0; i < cardList.length; i++) {
            if (cardNumber.equals(cardList[i].getCardNumber())) {
                return i;
            }
        }
        return -1;
    }

    private int searchAddress(String street, String number, String city) {
        for (int i = 0; i < addressList.length; i++) {
            if (street.equals(addressList[i].getStreet()) && number.equals(addressList[i].getNumber()) && city.equals(addressList[i].getCity())) {
                return i;
            }
        }
        return -1;
    }

    public void selectPaymentMethod(String cardNumber) {
        int withdrawalCardPosition = searchCard(cardNumber);
        currentPaymentMethod = cardList[withdrawalCardPosition];
    }

    public void selectAddress(String street) {
        for (int i = 0; i < addressList.length; i++) {
            if (street.equals(addressList[i].getStreet())) {
                currentBillingAddress = addressList[i];
                break;
            }
        }
    }

    public void generateInvoice(double amount, Address currentBillingAddress, Card currentPaymentMethod) {
        System.out.println("Nume: " + firstName + " " + lastName+". Ati platit suma " + amount + " RON folosind cardul cu numarul " + currentPaymentMethod.getCardNumber() + " pentru adresa: str. " + currentBillingAddress.getStreet() + ", nr. " + currentBillingAddress.getNumber() + ", " + currentBillingAddress.getCity());
    }

}
