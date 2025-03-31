import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bai6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> validNumbers = new ArrayList<>();
        int validCount = 0, invalidCount = 0;
        System.out.println("Nhập vào danh sách chuỗi (nhập 'exit' để kết thúc):");
        while (true) {
            String input = sc.nextLine();
            if (input.equals("exit")) {
                break;
            }
            try {
                int n = Integer.parseInt(input);
                validNumbers.add(n);
                validCount++;
            } catch (NumberFormatException e) {
                invalidCount++;
            }
        }
        System.out.println("Số lượng chuỗi hợp lệ: " + validCount);
        System.out.println("Số lượng chuỗi không hợp lệ: " + invalidCount);
        System.out.println("Danh sách số nguyên hợp lệ: " + validNumbers);
    }
}
