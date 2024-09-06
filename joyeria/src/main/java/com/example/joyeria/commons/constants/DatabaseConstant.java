package com.example.joyeria.commons.constants;

public abstract class DatabaseConstant {

    /**
     * <h1>SECURITY TABLES</h1>
     * <h2>Authority table 🛢</h2>
     */
    /* Property for the table name of "tb_authorities" */
    public static String AUTHORITIES_TABLE = "tb_authorities";

    /* Property for the primary key on table "tb_authorities" */
    public static String AUTHORITIES_ID = "authority_id";

    /* Property for the authority name on table "tb_authorities" */
    public static String AUTHORITIES_NAME = "authority";

    /**
     * <h2>Role table 🛢</h2>
     */
    /* Property for the table name of table "tb_roles" */
    public static String ROLE_TABLE = "tb_roles";

    /* Property for the primary key on table "tb_roles" */
    public static String ROLE_ID = "role_id";

    /* Property for the role name on table "tb_roles" */
    public static String ROLE_NAME = "role_name";

    /**
     * <h1>BUSINESS TABLES</h1>
     * <h2>Customer table 🛢</h2>
     */
    /* Property for the table name of "tb_customer" */
    public static final String CUSTOMER_TABLE = "tb_customer";

    /* Property for the primary key on table "tb_customer" */
    public static final String CUSTOMER_ID = "customer_id";

    /* Property for the username column on table "tb_customer" */
    public static final String USERNAME = "username";

    /* Property for the lastname column on table "tb_customer" */
    public static final String LASTNAME = "lastname";

    /* Property for the email column on table "tb_customer" */
    public static final String EMAIL = "email";

    /* Property for the password column on table "tb_customer" */
    public static final String PASSWORD = "password";

    /* Property for the phone column on table "tb_customer" */
    public static final String PHONE = "phone";

    /* Property for the address column on table "tb_customer" */
    public static final String ADDRESS = "address";

    /**
     * <h2>Payment table 🛢</h2>
     */
    /* Property for the table name of "tb_payment" */
    public static final String PAYMENT_TABLE = "tb_payment";

    /* Property for the primary key column on table "tb_payment" */
    public static final String PAYMENT_ID = "payment_id";

    /* Property for the payment date column on table "tb_payment" */
    public static final String PAYMENT_DATE = "payment_date";

    /* Property for the payment method column on table "tb_payment" */
    public static final String PAYMENT_METHOD = "payment_method";

    /* Property for the amount column on table "tb_payment" */
    public static final String AMOUNT = "amount";

    /**
     * <h2>Products table 🛢</h2>
     */
    /* Property for the table name of "tb_product" */
    public static final String PRODUCT_TABLE = "tb_product";

    /* Property for the primary key on table "tb_product" */
    public static final String PRODUCT_ID = "product_id";

    /* Property for the product name column on table "tb_product" */
    public static final String PRODUCT_NAME = "product_name";

    /* Property for the description column on table "tb_product" */
    public static final String DESCRIPTION = "description";

    /* Property for the price column on table "tb_product" */
    public static final String PRICE = "price";

    /* Property for the stock column on table "tb_product" */
    public static final String STOCK = "stock";

    /**
     * <h2>Shipment table 🛢</h2>
     */
    /* Property for the table name of "tb_shipment" */
    public static final String SHIPMENT_TABLE = "tb_shipment";

    /* Property for the primary key column on table "tb_shipment" */
    public static final String SHIPMENT_ID = "shipment_id";

    /* Property for the shipment date column on table "tb_shipment" */
    public static final String SHIPMENT_DATE = "shipment_date";

    /* Property for the address column on table "tb_shipment" */
    public static final String SHIPMENT_ADDRESS = "address";

    /* Property for the city column on table "tb_shipment" */
    public static final String CITY = "city";

    /* Property for the zip code column on table "tb_shipment" */
    public static final String ZIP_CODE = "zip_code";

    /**
     * <h2>Order table 🛢</h2>
     */
    /* Property for the table name of "tb_order" */
    public static final String ORDER_TABLE = "tb_order";

    /* Property for the primary key column on table "tb_order" */
    public static final String ORDER_ID = "order_id";

    /* Property for the order date column on table "tb_order" */
    public static final String ORDER_DATE = "order_date";

    /* Property for the total price column on table "tb_order" */
    public static final String TOTAL_PRICE = "total_price";

    /**
     * <h1>INTERMEDIATES TABLES</h1>
     * <h2>Role Authority table 🛢</h2>
     */
    /* Property for the table name of "role_authority" */
    public static final String ROLE_AUTHORITY_TABLE = "role_authority";

    /* Property for the role ID column on table "role_authority" */
    public static final String ROLE_AUTHORITY_ROLE_ID = "role_id";

    /* Property for the authority ID column on table "role_authority" */
    public static final String ROLE_AUTHORITY_AUTHORITY_ID = "authority_id";

    /**
     * <h2>Customer Role table 🛢</h2>
     */
    /* Property for the table name of "customer_role" */
    public static final String CUSTOMER_ROLE_TABLE = "customer_role";

    /* Property for the customer ID column on table "customer_role" */
    public static final String CUSTOMER_ROLE_CUSTOMER_ID = "customer_id";

    /* Property for the role ID column on table "customer_role" */
    public static final String CUSTOMER_ROLE_ROLE_ID = "role_id";

    /**
     * <h2>Order Item table 🛢</h2>
     */
    /* Property for the table name of "order_item" */
    public static final String ORDER_ITEM_TABLE = "order_item";

    /* Property for the product ID column on table "order_item" */
    public static final String ORDER_ITEM_PRODUCT_ID = "product_id";

    /* Property for the order ID column on table "order_item" */
    public static final String ORDER_ITEM_ORDER_ID = "order_id";

    /* Property for the quantity column on table "order_item" */
    public static final String ORDER_ITEM_QUANTITY = "quantity";

    /* Property for the price column on table "order_item" */
    public static final String ORDER_ITEM_PRICE = "price";

    /**
     * <h2>Cart table 🛢</h2>
     */
    /* Property for the table name of "Cart" */
    public static final String CART_TABLE = "Cart";

    /* Property for the cart ID column on table "Cart" */
    public static final String CART_ID = "cart_id";

    /* Property for the quantity column on table "Cart" */
    public static final String CART_QUANTITY = "quantity";

    /* Property for the customer ID column on table "Cart" */
    public static final String CART_CUSTOMER_ID = "customer_id";

    /* Property for the product ID column on table "Cart" */
    public static final String CART_PRODUCT_ID = "product_id";

    private DatabaseConstant() {}
}
