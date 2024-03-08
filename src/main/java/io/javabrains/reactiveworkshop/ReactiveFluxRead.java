package io.javabrains.reactiveworkshop;

import java.io.IOException;

public class ReactiveFluxRead {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux() and ReactiveSources.userFlux()

        // Print all numbers in the ReactiveSources.intNumbersFlux stream
        // subscribe is like foreach in collections
        ReactiveSources.intNumbersFlux().subscribe(System.out::println);

        // Print all users in the xReactiveSources.userFlux stream
        ReactiveSources.userFlux().subscribe(System.out::println);

        System.out.println("Press a key to end");
        System.in.read();
    }

}
