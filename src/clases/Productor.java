package clases;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Productor {
    private int documentoIdentidad;
    private String nombre;
    private String apellido;
    private ArrayList<Vivero> viveros = new ArrayList();

    public Productor() {}

    public Productor(int documentoIdentidad, String nombre, String apellido) {
        this.documentoIdentidad = documentoIdentidad;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public int getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public void setDocumentoIdentidad(int documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public ArrayList<Vivero> getViveros() {
        return viveros;
    }

    public void setViveros(ArrayList<Vivero> viveros) {
        this.viveros = viveros;
    }

    private Vivero crearVivero() throws IOException{
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        int codigoVivero;
        String nombre, departamento, municipio;
        ArrayList<Proceso> procesos = new ArrayList();
        Vivero nuevoVivero = new Vivero();
        
        System.out.println("Codigo vivero: ");
        codigoVivero = Integer.parseInt(entrada.readLine());
        System.out.println("Nombre Vivero: ");
        nombre = entrada.readLine();
        System.out.println("Departamento en el que se encuentra: ");
        departamento = entrada.readLine();
        System.out.println("Municipio en el que se encuentra: ");
        municipio = entrada.readLine();
        
        nuevoVivero.setCodigoVivero(codigoVivero);
        nuevoVivero.setNombre(nombre);
        nuevoVivero.setDepartamento(departamento);
        nuevoVivero.setMunicipio(municipio);
        nuevoVivero.setProcesos(procesos);        
        nuevoVivero.agragarProcesos();
        
        return nuevoVivero;
    }  
    
    public void agregarViveros() throws IOException{
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        Vivero nuevoVivero;
        int opcion;
        boolean estaAgregando = true;
        
        while(estaAgregando){
            nuevoVivero = crearVivero();
            this.viveros.add(nuevoVivero);
            System.out.println("¿Desea agregar otro vivero?: 1. Si, 2. No");
            opcion = Integer.parseInt(entrada.readLine());
            if(opcion == 2){
                estaAgregando = false;
            }
        }
    }
    
    public void mostrarInformacionProductor(){
        System.out.println("");
        System.out.printf("Nombre: %s \n", this.nombre);
        System.out.printf("Apellido: %s \n", this.apellido);
        System.out.printf("Documento identidad: %d \n", this.documentoIdentidad);
        System.out.println("");
    }
    
    public void mostrarInformacionViveros(){
        int idVivero = 1;
        
        for (Vivero vivero : this.viveros){
            System.out.println("Vivero #" + idVivero);
            vivero.mostrarInformacion();
            idVivero++;
        }
        System.out.println("");
    }
    
    public void mostrarInformacionLaboresViveros(){
        int idVivero = 1;
        System.out.println("");
        System.out.println("------------");
        
        for (Vivero vivero : this.viveros) {
            System.out.println("Vivero #" + idVivero);
            vivero.mostrarInformacionLabores();
            idVivero++;
        }
        System.out.println("------------");
        System.out.println("");
    }
    
}
