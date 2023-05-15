// Progammer: Aidan Pono
// Program Name: PartPal.java
// Date: 4/29/2023
// Version 3.0
// This program is designed to be a user-friendly app that will build a PC using parts it finds

//NOTE this does not include monitor, mouse, or keyboard

import java.util.Scanner;

public class PartPalv3
{
    public static void main(String[] args)
    {
        // 1. Initiate greetings
        System.out.println("Hello and Welcome to PartPal!");
        System.out.println("What is your budget?");

        // user input double
Scanner scan = new Scanner(System.in);

        Double budget = scan.nextDouble();
        
        // limit user input to $10,000
        final double MAX_BUDGET = 10000;

        if(budget > MAX_BUDGET)
        {
            System.out.println("Your budget is too high, please lower your budget.");
            return; //reprompt question
        }

        // Simple Options: School, Work, Gaming, Video editing
        System.out.println("What is the purpose of your PC?");
        System.out.println("School, Work, Gaming, or Editing"); //front end should have buttons for this
        String simpleOptions = scan.nextLine().toUpperCase();   //similar to knowledge, must work both uppercase and lowercase

        Double storage; 
        Double graphics;
        Double processing; 

if (simpleOptions.equals("SCHOOL") || simpleOptions.equals("WORK")) {
    storage = budget * 0.3;
    graphics = budget * 0.3;
    processing = budget * 0.4;
    System.out.printf("Based on your budget of $%.2f, we recommend:\n", budget);
    System.out.printf("- %d GB SSD for storage\n", Math.round(storage));
    System.out.printf("- Integrated graphics card\n");
    System.out.printf("- Quad-core CPU for processing\n");
}

else if (simpleOptions.equals("GAMING")) {
    storage = budget * 0.2;
    graphics = budget * 0.5;
    processing = budget * 0.3;
    System.out.printf("Based on your budget of $%.2f, we recommend:\n", budget);
    System.out.printf("- %d GB SSD for storage\n", Math.round(storage));
    System.out.printf("- Dedicated graphics card\n");
    System.out.printf("- Six-core CPU for processing\n");
}

else if (simpleOptions.equals("EDITING")) {
    storage = budget * 0.4;
    graphics = budget * 0.2;
    processing = budget * 0.4;
    System.out.printf("Based on your budget of $%.2f, we recommend:\n", budget);
    System.out.printf("- %d GB SSD for storage\n", Math.round(storage));
    System.out.printf("- Dedicated graphics card\n");
    System.out.printf("- Eight-core CPU for processing\n");
}
else {
    System.out.println("Invalid response, please try again.");
    return;
}

    }
}
