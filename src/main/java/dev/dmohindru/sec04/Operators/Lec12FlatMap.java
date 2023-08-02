package dev.dmohindru.sec04.Operators;

import dev.dmohindru.sec04.Operators.helper.OrderService;
import dev.dmohindru.sec04.Operators.helper.UserService;
import dev.dmohindru.utils.Util;

public class Lec12FlatMap {

    public static void main(String[] args) {
        /*
        Here OrderService returns Flux<PurchaseOrder>. To retrieve elements of
        this flux we need to call flatMap operator.
         */
        UserService.getUsers()
                .flatMap(user -> OrderService.getOrders(user.getUserId()))
                //.concatMap(user -> OrderService.getOrders(user.getUserId()))
                .subscribe(Util.subscriber());

        Util.sleepSeconds(60);

    }
}
