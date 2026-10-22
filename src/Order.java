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
    public static boolean hasOrdered = false;
    static private ArrayList<Pizza> pizzasInOrder = new ArrayList<>();
    static private ArrayList<Pizza.pizzaSize> sizes = new ArrayList<>();

    static private Double totalPrice = 0.00;
    private static int childPercentage = 75;
    private static int familyPercentage = 150;

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
                pizzasInOrder.add(pizza);
                sizes.add(size);
                if (size == Pizza.pizzaSize.Child) {
                    totalPrice += ((pizza.getPizzaPrice() / 100) * childPercentage);
                } else if (size == Pizza.pizzaSize.Family) {
                    totalPrice += ((pizza.getPizzaPrice() / 100) * familyPercentage);
                } else {
                    totalPrice += pizza.getPizzaPrice();
                }
                System.out.printf("Tilføjet: %d. %s | %s | Størrelse: %s%n", pizza.getMenuNO(), pizza.pizzaName, String.join(", ", pizza.pizzaIngredients), size);
                return;
            }
        }
        System.out.println("Selected item isnt on the menu");

    }

    public static void removePizza(int menuNO, Pizza.pizzaSize size) {

        for (int i = 0; i < pizzasInOrder.size(); i++) {

            if (pizzasInOrder.get(i).getMenuNO() == menuNO
                    && sizes.get(i) == size) {

                if (size == Pizza.pizzaSize.Child) {
                    totalPrice -= ((pizzasInOrder.get(i).getPizzaPrice() / 100) * childPercentage);
                } else if (size == Pizza.pizzaSize.Family) {
                    totalPrice -= ((pizzasInOrder.get(i).getPizzaPrice() / 100) * familyPercentage);

                } else {
                    totalPrice -= pizzasInOrder.get(i).getPizzaPrice();
                }
                pizzasInOrder.remove(i);
                sizes.remove(i);

                System.out.println("Pizza removed!");
                return;
            }
        }

        System.out.println("Pizza not found!");
    }


    public static void listProducts() {
        pizzasInOrder.sort((p1, p2) -> Integer.compare(p1.menuNO, p2.menuNO));

        for (Pizza pizza : pizzasInOrder) {
            System.out.println(pizza.menuNO + ". " + pizza.pizzaName + " | " + String.join(", ", pizza.pizzaIngredients));
        }
        System.out.printf("Total pris: %.2f kr.%n", Order.getTotalPrice());


    }
}

