package Entidades;

import java.util.Objects;

public class Fabricante {
    // Atributos privados
    private String nombre;
    private String ciudad;
    private int antiguedad;
    
    // Constructor
    public Fabricante(String nombre, String ciudad, int antiguedad) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.antiguedad = antiguedad;
    }
    
    // Metodos
    public static boolean sonIguales(Fabricante f1, Fabricante f2){
        return f1.equals(f2);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()){
            return false;
        }
        
        Fabricante otro = (Fabricante) obj;
        return this.antiguedad == otro.antiguedad && Objects.equals(this.nombre, otro.nombre) && Objects.equals(this.ciudad, otro.ciudad);
    }
    
    private String getInfoFabricante() {
        return String.format("%s (Ciudad: %s, Antigüedad: %d años)", this.nombre, this.ciudad, this.antiguedad);
    }

    @Override
    public String toString() {
        return getInfoFabricante();
    }
}
