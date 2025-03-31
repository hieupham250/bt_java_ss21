package bai10;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<CartItem> cartItems = new ArrayList<>();
    public void addToCart(Product product, int quantity) throws Exception {
        if (quantity <= 0) {
            throw new Exception("Lỗi: Số lượng không hợp lệ!");
        }

        for (CartItem item : cartItems) {
            if (item.getProduct().getId().equals(product.getId())) {
                item.setQuantity(item.getQuantity() + quantity);
                System.out.println("Sản phẩm đã có trong giỏ, tăng số lượng lên " + item.getQuantity());
                return;
            }
        }

        cartItems.add(new CartItem(product, quantity));
        System.out.println("Đã thêm sản phẩm vào giỏ: " + product.getName());
    }

    public void removeFromCart(String productId) throws Exception {
        CartItem itemToRemove = null;
        for (CartItem item : cartItems) {
            if (item.getProduct().getId().equals(productId)) {
                itemToRemove = item;
                break;
            }
        }

        if (itemToRemove != null) {
            cartItems.remove(itemToRemove);
            System.out.println("Đã xoá sản phẩm " + itemToRemove.getProduct().getName() + " khỏi giỏ hàng.");
        } else {
            throw new Exception("Lỗi: Không tìm thấy sản phẩm trong giỏ hàng!");
        }
    }

    public void displayCart() {
        if (cartItems.isEmpty()) {
            System.out.println("Giỏ hàng của bạn đang rỗng.");
        } else {
            System.out.println("Danh sách sản phẩm trong giỏ hàng:");
            for (CartItem item : cartItems) {
                System.out.println(item.displayItem());
            }
        }
    }

    public void checkout() {
        if (cartItems.isEmpty()) {
            System.out.println("Giỏ hàng của bạn đang rỗng.");
        } else {
            double total = 0;
            for (CartItem item : cartItems) {
                total += item.getTotalPrice();
            }
            System.out.println("Tổng tiền cần thanh toán: " + total);
        }
    }
}
