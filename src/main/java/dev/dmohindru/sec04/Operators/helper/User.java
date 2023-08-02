package dev.dmohindru.sec04.Operators.helper;

import dev.dmohindru.utils.Util;
import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class User {

    private int userId;
    private String name;

    public User(int userId) {
        this.userId = userId;
        this.name = Util.faker().name().fullName();
    }
}
