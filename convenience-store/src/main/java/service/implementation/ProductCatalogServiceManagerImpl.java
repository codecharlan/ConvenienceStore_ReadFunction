package service.implementation;

import com.codecharlan.conveniencestore.model.Employee;
import com.codecharlan.conveniencestore.model.Product;
import com.codecharlan.conveniencestore.repository.Store;
import service.ProductCatalogService;

import java.util.ArrayList;
import java.util.List;

public class ProductCatalogServiceManagerImpl implements ProductCatalogService {
    Product product = new Product("Milk", 3.45, "9", "beverage");
    List<Product> products = new ArrayList<>();
    List<String> categories = new ArrayList<>();
    Store store = new Store("myStore", products, categories);

    public List<Product> restockProduct(String filePath) {
        List<Product> loadedProducts = store.loadProductList(filePath);
        store.setProducts(loadedProducts);
        return store.getProducts();
    }
    public List<String> getCategory(List<Product> products) {
        List<String> productCategory = store.getCategory(store.getProducts()); // get categories
        return productCategory;
    }

    @Override
    public String updatePrice(Product product, int newPrice) {
    product.setProductPrice(product.getProductPrice() + newPrice);
        products.add(product);
        return "Price of " + product.getProductName() + " has been successfully updated to $"
                + product.getProductPrice();
    }

    @Override
    public String discountPrice(Product product, double priceDiscountInPercent) {
        double currentPrice = product.getProductPrice() - ((float)(priceDiscountInPercent/100) * product.getProductPrice());
        product.setProductPrice(currentPrice);
        return priceDiscountInPercent + "% discount has been applied to "
                + product.getProductName() + " the new price is $" + product.getProductPrice();
    }
}
