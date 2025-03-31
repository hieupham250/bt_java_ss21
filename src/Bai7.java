import java.util.Scanner;

public class Bai7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int balance = 1000000;
        final int MIN_BALANCE = 50000;
        System.out.println("Số dư hiện tại: " + balance + " đồng");
        try {
            int amount = Integer.parseInt(sc.nextLine());
            if (amount > MIN_BALANCE) {
                System.out.println("Lỗi: Số tiền rút vượt quá số dư!");
            } else if ((balance - amount) < MIN_BALANCE) {
                System.out.println("Lỗi: Tài khoản phải duy trì số dư tối thiểu 50.000 đồng!");
            } else {
                balance -= amount;
                System.out.println("Rút tiền thành công! Số dư còn lại: " + balance + " đồng");
            }
        } catch (NumberFormatException e) {
            System.out.println("Lỗi: Vui lòng nhập một số hợp lệ!");
        }
        sc.close();
    }
}
