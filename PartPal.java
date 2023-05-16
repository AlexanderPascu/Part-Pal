// Progammer: Aidan Pono
// Program Name: PartPal.java
// Date: 4/29/2023
// Version 1.0
// This program is designed to be a user-friendly app that will build a PC using parts it finds

//NOTE this does not include monitor, mouse, or keyboard

import java.util.Scanner;

public class PartPal
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
        if(budget > 10000.00)
        {
            System.out.println("Your budget is too high, please lower your budget.");
        }

        // 2. give user three options(beginner, intermediate, advanced)
        System.out.println("How knowledgeable are you on PC's?");
        System.out.println("Please select your level.");
        System.out.println("Beginner, Intermediate, Expert");
        String knowledge = scan.nextLine().toUpperCase();

// make sure they work both uppercase and lowercase
// store options as strings to simplify?


    // Beginner 
        /*  
            + price
            + “build-it”: builds PC ideas for them; not just finds parts 
            + Tips
            + simple options
            - specs
            - company information/ part description
            - comparison to other parts
        Strict budget offset
        */

        if(knowledge.equals("Beginner"))
        {

        }

    // Intermediate
        /*
        + price
        + company description
        + “build-it”
        + check box options
        - specs
        Limited comparison
        Moderate budge offset
        */

        if(knowledge.equals("Intermediate"))
        {

        }

    // Expert
        /*
        + price 
        + specs
        + Wide comparison
        + Expert description
        +/- “build-it” 
        + check box options
        Considerable budget offset –> maybe custom?
        */

        if(knowledge.equals("Expert"))
        {

        }

        // 3. ONLY ASK IF USER CHOOSES BEGINNER
        // Simple Options: Work, Gaming, Video editing
        System.out.println("What is the purpose of your PC?");
        System.out.println("Work, Gaming, Video Editing");
        String simpleOptions = scan.nextLine().toUpperCase();

        //similar to knowledge, must work both uppercase and lowercase
    // work
        if(simpleOptions.equals("Work"))
        {

        }

        if(simpleOptions.equals("Gaming"))
        {

        }

        if(simpleOptions.equals("VideoEditing"))
        {

        }

        //4. ONLY ASK IF USER CHOOSES INTERMEDIATE OR ADVANCED
        // Check-Box Options: Storage, Graphics, Processing, Versatility(all) 
        System.out.println("What is the priority of your PC?");
        System.out.println("Storage, Graphics, Processing, Versatility");
        String checkBoxOptions = scan.nextLine().toUpperCase();

        //Storage
            //put most of budget towards RAM, HD, SSD (SHOULD CHOOSE SSD OR HD??)

            if(checkBoxOptions.equals("Storage"))
            {

            }

        //Graphics
            //put most of budget towards graphics card and cooling
            if(checkBoxOptions.euqals("Graphics"))
            {

            }
        
        //Processing
            //put most of budget towards CPU, motherboard, and cooling
            if(checkBoxOptions.equals("Processing"))
            {

            }

        //Versatility 
            //budget goes towards preset that divides budget(Ex. 20% CPU, 40% Graphics card, 5% motherboard, 15% RAM, 10% HD/SSD, 10% other)
            if(checkBoxOptions.equals("Versatility"))
            {

            }

            else{
                System.out.println("Invalid response, please try again.");
            }
    }
}
