package dev.dmohindru.sec01.Mono;

import dev.dmohindru.sec01.Mono.assignment.FileService;
import dev.dmohindru.utils.Util;

public class Lec09AssignmentDemo {
    public static void main(String[] args) {
        FileService.read("file03.txt")
                .subscribe(Util.onNext(),
                        Util.onError(),
                        Util.onComplete());

        /*FileService.write("file03.txt", "This is file3")
                .subscribe(Util.onNext(),
                        Util.onError(),
                        Util.onComplete()); */

        FileService.delete("file03.txt")
                .subscribe(Util.onNext(),
                Util.onError(),
                Util.onComplete());
    }
}
