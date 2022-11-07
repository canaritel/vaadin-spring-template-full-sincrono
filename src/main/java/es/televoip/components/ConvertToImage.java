package es.televoip.components;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.server.StreamResource;

public class ConvertToImage {

    public static Image convertToImage(final byte[] imageData) {
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(imageData);
            BufferedImage imagen = ImageIO.read(bis);
            return (Image) imagen.getSource();
        } catch (IOException ex) {
            Logger.getLogger(ConvertToImage.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static StreamResource convertToStreamImage(byte[] imageData) {
        try {
            StreamResource streamResource = new StreamResource("isr", () -> new ByteArrayInputStream(imageData));
            return streamResource;
        } catch (NullPointerException e) {
            return null;
        }
    }

    public static byte[] convertToByte(ClassLoader classLoader2, String streamResource) {
        ClassLoader classLoader = classLoader2.getClass().getClassLoader();

        byte[] fileBytes = null;
        try ( InputStream input = classLoader
                .getResourceAsStream(streamResource)) {

            fileBytes = input.readAllBytes();
            return fileBytes;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

}
