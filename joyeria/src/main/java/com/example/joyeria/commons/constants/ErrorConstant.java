package com.example.joyeria.commons.constants;

public class ErrorConstant {

    /** Generic server error code. */
    public static final Integer GENERIC_ERROR_CODE = 500;

    /** Generic server error message. */
    public static final String GENERIC_ERROR_MESSAGE = "An unknown error occurred";

    /** Bad request error code. */
    public static final Integer BAD_REQUEST_CODE = 400;

    /** Not found error code. */
    public static final Integer NOT_FOUND_CODE = 404;

    /** Unauthorized error code. */
    public static final Integer UNAUTHORIZED_CODE = 401;

    /** Forbidden error code. */
    public static final Integer FORBIDDEN_CODE = 403;

    /** Conflict error code (e.g., data already exists). */
    public static final Integer CONFLICT_CODE = 409;

    /** Error message for record not found. */
    public static final String RECORD_NOT_FOUND_MESSAGE = "Record not found";

    /** Error message for invalid credentials. */
    public static final String INVALID_CREDENTIALS_MESSAGE = "Invalid username or password";

    /** Error message for unauthorized access. */
    public static final String UNAUTHORIZED_ACCESS_MESSAGE = "Unauthorized access";

    /** Error message for forbidden access. */
    public static final String FORBIDDEN_ACCESS_MESSAGE = "Access forbidden";

    /** Error message for data conflict (e.g., already exists). */
    public static final String DATA_CONFLICT_MESSAGE = "Data conflict, already exists";

    /** Error message for non-existent customer. */
    public static final String CUSTOMER_NOT_FOUND = "Customer does not exist";

    /** Error message for non-existent payment. */
    public static final String PAYMENT_NOT_FOUND = "Payment record not found";

    /** Error message for non-existent product. */
    public static final String PRODUCT_NOT_FOUND = "Product does not exist";

    /** Error message for non-existent shipment. */
    public static final String SHIPMENT_NOT_FOUND = "Shipment record not found";

    /** Error message for non-existent order. */
    public static final String ORDER_NOT_FOUND = "Order record not found";

    /** Error message for non-existent cart item. */
    public static final String CART_ITEM_NOT_FOUND = "Cart item does not exist";

    /** Error message for insufficient stock. */
    public static final String INSUFFICIENT_STOCK = "Insufficient stock for product";

    /** Error message for invalid order state. */
    public static final String INVALID_ORDER_STATE = "Invalid order state";

    private ErrorConstant() {}
}
