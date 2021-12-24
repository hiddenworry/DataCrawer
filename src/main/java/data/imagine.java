/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;
import java.net.URL;
import java.util.Arrays;
import java.util.HashSet;


/**
 *
 * @author ADMIN
 */
public class imagine {
    private String format;
    private final String Imgformats[] = {".jpg", ".apng", ".avif", ".gif", ".jpg", ".jpeg", ".jfif", ".pjpeg", ".pjp", ".ico", ".png", ".svg"}; 
    
    public String checkImg(String filelink){
        for (String Imgformat : Imgformats) {
//            System.out.println(filelink);
            if (filelink.indexOf(Imgformat) > 0)
                return Imgformat;
        }
            return null;
  }

}

    

