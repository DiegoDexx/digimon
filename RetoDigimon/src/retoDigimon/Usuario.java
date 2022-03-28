/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package retoDigimon;
import java.sql.*;
import Methods.Methods;
import java.util.ArrayList;

/**
 *
 * @author Rubén, Inma, Diego & Jaime
 */

public class Usuario {
    int codigoUsu;
    String contrasenyaUsu;
    String nombreUsu;
    int partidasganaUsu;
    int evolucionesUsu;
   
    public void setNomUsu( String nomusu) { this.nombreUsu=nomusu;}
    public void setContrasenyaUsu( String contrasenyaUsu ) { this.contrasenyaUsu=contrasenyaUsu;  }
    public void  setCodigo( int codigo) { this.codigoUsu=codigo; }
    public void setPartidasgan( int partidas ){ this.partidasganaUsu=partidas; }
    public void setEvoluciones( int evoluciones ){ this.evolucionesUsu=evoluciones; }
    
    public int getCodigousu() { return codigoUsu; }
    public String getNombre() { return nombreUsu; }
    public String getContrasenya() { return contrasenyaUsu; }
    public int getPartidas() { return partidasganaUsu; }
    public int getEvoluciones() { return evolucionesUsu; }
    
    
    Usuario(){  
    }
    
    public void creaUsuario(Connection con) throws SQLException {
        
        //Solicitamos los datos del nuevo usuario
        
        setNomUsu(Methods.datoNombreUsu("\tInserta el nombre del usuario: "));
        setContrasenyaUsu(Methods.datoString("\tInserta la contraseña del usuario: "));
        String consultaUSER = "INSERT INTO usuario(nombreUsu, contrasenyaUsu) VALUES (?,?)";
        PreparedStatement ps = con.prepareStatement(consultaUSER);
        ps.setString(1, nombreUsu);
        ps.setString(2, contrasenyaUsu);
        ps.executeUpdate();

        //Realizamos la consulta para introducir los valores del nuevo usuario
        
        int contadorDeDigimones = 0;
        String consultaDigimones = "SELECT nombreDig FROM digimon WHERE nivelDig = 1";
        PreparedStatement ps2 = con.prepareStatement(consultaDigimones);
        ResultSet rs = ps2.executeQuery();
        ArrayList<String> nombresDigimon = new ArrayList<String>();
        while (rs.next()) {
            nombresDigimon.add(rs.getString("nombreDig"));
        }
        String[] nombresDigimonArray = new String[nombresDigimon.size()];
        nombresDigimonArray = nombresDigimon.toArray(nombresDigimonArray);
        int posicionEnArray = 0;
        do {
            double random = Math.random() * nombresDigimonArray.length;
            posicionEnArray = (int) random;
            int codigoUsuario = 0;
            String consultaCodigo = "SELECT codigoUsu FROM usuario ORDER BY codigoUsu DESC LIMIT 1";
            ps2 = con.prepareStatement(consultaCodigo);
            rs = ps2.executeQuery(consultaCodigo);
            if (rs.next()) {
                codigoUsuario = rs.getInt("codigoUsu");
            }
            consultaDigimones = "SELECT codigoUsu FROM tiene WHERE codigoUsu = " + codigoUsuario + " && nombreDig = '" + nombresDigimonArray[posicionEnArray] + "'";
            ps2 = con.prepareStatement(consultaDigimones);
            rs = ps2.executeQuery(consultaDigimones);
            if (!rs.next()) {
                consultaDigimones = "INSERT INTO tiene(codigoUsu, nombreDig) VALUES (?,?)";
                ps2 = con.prepareStatement(consultaDigimones);
                ps2.setInt(1, codigoUsuario);
                ps2.setString(2, nombresDigimonArray[posicionEnArray]);
                ps2.executeUpdate();
                contadorDeDigimones++;
            }
        }while(contadorDeDigimones < 3);

        System.out.println("\tSe ha agregado el usuario " + nombreUsu + " a la base de datos\n\n");
        ps.close();
        con.close();
    }
     
    
    public static void listarUsuarios(Connection con) throws SQLException {
        
        //Consulta para que obtener todos los datos de mis usuarios
        
        String consultaUSER = "SELECT * FROM usuario";
        PreparedStatement ps =  con.prepareStatement(consultaUSER);
        ResultSet rs = ps.executeQuery(consultaUSER);
        
        //Creación de tabla manual para mostrar los usuarios con sus características
        
        System.out.println("\n######################################################################################################################");
        System.out.println(" LISTADO DE USUARIOS");
        System.out.println("######################################################################################################################");
        System.out.printf("%10s %20s %20s %26s %31s", "NOMBRE DE USUARIO", "PARTIDAS JUGADAS", "PARTIDAS GANADAS", "EVOLUCIONES DISPONIBLES", "DIGIMONES DEL USUARIO");

        while(rs.next()){
            String consultaDigimones = "SELECT nombreDig FROM tiene WHERE codigoUsu="+rs.getInt("codigoUsu")+";";
            PreparedStatement psConsultaDigimones = con.prepareStatement(consultaDigimones);
            ResultSet rsConsultaDigimones = psConsultaDigimones.executeQuery(consultaDigimones);
            String digimonesTotales = "";
            while(rsConsultaDigimones.next()){ digimonesTotales += rsConsultaDigimones.getString("nombreDig")+" "; }
                    
            System.out.println();
            System.out.format("%17s %20d %20d %26d %32s", rs.getString("nombreUsu"), rs.getInt("partidasUsu"), rs.getInt("partidasganaUsu"), rs.getInt("evolucionesUsu"), digimonesTotales);
        }
        System.out.println("\n######################################################################################################################\n\n");
        ps.close();
        con.close();
    }
    
    
    public void modificarUsu(Connection con) throws SQLException {
        
        //Preguntar al usuario qué usuario desea modificar.
        
        String usuarioIntrod = Methods.datoNombreModificarUsu("\t¿Qué usuario quieres modificar?: ", "El nombre no puede estar vacío");
        String consulta = " SELECT * FROM usuario WHERE nombreUsu = '" + usuarioIntrod + "';";
        PreparedStatement ps = con.prepareStatement(consulta);
        ResultSet rs = ps.executeQuery(consulta);
        
        //si encuentra algún usuario que establezca los valores de ese usuario al objeto usuario
        
        if (rs.next()) {
            setNomUsu(rs.getString("nombreUsu"));
            setContrasenyaUsu(rs.getString("contrasenyaUsu"));
            setCodigo(rs.getInt("codigoUsu"));
            setPartidasgan(rs.getInt("partidasganaUsu"));
            setEvoluciones(rs.getInt("evolucionesUsu"));
        }
        int opt;
        do {
            System.out.println("\n\tSeleccione un atributo a modificar: ");
            System.out.println("\t\t 1) Nombre");
            System.out.println("\t\t 2) Restablecer contraseña: ");
            System.out.println("\t\t 3) Cambiar partidas ganadas");
            System.out.println("\t\t 4) Cambiar número de evoluciones\n");
            System.out.println("\t\t 5) Guardar cambios");
            opt = Methods.datoInt("\tIntroduce la opción deseada: ");
            Methods.limpiarTeclado();
            switch (opt) {
                case 1:
                    setNomUsu(Methods.datoModificarNombreUsu("\t\tNombre: " + getNombre() + " ---> ", "\tNo es un nombre válido", getNombre()));
                    break;

                case 2:
                    setContrasenyaUsu(Methods.datoString("\t\tContraseña: " + getContrasenya() + " ---> "));
                    break;

                case 3:
                    setPartidasgan(Methods.datoInt("\t\tPartidas ganadas: " + getPartidas() + "-> "));
                    break;

                case 4:
                    setEvoluciones(Methods.datoInt("\t\tEvoluciones: " + getEvoluciones() + "-> "));
                    break;

                case 5:
                    String consultaModificar = "UPDATE usuario SET nombreUsu='" + getNombre() + "',contrasenyaUsu='" + getContrasenya() + "',partidasganaUsu=" + getPartidas() + ",evolucionesUsu=" + getEvoluciones() + " WHERE nombreUsu ='" + usuarioIntrod + "';";
                    PreparedStatement psModificar = con.prepareStatement(consultaModificar);
                    psModificar.executeUpdate();
                    break;

                default:
                    System.err.print("Debe introducir una opción del 1 al 5\n\n");
                    break;

            }
        } while (opt != 5);
        ps.close();
        con.close();
    }

