package dev.dmohindru.sec03.FluxEmittingItems;

import dev.dmohindru.utils.Util;
import reactor.core.publisher.Flux;

public class Lec03FluxTake {
    public static void main(String[] args) {

        /*
        take operator example
         */
        Flux.range(1, 10)
                .log()
                .take(3) // cancels subscription at count of three and sends onComplete() signal down stream
                .log()
                .subscribe(Util.subscriber());
    }
}
