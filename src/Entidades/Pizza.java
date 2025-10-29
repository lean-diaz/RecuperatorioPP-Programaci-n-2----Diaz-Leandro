package Entidades;

public class Pizza extends Producto implements IVendible{
    // Atributos Privados
    private TipoPizza sabor;
    private TamanoPizza tamano;
    
    // Constructor
    public Pizza(String nombre, double precio, Fabricante fabricante, TipoPizza sabor, TamanoPizza tamano) {
        super(nombre, precio, fabricante);
        this.sabor = sabor;
        this.tamano = tamano;
    }
   
    // Metodos
    @Override
    public double getPrecioTotal() {
        double precioFinal = super.precio; // Obtenemos el precio base del padre
        
        switch (this.tamano) {
            case CHICA:
                precioFinal *= 1.05;
                break;
            case MEDIANA:
                precioFinal *= 1.10;
                break;
            case GRANDE:
                precioFinal *= 1.20;
                break;
        }
        return precioFinal;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pizza{");
        sb.append("nombre=").append(this.nombre);
        sb.append(", fabricante=").append(this.fabricante); 
        sb.append(", sabor=").append(this.sabor);
        sb.append(", tamano=").append(this.tamano);
        sb.append(", precioBase=$").append(String.format("%.2f", this.precio));
        sb.append(", calorias=").append(this.getCalorias());
        sb.append(", tPrep=").append(this.getTiempoPreparacion());
        sb.append(", precioTotal=$").append(String.format("%.2f", this.getPrecioTotal()));
        sb.append('}');
        return sb.toString();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        
        if (!(obj instanceof Pizza)) {
            return false;
        }
        
        Pizza otra = (Pizza) obj;
        return this.sabor == otra.sabor && this.tamano == otra.tamano;
    }
}
