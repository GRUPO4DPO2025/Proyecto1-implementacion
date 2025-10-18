package modelo_tickets;

public class TiqueteSimple extends Tiquete {
    
    public TiqueteSimple(String id, Evento evento, double precioBase, String propietarioLogin) {
        super(id, evento, precioBase, propietarioLogin);

    }

    public double calcularPrecioFinal(double cargoFijoEmision, double porcentajeServicio) {
        double cargoServicio = this.precioBase * porcentajeServicio;
        
        this.precioFinal = this.precioBase + cargoServicio + cargoFijoEmision;
        
        return this.precioFinal;
    }
}