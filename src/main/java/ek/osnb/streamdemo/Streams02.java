package ek.osnb.streamdemo;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Streams02 {

    record Item(String description, double price) { }
    record OrderLine(Item item, int quantity) { }
    record Order(String orderId, List<OrderLine> orderLines) { }
    public static void main(String[] args) {
        List<Item> items = List.of(
                new Item("Book", 12.99),
                new Item("Keyboard", 199.99),
                new Item("Monitor", 2299.99),
                new Item("Mouse", 49.99),
                new Item("Desk", 2399.99),
                new Item("Chair", 899.99)
        );

        List<Order> orders = List.of(
                new Order("ORD001", List.of(
                        new OrderLine(items.get(0), 2),
                        new OrderLine(items.get(1), 1)
                )),
                new Order("ORD002", List.of(
                        new OrderLine(items.get(2), 1),
                        new OrderLine(items.get(3), 3)
                )),
                new Order("ORD003", List.of(
                        new OrderLine(items.get(4), 1),
                        new OrderLine(items.get(5), 2)
                )),
                new Order("ORD004", List.of(
                        new OrderLine(items.get(0), 1),
                        new OrderLine(items.get(3), 1),
                        new OrderLine(items.get(5), 1)
                ))
        );

        // TODO: Get total revenue from all orders

        // TODO: Find the most expensive item sold across all orders

        // TODO: Find the best order (highest total value)

        // TODO: List all items sold above a certain price threshold (e.g., $1000)

        // TODO: Show total quantity sold per item

        // TODO: Calculate average order value

        // TODO: List all orders containing a specific item (e.g., "Mouse")

    }
}
