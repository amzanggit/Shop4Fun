package shop4Fun.dao;

import shop4Fun.model.Cart;
import java.io.IOException;

public interface CartDao {
    Cart getCartById(int cartId);

    Cart validate(int cartId) throws IOException;
}
