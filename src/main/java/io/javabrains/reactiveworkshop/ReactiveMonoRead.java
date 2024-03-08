package io.javabrains.reactiveworkshop;

import java.io.IOException;

public class ReactiveMonoRead {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono()

        // Print the value from intNumberMono when it emits
        ReactiveSources.intNumberMono().subscribe(System.out::println);

        // Get the value from the Mono into an integer variable
        Integer n = ReactiveSources.intNumberMono().block();
        System.out.println("n.." + n);

        System.out.println("Press a key to end");
        System.in.read();
    }

}
