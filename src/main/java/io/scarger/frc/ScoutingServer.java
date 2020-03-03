package io.scarger.frc;

import java.io.IOException;
import java.net.InetAddress;

import static spark.Spark.*;

public class ScoutingServer {

    private static int counter = 0;
    private static final int port = 4567;

    //TODO automatic network creation / config on start
    //TODO make requests case insensitive

    public static void main(String[] args) throws IOException {
        QRCodeGenerator qrCodeGenerator = new QRCodeGenerator();
        String address = InetAddress.getLocalHost().getHostAddress() + ":" + port;
        byte[] rawQRCode = qrCodeGenerator.generateQRCode(address);
        System.out.println("Scouting server running on " + address);
        port(port);
        get("/", (req, res) -> increase());
        get("/qrcode", (req, res) -> {
            res.header("Content-Type", "image/jpeg");
            return rawQRCode;
        });
    }

    private static String increase() {
        System.out.println("PING");
        return Integer.toString(++counter);
    }
}
