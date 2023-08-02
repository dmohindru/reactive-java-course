package dev.dmohindru.sec03.FluxEmittingItems;

import dev.dmohindru.utils.Util;
import reactor.core.publisher.Flux;

public class Lec05FluxGenerate {
    public static void main(String[] args) {
        /*
        This code example demonstrates to create a producer with
        Flux.generate() method. Here synchronousSink's new instance
        will be created repeatedly by generate method until
        complete() or error() method is called.
         */

        Flux.generate(synchronousSink -> {
            System.out.println("emitting");
            synchronousSink.next(Util.faker().country().name());
            synchronousSink.complete();
//            synchronousSink.error(new RuntimeException("oops"));

        })
        .take(2)
        .subscribe(Util.subscriber());
    }
}
