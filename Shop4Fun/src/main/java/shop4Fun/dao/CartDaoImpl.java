package shop4Fun.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import shop4Fun.model.Cart;
import shop4Fun.model.CartItem;

import java.io.IOException;
import java.util.List;


@Repository
public class CartDaoImpl implements CartDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Cart getCartById(int CartId) {
        Cart cart = null;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            cart = (Cart) session.get(Cart.class, CartId);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cart;
    }

    public Cart validate(int cartId) throws IOException {
        Cart cart = getCartById(cartId);
        if (cart == null || cart.getCartItem().size() == 0) {
            throw new IOException(cartId + "");
        }
        update(cart);
        return cart;
    }

    private void update(Cart cart) {
        int cartId = cart.getId();
        double total = getSalesOrderTotal(cartId);
        cart.setTotalPrice(total);

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.saveOrUpdate(cart);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private double getSalesOrderTotal(int cartId) {
        double total = 0;
        Cart cart = getCartById(cartId);
        List<CartItem> cartItems = cart.getCartItem();

        for (CartItem item : cartItems) {
            total += item.getPrice();
        }
        return total;
    }
}
