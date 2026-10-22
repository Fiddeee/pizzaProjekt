/*
This file contains all Order handling for the user.

 */


import java.util.ArrayList;

public class Order {
    public static boolean firstOrder = true; // Used in the UX.java, for making seperate outputs, based upon if the user has been ordering a pizza already
    static private ArrayList<Pizza> pizzasInOrder = new ArrayList<>(); //A list for the Pizza object, used for holding the pizzas ordered by the user.
    static private ArrayList<Pizza.pizzaSize> sizes = new ArrayList<>(); //A list for the Pizza.pizzaSize variables, holding information of the size of the pizza, chosen by the user.

    static private Double totalPrice = 0.00; //Total price of order
    private static int childPercentage = 75; //Cost of a pizza in percentage, if Child size is chosen. Paying X% amount of the standard price set for the pizza
    private static int familyPercentage = 150; //Cost of a pizza in percentage, if Family size is chosen. Paying X% amount of the standard price set for the pizza


    //Prints totalPrice of order
    public static Double getTotalPrice() {

        return totalPrice;
    }

    //Gets % of cost for a Pizza with the size: Child
    public static int getChildPercentage() {

        return childPercentage;
    }

    //Gets % of cost for a Pizza with the size: Family
    public static int getFamilyPercentage() {

        return familyPercentage;
    }


    /*
    If a pizza is ordered, this function is called.

    Adding the Pizza to the pizzasInOrder list.
    Adds the size to sizes list.

    3 if statements, based upon the size chosen.
    Prints a success message with the Pizza Menu number, Pizza name, List of ingredients, and Size.

    We save the sizes to keep track of the size of each pizza ordered by the user.
    This is used to display the correct size and price in the order summary.
     */
    public static void addPizza(int menuNO, Pizza.pizzaSize size) {
        for (Pizza pizza : Pizza.pizzaMenu) { //Datatype: Pizza, pizza = variable, Pizza.pizzaMenu = Our pizzamenu from file: Pizza.java
            if (pizza.getMenuNO() == menuNO) {
                pizzasInOrder.add(pizza);
                sizes.add(size);
                if (size == Pizza.pizzaSize.Child) {
                    totalPrice += ((pizza.getPizzaPrice() / 100) * childPercentage);
                } else if (size == Pizza.pizzaSize.Family) {
                    totalPrice += ((pizza.getPizzaPrice() / 100) * familyPercentage);
                } else {
                    totalPrice += pizza.getPizzaPrice();
                }
                System.out.printf("Added: %d. %s | %s | Size: %s%n", pizza.getMenuNO(), pizza.pizzaName, String.join(", ", pizza.pizzaIngredients), size);
                return;
            }
        }
        System.out.println("Selected item isnt on the menu");

    }





    /*
    Prints the list of all pizzas added to the list pizzasInOrder.
    prints the information : Pizza Menu number, Pizza name, Ingredients

    Prints a formatted text with the price of the order.
     */

    public static void listProducts() {
        System.out.println("========== YOUR ORDER ==========");

        for (int i = 0; i < pizzasInOrder.size(); i++) {
            Pizza pizza = pizzasInOrder.get(i);
            Pizza.pizzaSize size = sizes.get(i);

            double price = pizza.getPizzaPrice();

            if (size == Pizza.pizzaSize.Child) {
                price = (price / 100) * childPercentage;
            } else if (size == Pizza.pizzaSize.Family) {
                price = (price / 100) * familyPercentage;
            }

            System.out.printf("%d. %s | %s | %s | %.2f kr.%n", i + 1, pizza.pizzaName, String.join(", ", pizza.pizzaIngredients), size, price);
        }

        System.out.println("===============================");
        System.out.printf("Total : %.2f kr.%n", getTotalPrice());
    }

}

