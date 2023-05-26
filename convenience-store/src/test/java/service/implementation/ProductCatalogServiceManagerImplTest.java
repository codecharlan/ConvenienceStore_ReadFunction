package service.implementation;

import com.codecharlan.conveniencestore.model.Product;
import com.codecharlan.conveniencestore.repository.Store;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ProductCatalogServiceManagerImplTest {
    ProductCatalogServiceManagerImpl productimpl;
    List<Product> products;
    Product product;
    List<String> categories;
    Store store;


    @BeforeEach
    void setUp() {
        products = new ArrayList<>();
        categories = new ArrayList<>();
        store = new Store("myStore", products, categories);
        productimpl = new ProductCatalogServiceManagerImpl();
        product = new Product("Milk", 3.45, "9", "beverage");

    }

    @Test
    void restockProduct() {
        List<Product> expected = store.getProducts();
        List<Product> actual = productimpl.restockProduct("convenience-store/src/main/resources/product.csv");
        Assertions.assertEquals(expected, actual);
        Assertions.assertNotNull(actual);
    }

    @Test
    void getCategory() {
        List<String> expected = store.getCategory(store.getProducts());
        List<String> actual = productimpl.getCategory(products);
        Assertions.assertEquals(expected, actual);
        Assertions.assertNotNull(actual);
    }

    @Test
    void updatePrice() {
        String expected = "Price of " + product.getProductName() + " has been successfully updated to $"
                + product.getProductPrice();
        String actual = productimpl.updatePrice(product, 14);
        Assertions.assertNotEquals(expected, actual);
        Assertions.assertNotNull(actual);
    }

    @Test
    void discountPrice() {
        double priceDiscountInPercent = 10.34;
        String expected = priceDiscountInPercent + "% discount has been applied to "
                + product.getProductName() + " the new price is $" + product.getProductPrice();
        String actual = productimpl.discountPrice(product, priceDiscountInPercent);
        Assertions.assertNotEquals(expected, actual);
        Assertions.assertNotNull(actual);
    }
}