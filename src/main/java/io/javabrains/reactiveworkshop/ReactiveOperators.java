package io.javabrains.reactiveworkshop;

import java.io.IOException;

public class ReactiveOperators {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

        // Print all values from intNumbersFlux that's greater than 5
        ReactiveSources.intNumbersFlux()
                .log()
                .filter(i -> i > 5).subscribe(i -> System.out.println(i));

        // Print 10 times each value from intNumbersFlux that's greater than 5
        ReactiveSources.intNumbersFlux()
                .filter(i -> i > 5)
                .map(i -> i * 10)
                .subscribe(i -> System.out.println(i));

        // Print 10 times each value from intNumbersFlux for the first 3 numbers emitted that's greater than 5
        ReactiveSources.intNumbersFlux()
                .filter(i -> i > 5)
                .map(i -> i * 10)
                .take(3)
                .subscribe(i -> System.out.println(i));

        // Print each value from intNumbersFlux that's greater than 20. Print -1 if no elements are found
        ReactiveSources.intNumbersFlux()
                .filter(i -> i > 20)
                .defaultIfEmpty(-1)
                .subscribe(i -> System.out.println(i));

        // Switch ints from intNumbersFlux to the right user from userFlux
        ReactiveSources.intNumbersFlux()
                .flatMap(id -> ReactiveSources.userFlux().filter(i -> i.getId() == id))
                .subscribe(i -> System.out.println(i));
        // Print only distinct numbers from intNumbersFluxWithRepeat
        ReactiveSources.intNumbersFluxWithRepeat()
                .distinct()
                .log()
                .subscribe();

        // Print from intNumbersFluxWithRepeat excluding immediately repeating numbers
        ReactiveSources.intNumbersFluxWithRepeat()
                .distinctUntilChanged()
                .log()
                .subscribe();


        System.out.println("Press a key to end");
        System.in.read();
    }

}
