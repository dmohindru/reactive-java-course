package dev.dmohindru.sec03.FluxEmittingItems;

import dev.dmohindru.sec03.FluxEmittingItems.helper.NameProducer;
import dev.dmohindru.utils.Util;
import reactor.core.publisher.Flux;

public class Lec08FluxPush {
    public static void main(String[] args) {
        /*
        This code example is similar to code example in
        class Lec02FluxCreateRefactoring. Only difference is
        Flux.push() is not thread safe.
         */
        NameProducer nameProducer = new NameProducer();

        Flux.push(nameProducer)
                .subscribe(Util.subscriber());

        Runnable runnable = nameProducer::produce;
        for (int i = 0; i < 10; i++) {
            new Thread(runnable).start();

        }

        Util.sleepSeconds(2);
    }
}
