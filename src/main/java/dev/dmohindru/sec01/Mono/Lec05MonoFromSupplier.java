package dev.dmohindru.sec01.Mono;

import dev.dmohindru.utils.Util;
import reactor.core.publisher.Mono;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class Lec05MonoFromSupplier {
    public static void main(String[] args) {

        // Example of demonstrate that subscriber should only work
        // if it has any subscriber
        // use just only when you have data already
        // Mono<String> mono = Mono.just(getName());

        // Just create a supplier and do not retrieve any data as we don't
        // have any subscriber yet
        // Create Mono from Supplier
        Supplier<String> stringSupplier = () -> getName();
        Mono<String> mono = Mono.fromSupplier(stringSupplier);
        mono.subscribe(
                Util.onNext()
        );


        // Create Mono from Callable
        Callable<String> stringCallable = () -> getName();
        Mono.fromCallable(stringCallable)
                .subscribe(
                        Util.onNext()
                );


    }

    private static String getName() {
        System.out.println("Generating name...");
        return Util.faker().name().fullName();
    }
}
