import java.util.Scanner;

public class Bai5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Nhập một số nguyên: ");
            int n = sc.nextInt();
            if (n <= 0) {
                throw new IllegalArgumentException("Lỗi: Vui lòng nhập một số nguyên dương lớn hơn 0!");
            }
            if(isPrime(n)) {
                System.out.println(n + " là số nguyên tố.");
            } else {
                System.out.println(n + " không phải là số nguyên tố.");
            }
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        catch (Exception e) {
            System.out.println("Lỗi: Bạn phải nhập một số nguyên!");
        }
        sc.close();
    }

    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
