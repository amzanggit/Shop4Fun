package shop4Fun.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop4Fun.dao.CartDao;
import shop4Fun.model.Cart;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartDao cartDao;

    public Cart getCartById(int CartId) {
        return cartDao.getCartById(CartId);
    }
}
