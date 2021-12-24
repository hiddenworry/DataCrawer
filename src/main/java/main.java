
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
        String url = "https://ttphats.github.io/Skillcetera-Store/?fbclid=IwAR3A3P6i6sXuajurOGDpFuIvuP1WyCe-lcQWAmqjuG1V4sLMWphMif0B2Qc#";
       webpage w = new webpage(url);
       w.gethtml();
     w.downloadAllImg(); 
     w.getCss();
      // w.downloadAllImg();
    }
}

