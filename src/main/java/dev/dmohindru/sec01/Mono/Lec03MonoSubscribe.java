package dev.dmohindru.sec01.Mono;

import dev.dmohindru.utils.Util;
import reactor.core.publisher.Mono;

public class Lec03MonoSubscribe {
    public static void main(String[] args) {


        // publisher with no error
        Mono<Integer> mono = Mono.just("ball")
                .map(s -> s.length())
                .map(l -> l / 2);


        // 1 - This method make the mono publisher to emit data
        mono.subscribe();

        // 2
        mono.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );


    }
}
