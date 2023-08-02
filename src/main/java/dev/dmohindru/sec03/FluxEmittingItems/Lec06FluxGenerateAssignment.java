package dev.dmohindru.sec03.FluxEmittingItems;

import dev.dmohindru.utils.Util;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicInteger;

public class Lec06FluxGenerateAssignment {
    public static void main(String[] args) {


        /*
        This code example is re implementation of same used
        implemented in class Lec01FluxCreate
         */
        Flux.generate(synchronousSink -> {

                    String country = Util.faker().country().name();
                    System.out.println("emitting: " + country);
                    synchronousSink.next(country);
                    if (country.equalsIgnoreCase("canada")) {
                        synchronousSink.complete();
                    }

                })
                .subscribe(Util.subscriber());
    }
}
