package dev.dmohindru.sec01.Mono;

import dev.dmohindru.utils.Util;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

public class Lec06SupplierRefactoring {

    /** Building a pipeline is different from executing a pipeline
     * In method below getName() only builds a pipeline. So just by
     * calling getName() are only building a pipeline and not executing.
     * To execute a pipeline we need to subscribe to the pipeline as it is
     * done in main method at line 22
     *
     *
     */
    public static void main(String[] args) {
        getName();
        // here block is also a subscriber which waits for result to arrive and
        // returns the data thereafter
        String name = getName()
                .subscribeOn(Schedulers.boundedElastic())
                .block();
        System.out.println(name);
        getName();
        Util.sleepSeconds(4);
    }

    private static Mono<String> getName() {
        System.out.println("Entered getName method");
        return Mono.fromSupplier(() -> {
            System.out.println("Generating name...");
            Util.sleepSeconds(3);
            return Util.faker().name().fullName();
        }).map(String::toUpperCase);
    }
}
