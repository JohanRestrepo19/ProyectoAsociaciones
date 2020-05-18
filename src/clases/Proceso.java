package clases;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Proceso {
    private String nombreProceso;
    private ArrayList<Labor> labores = new ArrayList();

    public Proceso() {}

    public Proceso(String nombreProceso) {
        this.nombreProceso = nombreProceso;
    }

    public String getNombreProceso() {
        return nombreProceso;
    }

    public void setNombreProceso(String nombreProceso) {
        this.nombreProceso = nombreProceso;
    }

    public ArrayList<Labor> getLabores() {
        return labores;
    }

    public void setLabores(ArrayList<Labor> labores) {
        this.labores = labores;
    }
    
    private Labor crearLabor() throws IOException{
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        String tipoDeLabor; 
        String descripcion = null; // Posible error
        int diaRealizacion, mesRealizacion, anyoRealizacion;
        Fecha fechaDeRealizacion;  
        Labor nuevaLabor = new Labor();
        
        System.out.println("Tipo de labor: ");
        tipoDeLabor = entrada.readLine();
        System.out.println("Dia de realizacion: ");
        diaRealizacion = Integer.parseInt(entrada.readLine());
        System.out.println("Mes de realizacion: ");
        mesRealizacion = Integer.parseInt(entrada.readLine());
        System.out.println("Año de realizacion: ");
        anyoRealizacion = Integer.parseInt(entrada.readLine());        
        fechaDeRealizacion = new Fecha(diaRealizacion, mesRealizacion, anyoRealizacion);
        System.out.println("Descripcion de labor: ");
        descripcion = entrada.readLine();
        
        nuevaLabor.setTipoDeLabor(tipoDeLabor);
        nuevaLabor.setFechaRealizacion(fechaDeRealizacion);
        nuevaLabor.setDescripcion(descripcion);
        
        return nuevaLabor;
    }
    
    public void agregarLabores() throws IOException{
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        Labor nuevaLabor;
        int opcion;
        boolean estaAgregando =  true;
        
        while(estaAgregando){
            nuevaLabor = crearLabor();
            this.labores.add(nuevaLabor);
            System.out.println("¿Desea agregar otra labor?: 1. Si, 2. No");
            opcion = Integer.parseInt(entrada.readLine());
            if(opcion == 2){
                estaAgregando = false;
            }
        }
        
    }
    
}
