package dev.dmohindru.sec08.CombiningPublisher.helper;

import dev.dmohindru.utils.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Emirates {
    public static Flux<String> getFlights() {
        return Flux.range(1, Util.faker().random().nextInt(1, 5))
                .delayElements(Duration.ofSeconds(1))
                .map(i -> "Emirates" + Util.faker().random().nextInt(100, 999))
                .filter(i -> Util.faker().random().nextBoolean());
    }
}
