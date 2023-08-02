package dev.dmohindru.sec12.Context;

import dev.dmohindru.sec12.Context.helper.BookService;
import dev.dmohindru.sec12.Context.helper.UserService;
import dev.dmohindru.utils.Util;
import reactor.util.context.Context;

public class Lec02CtxRateLimiterDemo {

    public static void main(String[] args) {
        BookService.getBook()
                .repeat(3)
                .contextWrite(UserService.userCategoryContext())
                .contextWrite(Context.of("user", "mike"))
                .subscribe(Util.subscriber());


    }
}
