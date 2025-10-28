package ek.osnb.streamdemo.funcInterfaces;

public class Main {
    public static void main(String[] args) {
        Payment card  = a -> System.out.println("Paying with card");
        Payment cash  = a -> System.out.println("Paying with cash");
        Payment mobilePay  = a -> System.out.println("Paying with mobilePay");

        card.pay(100);
    }
}
