package shop4Fun.dao;

import shop4Fun.model.Product;

import java.util.List;

public interface ProductDao {
    Product getProductById(int productId);

    void deleteProduct(int productId);

    void addProduct(Product product);

    void updateProduct(Product product);

    List<Product> getAllProducts();
}
