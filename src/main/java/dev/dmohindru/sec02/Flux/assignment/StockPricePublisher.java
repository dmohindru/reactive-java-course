package dev.dmohindru.sec02.Flux.assignment;

import dev.dmohindru.utils.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

public class StockPricePublisher {

    /*
    Generate a continuous steam of stock price with starting value of 100
    and adding values random value to stock price.
     */
    public static Flux<Integer> getPrice() {
        AtomicInteger atomicInteger = new AtomicInteger(100);
        return Flux.interval(Duration.ofSeconds(1))
                .map(i -> atomicInteger.getAndAccumulate(
                        Util.faker().random().nextInt(-5, 5),
                        (a, b) -> a + b
                ));
    }


}
