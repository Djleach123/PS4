import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * Copyright Georgia Institute of Technology 2004-2005
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param width the width of the desired picture
   * @param height the height of the desired picture
   */
  public Picture(int width, int height)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
 
  public static void main(String[] args) 
  {
     String fileName = FileChooser.pickAFile();
     Picture pictObj = new Picture(fileName);
    /// pictObj.grayscaleWithLuminance();
  }
  
  
  public void grayscaleWithLuminance()
  {
    Pixel[] pixelArray = this.getPixels();
    Pixel pixel = null;
    int luminance = 0;
    double redValue = 0;
    double greenValue = 0;
    double blueValue = 0;

    // loop through all the pixels
    for (int i = 0; i < pixelArray.length; i++)
    {
      // get the current pixel
      pixel = pixelArray[i];

      // get the corrected red, green, and blue values
      redValue = pixel.getRed() * 0.299;
      greenValue = pixel.getGreen() * 0.587;
      blueValue = pixel.getBlue() * 0.114;

      // compute the intensity of the pixel (average value)
      luminance = (int) (redValue + greenValue + blueValue);

      // set the pixel color to the new color
      pixel.setColor(new Color(luminance,luminance,luminance));

    }
  }

  public void negate()
  {
    Pixel[] pixelArray = this.getPixels();
    Pixel pixel = null;
    int redValue, blueValue, greenValue = 0;

    // loop through all the pixels
    for (int i = 0; i < pixelArray.length; i++)
    {
      // get the current pixel
      pixel = pixelArray[i];

      // get the current red, green, and blue values
      redValue = pixel.getRed();
      greenValue = pixel.getGreen();
      blueValue = pixel.getBlue();

      // set the pixel's color to the new color
      pixel.setColor(new Color(255 - redValue,
                               255 - greenValue,
                               255 - blueValue));
    }
  }
  public void mirrorVertical()
 {
   int width = this.getWidth();
   int mirrorPoint = width / 2;
   Pixel leftPixel = null;
   Pixel rightPixel = null;

   // loop through all the rows
   for (int y = 0; y < getHeight(); y++)
   {
     // loop from 0 to the middle (mirror point)
     for (int x = 0; x < mirrorPoint; x++)
     {
       leftPixel = getPixel(x, y);
       rightPixel = getPixel(width - 1 - x, y);
       leftPixel.setColor(rightPixel.getColor());
     }
   }
 }
  
     public void collage(Picture pic1, Picture pic2, Picture pic3) 
     {
      
       // from width 0 to pic1 width
       int offset = 0;
       int sourceX = 0;
       int targetX = 0;
       int sourceY = 0;
       int targetY = 0;
       Pixel sourcePixel = null; 
       Pixel targetPixel= null; 
       
       
           for(sourceX = 0, targetX = 0; sourceX < pic1.getWidth(); sourceX++, targetX++)
       {
           for(sourceY = 0, targetY = 0; sourceY < pic1.getHeight(); sourceY++, targetY++) 
           {
              sourcePixel = pic1.getPixel(sourceX,sourceY);
              targetPixel = this.getPixel(targetX,targetY);
              targetPixel.setColor(sourcePixel.getColor());
           }
                  
         offset= pic1.getWidth();         
       }

       System.out.println(sourceX);
       System.out.println(sourceY);

       // from width pic1Width to pic2Width
       for(sourceX = 0, targetX = offset; sourceX < pic2.getWidth(); sourceX++, targetX++) 
       {
            for(sourceY = 0, targetY = 0; sourceY < pic2.getHeight(); sourceY++, targetY++)
           {
            sourcePixel = pic2.getPixel(sourceX,sourceY);
            targetPixel = this.getPixel(targetX,targetY);
            targetPixel.setColor(sourcePixel.getColor());
           }
       }
      
       offset += pic2.getWidth();
        System.out.println(sourceX);
       System.out.println(sourceY);

       // from width pic2Width to pic3Width
       for(sourceX = 0, targetX =offset; sourceX < pic3.getWidth(); sourceX++, targetX++) 
       {
            for(sourceY =0, targetY = 0; sourceY < pic3.getHeight(); sourceY++, targetY++)
           {
             sourcePixel = pic3.getPixel(sourceX,sourceY);
             targetPixel = this.getPixel(targetX,targetY);
             targetPixel.setColor(sourcePixel.getColor());
           }
       }
       System.out.println(sourceX);
       System.out.println(sourceY);
   }
 } 

   // this } is the end of class Picture, put all new methods before this
 