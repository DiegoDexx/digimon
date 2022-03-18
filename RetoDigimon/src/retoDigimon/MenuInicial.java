/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retoDigimon;
import Methods.Methods;
import java.sql.*;

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
        //Añadir buscar usuario, mostrar sus datos y sus digimones
        int opcion = Methods.datoInt("Introduce la opción deseada: ");
        return opcion;
    }
    
    public void pideMenu(int opcion) throws SQLException{
        Methods.limpiarTeclado();
        Digimon d = new Digimon();
        switch (opcion){
            case 1:     d.listarDigimones();
                        pideMenu(mostrarMenu());
                        break;
                        
            case 2:     d.crearDigimon();
                        pideMenu(mostrarMenu());
                        break;
            
            case 3:     d.modificarDigimon();
                        pideMenu(mostrarMenu());
                        break;
                        
            case 4:     d.eliminarDigimon();
                        pideMenu(mostrarMenu());
                        break;
            
            case 9:     conexionBD classConexionBD = new conexionBD();
                        Connection con = classConexionBD.getConexion();   
                        String consultaTruncar = "TRUNCATE TABLE digimon";
                        PreparedStatement psEliminar = con.prepareStatement(consultaTruncar);
                        psEliminar.executeUpdate();
                        System.out.println("Tabla 'Digimon' ha sido eliminado correctamente.\n");
                        break;

            case 10:    break;
            default:    System.err.print("Debe introducir una opción del 1 al 10\n\n");
                        pideMenu(mostrarMenu());
        } 
    }

}