    public void eliminarUsuario(Connection con) throws SQLException {
        String nombreUsuEliminar = Methods.datoNombreModificarUsu("\tIntroduce el usuario a eliminar: ", "El nombre no puede estar vacío");
        
        //Buscamos el usuario que desea eliminar en la columna nombreUsu de la tabla usuario
        
        int opt2;
        String consulta = "SELECT * FROM usuario WHERE nombreUsu ='" + nombreUsuEliminar + "';";
        PreparedStatement ps = con.prepareStatement(consulta);
        ResultSet rs = ps.executeQuery(consulta);
        
        //si existe algún usuario con el nombre introducido previamente, decidir si borrar
        
        if (rs.next()) {
            System.out.println("\t Estas seguro de eliminar el usuario? Se eliminarán todos sus datos: ");
            System.out.println("\t 1) Si, eliminar");
            System.out.println("\t 2) No");
            opt2 = Methods.datoInt("Introduzca la opción a ejecutar: ");
            Methods.limpiarTeclado();
            switch (opt2) {
                case 1:
                    String consultaEliminar = "DELETE FROM usuario WHERE nombreUsu = '" + nombreUsuEliminar + "'";
                    PreparedStatement psEliminar = con.prepareStatement(consultaEliminar);
                    psEliminar.executeUpdate();
                    System.out.println("\t" + nombreUsuEliminar + " ha sido eliminado correctamente.\n");
                    break;

                case 2:
                    break;

                default:
                    System.err.print("Debe introducir 1 o 2\n\n");
                    break;
            }
        }
        ps.close();
        con.close();
    }
}