import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Nhập độ tuổi của bạn: ");
            int age = sc.nextInt();
            if (age < 18) {
                throw new Exception("Bạn chưa đủ 18 tuổi!");
            }
            System.out.println("Chào mừng bạn!");
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
}
