package dev.dmohindru.sec01.Mono;

import reactor.core.publisher.Mono;

public class Lec02MonoJust {
    public static void main(String[] args) {

        // publisher
        Mono<Integer> mono = Mono.just(1);
        System.out.println(mono);

        mono.subscribe(i -> System.out.println("Received: " + i));
    }
}
