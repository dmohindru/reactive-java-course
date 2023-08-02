package dev.dmohindru.sec11.Sinks;

import dev.dmohindru.sec11.Sinks.assignment.SlackMember;
import dev.dmohindru.sec11.Sinks.assignment.SlackRoom;
import dev.dmohindru.utils.Util;

public class Lec07SlackDemo {
    public static void main(String[] args) {

        SlackRoom slackRoom = new SlackRoom("reactor");

        SlackMember sam = new SlackMember("sam");
        SlackMember jake = new SlackMember("jake");
        SlackMember mike = new SlackMember("mike");

        slackRoom.joinRoom(sam);
        slackRoom.joinRoom(jake);

        sam.says("Hi all....");
        Util.sleepSeconds(4);

        jake.says("Hey!");
        sam.says("I simply wanted to say hi....");
        Util.sleepSeconds(4);

        slackRoom.joinRoom(mike);
        mike.says("Hey guys...glad to be here...");

    }
}
