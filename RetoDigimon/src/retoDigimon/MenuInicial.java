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
        Usuario us = new Usuario();
        conexionBD classConexionBD = new conexionBD();
        Connection con = classConexionBD.getConexion();
        switch (opcion){
            case 1:     d.listarDigimones(con);
                        pideMenu(mostrarMenu());
                        break;
                        
            case 2:     d.crearDigimon(con);
                        pideMenu(mostrarMenu());
                        break;
            
            case 3:     d.modificarDigimon(con);
                        pideMenu(mostrarMenu());
                        break;
                        
            case 4:     d.eliminarDigimon(con);
                        pideMenu(mostrarMenu());
                        break;
                        
            case 5:     us.listarUsuarios(con);
                        pideMenu(mostrarMenu());
                        break;
                        
            case 6:     us.creaUsuario(con);
                        pideMenu(mostrarMenu());
                        break;
            
            case 7:     us.modificarUsu(con);
                        pideMenu(mostrarMenu());
                        break;  
                        
            case 8:     us.eliminarUsuario(con);
                        pideMenu(mostrarMenu());
                        break;  
                        
            case 9:     System.out.println("\t\n¿Deseas realmente vaciar la base de datos");
                        System.out.println("\t 1) Si");
                        System.out.println("\t 2) No");
                        int opcionSeleccionada = Methods.datoInt("\t Introduce la opción deseada: ");
                        switch(opcionSeleccionada){
                            case 1: String consultaTruncar = "DELETE FROM tiene";
                                    PreparedStatement psTruncar = con.prepareStatement(consultaTruncar);
                                    psTruncar.executeUpdate();
                                    System.out.println("\tTabla 'Tiene' ha sido vaciada correctamente.");
                                    consultaTruncar = "DELETE FROM digimon";
                                    psTruncar = con.prepareStatement(consultaTruncar);
                                    psTruncar.executeUpdate();
                                    System.out.println("\tTabla 'Digimon' ha sido vaciada correctamente.");
                                    consultaTruncar = "DELETE FROM usuario";
                                    psTruncar = con.prepareStatement(consultaTruncar);
                                    psTruncar.executeUpdate();
                                    consultaTruncar = "ALTER TABLE usuario AUTO_INCREMENT = 1";
                                    psTruncar = con.prepareStatement(consultaTruncar);
                                    psTruncar.executeUpdate();
                                    System.out.println("\tTabla 'Usuario' ha sido vaciada correctamente.\n");
                                    break;
                                    
                            case 2: pideMenu(mostrarMenu());
                                    break;
                            
                            default:System.err.print("\tDebe introducir 1 o 2\n\n");
                                    break;
                        }
                        
            case 10:    break;
            default:    System.err.print("Debe introducir una opción del 1 al 10\n\n");
                        pideMenu(mostrarMenu());
        } 
    }

}