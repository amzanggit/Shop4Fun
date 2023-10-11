package shop4Fun.service;

import shop4Fun.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product getProductById(int productId);

    void deleteProduct(int productId);

    void addProduct(Product product);

    void updateProduct(Product product);
}
