package dev.dmohindru.sec08.CombiningPublisher;

import dev.dmohindru.sec08.CombiningPublisher.helper.NameGenerator;
import dev.dmohindru.utils.Util;

public class Lec01StartWith {
    public static void main(String[] args) {
        NameGenerator generator = new NameGenerator();
        generator.generateNames()
                .take(2)
                .subscribe(Util.subscriber("sam"));

        generator.generateNames()
                .take(2)
                .subscribe(Util.subscriber("mike"));

        generator.generateNames()
                .take(3)
                .subscribe(Util.subscriber("Jake"));

        generator.generateNames()
                .filter(n -> n.startsWith("A"))
                .take(1)
                .subscribe(Util.subscriber("Marshal"));
    }
}
