package io.scarger.frc;

import java.io.IOException;

import static spark.Spark.*;

public class ScoutingServer {

    private static int counter = 0;

    public static void main(String[] args) throws IOException {
        String str1="192.168.0.201";
        String str2="255.255.255.0";
        String[] command1 = { "netsh", "interface", "ip", "set", "address",
                "name=", "Local Area Connection" ,"source=static", "addr=",str1,
                "mask=", str2};
        Process pp = java.lang.Runtime.getRuntime().exec(command1);
        get("/", (req, res) -> increase());
    }

    private static String increase() {
        System.out.println("PING");
        return Integer.toString(++counter);
    }
}
