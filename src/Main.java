
/*TODO
   -Variables to use:
    - loadPizzas(Creates all pizzas for the menu)



 */

import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        Order.hasOrdered = false; // Variable for making sure if anything is ordered.
        Pizza.loadPizzas(); // Creates the objects of Pizzas, used in the Menu.
        UX.homeScreen(); //Starts the User experience, at the Homescreen


    }
}
