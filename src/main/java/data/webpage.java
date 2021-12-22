/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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

    public void downloadAllImg() throws IOException {
        ArrayList<Element> imgList = new ArrayList();
        imgList = doc.getElementsByTag("img");
        int name = 0;
        for (Element element : imgList) {
            String src = element.absUrl("src");
            String filetype = src.substring(src.lastIndexOf("."));
            System.out.println(name + filetype);
           downloadFromsrc(src, String.valueOf(name), filetype );
           name ++;

        }

    }

    private void downloadFromsrc(String src, String filenameOut, String type) {
        try{
            byte[] arr = new byte[2024];
            URL imgSrc = new URL(src);
            this.is = imgSrc.openStream();
            this.os = new FileOutputStream(outputdir + filenameOut + type);
            int length = 0;
            while ((length = is.read(arr)) != -1) {
                System.out.println(length);
                os.write(arr, 0, length);
                
        }
        is.close();
        os.close();
        } catch (Exception e){
            System.out.println("falied");
        }
    }

}
