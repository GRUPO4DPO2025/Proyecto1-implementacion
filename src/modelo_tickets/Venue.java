package modelo_tickets;

import java.util.List;
import java.util.ArrayList;

public class Venue {
    
    private String nombre;
    private String ubicacion;
    private int capacidadMaxima;
    private List<String> restricciones; 
    private boolean estaAprobado = false;

    /**
     * Constructor para inicializar un nuevo Venue.
     * Un Venue se crea inicialmente como NO aprobado.
     */
    public Venue(String nombre, String ubicacion, int capacidadMaxima, List<String> restricciones) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.capacidadMaxima = capacidadMaxima;
        
        if (restricciones == null) {
            this.restricciones = new ArrayList<>();
        } else {
            this.restricciones = restricciones;
        }
        
        this.estaAprobado = false; 
    }

    // -------------------------------------------------------------------
    // MÉTODOS DE CONSULTA (GETTERS)
    // -------------------------------------------------------------------

    public String getNombre() {
        return nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public List<String> getRestricciones() {
        return restricciones;
    }

    public boolean estaAprobado() {
        return estaAprobado;
    }
    
    
    public void setAprobado(boolean aprobado) {
        this.estaAprobado = aprobado;
        if (aprobado) {
            System.out.println("✅ Venue '" + this.nombre + "' ha sido aprobado por el Administrador.");
        } else {
            System.out.println("❌ Venue '" + this.nombre + "' ha sido desaprobado.");
        }
    }
}