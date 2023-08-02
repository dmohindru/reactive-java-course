package dev.dmohindru.sec03.FluxEmittingItems;

import dev.dmohindru.utils.Util;
import reactor.core.publisher.Flux;

public class Lec01FluxCreate {
    public static void main(String[] args) {
        /*
        This code example demonstrates how to programmatically
        emit value by a Flux producer
         */
        Flux.create(fluxSink -> {

                    String country;
                    do {
                        country = Util.faker().country().name();
                        fluxSink.next(country);
                    } while (!country.equalsIgnoreCase("canada"));

                    fluxSink.complete();
                })
                .subscribe(Util.subscriber());
    }
}
