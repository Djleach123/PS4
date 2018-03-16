/*
 * Filename: PSA4.java
 * Created by: Dominic Leach, 3/15/2018... 5709954
 *        
 *
 *
 * Description: This class is designed to...
 *
 */

public class PSA4
{
    public static void main (String[] args)
    {
        String fileName = FileChooser.pickAFile();
      Picture picture = new Picture (fileName); 
        
       Picture pic1 = new Picture(picture);
       Picture pic2 = new Picture(picture);
       Picture pic3 = new Picture(picture);
       
       pic1.grayscaleWithLuminance();
       pic2.negate();
       pic3.mirrorVertical();
       
       
       
       

       Picture result = new Picture(pic1.getWidth() * 3, pic1.getHeight());

       result.collage(pic1, pic2, pic3);

       result.show();
    }
}