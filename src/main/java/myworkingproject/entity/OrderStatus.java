package myworkingproject.entity;

public enum OrderStatus {
    CREATED("Created"),
    OPEN("Open"),
    COMPLETED("Completed"),
    CLOSE("Close"),
    DELETE("Delete");

    private String value;

    OrderStatus(String value) {
        this.value = value;
    }

    public static OrderStatus fromString(String value){
        if (value != null) {
            for (OrderStatus orderStatus : OrderStatus.values()) {
                if (value.equalsIgnoreCase(orderStatus.value)) {
                    return orderStatus;
                }
            }
        }

        throw new IllegalArgumentException("There is no such status value");
    }
}
