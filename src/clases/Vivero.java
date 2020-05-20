package clases;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Vivero {
    private int codigoVivero;
    private String nombre;
    private String departamento;
    private String municipio;
    private ArrayList<Proceso> procesos = new ArrayList();

    public Vivero() {}

    public Vivero(int codigoVivero, String nombre, String departamento, String municipio) {
        this.codigoVivero = codigoVivero;
        this.nombre = nombre;
        this.departamento = departamento;
        this.municipio = municipio;
    }

    public int getCodigoVivero() {
        return codigoVivero;
    }

    public void setCodigoVivero(int codigoVivero) {
        this.codigoVivero = codigoVivero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public ArrayList<Proceso> getProcesos() {
        return procesos;
    }

    public void setProcesos(ArrayList<Proceso> procesos) {
        this.procesos = procesos;
    }
    
        
    private Proceso crearProceso() throws IOException{
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        String nombreProceso;
        ArrayList<Labor> labores = new ArrayList(); 
        Proceso nuevoProceso = new Proceso();
        
        System.out.println("Nombre proceso: ");
        nombreProceso = entrada.readLine();
        
        nuevoProceso.setLabores(labores);
        nuevoProceso.setNombreProceso(nombreProceso);
        
        nuevoProceso.agregarLabores();
        
        return nuevoProceso;
    }
    
    public void agragarProcesos() throws IOException{
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        Proceso nuevoProceso;
        int opcion;
        boolean estaAgregando = true;
        
        while(estaAgregando){
            nuevoProceso = crearProceso();
            this.procesos.add(nuevoProceso);
            System.out.println("¿Desea agregar otro proceso?: 1. Si, 2. No");
            opcion = Integer.parseInt(entrada.readLine());
            if(opcion == 2){
                estaAgregando = false;
            }
        }
    }
    
    public void mostrarInformacion(){
        System.out.println("");
        System.out.println("------------");
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Codigo: " + this.codigoVivero);
        System.out.println("Departamento: " + this.departamento);
        System.out.println("Municipio: " + this.municipio);
        System.out.println("------------");
        System.out.println("");
    }
    
    public void mostrarInformacionLabores(){
        System.out.println("");
        
        System.out.println("Nombre vivero: " + this.nombre);
        System.out.println("Procesos: ");
        for (Proceso proceso : this.procesos) {
            System.out.println("\tNombre proceso: " + proceso.getNombreProceso());
            System.out.println("\tLabores asociadas al proceso: ");
            for (Labor labor : proceso.getLabores()) {
                labor.mostrarInformacion();
            }
        }
        System.out.println("");
    }
    
    
}
