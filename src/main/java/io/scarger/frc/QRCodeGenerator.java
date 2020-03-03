package io.scarger.frc;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class QRCodeGenerator {

    public byte[] generateQRCode(String address) {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        try {
            BitMatrix codeBits =  qrCodeWriter.encode(address, BarcodeFormat.QR_CODE, 250, 250);
            BufferedImage bitsImage = MatrixToImageWriter.toBufferedImage(codeBits);
            byte[] rawImage;
            try(ByteArrayOutputStream baStream = new ByteArrayOutputStream()) {
                ImageIO.write( bitsImage, "jpg", baStream );

                baStream.flush();
                rawImage = baStream.toByteArray();
                return rawImage;
            } catch (IOException e) {}
        } catch (WriterException e) {
            e.printStackTrace();
        }
        return null;
    }
}
