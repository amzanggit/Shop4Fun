package shop4Fun.service;

import shop4Fun.model.Cart;
import shop4Fun.model.CartItem;

public interface CartItemService {
    void addCartItem(CartItem cartItem);

    void removeCartItem(int CartItemId);

    void removeAllCartItems(Cart cart);
}
