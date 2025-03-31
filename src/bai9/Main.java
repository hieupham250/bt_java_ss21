package bai9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<BankAccount> accounts = new ArrayList<>();
        BankAccount account1 = new BankAccount("ACC123", 1000);
        BankAccount account2 = new BankAccount("ACC456", 2000);
        accounts.add(account1);
        accounts.add(account2);
        do {
            System.out.println("------------- MENU -------------");
            System.out.println("1. Gửi tiền");
            System.out.println("2. Rút tiền");
            System.out.println("3. Chuyển tiền");
            System.out.println("4. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Nhập tài khoản gửi tiền: ");
                    String depositAccountId = sc.next();
                    BankAccount depositAccount = findAccountById(depositAccountId, accounts);
                    if (depositAccount != null) {
                        System.out.print("Nhập số tiền cần gửi: ");
                        double depositAmount = sc.nextDouble();
                        try {
                            depositAccount.deposit(depositAmount);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("Tài khoản không tồn tại.");
                    }
                    break;
                case 2:
                    System.out.print("Nhập tài khoản rút tiền: ");
                    String withdrawAccountId = sc.next();
                    BankAccount withdrawAccount = findAccountById(withdrawAccountId, accounts);
                    if (withdrawAccount != null) {
                        System.out.print("Nhập số tiền cần rút: ");
                        double withdrawAmount = sc.nextDouble();
                        try {
                            withdrawAccount.withdraw(withdrawAmount);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("Tài khoản không tồn tại.");
                    }
                    break;
                case 3:
                    System.out.print("Nhập tài khoản nguồn: ");
                    String sourceAccountId = sc.next();
                    BankAccount sourceAccount = findAccountById(sourceAccountId, accounts);
                    if (sourceAccount != null) {
                        System.out.print("Nhập tài khoản đích: ");
                        String targetAccountId = sc.next();
                        BankAccount targetAccount = findAccountById(targetAccountId, accounts);
                        if (targetAccount != null) {
                            System.out.print("Nhập số tiền cần chuyển: ");
                            double transferAmount = sc.nextDouble();
                            try {
                                sourceAccount.transfer(targetAccount, transferAmount);
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        } else {
                            System.out.println("Tài khoản đích không tồn tại.");
                        }
                    } else {
                        System.out.println("Tài khoản nguồn không tồn tại.");
                    }
                    break;
                case 4:
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (true);
    }

    public static BankAccount findAccountById(String accountId, List<BankAccount> accounts) {
        for (BankAccount account : accounts) {
            if (account.getAccountId().equals(accountId)) {
                return account;
            }
        }
        return null;
    }
}
