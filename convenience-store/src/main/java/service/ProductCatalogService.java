package service;

import com.codecharlan.conveniencestore.model.Product;

import java.util.List;

public interface ProductCatalogService {

        List<Product> restockProduct(String filePath);
        String updatePrice(Product product, int newPrice);
        String discountPrice(Product product, double priceDiscountInPercent);
    }

