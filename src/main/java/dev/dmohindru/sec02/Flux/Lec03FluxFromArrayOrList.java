package dev.dmohindru.sec02.Flux;

import dev.dmohindru.utils.Util;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

public class Lec03FluxFromArrayOrList {
    public static void main(String[] args) {

        // Flux from iterable
        List<String> strings = Arrays.asList("a", "b", "c");
        Flux.fromIterable(strings)
                .subscribe(Util.onNext());

        // Flux from Array
        Integer[] arr = {2, 5, 7, 8};
        Flux.fromArray(arr)
                .subscribe(Util.onNext());
    }
}
