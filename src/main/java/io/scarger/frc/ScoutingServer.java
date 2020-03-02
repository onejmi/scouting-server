package io.scarger.frc;

import static spark.Spark.*;

public class ScoutingServer {

    private static int counter = 0;

    public static void main(String[] args) {
        get("/", (req, res) -> increase());
    }

    private static String increase() {
        System.out.println("PING");
        return Integer.toString(++counter);
    }
}
