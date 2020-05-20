package clases;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Crud {
    
    
    //Metodo para buscar el indice de un productor
    private static <T extends Productor> int buscarIndexProductor(ArrayList<T> productores, int documentoBuscado){
        int indexProductor = -1;
        
        for (T productor : productores) {
            if(productor.getDocumentoIdentidad() == documentoBuscado){
                indexProductor = productores.indexOf(productor);
                break;
            }
        }
        return indexProductor;
    }
    
    //Metodo para crear un productor
    public static Productor crearProductor() throws IOException{
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        int documentoProductor;
        String nombreProductor, apellidoProductor;
        Productor nuevoProductor = new Productor(); 
        
        System.out.println("Nombre productor: ");
        nombreProductor = entrada.readLine();
        System.out.println("Apellido productor: ");
        apellidoProductor = entrada.readLine();
        System.out.println("Documento de identidad: ");
        documentoProductor = Integer.parseInt(entrada.readLine());
        
        nuevoProductor.setNombre(nombreProductor);
        nuevoProductor.setApellido(apellidoProductor);
        nuevoProductor.setDocumentoIdentidad(documentoProductor);
        nuevoProductor.agregarViveros();
        
        return nuevoProductor;
    }
    
    //Metodo para buscar un productor
    public static <T extends Productor> void buscarProductor(ArrayList<T> productores) throws IOException{
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        T productorBuscado;
        int documentoProductor, indexProductorBuscado, opcionInformacion;
        
        System.out.println("Documento identidad del productor: ");
        documentoProductor = Integer.parseInt(entrada.readLine());
        
        indexProductorBuscado = buscarIndexProductor(productores, documentoProductor);
        
        if(indexProductorBuscado >= 0){
            productorBuscado = productores.get(indexProductorBuscado);
            System.out.println("");
            System.out.println("------------");
            System.out.println("1. Mostrar viveros.");
            System.out.println("2. Mostrar labores viveros.");
            System.out.println("------------");
            System.out.println("");
            
            opcionInformacion = Integer.parseInt(entrada.readLine());
            
            switch (opcionInformacion) {
                case 1:
                    productorBuscado.mostrarInformacionProductor();
                    productorBuscado.mostrarInformacionViveros();
                    break;
                case 2:
                    productorBuscado.mostrarInformacionProductor();
                    productorBuscado.mostrarInformacionLaboresViveros();
                    break;
                default:
                    System.out.println("Opcion no valida.");
                    break;
            }
        }
        else{
            System.out.println("El productor con documento " + documentoProductor + " No fue encontrado.");
        }
    }
    
    //Metodo para actualizar informacion de un productor
    public static <T extends Productor> void actualizarProductor(ArrayList<T> productores) throws IOException{
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        T productorBuscado;
        int documentoProductor, indexProductorBuscado;
        
        System.out.println("Documento identidad del productor: ");
        documentoProductor = Integer.parseInt(entrada.readLine());
        
        indexProductorBuscado = buscarIndexProductor(productores, documentoProductor);
        
        if(indexProductorBuscado >= 0){
            productorBuscado = productores.get(indexProductorBuscado);
            System.out.println("Información actual: ");
            productorBuscado.mostrarInformacionProductor();
            
            System.out.println("Nueva informacion: ");
            System.out.println("Nuevo nombre: ");
            productorBuscado.setNombre(entrada.readLine());
            System.out.println("Nuevo apellido: ");
            productorBuscado.setApellido(entrada.readLine());
            System.out.println("Nuevo documento de identidad: ");
            productorBuscado.setDocumentoIdentidad(Integer.parseInt(entrada.readLine()));
            
            productores.set(indexProductorBuscado, productorBuscado);
        }
        else{
            System.out.println("El productor con documento " + documentoProductor + " no fue encontrado.");
        }
    }
    
    
    //Metodo para eliminar productor
    public static <T extends Productor> void eliminarProductor(ArrayList<T> productores) throws IOException{
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        T productorBuscado;
        int documentoProductor, indexProductorBuscado;
        
        System.out.println("Documento identidad del productor: ");
        documentoProductor = Integer.parseInt(entrada.readLine());
        
        indexProductorBuscado = buscarIndexProductor(productores, documentoProductor);
        
        if (indexProductorBuscado >= 0) {
            productorBuscado = productores.get(indexProductorBuscado);
            productores.remove(productorBuscado);
            System.out.println("El productor con informacion: ");
            productorBuscado.mostrarInformacionProductor();
            System.out.println("Fue eliminado");
        }
        else{
            System.out.println("El productor con documento " + documentoProductor + " no fue encontrado.");
        }
    }
}
