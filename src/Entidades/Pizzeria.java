package Entidades;

import java.util.ArrayList;
import java.util.Iterator;

public class Pizzeria implements Iterable<Producto>{
    // Atributos privados
    private String nombre;
    private int capacidad;
    private ArrayList<Producto> productos;
    
    // Constructores
    public Pizzeria(String nombre, int capacidad) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.productos = new ArrayList<>(); // Inicializa la colección
    }

    public Pizzeria(String nombre) {
        this(nombre, 3); // Llama al constructor Pizzeria(String, int)
    }
    
    // Metodos
    private boolean sonIguales(Producto p) {
        return this.productos.contains(p);
    }
    
    public void agregar(Producto producto) {
        if (producto == null) {
            System.out.println("Error: No se puede agregar un producto nulo.");
            return;
        }

        if (this.productos.size() >= this.capacidad) {
            System.out.println("Error: La Pizzería '" + this.nombre + "' está llena. No se pudo agregar '" + producto.nombre);
            return;
        }

        if (this.sonIguales(producto)) {
            System.out.println("Error: El producto '" + producto.nombre + "' ya se encuentra en la Pizzería.");
            return;
        }

        this.productos.add(producto);
        System.out.println("Producto '" + producto.nombre + "' agregado a " + this.nombre + " con éxito.");
    }
    
    private double getPrecioProductos(TipoProducto tipo) {
        double total = 0.0;

        for (Producto item : this.productos) {
            boolean sumar = false;

            if (tipo == TipoProducto.TODOS) {
                sumar = true;
            } else if (tipo == TipoProducto.PIZZAS && item instanceof Pizza) {
                sumar = true;
            } else if (tipo == TipoProducto.POSTRES && item instanceof Postre) {
                sumar = true;
            }

            if (sumar) {
                total += ((IVendible) item).getPrecioTotal();
            }
        }
        return total;
    }
    
    private double getPrecioDePizzas() {
        return this.getPrecioProductos(TipoProducto.PIZZAS);
    }

    private double getPrecioDePostres() {
        return this.getPrecioProductos(TipoProducto.POSTRES);
    }

    private double getPrecioTotal() {
        return this.getPrecioProductos(TipoProducto.TODOS);
    }
    
    @Override
    public Iterator<Producto> iterator() {
        return this.productos.iterator();
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("--- Detalle de la Pizzería '").append(this.nombre);
        sb.append("Capacidad: ").append(this.capacidad).append("\n");
        sb.append("Cantidad de Productos: ").append(this.productos.size());
        
        sb.append("--- Listado de Productos ---\n");
        if (this.productos.isEmpty()) {
            sb.append("(La pizzería está vacía)\n");
        } else {
            for (Producto p : this.productos) { // Iteramos sobre los productos
                sb.append(p.toString()).append("\n"); // Llamamos al toString() de una línea de Pizza o Postre
            }
        }
        
        sb.append("\n--- Totales ---\n");
        sb.append("Precio total de Pizzas: $").append(this.getPrecioDePizzas()).append("\n");
        sb.append("Precio total de Postres: $").append(this.getPrecioDePostres()).append("\n");
        sb.append("Precio total General: $").append(this.getPrecioTotal()).append("\n");
        sb.append("--------------------------------------");
        return sb.toString();
    }
}
