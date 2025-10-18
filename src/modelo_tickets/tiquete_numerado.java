package modelo_tickets;

public class TiqueteNumerado extends Tiquete {
    
    private int numeroAsiento; 

       public TiqueteNumerado(String id, Evento evento, double precioBase, String propietarioLogin, int numeroAsiento) {
        super(id, evento, precioBase, propietarioLogin);
        this.numeroAsiento = numeroAsiento;
    }


    public double calcularPrecioFinal(double cargoFijoEmision, double porcentajeServicio) {
        double cargoServicio = this.precioBase * porcentajeServicio;
        
        this.precioFinal = this.precioBase + cargoServicio + cargoFijoEmision;
        
        return this.precioFinal;
    }

    public int getNumeroAsiento() {
        return numeroAsiento;
    }
    
    public String toString() {
        return "Tiquete Numerado [ID: " + getId() + ", Asiento: " + numeroAsiento + 
               ", Precio Final: " + getPrecioFinal() + ", Dueño: " + getPropietarioLogin() + "]";
    }
}