package shop4Fun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import shop4Fun.model.Cart;
import shop4Fun.model.Customer;
import shop4Fun.service.CartService;
import shop4Fun.service.CustomerService;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private CartService cartService;

    @GetMapping("/getCartById")
    public ModelAndView getCartId(Model model){
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String username = loggedInUser.getName();
        Customer customer = customerService.getCustomerByUserName(username);
        ModelAndView modelAndView = new ModelAndView("cart", "cartId", customer.getCart().getId());
        return modelAndView;
    }

    @GetMapping("/getCart/{cartId}")
    @ResponseBody
    public Cart getCartItems(@PathVariable(value="cartId")int cartId){
        return cartService.getCartById(cartId);
    }
}
