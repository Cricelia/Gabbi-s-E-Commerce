package org.yearup.controllers;

import org.junit.jupiter.api.Test;
import org.yearup.data.ProductDao;
import org.yearup.models.Product;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductsControllerTest {

    @Test
    void searchByCat() {
        // Arrange
        ProductDao productDao = mock(ProductDao.class);
        ProductsController productsController = new ProductsController(productDao);

        // Create a product using the full constructor
        Product expectedProduct = new Product(1, "Product A", BigDecimal.valueOf(10.00),
                1, null, "Red", 0, false, null);

        List<Product> expectedProducts = List.of(expectedProduct);

        when(productDao.search(1, null, null, null)).thenReturn(expectedProducts);

        // Act
        List<Product> products = productsController.search(1, null, null, null);

        // Assert
        assertEquals(expectedProducts, products);
        verify(productDao).search(1, null, null, null);
    }

    @Test
    void searchByMinPrice() {
        // Arrange
        ProductDao productDao = mock(ProductDao.class);
        ProductsController productsController = new ProductsController(productDao);

        // Create a product using the full constructor
        Product expectedProduct = new Product(1, "Product B", BigDecimal.valueOf(20.00),
                2, null, "Blue", 0, false, null);

        List<Product> expectedProducts = List.of(expectedProduct);

        when(productDao.search(null, BigDecimal.valueOf(15.00), null, null)).thenReturn(expectedProducts);

        // Act
        List<Product> products = productsController.search(null, BigDecimal.valueOf(15.00), null, null);

        // Assert
        assertEquals(expectedProducts, products);
        verify(productDao).search(null, BigDecimal.valueOf(15.00), null, null);
    }

    @Test
    void searchByMaxPrice() {
        // Arrange
        ProductDao productDao = mock(ProductDao.class);
        ProductsController productsController = new ProductsController(productDao);

        // Create a product using the full constructor
        Product expectedProduct = new Product(1, "Product C", BigDecimal.valueOf(30.00),
                3, null, "Green", 0, false, null);

        List<Product> expectedProducts = List.of(expectedProduct);

        when(productDao.search(null, null, BigDecimal.valueOf(35.00), null)).thenReturn(expectedProducts);

        // Act
        List<Product> products = productsController.search(null, null, BigDecimal.valueOf(35.00), null);

        // Assert
        assertEquals(expectedProducts, products);
        verify(productDao).search(null, null, BigDecimal.valueOf(35.00), null);
    }

    @Test
    void searchByColor() {
        // Arrange
        ProductDao productDao = mock(ProductDao.class);
        ProductsController productsController = new ProductsController(productDao);

        // Create a product using the full constructor
        Product expectedProduct = new Product(1, "Product D", BigDecimal.valueOf(40.00),
                4, null, "Yellow", 0, false, null);

        List<Product> expectedProducts = List.of(expectedProduct);

        when(productDao.search(null, null, null, "Yellow")).thenReturn(expectedProducts);

        // Act
        List<Product> products = productsController.search(null, null, null, "Yellow");

        // Assert
        assertEquals(expectedProducts, products);
        verify(productDao).search(null, null, null, "Yellow");
    }


}