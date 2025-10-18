 package modelo_tickets;

public abstract class Tiquete {
    
    
    private String id;                 
    protected double precioBase;       
    protected double precioFinal;      
    protected boolean esTransferible = true; 
    
    private Evento eventoAsociado;      
    private String propietarioLogin;     
    private boolean estaVendido = false; 


    public Tiquete(String id, Evento evento, double precioBase, String propietarioLogin) {
        this.id = id;
        this.eventoAsociado = evento;
        this.precioBase = precioBase;
        this.propietarioLogin = propietarioLogin;
    }
    

    public abstract double calcularPrecioFinal(double cargoFijoEmision, double porcentajeServicio);

    
    public boolean transferir(String nuevoPropietarioLogin) {
        if (!this.esTransferible) {
            System.out.println("❌ Error: El tiquete " + this.id + " (Deluxe) no es transferible.");
            return false;
        }
        
        this.propietarioLogin = nuevoPropietarioLogin;
        System.out.println("✅ Tiquete " + this.id + " transferido al usuario: " + nuevoPropietarioLogin);
        return true;
    }

    public void marcarComoVendido() {
        this.estaVendido = true;
    }

    public String getId() { return id; }
    public double getPrecioBase() { return precioBase; }
    public double getPrecioFinal() { return precioFinal; }
    public boolean esTransferible() { return esTransferible; }
    public String getPropietarioLogin() { return propietarioLogin; }
    public Evento getEventoAsociado() { return eventoAsociado; }
    
    protected void setEsTransferible(boolean esTransferible) {
        this.esTransferible = esTransferible;
    }
}