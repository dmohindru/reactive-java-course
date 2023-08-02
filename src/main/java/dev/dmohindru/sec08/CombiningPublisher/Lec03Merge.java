package dev.dmohindru.sec08.CombiningPublisher;

import dev.dmohindru.sec08.CombiningPublisher.helper.American;
import dev.dmohindru.sec08.CombiningPublisher.helper.Emirates;
import dev.dmohindru.sec08.CombiningPublisher.helper.QatarFlights;
import dev.dmohindru.utils.Util;
import reactor.core.publisher.Flux;

public class Lec03Merge {
    public static void main(String[] args) {
        Flux<String> merge = Flux.merge(QatarFlights.getFlights(),
                Emirates.getFlights(),
                American.getFlights());

        merge.subscribe(Util.subscriber());

        Util.sleepSeconds(30);
    }
}
