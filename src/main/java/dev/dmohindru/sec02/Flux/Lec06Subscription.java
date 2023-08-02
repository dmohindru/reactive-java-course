package dev.dmohindru.sec02.Flux;

import dev.dmohindru.utils.Util;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicReference;

public class Lec06Subscription {
    public static void main(String[] args) {

        /* As per specification when you create your own subscriber
         1. You need to request for data explicitly with request() method
         2. Once you have canceled your subscription with cancel() method
            you cannot request more data from publisher
         */
        AtomicReference<Subscription> atomicReference = new AtomicReference<>();
        Flux.range(1, 20)
                .log()
                .subscribeWith(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription subscription) {
                        System.out.println("Received Sub: " + subscription);
                        atomicReference.set(subscription);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println("OnNext: " + integer);

                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println("OnError : " + throwable.getMessage());

                    }

                    @Override
                    public void onComplete() {
                        System.out.println("onComplete");

                    }
                });

        Util.sleepSeconds(3);
        atomicReference.get().request(3);
        Util.sleepSeconds(5);
        atomicReference.get().request(3);
        Util.sleepSeconds(5);
        System.out.println("going to cancel");
        atomicReference.get().cancel();
        Util.sleepSeconds(3);
        atomicReference.get().request(4);

    }
}
