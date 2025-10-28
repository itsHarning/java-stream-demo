package ek.osnb.streamdemo;

import java.util.function.Consumer;

public class ConsumerImpl<String> implements Consumer<String> {
    @Override
    public void accept(String t) {
        System.out.println(t.toString().toUpperCase());
    }
}
