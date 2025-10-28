package ek.osnb.streamdemo;

import java.util.List;
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
        double total = orders.stream()
                .flatMap(o -> o.orderLines.stream())
                .mapToDouble(ol -> ol.item.price * ol.quantity)
                .sum();
        System.out.println("Total revenue: " + total);

        // TODO: Find the most expensive item sold across all orders
        double max = orders.stream()
                .flatMap(o -> o.orderLines.stream())
                .mapToDouble(ol -> ol.item.price)
                .max()
                .orElse(0.0);
        System.out.println("Most expensive item: " + max);

        // TODO: Find the best order (highest total value)
        String orderId = orders.stream()
                .max((o1, o2) -> {
                    return Double.compare(
                            o1.orderLines.stream().mapToDouble(ol -> ol.quantity * ol.item.price).sum(),
                            o2.orderLines.stream().mapToDouble(ol -> ol.quantity * ol.item.price).sum()
                    );
                })
                .map(o -> o.orderId)
                        .orElse(null);


        System.out.println(orderId);

        // TODO: List all items sold above a certain price threshold (e.g., $1000)
        orders.stream()
                .flatMap(o -> o.orderLines.stream())
                .filter(ol -> ol.item.price > 1000)
                .forEach(System.out::println);

        System.out.println();

        // TODO: Show total quantity sold per item
        orders.stream()
                .flatMap(o -> o.orderLines.stream())
                .collect(Collectors.groupingBy(ol -> ol.item.description, Collectors.summingInt(ol -> ol.quantity)))
                .forEach((a,b) -> System.out.println(a + " - " + b));

        System.out.println();

        // TODO: Calculate average order value
        double avg = orders.stream()
                .map(o -> o.orderLines.stream()
                        .mapToDouble(ol -> ol.quantity*ol.item.price)
                        .sum()
                )
                .mapToDouble(a -> a.doubleValue())
                .average()
                .orElse(0.0);
        System.out.println(avg);


        System.out.println();

        // TODO: List all orders containing a specific item (e.g., "Mouse")
        orders.stream()
                .filter(o -> o.orderLines.stream().anyMatch(ol -> ol.item.description.equalsIgnoreCase("mouse")))
                .forEach(System.out::println);
    }
}
