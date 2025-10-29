package Entidades;

import java.util.Objects;
import java.util.Random;

public abstract class Producto{
    // Atributos protegidos
    protected Fabricante fabricante;
    protected String nombre;
    protected double precio;
    protected int calorias;
    protected int tiempoPreparacion;
    protected static Random generadorAleatorio;

    // Constructores
    public Producto(String nombre, double precio, Fabricante fabricante) {
        this.nombre = nombre;
        this.precio = precio;
        this.fabricante = fabricante;
    }

    public Producto(String nombre, double precio, String nombreFabricante, String ciudadFabricante, int antiguedadFabricante) {
        this.nombre = nombre;
        this.precio = precio;
        this.fabricante = new Fabricante(nombreFabricante, ciudadFabricante, antiguedadFabricante);
    }

    // Bloque estatico para generadorAleatorio
    static {
        generadorAleatorio = new Random();
    }

    // Metodos Getters
    public Fabricante getFabricante() {
        return fabricante;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public static Random getGeneradorAleatorio() {
        return generadorAleatorio;
    }

    // Metodos
    public int getCalorias() {
        if (this.calorias == 0) {
            // Aleatorio entre 200 y 800: nextInt(max - min + 1) + min -> nextInt(800 - 200 + 1) + 200
            this.calorias = generadorAleatorio.nextInt(800 - 200 + 1) + 200;
        }
        return this.calorias;
    }

    public int getTiempoPreparacion() {
        if (this.tiempoPreparacion == 0) {
            // Aleatorio entre 5 y 20: nextInt(20 - 5 + 1) + 5 -> nextInt(16) + 5
            this.tiempoPreparacion = generadorAleatorio.nextInt(20 - 5 + 1) + 5;
        }
        return this.tiempoPreparacion;
    }

    private static String mostrar(Producto p) {
        StringBuilder sb = new StringBuilder();
        // Usamos los getters para asegurar que se inicialicen los valores aleatorios si son 0
        sb.append("Nombre: ").append(p.nombre).append("\n");
        sb.append("Precio: $").append(p.precio).append("\n");
        sb.append("Calorías: ").append(p.getCalorias()).append("\n");
        sb.append("Tiempo Preparación: ").append(p.getTiempoPreparacion()).append(" min\n");
        sb.append("Fabricante: ").append(p.fabricante.toString());
        return sb.toString();
    }

    private static boolean sonIguales(Producto p1, Producto p2) {
        if (p1 == p2){
            return true;
        }
        if (p1 == null || p2 == null){
            return false;
        }
        // Comparamos nombre y usamos el método estático de Fabricante para comparar
        return Objects.equals(p1.nombre, p2.nombre) && Fabricante.sonIguales(p1.fabricante, p2.fabricante);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null || !(obj instanceof Producto)){
            return false;
        }
        Producto otro = (Producto) obj;
        return Producto.sonIguales(this, otro);
    }
    
    @Override
    public String toString() {
        return Producto.mostrar(this);
    }
}
