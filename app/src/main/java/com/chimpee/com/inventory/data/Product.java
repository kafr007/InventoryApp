package com.chimpee.com.inventory.data;
/**
 * An {@link Product} object contains datas about a single product.
 */
public class Product {
    /**
     * Name of the product.
     *
     * Type: TEXT
     */
    private final String productName;

    /**
     * Price of the product.
     *
     * Type: TEXT
     */
    private final double price;

    /**
     * Quantity of the product.
     *
     * Type: INTEGER
     */
    private final int quantity;

    /**
     * Name of the product's supplier.
     *
     * Type: TEXT
     */
    private final String supplierName;

    /**
     * Phone number of the product's supplier.
     *
     * Type: TEXT
     */
    private final String supplierPhone;

    /**
     * Email address of the product's supplier.
     *
     * Type: TEXT
     */
    private final String supplierEmail;

    /**
     * Image address of the products.
     *
     * Type: TEXT
     */
    private final String image;

    /**
     * Constructs a new {@link Product} object.
     *
     * @param productName     is the name of the product
     * @param price           is the price of the product
     * @param quantity        is the quantity of the product
     * @param supplierName    is the name of the product's supplier
     * @param supplierPhone   is the phone number of the product's supplier
     * @param supplierEmail   is the email number of the product's supplier
     * @param image           is the address of the photo about the product
     */
    public Product(String productName, double price, int quantity, String supplierName, String supplierPhone, String supplierEmail, String image) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.supplierName = supplierName;
        this.supplierPhone = supplierPhone;
        this.supplierEmail = supplierEmail;
        this.image = image;
    }

    /**
     * Returns the name of the product.
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Returns the price of the product.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Returns the quantity of the product.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Returns the name of the product's supplier.
     */
    public String getSupplierName() {
        return supplierName;
    }

    /**
     * Returns the phone number of the product's supplier.
     */
    public String getSupplierPhone() {
        return supplierPhone;
    }

    /**
     * Returns the email address of the product's supplier.
     */
    public String getSupplierEmail() {
        return supplierEmail;
    }

    /**
     * Returns the address of the photo about the product.
     */
    public String getImage() {
        return image;
    }
    @Override
    public String toString() {
        return "StockItem{" +
                "productName='" + productName + '\'' +
                ", price='" + price + '\'' +
                ", quantity=" + quantity +
                ", supplierName='" + supplierName + '\'' +
                ", supplierPhone='" + supplierPhone + '\'' +
                ", supplierEmail='" + supplierEmail + '\'' +
                '}';
    }

}