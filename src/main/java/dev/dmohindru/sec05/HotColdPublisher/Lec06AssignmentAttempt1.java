package dev.dmohindru.sec05.HotColdPublisher;

import dev.dmohindru.utils.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Lec06AssignmentAttempt1 {
    public static void main(String[] args) {

        /*
        Create a hot publisher using share() method. Hot publisher
        is like a tv it will broadcast even if it has no subscriber.
        Whereas cold publisher is acts like Netflix it will publish
        only when there is a subscriber
         */

        Flux<Map.Entry<String, String>> purchaseOrderStream = Flux.fromStream(() -> getPurchaseOrders())
                .delayElements(Duration.ofSeconds(1))
                .publish()
                .refCount(2);

        Util.sleepSeconds(3);
        purchaseOrderStream.subscribe(Util.subscriber("Inventory"));

        Util.sleepSeconds(10);

        System.out.println("Revenue is about to join");
        purchaseOrderStream.subscribe(Util.subscriber("Revenue"));

        Util.sleepSeconds(60);

    }

    // act as netflix
    private static Stream<Map.Entry<String, String>> getPurchaseOrders() {
        System.out.println("Got the movie streaming req");

        Map<String, String> purchaseOrders = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            purchaseOrders.put(
                    Util.faker().commerce().productName(),
                    Util.faker().commerce().price()
            );

        }

        return purchaseOrders.entrySet().stream();

    }
}
