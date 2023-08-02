package dev.dmohindru.sec02.Flux;

import dev.dmohindru.sec02.Flux.helper.NameGenerator;
import dev.dmohindru.utils.Util;

public class Lec07FluxVsList {
    public static void main(String[] args) {

        /*
        The subtle difference between two approach to generate 5 name
        1. Method getNames() that generate list has to wait full 5 seconds to supply 5 name
        2. Method getNames() that generate Flux has to wait for only 1 second to supply each name.
        Note: In both the methods above its takes full 5 seconds to generate five name, however
        the difference is when these names become available.
         */

        //List<String> names = NameGenerator.getNames(5);
        //System.out.println(names);
        NameGenerator.getNames(5)
                        .subscribe(Util.onNext());

    }
}
