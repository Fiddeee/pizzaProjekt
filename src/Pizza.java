import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*TODO
   - Object creator for Pizza with MenuNO as constructer ( EX: Pizza Skinke = new Pizza(1) - Number 1 in Menucard
   - Fix loadPizzas to be able to initialize on Main.java

 */



public class Pizza {
    double pizzaPrice; // Price of a single pizza
    String pizzaName; // Name of Pizza
    int menuNO; // Number in the Menu for the user

    //Constructer for making requirement of MenuNO and pricing
    public Pizza(int menuNO, String pizzaName, double pizzaPrice) {

        this.menuNO = menuNO;
        this.pizzaName = pizzaName;
        this.pizzaPrice = pizzaPrice;
    }

    // Shared menu containing all pizzas
    public static ArrayList<Pizza> pizzaMenu = new ArrayList<>();

    //List made to add multiple ingredients on a pizza
    ArrayList<String> pizzaIngredients = new ArrayList<>();


    //Possible sizes of pizzas
    public static enum pizzaSize {
        Child,
        Standard,
        Family
    }


    //Public GETTER for pizzaPrice
    public double getPizzaPrice() {

        return pizzaPrice;
    }

    public int getMenuNO() {

        return menuNO;
    }

    //Create Menu of pizzas
    public static void loadPizzas() {
        //Menu Item #1
        Pizza Margherita = new Pizza(1, "Margherita", 95.00);
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
        Pizza Pepperoni = new Pizza(4, "Pepperoni", 95.00);
        Pepperoni.pizzaIngredients.addAll(Arrays.asList("Tomato", "Cheese", "Pepperoni"));
        pizzaMenu.add(Pepperoni);

        //Menu Item #5
        Pizza Kebab = new Pizza(5, "Kebab", 95.00);
        Kebab.pizzaIngredients.addAll(Arrays.asList("Tomato", "Cheese", "Kebab"));
        pizzaMenu.add(Kebab);

        //Menu Item #6
        Pizza Diavola = new Pizza(6, "Diavola", 95.00);
        Diavola.pizzaIngredients.addAll(Arrays.asList("Tomato", "Cheese", "Hot Salami", "Chili"));
        pizzaMenu.add(Diavola);

        //Menu Item #7
        Pizza Nduja = new Pizza(7, "Nduja", 95.00);
        Nduja.pizzaIngredients.addAll(Arrays.asList("Tomato", "Cheese", "Nduja"));
        pizzaMenu.add(Nduja);

        //Menu Item #8
        Pizza Veggie = new Pizza(8, "Veggie", 95.00);
        Veggie.pizzaIngredients.addAll(Arrays.asList("Tomato", "Cheese", "Artichoke", "Bell pepper"));
        pizzaMenu.add(Veggie);

        //Menu Item #9
        Pizza Meatlover = new Pizza(9, "Meatlover", 95.00);
        Meatlover.pizzaIngredients.addAll(Arrays.asList("Tomato", "Cheese", "Ham", "Kebab", "Pepperoni"));
        pizzaMenu.add(Meatlover);

        //Menu Item #10
        Pizza Potato = new Pizza(10, "Potato", 95.00);
        Potato.pizzaIngredients.addAll(Arrays.asList("Mascarpone", "Cheese", "Potato", "Rosemary"));
        pizzaMenu.add(Potato);


    }

    public static void listMenu() {
        pizzaMenu.sort((p1, p2) -> Integer.compare(p1.menuNO, p2.menuNO));
        System.out.println("=".repeat(140));
        System.out.println("                                                            Menukort                                                            ");
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




