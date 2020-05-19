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
                    nuevoProductor = Crud.crearProductor();
                    productores.add(nuevoProductor);
                    break;
                case 2:
                    Crud.buscarProductor(productores);
                    break;
                case 3:
                    Crud.actualizarProductor(productores);
                    break;
                case 4:
                    Crud.eliminarProductor(productores);
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
