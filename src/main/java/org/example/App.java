package org.example;


import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

import java.io.IOException;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        // initializing the HTML Document page variable
        Document doc;
        String url = "https://in.bookmyshow.com/buytickets/la-cinemas-shanthi-ac-dolby-atmos/cinema-manb-LASM-MT/20231019";

        try {
            // fetching the target website
            doc = Jsoup
                    .connect("https://in.bookmyshow.com/buytickets/la-cinemas-shanthi-ac-dolby-atmos/cinema-manb-LASM-MT/20231019")
                    .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7")
                    .header("Sec-Ch-Ua","\"Google Chrome\";v=\"117\", \"Not;A=Brand\";v=\"8\", \"Chromium\";v=\"117\"")
                    .header("Sec-Ch-Ua-Mobile","?0")
                    .header("Sec-Ch-Ua-Platform","Windows")
                    .header("Service-Worker-Navigation-Preload","true")
                    .header("Accept-Encoding", "gzip, deflate, br")
                    .header("Accept-Language", "en-US,en;q=0.9")
                    .header("Upgrade-Insecure-Requests", "1")
                    .referrer("https://in.inbookmyshow.com/buytickets/la-cinemas-shanthi-ac-dolby-atmos/cinema-manb-LASM-MT/20231020")
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/117.0.0.0 Safari/537.36")
                    .get();


            System.out.println( "Hello World!" );

        } catch (IOException e) {
            throw new RuntimeException(e);
        }




    }
}
