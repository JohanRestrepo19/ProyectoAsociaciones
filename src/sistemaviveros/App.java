package sistemaviveros;

import clases.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class App {
    
    public static void imprimirMenu(){
        System.out.println("------------");
        System.out.println("1. Añadir productor.");
        System.out.println("2. Buscar productor.");
        System.out.println("3. Actualizar productor.");
        System.out.println("4. Eliminar productor.");
        System.out.println("5. Salir");
        System.out.println("------------");
        System.out.println("");
    }
    
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

    public static void main(String[] args) throws IOException {
        ArrayList<Productor> productores = new ArrayList<>();
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        Productor nuevoProductor;
        boolean estaEjecutando = true;
        int opcionMenu;
        
        while (estaEjecutando) {
            imprimirMenu();
            opcionMenu = Integer.parseInt(entrada.readLine());
            
            switch (opcionMenu) {
                case 1:
                    nuevoProductor = crearProductor();
                    productores.add(nuevoProductor);
                    break;
                case 2:
                    buscarProductor(productores);
                    break;
                case 3:
                    actualizarProductor(productores);
                    break;
                case 4:
                    eliminarProductor(productores);
                    break;
                case 5:
                    estaEjecutando = false;
                    break;
                default:
                    throw new AssertionError();
            }
            
        }
    }
    
}
