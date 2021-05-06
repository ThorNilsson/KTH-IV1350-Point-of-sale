package org.thor.view;

import org.thor.controller.Controller;

import java.util.Scanner;
import java.util.regex.Pattern;

public class View {

    private Controller controller;

    /**
     * Creates a new instance, representing thec controller.
     *
     * @param controller the controller
     */
    public View(Controller controller) {
        this.controller = controller;
    }

    public static boolean isNumeric(String string) {
        // Checks if the provided string
        // is a numeric by applying a regular
        // expression on it.
        String regex = "[0-9]+[\\.]?[0-9]*";
        return Pattern.matches(regex, string);
    }

    public void view() {
        while (true) {
            controller.startNewSale();

            Scanner scanner = new Scanner(System.in);

            //Hardcoded items enterd
            controller.enterItem("A2", 4);
            controller.enterItem("A2", 7);
            controller.enterItem("A5", 3);
            controller.enterItem("A5", 6);


            while (true) {
                String textIn = getItemId();
                if (textIn.equals("end"))
                    break;
                controller.enterItem(textIn, getQuantity());
                System.out.println("\n" + controller.getScannedItems());
            }

            System.out.println("Sale ended \n\n");

            System.out.println(String.format("%-25s %10.2f", "To Pay:", controller.getRunningTotal()));
            System.out.println(String.format("%-25s", "Enter Cash Paid:"));
            Double amountPaid = scanner.nextDouble();

            controller.pay(controller.getRunningTotal(), amountPaid);
        }
    }

    private String getItemId() {
        String itemId;
        System.out.println("Enter ItemID or 'end' to end sale.");

        do {
            itemId = getString();
        } while (itemId.length() < 2);

        return itemId;
    }

    private int getQuantity() {
        System.out.println("Enter Quantity: ");
        String input;

        do {
            input = getString();
        } while (!isNumeric(input));

        return Integer.parseInt(input);
    }

    private String getString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}