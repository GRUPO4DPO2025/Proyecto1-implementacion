package modelo_tickets;

import java.util.ArrayList;
import java.util.List;

public class TiqueteMultiple extends Tiquete {
    
    // Composición: el tiquete múltiple CONTIENE las entradas individuales
    private List<Tiquete> entradasIndividuales; 
    
    /**
     * Constructor para un Tiquete Múltiple.
     * @param id Identificador único del tiquete MÚLTIPLE.
     * @param evento Evento asociado.
     * @param precioPaquete Precio total del conjunto de entradas.
     * @param propietarioLogin El login del cliente que compra el tiquete.
     * @param entradas Lista de los tiquetes que incluye este paquete (ej. TiqueteSimple o TiqueteNumerado).
     */
    public TiqueteMultiple(String id, Evento evento, double precioPaquete, String propietarioLogin, List<Tiquete> entradas) {
        super(id, evento, precioPaquete, propietarioLogin);
        if (entradas == null) {
            this.entradasIndividuales = new ArrayList<>();
        } else {
            this.entradasIndividuales = entradas;
        }
    }


    public double calcularPrecioFinal(double cargoFijoEmision, double porcentajeServicio) {

        double cargoServicio = this.precioBase * porcentajeServicio;
        this.precioFinal = this.precioBase + cargoServicio + cargoFijoEmision;
        return this.precioFinal;
    }


    public boolean transferir(String nuevoPropietarioLogin) {
        
        boolean algunaEntradaTransferidaOUsada = entradasIndividuales.stream()
            .anyMatch(t -> !t.esTransferible()); 
            
        if (algunaEntradaTransferidaOUsada) {
            System.out.println("❌ Error: Tiquete Múltiple " + this.getId() + 
                               " no puede transferirse porque una o más entradas individuales ya han sido gestionadas.");
            return false;
        }
        
        boolean exito = super.transferir(nuevoPropietarioLogin);
        
        if (exito) {
            for (Tiquete t : entradasIndividuales) {
                t.transferir(nuevoPropietarioLogin);
            }
        }
        return exito;
    }
    
    public List<Tiquete> getEntradasIndividuales() {
        return entradasIndividuales;
    }
}