package dev.dmohindru.sec05.HotColdPublisher;

import dev.dmohindru.sec05.HotColdPublisher.assignment.InventoryService;
import dev.dmohindru.sec05.HotColdPublisher.assignment.OrderService;
import dev.dmohindru.sec05.HotColdPublisher.assignment.RevenueService;
import dev.dmohindru.utils.Util;

public class Lec06Assignment {
    public static void main(String[] args) {

        OrderService orderService = new OrderService();
        RevenueService revenueService = new RevenueService();
        InventoryService inventoryService = new InventoryService();

        // revenue and inventory - observe the order stream
        orderService.orderSteam().subscribe(revenueService.subscribeOrderStream());
        orderService.orderSteam().subscribe(inventoryService.subscribeOrderStream());

        inventoryService.inventoryStream()
                .subscribe(Util.subscriber("inventory"));

        revenueService.revenueStream()
                .subscribe(Util.subscriber("revenue"));

        Util.sleepSeconds(60);

    }
}
