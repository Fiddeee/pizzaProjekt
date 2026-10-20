import java.util.Scanner;

public class UX {
    static Scanner scanner = new Scanner(System.in);
    public static void homeScreen(){
        System.out.println("==================================");
        System.out.println("    Velkommen til Pizza Shoppen    ");
        System.out.println(" ");
        System.out.printf("%-10s", "Du har nu følgende valgmuligheder\n");
        System.out.printf("%-10s", "1. Se menukort.\n");
        System.out.printf("%-10s", "2. Bestil pizza.\n");
        System.out.printf("%-10s", "3. Forlad shoppen.\n");
        System.out.println("");
        System.out.printf("%-10s", "Du navigere i menuen ved at skrive det tal du ønsker at gå til.\n");
        scanner.nextInt();
    }

    public static void orderScreen() {
        if (!Order.hasOrdered) {
            System.out.println("==================================");
            System.out.printf("%-10s", "Hvilken pizza ønsker du?\n");
            System.out.println("");
            System.out.printf("%-10s", "Skriv nummeret af den pizza du ønsker\n");
            System.out.println("");
            scanner.nextInt();
            }
        else{
            System.out.println("==================================");
            System.out.printf("%-10s", "Ønsker du at bestille flere pizzaer?\n");
            System.out.println("");
            System.out.printf("%-10s", "Skriv nummeret af den pizza du ønsker, Skriv \"P"+"for pay\n");
            System.out.println("");
            scanner.nextInt();
        }
    }


}
