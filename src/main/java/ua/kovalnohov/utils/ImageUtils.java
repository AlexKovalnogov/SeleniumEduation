package ua.kovalnohov.utils;

import net.sourceforge.tess4j.Tesseract;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class ImageUtils {
    static final int DELTA = 3;

    public static BufferedImage cleanImage(BufferedImage source){
        BufferedImage clone = new BufferedImage(source.getWidth(),
                source.getHeight(), source.getType());
        Graphics2D g2d = clone.createGraphics();
        g2d.drawImage(source, 0, 0, null);
        g2d.dispose();
        for(int i=0;i<clone.getWidth();i++){
            for(int j=0;j<clone.getHeight();j++){
                int rgb = clone.getRGB(i,j);
                if( rgb == Color.WHITE.getRGB()){
                    continue;
                }
                if( isEligible(clone, i,j)) {
                    continue;
                }
                else {
                    clone.setRGB(i,j,Color.WHITE.getRGB());
                }

            }
        }

        return clone;

    }

    public static boolean isEligible(BufferedImage img, int x, int y){
        int left  = x-1;
        while (  left < 0 &&  x -left < 2* DELTA) {
            if( img.getRGB(left,y) == Color.WHITE.getRGB()) {
                break;
            }
            left --;
        }
        if( left < 0) {
            return false;
        }
        int right = x + 1;

        while ( right < img.getWidth() && right - left < 2 * DELTA) {
            if( img.getRGB(right,y) == Color.WHITE.getRGB()) {
                break;
            }
            right++;
        }
        if( right > img.getWidth()) {
            return false;
        }
        int top = y -1;
        while (top >0 && y - top < 2 * DELTA) {
            if( img.getRGB(x,top) == Color.WHITE.getRGB()) {
                break;
            }
            top --;
        }
        if( top < 0) {
            return false;
        }
        int bottom = y+1;
        while (bottom < img.getHeight() && bottom -top < 2* DELTA) {
            if( img.getRGB( x,bottom) == Color.WHITE.getRGB()) {
                break;
            }
            bottom++;
        }
        if( bottom > img.getHeight()) {
            return false;
        }


        int width = right -left;
        int height =  bottom - top;
        if( width >= DELTA && height >= DELTA) {
            return true;
        }
        return false;

    }
    public static String getCapchaValue(String link) {
        String result="";
        try {
            URL url = new URL(link);
            InputStream is = url.openStream();
            OutputStream os = new FileOutputStream("image.png");

            byte[] b = new byte[2048];
            int length;

            while ((length = is.read(b)) != -1) {
                os.write(b, 0, length);
            }

            is.close();
            os.close();
                File f =new File("image.png");
            BufferedImage image = ImageIO.read(f);
            BufferedImage clean = cleanImage(image);
            ImageIO.write(clean, "png",new File("clean.png"));
            Tesseract tesseract = new Tesseract();
           tesseract.setDatapath("C:\\tessdata");
           tesseract.setOcrEngineMode(2);
            tesseract.setPageSegMode(1);

            tesseract.setLanguage("eng");
          result = tesseract.doOCR( clean);
            return  result;
            } catch (Exception e) {

        }

return  result;


    }
}