package dev.dmohindru.sec02.Flux;

import dev.dmohindru.utils.Util;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Stream;

public class Lec04FluxFromStream {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5);

        // Streams can only be worked on once and when it is closed
        // and then tried to use again it throws an error
        Stream<Integer> stream =  list.stream();
        //stream.forEach(System.out::println);
        //stream.forEach(System.out::println);

        // When a Flux is created by stream it can have only
        // one subscriber
        //Flux<Integer> integerFlux = Flux.fromStream(stream);

        // Better options is to create stream from a supplier interface
        Flux<Integer> integerFlux = Flux.fromStream(() -> list.stream());


        integerFlux.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );

        // second subscriber
        integerFlux.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );


    }
}
