package dev.dmohindru.sec03.FluxEmittingItems;

import dev.dmohindru.utils.Util;
import reactor.core.publisher.Flux;

public class Lec04FluxCreateIssueFix {
    public static void main(String[] args) {
        /*
        This code example demonstrates how a Flux producer should stop emitting
        values if a subscriber has cancelled its subscription
        Only one instance of fluxSink is used here
         */
        Flux.create(fluxSink -> {
                    String country;
                    int counter = 0;
                    do {
                        country = Util.faker().country().name();
                        System.out.println("emitting : " + country);
                        fluxSink.next(country);
                        counter++;
                    } while (!country.equalsIgnoreCase("canada") && !fluxSink.isCancelled() && counter < 10);


                    fluxSink.complete();
                })
                .take(3)
                .subscribe(Util.subscriber());
    }
}
