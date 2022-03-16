/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retoDigimon;

import Sleer2.SLeer2;

/**
 *
 * @author inmag
 */
public class MenuInicial {
    
    public int mostrarMenu(){
    System.out.println("Seleccione una opción: ");
    System.out.println("\t 1) Listar digimones");
    System.out.println("\t 2) Crear digimon");
    System.out.println("\t 3) Modificar digimon");
    System.out.println("\t 4) Eliminar digimon\n");
    System.out.println("\t 5) Listar usuarios");
    System.out.println("\t 6) Crear usuario");
    System.out.println("\t 7) Modificar usuario");
    System.out.println("\t 8) Eliminar usuario\n");
    System.out.println("\t 9) Reiniciar base de datos");
    System.out.println("\t10) Salir");
    int opcion=SLeer2.datoInt("Introduce la opción deseada: ");
    return opcion;
    }
    
    public void pideMenu(int opcion){
        switch (opcion){
            case 10: break;
            default: 
                System.out.print("\n\n\nDebe introducir una opción del 1 al 5");
                pideMenu(mostrarMenu());
        } 
    }

}