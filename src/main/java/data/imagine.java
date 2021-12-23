/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;
import java.util.Arrays;
import java.util.HashSet;


/**
 *
 * @author ADMIN
 */
public class imagine {
    private String format;
    private final String Imgformats[] = {".jpg", ".apng", ".avif", ".gif", ".jpg", ".jpeg", ".jfif", ".pjpeg", ".pjp", ".icon", ".png"}; 
    private HashSet<String>formatSet = null; ;
    
    public imagine() {
         this.formatSet = new HashSet<String>(Arrays.asList(Imgformats));
    }
    
    
    public boolean IsImagine(String fileStyle){
        System.out.println(fileStyle);
        return formatSet.contains(fileStyle) == true;
    
  }

    
}
