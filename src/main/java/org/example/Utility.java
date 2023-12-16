package org.example;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalTime;

public class Utility {

    private static final Logger logger = LogManager.getLogger(GetPageSourceWithSelenium.class);

    public static void TriggerAlarmSound(){
        // Specify the path to your alarm sound file (in MP3 format)
        String soundFilePath = "/naan-ready-than-varava-ringtone-tkkb.mp3"; //"path/to/your/alarm.mp3";

        try {
            // Create a Player to play the sound
            Player player = new Player(Utility.class.getResourceAsStream(soundFilePath));

            // Start playing the sound
            player.play();

            // Sleep for the desired duration (30 seconds)
//            Thread.sleep(30000);

            // Stop playing the sound
            player.close();
        } catch (JavaLayerException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

        logger.info("*************Current Time:"+ LocalTime.now() + "Available show time");

    }
}
