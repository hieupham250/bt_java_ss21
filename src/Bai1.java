import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Nhập số thứ 1: ");
            int a = sc.nextInt();
            System.out.print("Nhập số thứ 2: ");
            int b = sc.nextInt();
            int result = a / b;
            System.out.println("Kết quả: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Lỗi: Không thể chia cho 0!");
        }
        sc.close();
    }
}
