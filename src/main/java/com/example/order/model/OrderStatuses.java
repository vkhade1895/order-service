package com.example.order.model;

public enum OrderStatuses {
        PENDING("Pending"),
        PROCESSING("Processing"),
        SHIPPED("Shipped"),
        DELIVERED("Delivered"),
        CANCELLED("Cancelled");

        private final String orderStatus;

        OrderStatuses(String orderStatus) {
                this.orderStatus = orderStatus;
        }

        public static OrderStatuses getOrderName(String displayName) {
                for (OrderStatuses status : OrderStatuses.values()) {
                        if (status.orderStatus.equalsIgnoreCase(displayName)) {
                                return status;
                        }
                }
                throw new IllegalArgumentException("No enum constant with display name " + displayName);
        }

}