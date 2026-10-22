import java.util.Scanner;
/*
This file is made for the User Experience - Everything the user will see in their console, is written in here.
 */


public class UX {
    static int UserNavForInt; //Variable for saving navigation choices WHERE the Scanner is an int .
    static String UserNavForString; // Variable for saving navigation choices, WHERE the Scanner is a String.
    static int UserPizzaNO; // Used for holding the pizza selected by the user.
    static String UserPizzaSize; // Used for holding the pizza size, selected by the user.
    public static Boolean PaymentReady = false; //Used for breaking a loop, sending the user to payment.

    static Scanner scanner = new Scanner(System.in); //Used for scanning user input to the system


    /*
    homeScreen is the first screen of the system.
    Used as en entry to the system. The user can answer 2 things in the console
    1 - Prints pizza menu with Pizza.listMenu(), afterwards executing the orderScreen();
    2 - Stopping the program
     */
    public static void homeScreen() {
        System.out.println("==================================");
        System.out.println("    Welcome to Pizza shop    ");
        System.out.println(" ");
        System.out.printf("%-10s", "You have the following choices\n");
        System.out.printf("%-10s", "1. Order.\n");
        System.out.printf("%-10s", "2. Leave the shop.\n");
        System.out.println("");
        System.out.printf("%-10s", "Navigate the menu by typing the number of your choice.\n");
        int UserNavForInt = scanner.nextInt();
        if (UserNavForInt == 1) {
            Pizza.listMenu();
            orderScreen();
        }
        else if (UserNavForInt == 2) {
            System.out.println("You left the shop.");
        }
        else{
            System.out.println("Invalid answer, please try again...");
            return;
        }
    }

    /*
    Order screen runs in a do While loop.
    2 different types of outputs.
    One if you havent already ordered a pizza.
    One if you have ordered a pizza, and therefore gets asked if you want to order more.

    2 ways of breaking out of the loop.
    Type "Q" or "Quit" for leaving
    Typing "P" making the boolean PaymentReady = true, breaking out of the loop.


     */
    public static void orderScreen() {

        do {
            System.out.println("==================================");

            if (Order.firstOrder) {
                System.out.println("Which pizza do you want?");
                System.out.println("Type the number of the Pizza");
                System.out.println("");
                System.out.println("Type M to view the menu.");
                System.out.println("Type Q or Quit to leave the shop.");
            } else {
                System.out.println("Do you want to order more?");
                System.out.println("Type the number of the Pizza");
                System.out.println("");
                System.out.println("Type P to pay the order");
                System.out.println("Type S for order summary.");
                System.out.println("Type M to view the menu.");
                System.out.println("Type Q or Quit to leave.");
            }


            if (scanner.hasNextInt()) {

                UserPizzaNO = scanner.nextInt();
                if(UserPizzaNO > 10 || 1 > UserPizzaNO){
                    System.out.println("ERROR:");
                    System.out.println("Our menu is from 1 - 10.");
                    continue;
                }


                System.out.println("Which size do you want?");
                System.out.println("C for Child | S for Standard | F for Family");

                UserPizzaSize = scanner.next();

                if (UserPizzaSize.equalsIgnoreCase("C")) {
                    Order.addPizza(UserPizzaNO, Pizza.pizzaSize.Child);
                    Order.firstOrder = false;

                } else if (UserPizzaSize.equalsIgnoreCase("S")) {
                    Order.addPizza(UserPizzaNO, Pizza.pizzaSize.Standard);
                    Order.firstOrder = false;

                } else if (UserPizzaSize.equalsIgnoreCase("F")) {
                    Order.addPizza(UserPizzaNO, Pizza.pizzaSize.Family);
                    Order.firstOrder = false;

                } else {
                    System.out.println("Invalid pizza size!");
                }

            } else {

                UserNavForString = scanner.next();

                if (UserNavForString.equalsIgnoreCase("P")) {

                    if (!Order.firstOrder) {
                        PaymentReady = true;
                        completedOrder();
                    } else {
                        System.out.println("You need to order a pizza first!");
                    }

                }else if(UserNavForString.equalsIgnoreCase("Q") || (UserNavForString.equalsIgnoreCase("QUIT"))){
                    System.out.println("Goodbye.");
                    break;
                }
                else if(UserNavForString.equalsIgnoreCase("M")){
                    Pizza.listMenu();
                    continue;
                }
                else if (UserNavForString.equalsIgnoreCase("S")) {
                    if (!Order.firstOrder) {
                        Order.listProducts();
                    } else {
                        System.out.println("You haven't ordered any pizzas yet!");
                    }
                }


                else {
                    System.out.println("Invalid choice!");
                }
            }

        } while (!PaymentReady);
    }



        /*
        Prints the receipt of the order to the user.
        Prints the order summary through Order.listProducts();
         */
        public static void completedOrder () {
            for (int i = 0; i < 10; i++) {
                System.out.println("");

            }
            System.out.println("=".repeat(140));
            System.out.println("Order has been received");
            System.out.println("");
            System.out.println("You've ordered the following items:");
            Order.listProducts();
            System.out.println("Payment has been confirmed.");
            System.out.println("Goodbye");
        }


    }

