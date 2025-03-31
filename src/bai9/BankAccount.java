package bai9;

public class BankAccount {
    private String accountId;
    private double balance;

    public BankAccount() {}

    public BankAccount(String accountId, double balance) {
        this.accountId = accountId;
        this.balance = balance;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) throws Exception {
        if (amount <= 0) {
            throw new Exception("Số tiền gửi phải là một số dương.");
        }
        this.balance += amount;
        System.out.println("Đã gửi thành công " + amount + ". Số dư hiện tại: " + this.balance);
    }

    public void withdraw(double amount) throws Exception {
        if (amount <= 0) {
            throw new Exception("Số tiền rút phải là một số dương.");
        }
        if (amount > this.balance) {
            throw new Exception("Số dư không đủ để thực hiện giao dịch.");
        }
        this.balance -= amount;
        System.out.println("Đã rút thành công " + amount + ". Số dư hiện tại: " + this.balance);
    }

    public void transfer(BankAccount targetAccount, double amount) throws Exception {
        if (amount <= 0) {
            throw new Exception("Số tiền chuyển phải là một số dương.");
        }
        if (amount > this.balance) {
            throw new Exception("Số dư không đủ để thực hiện giao dịch.");
        }
        if (targetAccount == null) {
            throw new Exception("Tài khoản chuyển tiền không tồn tại.");
        }
        this.balance -= amount;
        targetAccount.deposit(amount);
        System.out.println("Đã chuyển thành công " + amount + " từ tài khoản " + this.accountId + " đến tài khoản " + targetAccount.getAccountId());
    }
}
