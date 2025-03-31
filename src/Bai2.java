import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = {10, 20, 30, 40, 50};
        try {
            System.out.print("Nhập chỉ số của phần tử trong mảng: ");
            int index = sc.nextInt();
            int value = numbers[index];
            System.out.println("Giá trị tại chỉ số " + index + " là: " + value);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Lỗi: Chỉ số ngoài phạm vi mảng!");
        }
        sc.close();
    }
}
