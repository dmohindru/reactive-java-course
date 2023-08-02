package dev.dmohindru.sec02.Flux;

import dev.dmohindru.utils.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lec09FluxFromMono {
    public static void main(String[] args) {
        /*
        // Create a Flux from Mono
        Mono<String> mono = Mono.just("a");
        Flux<String> flux = Flux.from(mono);
        flux.subscribe(Util.onNext());
         */

        // Create a Mono from Flux
        Flux.range(1, 10)
                .filter(i -> i > 3)
                .next()
                .subscribe(Util.onNext(), Util.onError(), Util.onComplete());


    }

    private static void doSomething(Flux<String> flux) {

    }
}
