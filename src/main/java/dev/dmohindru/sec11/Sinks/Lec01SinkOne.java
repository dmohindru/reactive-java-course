package dev.dmohindru.sec11.Sinks;

import dev.dmohindru.utils.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

public class Lec01SinkOne {
    public static void main(String[] args) {

        // mono 1 value / empty / error
        Sinks.One<Object> sink = Sinks.one();

        Mono<Object> mono = sink.asMono();

        mono.subscribe(Util.subscriber("sam"));
        mono.subscribe(Util.subscriber("mike"));

        /*sink.emitValue("hi", ((signalType, emitResult) -> {
            System.out.println(signalType.name());
            System.out.println(emitResult.name());
            return false;
        }));

        sink.emitValue("Hello", ((signalType, emitResult) -> {
            System.out.println(signalType.name());
            System.out.println(emitResult.name());
            return true;
        })); */

        sink.tryEmitValue("Hello");
    }
}
