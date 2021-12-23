
import data.webpage;
import java.io.IOException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class main {
    public static void main(String[] args) throws IOException {
        String url = "https://www.pinterest.com/debratstanley/beautiful-scenes/";
       webpage w = new webpage(url);
       w.gethtml();
   //   w.downloadAllImg(); 
      w.getCss();
      // w.downloadAllImg();
    }
}

