package bai10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Product> availableProducts = new ArrayList<>();
        availableProducts.add(new Product("P001", "Sản phẩm A", 100));
        availableProducts.add(new Product("P002", "Sản phẩm B", 200));
        availableProducts.add(new Product("P003", "Sản phẩm C", 150));
        ShoppingCart cart = new ShoppingCart();
        do {
            System.out.println("--------------- MENU ---------------");
            System.out.println("1. Xem danh sách sản phẩm có sẵn");
            System.out.println("2. Thêm sản phẩm vào giỏ hàng");
            System.out.println("3. Xoá sản phẩm khỏi giỏ hàng");
            System.out.println("4. Xem giỏ hàng");
            System.out.println("5. Thanh toán");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Danh sách sản phẩm có sẵn:");
                    for (Product product : availableProducts) {
                        System.out.println(product);
                    }
                    break;
                case 2:
                    System.out.print("Nhập mã sản phẩm cần thêm: ");
                    String productId = sc.nextLine();
                    Product productToAdd = null;
                    for (Product product : availableProducts) {
                        if (product.getId().equals(productId)) {
                            productToAdd = product;
                            break;
                        }
                    }
                    if (productToAdd != null) {
                        System.out.print("Nhập số lượng cần mua: ");
                        int quantity = sc.nextInt();
                        try {
                            cart.addToCart(productToAdd, quantity);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("Sản phẩm không tồn tại.");
                    }
                    break;
                case 3:
                    System.out.print("Nhập mã sản phẩm cần xoá: ");
                    String removeId = sc.next();
                    try {
                        cart.removeFromCart(removeId);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    cart.displayCart();
                    break;
                case 5:
                    cart.checkout();
                    break;
                case 6:
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (true);
    }
}
