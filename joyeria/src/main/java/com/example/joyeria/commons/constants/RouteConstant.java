package com.example.joyeria.commons.constants;

public abstract class RouteConstant {

    /**
     * <h2>Domain routes</h2>
     */
    private static final String CUSTOMERS_BASE_PATH = "${api.uri.domain.customers}";
    private static final String ROLES_BASE_PATH = "${api.uri.domain.roles}";
    private static final String AUTHORITIES_BASE_PATH = "${api.uri.domain.authorities}";
    private static final String PRODUCTS_BASE_PATH = "${api.uri.domain.products}";
    private static final String ORDERS_BASE_PATH = "${api.uri.domain.orders}";
    private static final String SHIPMENTS_BASE_PATH = "${api.uri.domain.shipments}";
    private static final String CART_BASE_PATH = "${api.uri.domain.cart}";

    /**
     * <h2>Data routes</h2>
     */
    // Data routes
    public static final String MODIFIED_PATH = "${api.uri.data.modified}";
    public static final String SEARCH_PATH = "${api.uri.data.search}";

    // Authentication and roles
    public static final String AUTHENTICATION_PATH = "${api.uri.data.authentication}";
    public static final String CUSTOMER_CONFIRM_PATH = "${api.uri.data.customerConfirm}";
    public static final String ROLES_LIST_PATH = "${api.uri.data.rolesList}";
    public static final String AUTHORITIES_LIST_PATH = "${api.uri.data.authoritiesList}";

    // Product-specific routes
    public static final String PRODUCT_TYPE_PATH = "${api.uri.data.productType}";
    public static final String PRODUCT_STOCK_PATH = "${api.uri.data.productStock}";

    // Order routes
    public static final String ORDER_DETAILS_PATH = "${api.uri.data.orderDetails}";
    public static final String ORDER_STATUS_PATH = "${api.uri.data.orderStatus}";

    // Shipment-specific routes
    public static final String SHIPMENT_DETAILS_PATH = "${api.uri.data.shipmentDetails}";

    // Payment-specific routes
    public static final String PAYMENT_METHOD_PATH = "${api.uri.data.paymentMethod}";
    public static final String PAYMENT_DETAILS_PATH = "${api.uri.data.paymentDetails}";

    // Cart-specific routes
    public static final String CART_ITEMS_PATH = "${api.uri.data.cartItems}";
    public static final String CART_CHECKOUT_PATH = "${api.uri.data.cartCheckout}";

    private RouteConstant() {}
}
