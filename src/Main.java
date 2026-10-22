
/*Programs main file
This file is primarly made to start the program.
We initialize 2 funtions in this file
Pizza.loadPizzas() - This function creates our objects for the menu card.
UX.homeScreen() - Starts the User Experience, on the home screen.


 */

import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        Pizza.loadPizzas(); // Creates the objects of Pizzas, used in the Menu.
        UX.homeScreen(); //Starts the User experience, at the Homescreen


    }
}
