public class BankAccount {

    private int accountNumber;
    private double balance;
    private String customerName;
    private String email;
    private int phoneNumber;

    public BankAccount(int accountNumber, double balance, String customerName, String email, int phoneNumber) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

//    // example of setting up a default constructor value
//    public BankAccount() {
//        // this line must be first if you want to have default values for a constructor
//        this(12345, 0.00, "Default Name", "Default Email", 123_456_7890 );
//    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void depositFunds(double amount) {
        this.balance += amount;
        System.out.println("The new balance is " + this.balance);
    }

    public void withdrawFunds(double amount) {
        if(this.balance >= amount ) {
            balance -= amount;
            System.out.println("The amount " + amount + " is withdrawn. The new balance is " + this.balance);
        } else {
            System.out.println("The withdrawl amount " + amount + " does not have enough funds. Remaining balance is " + this.balance);
        }
    }
}
