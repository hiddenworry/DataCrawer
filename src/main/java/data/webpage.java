/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 *
 * @author ADMIN
 */
public class webpage {

    private URL url;
    private InputStream is = null;
    private OutputStream os = null;
    Document doc = null;
    String outputdir = "E:\\Crawer-java-tool\\";

    public webpage(String url) throws MalformedURLException, IOException {
        this.url = new URL(url);
        this.doc = Jsoup.connect(url).timeout(1000000).get();
    }
//// download img
    public void downloadAllImg() throws IOException {
        ArrayList<Element> imgList = new ArrayList();
        ArrayList <Element> imgLink = new ArrayList();
        // get all possible img
        imgList = doc.getElementsByTag("img");
        imgLink = doc.getElementsByTag("link");
        int name = 0;
        for (Element element : imgList) {
            String src = element.absUrl("src");
            String filetype = src.substring(src.lastIndexOf("."));
            System.out.println(name + filetype);
           downloadFromsrc(src, String.valueOf(name), filetype );
           name ++;

        }

  }
    
//    public void downloadAllImg(){
//          ArrayList <Element> imgLink = new ArrayList();
//          imgLink = doc.getElementsByTag("link");
//          for (Element element : imgLink) {
//            String href = element.attr("href");
//            int name = 0;
//            String filetype = href.substring(href.lastIndexOf("."));
//            if (new imagine().IsImagine(filetype)){
//                 downloadFromsrc(href, String.valueOf(name), filetype );
//                 name++;
//            }
//        }
//    
//    }
    
    public void getCss() throws IOException{
        ArrayList<Element> cssLink = new ArrayList<>();
        ArrayList<Element> styleTags = new ArrayList<>();
        cssLink = doc.getElementsByTag("link").attr("rel","stylesheet");
        styleTags = doc.getElementsByTag("style");
        FileWriter f = new FileWriter(outputdir + "webstyle.css");
        for (Element styleTag : styleTags) {
            String cssText = styleTag.toString();
           // System.out.println(cssText);
            f.write(cssText);
        }
        f.close();
        int name = 0;
        for (Element link : cssLink) {
            String href = link.attr("href");
           if (href.contains(".css") ){
                downloadFromsrc(href, "css" + name , ".css");
                name++;
           }
        }  
    }
    public void gethtml() throws UnsupportedEncodingException, FileNotFoundException, IOException{
        String html = this.doc.html();
       FileWriter f = new FileWriter(outputdir + "\\index.html");
       f.write(html);
    }

    private void downloadFromsrc(String src, String filenameOut, String type) {
        try{
            byte[] arr = new byte[2024];
            URL Src = new URL(this.url + src);
            this.is = Src.openStream();
            this.os = new FileOutputStream(outputdir + filenameOut + type);
            int length = 0;
            while ((length = is.read(arr)) != -1) {
                System.out.println(length);
                os.write(arr, 0, length);       
        }
        is.close();
        os.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
 
}
