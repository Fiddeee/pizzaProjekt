import java.util.Scanner;

public class UX {
    static int UserNavForInt; //Variable for saving navigation choices WHERE the Scanner is an int .
    static String UserNavForString; // Variable for saving navigation choices, WHERE the Scanner is a String.
    static int UserPizzaNO;
    static String UserPizzaSize;
    public static Boolean PaymentReady = false;


    static Scanner scanner = new Scanner(System.in);

    public static void homeScreen() {
        System.out.println("==================================");
        System.out.println("    Velkommen til Pizza Shoppen    ");
        System.out.println(" ");
        System.out.printf("%-10s", "Du har nu følgende valgmuligheder\n");
        System.out.printf("%-10s", "1. Bestil.\n");
        System.out.printf("%-10s", "2. Forlad shoppen.\n");
        System.out.println("");
        System.out.printf("%-10s", "Du navigere i menuen ved at skrive det tal du ønsker at gå til.\n");
        int UserNavForInt = scanner.nextInt();
        if (UserNavForInt == 1) {
            Pizza.listMenu();
            orderScreen();
        }
        if (UserNavForInt == 2) {
            System.out.println("Du forlod butikken, tak for denne gang.");
        }
    }


    public static void orderScreen() {

        do {
            System.out.println("==================================");

            if (!Order.hasOrdered) {
                System.out.println("Hvilken pizza ønsker du?");
                System.out.println("Skriv pizzaens nummer");
                System.out.println("");
                System.out.println("Skriv M for at se menukortet igen.");
                System.out.println("Skriv Q eller Quit for at forlade butikken.");
            } else {
                System.out.println("Ønsker du at bestille flere pizzaer?");
                System.out.println("Skriv pizzaens nummer");
                System.out.println("");
                System.out.println("Skriv P for at betale");
                System.out.println("Skriv M for at se menukortet igen.");
                System.out.println("Skriv Q eller Quit for at forlade butikken.");
            }


            if (scanner.hasNextInt()) {

                UserPizzaNO = scanner.nextInt();
                if(UserPizzaNO > 10 || 1 > UserPizzaNO){
                    System.out.println("Der skete en fejl");
                    System.out.println("Vores menu går fra 1 til 10.");
                    continue;
                }


                System.out.println("Hvilken størrelse ønsker du?");
                System.out.println("C for Child | S for Standard | F for Family");

                UserPizzaSize = scanner.next();

                if (UserPizzaSize.equalsIgnoreCase("C")) {
                    Order.addPizza(UserPizzaNO, Pizza.pizzaSize.Child);
                    Order.hasOrdered = true;

                } else if (UserPizzaSize.equalsIgnoreCase("S")) {
                    Order.addPizza(UserPizzaNO, Pizza.pizzaSize.Standard);
                    Order.hasOrdered = true;

                } else if (UserPizzaSize.equalsIgnoreCase("F")) {
                    Order.addPizza(UserPizzaNO, Pizza.pizzaSize.Family);
                    Order.hasOrdered = true;

                } else {
                    System.out.println("Ugyldig pizza størrelse!");
                }

            } else {

                UserNavForString = scanner.next();

                if (UserNavForString.equalsIgnoreCase("P")) {

                    if (Order.hasOrdered) {
                        PaymentReady = true;
                        completedOrder();
                    } else {
                        System.out.println("Du skal bestille en pizza først!");
                    }

                }else if(UserNavForString.equalsIgnoreCase("Q") || (UserNavForString.equalsIgnoreCase("QUIT"))){
                    System.out.println("Tak for denne gang.");
                    break;
                }
                else if(UserNavForString.equalsIgnoreCase("M")){
                    Pizza.listMenu();
                    continue;
                }


                else {
                    System.out.println("Ugyldigt valg!");
                }
            }

        } while (!PaymentReady);
    }




        public static void completedOrder () {
            for (int i = 0; i < 10; i++) {
                System.out.println("");

            }
            System.out.println("=".repeat(140));
            System.out.println("Ordren er modtaget");
            System.out.println("");
            System.out.println("Vi har modtaget ordren på følgende:");
            Order.listProducts();
            System.out.println("Betalingen er godkendt.");
        }


    }

