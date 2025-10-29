package Entidades;

public class Postre extends Producto implements IVendible{
    // Atributo
    private TipoPostre tipoPostre;

    // Constructor
    public Postre(String nombre, double precio, Fabricante fabricante, TipoPostre tipoPostre) {
        super(nombre, precio, fabricante);
        this.tipoPostre = tipoPostre;
    }
    
    // Metodos
    @Override
    public double getPrecioTotal() {
        double precioFinal = super.precio;
        
        switch (this.tipoPostre) {
            case TIRAMISU:
                precioFinal *= 1.20;
                break;
            case HELADO:
                precioFinal *= 1.15;
                break;
            case FLAN:
                precioFinal *= 1.10;
                break;
        }
        return precioFinal;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }

        if (!(obj instanceof Postre)) {
            return false;
        }

        Postre otro = (Postre) obj;
        return this.tipoPostre == otro.tipoPostre;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Postre{");
        sb.append("nombre=").append(this.nombre);
        sb.append(", fabricante=").append(this.fabricante);
        sb.append(", tipoPostre=").append(this.tipoPostre);
        sb.append(", precioBase=$").append(String.format("%.2f", this.precio));
        sb.append(", calorias=").append(this.getCalorias());
        sb.append(", tPrep=").append(this.getTiempoPreparacion());
        sb.append(", precioTotal=$").append(String.format("%.2f", this.getPrecioTotal()));
        sb.append('}');
        return sb.toString();
    }
}
