package dev.dmohindru.sec09.Batching;

import dev.dmohindru.sec09.Batching.assignment.OrderService;
import dev.dmohindru.sec09.Batching.assignment.PurchaseOrder;
import dev.dmohindru.sec09.Batching.assignment.OrderProcessor;
import dev.dmohindru.utils.Util;
import reactor.core.publisher.Flux;

import java.util.Map;
import java.util.Set;
import java.util.function.Function;

public class Lec06Assignment {
    public static void main(String[] args) {
        Map<String, Function<Flux<PurchaseOrder>, Flux<PurchaseOrder>>> map
                = Map.of(
                   "Kids", OrderProcessor.kidsProcessing(),
                   "Automative", OrderProcessor.automotiveProcessing()

                );

        Set<String> set = map.keySet();
        OrderService.orderStream()
                .filter(p -> set.contains(p.getCategory()))
                .groupBy(PurchaseOrder::getCategory)
                .flatMap(gf -> map.get(gf.key()).apply(gf))
                .subscribe(Util.subscriber());

        Util.sleepSeconds(60);
    }
}
