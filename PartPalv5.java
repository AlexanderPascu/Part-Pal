// Progammer: Aidan Pono
// Program Name: PartPal.java
// Date: 5/16/2023
// Version 5.0
// This program is designed to be a user-friendly app that will build a PC using parts it finds

//NOTE this does not include monitor, mouse, or keyboard

//FAIL: WEBMAGIC DOES NOT WORK WITH ANDROID STUDIO

import us.codecraft.webmagic.*;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import java.util.Scanner;

public class PartPalv5 {
    public static void main(String[] args) {
        // Initiate greetings
        System.out.println("Hello and Welcome to PartPal!");
        System.out.println("What is your budget?");

        // User input double
        Scanner scan = new Scanner(System.in);
        Double budget = scan.nextDouble();

        // Limit user input to $10,000
        final double MAX_BUDGET = 10000;

        if (budget > MAX_BUDGET) {
            System.out.println("Your budget is too high, please lower your budget.");
            return;
        }

        // Simple Options: School, Work, Gaming, Video editing
        System.out.println("What is the purpose of your PC?");
        System.out.println("School, Work, Gaming, or Editing");
        String simpleOptions = scan.next().toUpperCase();

        // Create a Spider with a custom PageProcessor
        Spider.create(new PCPartPageProcessor(budget, simpleOptions))
                .addUrl("https://www.newegg.com/p/pl?d=") // Replace with the actual URL for PC parts
                .addPipeline(new ConsolePipeline()) // Output results to console (you can customize this)
                .thread(5) // Number of concurrent threads
                .run();
    }

    public static class PCPartPageProcessor implements PageProcessor {
        private final double budget;
        private final String simpleOptions;

        public PCPartPageProcessor(double budget, String simpleOptions) {
            this.budget = budget;
            this.simpleOptions = simpleOptions;
        }

        @Override
        public void process(Page page) {
            // Extract PC part information from the web page
            Elements items = page.getHtml().$(".item-cell");

            System.out.printf("Based on your budget of $%.2f, we recommend:\n", budget);
            for (Element item : items) {
                String priceString = item.$(".price-current").text();
                String nameString = item.$(".item-title").text();

                // Extract price from string
                Double price = Double.parseDouble(priceString.substring(1).replace(",", ""));
                if (price <= budget) {
                    System.out.printf("- %s for $%.2f\n", nameString, price);
                }
            }
        }

        @Override
        public Site getSite() {
            // Configure the site-specific settings (e.g., user agent, timeout, etc.)
            return Site.me().setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/98.0.1234.5678 Safari/537.36")
                    .setTimeOut(5000)
                    .setRetryTimes(3);
        }
    }
}
