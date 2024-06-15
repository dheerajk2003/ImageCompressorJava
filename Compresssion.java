import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.Buffer;
import java.util.Iterator;
import java.util.Scanner;

import javax.imageio.*;
import javax.imageio.stream.*;

public class Compresssion {

  public static void main(String[] args) throws IOException {


    // a bit lossless comp ------------>

    // File input = new File("three.jpg");
    // BufferedImage image = ImageIO.read(input);

    // File compressedImageFile = new File("compressed_image.jpg");
    // OutputStream os = new FileOutputStream(compressedImageFile);

    // Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("jpg");
    // ImageWriter writer = (ImageWriter) writers.next();

    // ImageOutputStream ios = ImageIO.createImageOutputStream(os);
    // writer.setOutput(ios);

    // ImageWriteParam param = writer.getDefaultWriteParam();

    // param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
    // param.setCompressionQuality(0.2f);  // Change the quality value you prefer
    // writer.write(null, new IIOImage(image, null, null), param);

    // os.close();
    // ios.close();
    // writer.dispose();

    try{
      Scanner scn = new Scanner(System.in);
      System.out.println("enter file path");
      String input = scn.next();
      System.out.println("Enter the amount of compression in digits: ");
      int size = scn.nextInt();
      BufferedImage bi = ImageIO.read(new File(input));
      int nWidth = bi.getWidth()/size;
      int nHeight = bi.getHeight()/size;
      BufferedImage nBI = new BufferedImage(nWidth, nHeight, bi.getType());

      // Graphics2D gd = nBI.createGraphics();
      // gd.drawImage(bi,0,0,nWidth,nHeight,null);
      // gd.dispose();

      for(int i=0; i<nWidth; i++){
        for(int j=0; j<nHeight; j++){
          nBI.setRGB(i, j, bi.getRGB(i*size, j*size));
        }
      }

      File output = new File("compressed_image.jpg");
      ImageIO.write(nBI, "jpg", output);
    }
    catch(Exception e){
      System.out.println(e);
    }

  }
}