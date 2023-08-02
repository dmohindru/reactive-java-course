package dev.dmohindru.sec03.FluxEmittingItems;

import dev.dmohindru.sec03.FluxEmittingItems.assignment.FileReaderService;
import dev.dmohindru.utils.Util;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Lec09FileReaderServiceAssignment {
    public static void main(String[] args) {
        FileReaderService readerService = new FileReaderService();
        Path path = Paths.get("src/main/resources/assignment.sec03/file.txt");
        readerService.read(path)
                .map(s -> {
                    Integer integer = Util.faker().random().nextInt(0, 10);
                    if (integer > 8)
                        throw new RuntimeException("oops");
                    return s;
                })
                .take(5)
                .subscribe(Util.subscriber());
    }
}
