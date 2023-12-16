package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.LocalTime;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class GetPageSourceWithSelenium {

    private static final Logger logger = LogManager.getLogger(GetPageSourceWithSelenium.class);

    public static void main(String[] args) {

        while (true){
            checkIfShowsAreAvailableToBook();
        }
    }

    public static boolean checkIfShowsAreAvailableToBook(){

        boolean isAvailable = false;

        try{

        // Set the path to the ChromeDriver executable (you need to download it from the Selenium website)
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\vasan\\Downloads\\chromedriver-win64\\chromedriver.exe");

        // Initialize the WebDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to the website
        driver.get("https://in.bookmyshow.com/buytickets/la-cinemas-shanthi-ac-dolby-atmos/cinema-manb-LASM-MT/20231019");

        // Get the page source
        String pageSource = driver.getPageSource();

        // Parse the page source into a Jsoup Document
        Document document = Jsoup.parse(pageSource);

        // Find and extract the <div> element with the class "listing-info"
        Elements listingInfoDivs = document.select("div.listing-info");

        for(Element listingInfoDiv: listingInfoDivs){
            Optional<Element> detailsOptional = listingInfoDiv.getElementsByClass("details").stream().findFirst();
            if(detailsOptional.isPresent()){
                Optional<Element> nameSpanOptional = detailsOptional.get().getElementsByClass("nameSpan").stream().findFirst();
                if(nameSpanOptional.isPresent()){
                    Optional<Element> bodyElement  = listingInfoDiv.nextElementSiblings().stream().filter(siblings-> siblings.hasClass("body")).findFirst();
                    if(bodyElement.isPresent()){

                        for(Element show: bodyElement.get().children()){

                            if(!show.hasClass("data-disabled")){
                                String showTiming = show.getElementsByClass("__text").html();
                                System.out.println("Current Time:"+ LocalTime.now() + "Available show time"+showTiming);
                                logger.info("Current Time:"+ LocalTime.now() + "Available show time"+showTiming);
                                Utility.TriggerAlarmSound();
                                isAvailable = true;
                            }
                        }

                    }
                }
            }
        }

         // Wait for 30 seconds
         TimeUnit.SECONDS.sleep(30);

        // Close the browser
        driver.quit();

        }catch (Exception exception){
            System.out.println("Exception"+exception.getMessage());
        }

        return isAvailable;
    }
}
