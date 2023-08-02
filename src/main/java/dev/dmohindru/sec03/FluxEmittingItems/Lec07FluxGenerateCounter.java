package dev.dmohindru.sec03.FluxEmittingItems;

import dev.dmohindru.utils.Util;
import reactor.core.publisher.Flux;

public class Lec07FluxGenerateCounter {
    public static void main(String[] args) {
        /*
        This code example demonstrates how to maintain states between
        multiple invocation of synchronous sink instance.
        Requirement for this logic is as below
        exit requirements:
        * country is canada
        * max = 10
        * cancels when subscriber exits
        */
        Flux.generate(() -> 1,
                (counter, sink) -> {
            String country = Util.faker().country().name();
            sink.next(country);
            if (counter >= 10 || country.equalsIgnoreCase("canada")) {
                sink.complete();
            }
            return counter + 1;
        })
                .take(4)
                .subscribe(Util.subscriber());
    }
}
