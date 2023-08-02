package dev.dmohindru.sec03.FluxEmittingItems;

import dev.dmohindru.sec03.FluxEmittingItems.helper.NameProducer;
import dev.dmohindru.utils.Util;
import reactor.core.publisher.Flux;

public class Lec02FluxCreateRefactoring {
    public static void main(String[] args) {

        /*
        Refactored version of Lec01 example
         */
        NameProducer nameProducer = new NameProducer();

        Flux.create(nameProducer)
                .subscribe(Util.subscriber());

        Runnable runnable = nameProducer::produce;
        for (int i = 0; i < 10; i++) {
            new Thread(runnable).start();

        }

        Util.sleepSeconds(2);
    }
}
