package Pizza.Base.Especialidades;

import Pizza.Base.Pizza;
import Pizza.Base.Topping;

public class Especialidades extends Pizza {
    public Especialidades(String name, String size, Topping... toppings) {
        super(name, size, toppings);
    }

    public static final String PEPPERONI_NAME = "Pepperoni";
    public static final String HAWAIIAN_NAME = "Hawaiana";
    public static final String VEGETARIAN_NAME = "Vegetariana";
    public static final String SUPREME_NAME = "Suprema";
    public static final String WHITE_NAME = "Blanca";

    public static final double PEPPERONI_BASE_PRICE = 40;
    public static final double HAWAIIAN_BASE_PRICE = 55;
    public static final double VEGETARIAN_BASE_PRICE = 50;
    public static final double SUPREME_BASE_PRICE = 70;
    public static final double WHITE_BASE_PRICE = 35;

    @Override
    protected double calculatePrice(String pizzaName, String pizzaSize) {
        double basePrice = 0;

        switch (pizzaName) {
            case PEPPERONI_NAME:
                basePrice = PEPPERONI_BASE_PRICE;
                break;
            case HAWAIIAN_NAME:
                basePrice = HAWAIIAN_BASE_PRICE;
                break;
            case VEGETARIAN_NAME:
                basePrice = VEGETARIAN_BASE_PRICE;
                break;
            case SUPREME_NAME:
                basePrice = SUPREME_BASE_PRICE;
                break;
            case WHITE_NAME:
                basePrice = WHITE_BASE_PRICE;
                break;
            default:
                throw new IllegalArgumentException("Nombre de pizza no válido: " + pizzaName);
        }

        switch (pizzaSize) {
            case SMALL_SIZE:
                return basePrice;
            case MEDIUM_SIZE:
                return basePrice * 1.2;
            case LARGE_SIZE:
                return basePrice * 1.35;
            default:
                throw new IllegalArgumentException("Tamaño de pizza no válido: " + pizzaSize);
        }
    }

}