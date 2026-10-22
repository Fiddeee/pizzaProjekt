import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
This file is created for the Pizza object.
This object consist of multiple variables for making sure we got all the right information for the pizza.


 */



public class Pizza {
    double pizzaPrice; // Price of a single pizza
    String pizzaName; // Name of Pizza
    int menuNO; // Number in the Menu for the user

    //Constructer for the pizzas
    public Pizza(int menuNO, String pizzaName, double pizzaPrice) {

        this.menuNO = menuNO; //The number the pizza will get on the menu card
        this.pizzaName = pizzaName; //The name of the pizza
        this.pizzaPrice = pizzaPrice; // The price of a standard size pizza
    }

    //A list thats capable of holding the objects Pizza, used to make a menuCard.
    public static ArrayList<Pizza> pizzaMenu = new ArrayList<>();

    //A list thats capable of holding Strings, used for the ingredients on the Pizza.
    ArrayList<String> pizzaIngredients = new ArrayList<>();


    //The 3 different sizes of pizzas.
    public static enum pizzaSize {
        Child,
        Standard,
        Family
    }


    //Returns the price of the pizza.
    public double getPizzaPrice() {

        return pizzaPrice;
    }
    //Returns the menu number of the pizza
    public int getMenuNO() {

        return menuNO;
    }

    /*
    Creating the menu of our pizzas.
    Line 1 - Makes the object Pizza, based on our template made in the Pizza object
    Line 2 - Adds the ingredients of the pizza to our list, as Strings
    Line 3 - Adds the Pizza to the list of Pizzas, as an Pizza object
     */

    public static void loadPizzas() {
        //Menu Item #1
        Pizza Margherita = new Pizza(1, "Margherita", 75.00);
        Margherita.pizzaIngredients.addAll(Arrays.asList("Tomato", "Cheese"));
        pizzaMenu.add(Margherita);

        //Menu Item #2
        Pizza Salami = new Pizza(2, "Salami", 95.00);
        Salami.pizzaIngredients.addAll(Arrays.asList("Tomato", "Cheese", "Salami"));
        pizzaMenu.add(Salami);

        //Menu Item #3
        Pizza Ham = new Pizza(3, "Ham", 95.00);
        Ham.pizzaIngredients.addAll(Arrays.asList("Tomato", "Cheese", "Ham"));
        pizzaMenu.add(Ham);

        //Menu Item #4
        Pizza Pepperoni = new Pizza(4, "Pepperoni", 100.00);
        Pepperoni.pizzaIngredients.addAll(Arrays.asList("Tomato", "Cheese", "Pepperoni"));
        pizzaMenu.add(Pepperoni);

        //Menu Item #5
        Pizza Kebab = new Pizza(5, "Kebab", 95.00);
        Kebab.pizzaIngredients.addAll(Arrays.asList("Tomato", "Cheese", "Kebab"));
        pizzaMenu.add(Kebab);

        //Menu Item #6
        Pizza Diavola = new Pizza(6, "Diavola", 120.00);
        Diavola.pizzaIngredients.addAll(Arrays.asList("Tomato", "Cheese", "Hot Salami", "Chili"));
        pizzaMenu.add(Diavola);

        //Menu Item #7
        Pizza Nduja = new Pizza(7, "Nduja", 130.00);
        Nduja.pizzaIngredients.addAll(Arrays.asList("Tomato", "Cheese", "Nduja"));
        pizzaMenu.add(Nduja);

        //Menu Item #8
        Pizza Veggie = new Pizza(8, "Veggie", 150.00);
        Veggie.pizzaIngredients.addAll(Arrays.asList("Tomato", "Cheese", "Artichoke", "Bell pepper"));
        pizzaMenu.add(Veggie);

        //Menu Item #9
        Pizza Meatlover = new Pizza(9, "Meatlover", 150.00);
        Meatlover.pizzaIngredients.addAll(Arrays.asList("Tomato", "Cheese", "Ham", "Kebab", "Pepperoni"));
        pizzaMenu.add(Meatlover);

        //Menu Item #10
        Pizza Potato = new Pizza(10, "Potato", 145.00);
        Potato.pizzaIngredients.addAll(Arrays.asList("Mascarpone", "Cheese", "Potato", "Rosemary"));
        pizzaMenu.add(Potato);


    }

    //Lists our pizza menu, sorts the Pizza NO from low to high
    public static void listMenu() {
        pizzaMenu.sort((p1, p2) -> Integer.compare(p1.menuNO, p2.menuNO));
        System.out.println("=".repeat(140));
        System.out.println("                                                            MENU                                                            ");
        System.out.println("");
        for (Pizza pizza : pizzaMenu) {

            System.out.printf("%-4d %-15s | %-45s | Child: %7.2f kr. | Standard: %7.2f kr. | Family: %7.2f kr.%n", pizza.menuNO, pizza.pizzaName, String.join(", ", pizza.pizzaIngredients), (pizza.pizzaPrice / 100) * Order.getChildPercentage(), pizza.pizzaPrice, (pizza.pizzaPrice / 100) * Order.getFamilyPercentage()
            );


        }
        for (int i = 0; i < 3; i++) {
            System.out.println("");

        }


    }
}




