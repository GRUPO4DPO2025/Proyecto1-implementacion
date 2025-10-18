package modelo_tickets;

import java.util.ArrayList;
import java.util.List;

public class PaqueteDeluxe extends Tiquete {
    
    private String beneficios; 
    private List<Tiquete> tiquetesIncluidos; 


    public PaqueteDeluxe(String id, Evento evento, double precioPaquete, String propietarioLogin, String beneficios) {
        super(id, evento, precioPaquete, propietarioLogin);
        this.beneficios = beneficios;
        this.tiquetesIncluidos = new ArrayList<>();
        
        super.setEsTransferible(false); 
    }


    public double calcularPrecioFinal(double cargoFijoEmision, double porcentajeServicio) {
        double cargoServicio = this.precioBase * porcentajeServicio;
        this.precioFinal = this.precioBase + cargoServicio + cargoFijoEmision;
        return this.precioFinal;
    }
    

    public boolean transferir(String nuevoPropietarioLogin) {
        System.out.println("❌ Error: Los Paquetes Deluxe (" + this.getId() + ") NO son transferibles por regla de negocio.");
        return false;
    }

    public void agregarTiquete(Tiquete tiquete) {
        this.tiquetesIncluidos.add(tiquete);
    }
    
    public List<Tiquete> getTiquetesIncluidos() {
        return tiquetesIncluidos;
    }
}