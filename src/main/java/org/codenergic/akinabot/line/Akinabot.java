package org.codenergic.akinabot.line;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Created by diasa on 2/18/17.
 */
@SpringBootApplication
public class Akinabot {
    public static final String AKINATOR_API_URL = "http://api-en4.akinator.com";

    public static final String BUTTON_PLAYAGAIN = "Play Again";
    public static final String BUTTON_PLAYNOW = "Play Now";
    public static final String BUTTON_QUIT = "Quit";
    public static final String BUTTON_START = "Start";

    public static void main(String [] args) {
        SpringApplication.run(Akinabot.class, args);
    }

}
