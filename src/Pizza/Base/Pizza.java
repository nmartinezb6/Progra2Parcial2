package Pizza.Base;
import java.util.*;

public class Pizza {
    protected java.lang.String name;
    protected java.lang.String size;
    protected double price;
    protected List<Topping> toppings = new ArrayList<>();

    // Constantes para los tamaños de pizza
    public static final java.lang.String SMALL_SIZE = "small";
    public static final java.lang.String MEDIUM_SIZE = "medium";
    public static final java.lang.String LARGE_SIZE = "large";

    // Nombres preestablecidos
    public static final java.lang.String PEPPERONI_NAME = "Pepperoni";


    // Precios base preestablecidos para cada pizza
    public static final double PEPPERONI_BASE_PRICE = 40;
    public static final double HAWAIIAN_BASE_PRICE = 55;
    public static final double VEGETARIAN_BASE_PRICE = 50;
    public static final double SUPREME_BASE_PRICE = 70;
    public static final double WHITE_BASE_PRICE = 35;

    public Pizza(java.lang.String name, java.lang.String size, Topping... toppings) {
        this.name = name;
        this.size = size.toLowerCase(); // Convertir a minúsculas para comparación
        for (Topping topping : toppings) {
            this.toppings.add(topping);
        }
        // Calcular el precio en función del tamaño y el precio base de la pizza
        this.price = calculatePrice(name, size);
    }

    protected double calculatePrice(java.lang.String pizzaName, java.lang.String pizzaSize) {
        double basePrice = 0;


        // Determinar el precio base según el nombre de la pizza
        switch (pizzaName) {
            case PEPPERONI_NAME:
                basePrice = PEPPERONI_BASE_PRICE;
                break;
            default:
                throw new IllegalArgumentException("Nombre de pizza no válido: " + pizzaName);
        }

        // Aplicar el factor de aumento según el tamaño
        switch (pizzaSize) {
            case SMALL_SIZE:
                return basePrice;
            case MEDIUM_SIZE:
                return basePrice * 1.2; // Aumentar un 20%
            case LARGE_SIZE:
                return basePrice * 1.35; // Aumentar un 35%
            default:
                throw new IllegalArgumentException("Tamaño de pizza no válido: " + pizzaSize);
        }
    }

    public void addTopping(Topping topping) {
        this.toppings.add(topping);
    }

    public void removeTopping(int index) {
        this.toppings.remove(index);
    }

    public List<Topping> getToppings() {
        return Collections.unmodifiableList(new ArrayList<>(toppings));
    }

    public java.lang.String getName() {
        return name;
    }

    public java.lang.String getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public java.lang.String toString() {
        return "Pizza{" + "name='" + name + '\'' + ", size='" + size + '\'' + ", price=" + price + ", toppings=" + toppings + '}';
    }



    public void prepare() {
        System.out.println("Cocinando la pizza... " + name);
        System.out.println("Tamaño: " + size);
        System.out.println("Se agregaron los toppings:");
        for (Topping topping : toppings) {
            System.out.println("- " + topping.getNombre());
            //put 1 second delay
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("¡La pizza está lista!");
    }
}
