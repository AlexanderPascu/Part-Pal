// Progammer: Aidan Pono
// Program Name: PartPal.java
// Date: 5/16/2023
// Version 7.0
// This program is designed to be a user-friendly app that will build a PC using parts it finds

//NOTE this does not include monitor, mouse, or keyboard

import java.io.IOException;
import java.util.Scanner;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class PartPalv7 {                        //GPT enhanced, new budget limitations between 500-10000
    public static void main(String[] args) {
        // Initiate greetings
        System.out.println("Hello and Welcome to PartPal!");
        System.out.println("What is your budget? (between $500 and $10,000)");

        // User input double
        Scanner scan = new Scanner(System.in);
        double budget = scan.nextDouble();

        // Validate budget range
        if (budget < 500 || budget > 10000) {
            System.out.println("Invalid budget. Please enter a budget between $500 and $10,000.");
            return;
        }

        // Simple Options: School, Work, Gaming, Video editing
        System.out.println("What is the purpose of your PC?");
        System.out.println("School, Work, Gaming, or Editing");
        String simpleOptions = scan.next().toUpperCase();

        // Web scrape for PC parts on Newegg.com
        String searchUrl = "https://www.newegg.com/p/pl?d=";
        double storagePercentage = 0.0;
        double graphicsPercentage = 0.0;
        double processingPercentage = 0.0;

        if (simpleOptions.equals("SCHOOL") || simpleOptions.equals("WORK")) {
            searchUrl += "SSD+Quad+Core";
            storagePercentage = 0.3;
            graphicsPercentage = 0.0;
            processingPercentage = 0.4;
        } else if (simpleOptions.equals("GAMING")) {
            searchUrl += "SSD+Dedicated+Graphics+Six+Core";
            storagePercentage = 0.2;
            graphicsPercentage = 0.5;
            processingPercentage = 0.3;
        } else if (simpleOptions.equals("EDITING")) {
            searchUrl += "SSD+Dedicated+Graphics+Eight+Core";
            storagePercentage = 0.4;
            graphicsPercentage = 0.2;
            processingPercentage = 0.4;
        } else {
            System.out.println("Invalid response, please try again.");
            return;
        }

        try {
            Document doc = Jsoup.connect(searchUrl).get();
            Elements items = doc.select(".item-cell");

            System.out.printf("Based on your budget of $%.2f, we recommend:\n", budget);
            System.out.printf("For %s, we suggest the following parts:\n", simpleOptions);

            double storageBudget = budget * storagePercentage;
            double graphicsBudget = budget * graphicsPercentage;
            double processingBudget = budget * processingPercentage;

            for (Element item : items) {
                String priceString = item.select(".price-current").text();
                String nameString = item.select(".item-title").text();

                // Extract price from string
                double price = Double.parseDouble(priceString.substring(1).replace(",", ""));
                if (price <= budget) {
                    System.out.printf("- %s for $%.2f\n", nameString, price);
                }
            }

            System.out.println("\nBased on your budget allocation:");
            System.out.printf("- Allocate $%.2f for storage\n", storageBudget);
            System.out.printf("- Allocate $%.2f for graphics\n", graphicsBudget);
            System.out.printf("- Allocate $%.2f for processing\n", processingBudget);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
