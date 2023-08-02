package dev.dmohindru.sec02.Flux;

import dev.dmohindru.utils.Util;
import reactor.core.publisher.Flux;

public class Lec01FluxIntro {
    public static void main(String[] args) {
        // Flux with just and homogenous data
        //Flux<Integer> flux = Flux.just(1, 2, 3, 4);

        // Empty flux
        //Flux<Integer> flux = Flux.empty();

        // Flux with mixed data
        Flux<Object> flux = Flux.just(1, 2, 3, "a", Util.faker().name().fullName());

        flux.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete());
    }
}
