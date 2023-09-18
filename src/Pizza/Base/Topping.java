package Pizza.Base;
import java.util.*;
public class Topping {



    private java.lang.String nombre; // Nombre del topping

    private double price;
    private ArrayList<String> ingredientes = new ArrayList<>();
    // Nombres preestablecidos
    public static final java.lang.String PEPPERONI_NAME = "Pepperoni";
    public static final java.lang.String PINEAPPLE_NAME = "Piña";
    public static final java.lang.String SWEET_PEPPER_NAME = "Chile Dulce";
    public static final java.lang.String ONION_NAME = "Cebolla";
    public static final java.lang.String CHEESE_NAME = "Queso";
    public static final java.lang.String MUSHROOMS_NAME = "Champiñones";

    // Precios preestablecidos
    public static final double PEPPERONI_PRICE = 10.00;
    public static final double PINEAPPLE_PRICE = 12.00;
    public static final double SWEET_PEPPER_PRICE = 2.00;
    public static final double ONION_PRICE = 4.00;
    public static final double CHEESE_PRICE = 8.00;
    public static final double MUSHROOMS_PRICE = 15.00;// Ingredientes del topping

    public void agregarIngrediente(String ingrediente) {
        this.ingredientes.add(ingrediente);
    }

    public Topping(java.lang.String nombre, double price) {
        this.nombre = nombre;
        this.price = price;
    }

    @Override
    public java.lang.String toString() {
        return "Topping{" + "nombre='" + nombre + '\'' + ", ingredientes=" + ingredientes + '}';
    }


    //getters y setters
    public java.lang.String getNombre() {
        return nombre;
    }

    public void setNombre(java.lang.String nombre) {
        this.nombre = nombre;
    }
    public double getPrice() {
        return price;
    }


    public void setPrice(double price) {
        this.price = price;
    }

    public ArrayList<String> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(ArrayList<String> ingredientes) {
        this.ingredientes = ingredientes;
    }


}