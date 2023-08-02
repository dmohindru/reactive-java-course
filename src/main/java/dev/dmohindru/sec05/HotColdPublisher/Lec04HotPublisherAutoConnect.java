package dev.dmohindru.sec05.HotColdPublisher;

import dev.dmohindru.utils.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class Lec04HotPublisherAutoConnect {
    public static void main(String[] args) {

        /*
        Create a hot publisher using share() method. Hot publisher
        is like a tv it will broadcast even if it has no subscriber.
        Whereas cold publisher is acts like Netflix it will publish
        only when there is a subscriber
         */
        Util.sleepSeconds(10);
        Flux<String> movieStream = Flux.fromStream(() -> getMovie())
                .delayElements(Duration.ofSeconds(1))
                .publish()
                .autoConnect(0);

        Util.sleepSeconds(3);
        movieStream.subscribe(Util.subscriber("sam"));

        Util.sleepSeconds(10);

        System.out.println("Mike is about to join");
        movieStream.subscribe(Util.subscriber("mike"));

        Util.sleepSeconds(60);

    }

    // act as netflix
    private static Stream<String> getMovie() {
        System.out.println("Got the movie streaming req");
        return Stream.of(
                "Scene 1",
                "Scene 2",
                "Scene 3",
                "Scene 4",
                "Scene 5",
                "Scene 6",
                "Scene 7"
        );

    }
}
