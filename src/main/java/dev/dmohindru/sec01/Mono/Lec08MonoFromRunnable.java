package dev.dmohindru.sec01.Mono;

import dev.dmohindru.utils.Util;
import reactor.core.publisher.Mono;

public class Lec08MonoFromRunnable {
    public static void main(String[] args) {

        /**
         * When creating Mono from a runnable it does not provide
         * any data to its subscriber but only provided a notification
         * that a task/process is completed. Like in example below
         * Util.onNext() will never be called and only onComplete()
         * functional interface will be executed.
         * Create Mono from runnable provides a Mono of type
         * Mono<Void>
         */
        Runnable runnable = () -> System.out.println("");

        Mono.fromRunnable(timeConsumingProcess())
                .subscribe(Util.onNext(),
                        Util.onError(),
                        Util.onComplete());
    }

    private static Runnable timeConsumingProcess() {
        return () -> {
            Util.sleepSeconds(3);
            System.out.println("Operation completed");
        };
    }
}
