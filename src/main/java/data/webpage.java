/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    String outputdir = System.getProperty("user.dir") + "\\CrawerData\\";

    public webpage(String url) throws MalformedURLException, IOException {
        this.url = new URL(url);
        this.doc = Jsoup.connect(url).timeout(100000).get();
    }
//// download img

    public void downloadAllImg() {
        try {
            getImgFromTag();
        } catch (IOException ex) {
            Logger.getLogger(webpage.class.getName()).log(Level.SEVERE, null, ex);
        }
        getImgFromlink();

    }

    private void getImgFromTag() throws IOException {
        ArrayList<Element> imgList = new ArrayList();
        // get all possible img
        imgList = doc.getElementsByTag("img");
        int name = 0;
        for (Element element : imgList) {
            String src = element.absUrl("src");
            String filetype = new imagine().checkImg(src);

            if (filetype != null) {
                downloadFromsrc(src, String.valueOf("Tagimg" + name), filetype);
                System.out.println("Success");
            }

            name++;

        }

    }

    private void getImgFromlink() {
        ArrayList<Element> imgLink = new ArrayList();
        try {
            imgLink = doc.getElementsByTag("link");
            for (Element element : imgLink) {
                String href = element.attr("href");
                int name = 0;
                String filetype = new imagine().checkImg(href);

                if (filetype != null) {
                    downloadFromsrc(href, String.valueOf("LinkImg" + name), filetype);
                }

                name++;
            }
        } catch (Exception e) {
            System.out.println("falied");
        }

    }

    public void getCss() throws IOException {
        ArrayList<Element> cssLink = new ArrayList<>();
        ArrayList<Element> styleTags = new ArrayList<>();
        cssLink = doc.getElementsByTag("link").attr("rel", "stylesheet");
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
            if (href.contains(".css")) {
                downloadFromsrc(href, "css" + name, ".css");
                name++;
            }
        }
    }

    public void gethtml() throws UnsupportedEncodingException, FileNotFoundException, IOException {
        String html = this.doc.html();
        FileWriter f = new FileWriter(outputdir + "\\index.html");
        f.write(html);
        f.close();
    }

    private void downloadFromsrc(String src, String filenameOut, String type) {
        try ( InputStream in = new URL(src).openStream()) {
            Files.copy(in, Paths.get(outputdir + filenameOut + type));
        } catch (Exception e) {
            System.out.println("falied");
        }
    }

}
