package clases;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Crud {
    
    //Metodo para buscar el indice de un productor
    public static int buscarIndexProductor(ArrayList<Productor> productores, int documentoBuscado){
        int indexProductor = -1;
        
        for (Productor productor : productores) {
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
        Productor nuevoProductor = new Productor();
        int documentoProductor;
        String nombreProductor, apellidoProductor;
        
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
    public static void buscarProductor(ArrayList<Productor> productores) throws IOException{
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        Productor productorBuscado;
        int documentoProductor, indexProductorBuscado, opcionInformacion;

        System.out.println("Documento identidad del productor: ");
        documentoProductor = Integer.parseInt(entrada.readLine());
        
        indexProductorBuscado = buscarIndexProductor(productores, documentoProductor);
        
        if(indexProductorBuscado >= 0){
            productorBuscado = productores.get(indexProductorBuscado);
            System.out.println("1. Mostrar viveros.");
            System.out.println("2. Mostrar labores viveros.");
            opcionInformacion = Integer.parseInt(entrada.readLine());
            
            switch (opcionInformacion) {
                case 1:
                    productorBuscado.mostrarInformacionViveros();
                    break;
                case 2:
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
    
    //Metodo para actualizar la informacion de un productor
    public static void actualizarProductor(ArrayList<Productor> productores) throws IOException{
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        Productor productorBuscado;
        int documentoProductor, indexProductorBuscado;
        
        System.out.println("Documento identidad del productor: ");
        documentoProductor = Integer.parseInt(entrada.readLine());
        
        indexProductorBuscado = buscarIndexProductor(productores, documentoProductor);
        
        if(indexProductorBuscado >= 0){
            productorBuscado = productores.get(indexProductorBuscado);
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
    
    //Metodo para eliminar un productor
    public static void eliminarProductor(ArrayList<Productor> productores) throws IOException{
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        Productor productorBuscado;
        int documentoProductor, indexProductorBuscado;
        
        System.out.println("Documento identidad del productor: ");
        documentoProductor = Integer.parseInt(entrada.readLine());
        
        indexProductorBuscado = buscarIndexProductor(productores, documentoProductor);
        
        if(indexProductorBuscado >= 0){
            productorBuscado = productores.get(indexProductorBuscado);
            productores.remove(productorBuscado);
            System.out.println("El productor con documento " + documentoProductor + " fue eliminado del sistema.");
        }
        else{
            System.out.println("El productor con documento " + documentoProductor + " no fue encontrado.");
        }
    }
}
