
import data.Webpage;

import java.io.IOException;
import java.util.Scanner;

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
        Scanner scanner = null;
        int input = 0;
        try {
            while ( input != 4) {
                System.out.println("==================================Input your website url============================");
                scanner = new Scanner(System.in);
                String url = scanner.nextLine();
                if (url.isEmpty())
                    throw new Exception("url is required");
                Webpage page = new Webpage(url);
                System.out.println("1. Get Html of website");
                System.out.println("2. Get Css of website");
                System.out.println("3. Get Image of website");
                System.out.println("Other. Exit");
                input = scanner.nextInt();

                switch (input) {
                    case 1:
                        page.gethtml();
                        System.out.println("Success");
                        break;
                    case 2:
                        page.getCss();
                        System.out.println("Success");
                        break;
                    case 3:
                        page.downloadAllImg();
                        System.out.println("Sucesss");
                        break;
                    case 4:
                        break;

                }
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
        finally {
            scanner.close();
        }

    }
}

