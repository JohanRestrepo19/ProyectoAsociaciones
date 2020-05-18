package clases;

public class Labor {
    private String tipoDeLabor;
    private Fecha fechaRealizacion;
    private String descripcion;

    public Labor() {}

    public Labor(String tipoDeLabor, Fecha fechaRealizacion, String descripcion) {
        this.tipoDeLabor = tipoDeLabor;
        this.fechaRealizacion = fechaRealizacion;
        this.descripcion = descripcion;
    }

    public String getTipoDeLabor() {
        return tipoDeLabor;
    }

    public void setTipoDeLabor(String tipoDeLabor) {
        this.tipoDeLabor = tipoDeLabor;
    }

    public Fecha getFechaRealizacion() {
        return fechaRealizacion;
    }

    public void setFechaRealizacion(Fecha fechaRealizacion) {
        this.fechaRealizacion = fechaRealizacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
        
    
    public void mostrarInformacion(){
        System.out.println("\t\t-Tipo de labor: " + this.tipoDeLabor);
        System.out.println("\t\t-Fecha de realización: " + this.fechaRealizacion.getDia() + 
                                                "/" + this.fechaRealizacion.getMes() +
                                                "/" + this.fechaRealizacion.getAnyo());        
        System.out.println("\t\t-Descripcion: " + this.descripcion);
    }
}
