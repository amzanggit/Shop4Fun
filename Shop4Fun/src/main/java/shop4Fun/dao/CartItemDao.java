package shop4Fun.dao;

import shop4Fun.model.Cart;
import shop4Fun.model.CartItem;

public interface CartItemDao {
    void addCartItem(CartItem cartItem);

    void removeCartItem(int CartItemId);

    void removeAllCartItems(Cart cart);
}
