/*TODO
    - Variables to declare
        - pizzas (List of all pizzas ordered) - ArrayList // DONE
        - totalPrice (Total price of all pizzas ordered) - Double // DONE
      - Methods
      - addPizza(MenuNO) - Adds pizza to order // DONE
         - Next Step(Asks if anything should be Extra / Unselected
      -removePizza(MenuNO) - Removes pizza of MenuNO from order // DONE
      -getTotalPrice - Get total price of order // DONE
      -getPizzas - Return list of pizzas



 */


import java.util.ArrayList;

public class Order {
    public static boolean hasOrdered = true;
    static private ArrayList<Pizza> pizzas = new ArrayList<>();
    static private ArrayList<Pizza.pizzaSize> sizes = new ArrayList<>();

    static private Double totalPrice = 0.00;
    private static int childPercentage = 75;
    private static int familyPercentage = 125;

    public static Double getTotalPrice() {
        return totalPrice;
    }

    public static int getChildPercentage() {
        return childPercentage;
    }

    public static int getFamilyPercentage() {
        return familyPercentage;
    }

    public static void addPizza(int menuNO, Pizza.pizzaSize size) {
        for (Pizza pizza : Pizza.pizzaMenu) { //Datatype: Pizza, pizza = variable, Pizza.pizzaMenu = Our pizzamenu from file: Pizza.java
            if (pizza.getMenuNO() == menuNO) {
                pizzas.add(pizza);
                sizes.add(size);
                if (size == Pizza.pizzaSize.Child) {
                    totalPrice += ((pizza.getPizzaPrice() / 100) * childPercentage);
                } else if (size == Pizza.pizzaSize.Family) {
                    totalPrice += ((pizza.getPizzaPrice() / 100) * familyPercentage);
                } else {
                    totalPrice += pizza.getPizzaPrice();
                }
                System.out.println("Pizza NO " + menuNO + " added to the order");

            } else {
                System.out.println("Selected item isnt on the menu");

            }
        }

    }

    public static void removePizza(int menuNO, Pizza.pizzaSize size) {

        for (int i = 0; i < pizzas.size(); i++) {

            if (pizzas.get(i).getMenuNO() == menuNO
                    && sizes.get(i) == size) {

                if (size == Pizza.pizzaSize.Child) {
                    totalPrice -= ((pizzas.get(i).getPizzaPrice() / 100) * childPercentage);
                } else if (size == Pizza.pizzaSize.Family) {
                    totalPrice -= ((pizzas.get(i).getPizzaPrice() / 100) * familyPercentage);

                } else {
                    totalPrice -= pizzas.get(i).getPizzaPrice();
                }
                pizzas.remove(i);
                sizes.remove(i);

                System.out.println("Pizza removed!");
                return;
            }
        }

        System.out.println("Pizza not found!");
    }


    public static void listProducts() {
        pizzas.sort((p1, p2) -> Integer.compare(p1.menuNO, p2.menuNO));

        for (Pizza pizza : pizzas) {
            System.out.println(pizza.menuNO + ". " + pizza.pizzaName + " | " + String.join(", ", pizza.pizzaIngredients));
        }
        System.out.println("Total pris "+ Order.getTotalPrice());


    }
}

