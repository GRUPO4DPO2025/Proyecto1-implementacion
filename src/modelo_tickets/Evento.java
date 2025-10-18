package modelo_tickets;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Evento {
    
    private String id;
    private String nombre;
    private LocalDateTime fechaHora; 
    private String tipo;
    private String estado = "Activo"; 
    
    private Object organizador;      
    private Venue venue;             
    private List<Localidad> localidades; 

    public Evento(String id, Object organizador, Venue venue, String nombre, LocalDateTime fechaHora, String tipo) throws IllegalArgumentException {
        
        if (venue == null || !venue.estaAprobado()) {
            throw new IllegalArgumentException("Error de creación: El Venue debe existir y estar aprobado por el Administrador.");
        }
        
        this.id = id;
        this.organizador = organizador;
        this.venue = venue;
        this.nombre = nombre;
        this.fechaHora = fechaHora;
        this.tipo = tipo;
        this.localidades = new ArrayList<>();
    }
    

    public boolean agregarLocalidad(Localidad localidad) {
        return localidades.add(localidad);
    }
    
    public int consultarTiquetesVendidos() {
        return localidades.stream()
                         .mapToInt(Localidad::getTiquetesVendidos)
                         .sum();
    }

    public void cancelar() {
        this.estado = "Cancelado";
        System.out.println("⚠️ Evento " + this.nombre + " ha sido CANCELADO.");
    }

    // -------------------------------------------------------------------
    // MÉTODOS DE CONSULTA (GETTERS)
    // -------------------------------------------------------------------

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public LocalDateTime getFechaHora() { return fechaHora; }
    public String getTipo() { return tipo; }
    public String getEstado() { return estado; }
    public Venue getVenue() { return venue; }
    public List<Localidad> getLocalidades() { return localidades; }
}
