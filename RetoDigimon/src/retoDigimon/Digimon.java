/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package retoDigimon;

import Methods.Methods;
import static java.lang.String.format;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
/**
 *
 * @author Rubén
 */
public class Digimon {
    String nombreDig;
    String nombreevolucionDig;
    int nivelDig;
    int defensaDig;
    int ataqueDig;
    String tipoDig; // Pasar a ENUM
    String fotoDig = "No usamos";
    String fotovicDig = "No usamos";
    String fotoderDig = "No usamos";
    static String[] tiposDeDigimon = {"acuatico","arma","baba","diablillo","parásito","angel","fuego"};

    public void setNombreDig(String nombreDig) { this.nombreDig = nombreDig; }
    public void setNombreevolucionDig(String nombreevolucionDig) { this.nombreevolucionDig = nombreevolucionDig;}
    public void setNivelDig(int nivelDig) { this.nivelDig = nivelDig; }
    public void setDefensaDig(int defensaDig) { this.defensaDig = defensaDig; }
    public void setAtaqueDig(int ataqueDig) {this.ataqueDig = ataqueDig; }
    public void setTipoDig(String tipoDig) { this.tipoDig = tipoDig; }
    public void setFotoDig(String fotoDig) { this.fotoDig = fotoDig;}
    public void setFotovicDig(String fotovicDig) {this.fotovicDig = fotovicDig;}
    public void setFotoderDig(String fotoderDig) { this.fotoderDig = fotoderDig;}

    public String getNombreDig() { return nombreDig; }
    public String getNombreevolucionDig() { return nombreevolucionDig; }
    public int getNivelDig() { return nivelDig; }
    public int getDefensaDig() { return defensaDig; }
    public int getAtaqueDig() { return ataqueDig; }
    public String getTipoDig() { return tipoDig; }
    public String getFotoDig() { return fotoDig; }
    public String getFotovicDig() {return fotovicDig; }
    public String getFotoderDig() { return fotoderDig; }
    public String[] getTiposDeDigimon() { return tiposDeDigimon; }
    
    Digimon(){ }
    
    public void crearDigimon(Connection con) throws SQLException{
        System.out.println("\n####################################");
        System.out.println(" CREAR DIGIMON");
        System.out.println("####################################");
        
        setNombreDig(Methods.datoNombre("\tNombre de digimón: "));
        setNombreevolucionDig(Methods.datoNombreEvolucion("\tNombre de su digievolución: ","",getNombreDig()));
        setTipoDig(Methods.datoTipo("\tTipo del digimón: ",getTiposDeDigimon(),""));
        setNivelDig(Methods.datoNivel("\tNivel de digimón: ","\tEl nivel del digimon debe ser 1,2 o 3"));
        setAtaqueDig(Methods.datoEstadisticas("\tAtaque del digimón: ",""));
        setDefensaDig(Methods.datoEstadisticas("\tDefensa del digimón: ",""));

        String consulta = "INSERT INTO digimon (nombreDig,nombreevolucionDig,nivelDig,defensaDig,ataqueDig,tipoDig) VALUES (?,?,?,?,?,?)";
        PreparedStatement ps =  con.prepareStatement(consulta);
        ps.setString(1, getNombreDig());
        ps.setString(2, getNombreevolucionDig());
        ps.setInt(3, getNivelDig());
        ps.setInt(4, getDefensaDig());
        ps.setInt(5, getAtaqueDig());
        ps.setString(6, getTipoDig());
        ps.executeUpdate();
        System.out.println("\tSe ha agregado a "+getNombreDig()+" correctamente\n\n");
        ps.close();
        con.close();
    }
    
    public void listarDigimones(Connection con) throws SQLException{
        String consulta = "SELECT * FROM digimon";
        PreparedStatement ps =  con.prepareStatement(consulta);
        ResultSet rs = ps.executeQuery(consulta);
        
        System.out.println("\n###########################################################################");
        System.out.println(" LISTADO DE DIGIMONES");
        System.out.println("###########################################################################");
        System.out.printf("%10s %20s %5s %5s %5s %5s", "NOMBRE DE DIGIMON", "NOMBRE DE EVOLUCION", "TIPO DE DIGIMON", "NIVEL", "ATAQUE", "DEFENSA");

        while(rs.next()){
            System.out.println();
            System.out.format("%17s %20s %15s %5d %6d %7d", rs.getString("nombreDig"), rs.getString("nombreevolucionDig"), rs.getString("tipoDig"), rs.getInt("nivelDig"), rs.getInt("ataqueDig"), rs.getInt("defensaDig"));
        }
        System.out.println("\n###########################################################################\n\n");
        ps.close();
        con.close();
    }
    
    public void modificarDigimon(Connection con) throws SQLException{
        String nombreDigimonIntroducido = Methods.datoNombreModificar("\tIntroduce el digimon a modificar: ");
        String consulta = "SELECT * FROM digimon WHERE nombreDig ='"+nombreDigimonIntroducido+"';";
        PreparedStatement ps =  con.prepareStatement(consulta);
        ResultSet rs = ps.executeQuery(consulta);
        if(rs.next()){
            setNombreDig(rs.getString("nombreDig"));
            setNombreevolucionDig(rs.getString("nombreevolucionDig"));
            setNivelDig(rs.getInt("nivelDig"));
            setAtaqueDig(rs.getInt("ataqueDig"));
            setDefensaDig(rs.getInt("defensaDig"));
            setTipoDig(rs.getString("tipoDig"));
        }
        int opcionSeleccionada;
        do {
            System.out.println("\n\tSeleccione un atributo a modificar: ");
            System.out.println("\t\t 1) Nombre");
            System.out.println("\t\t 2) Nombre de su digievolución");
            System.out.println("\t\t 3) Ataque");
            System.out.println("\t\t 4) Defensa");
            System.out.println("\t\t 5) Tipo\n");
            System.out.println("\t\t 6) Guardar cambios");
            opcionSeleccionada = Methods.datoInt("\t\tIntroduce la opción deseada: ");
            Methods.limpiarTeclado();
            switch (opcionSeleccionada) {
                case 1: setNombreDig(Methods.datoModificarNombre("\t\tNombre: "+getNombreDig()+" ---> ",getNombreDig()));
                        break;
                case 2: setNombreevolucionDig(Methods.datoNombreEvolucion("\t\tNombre digievolución: "+getNombreevolucionDig()+" ---> ","\t",getNombreevolucionDig()));
                        break;
                case 3: setAtaqueDig(Methods.datoEstadisticas("\t\tAtaque: "+getAtaqueDig()+" ---> ","\t"));
                        break;
                case 4: setDefensaDig(Methods.datoEstadisticas("\t\tDefensa: "+getDefensaDig()+" ---> ","\t"));
                        break;      
                case 5: setTipoDig(Methods.datoTipo("\t\tTipo: "+getTipoDig()+" ---> ",getTiposDeDigimon(),"\t"));
                        break;
                case 6: String consultaModificar = "UPDATE digimon SET nombreDig ='"+getNombreDig()+"',nombreevolucionDig ='"+getNombreevolucionDig()+"',ataqueDig ="+getAtaqueDig()+",defensaDig ="+getDefensaDig()+",tipoDig ='"+getTipoDig()+"' WHERE nombreDig ='"+nombreDigimonIntroducido+"'";
                        PreparedStatement psModificar = con.prepareStatement(consultaModificar);
                        psModificar.executeUpdate();
                        break;
                default:System.err.print("Debe introducir una opción del 1 al 6\n\n");
                        break;
            }
        }while(opcionSeleccionada != 6);
        ps.close();
        con.close();
    }
    
    public void eliminarDigimon(Connection con) throws SQLException{

        String nombreDigimonEliminar = Methods.datoNombreModificar("\tIntroduce el digimon a eliminar: ");
        
        String consulta = "SELECT * FROM digimon WHERE nombreDig ='"+nombreDigimonEliminar+"';";
        PreparedStatement ps =  con.prepareStatement(consulta);
        ResultSet rs = ps.executeQuery(consulta);
        int opcionSeleccionada;
        if(rs.next()){
            System.out.println("\t\t¿Deseas realmente eliminar el digimon "+nombreDigimonEliminar+"?");
            System.out.println("\t\t 1) Si");
            System.out.println("\t\t 2) No");
            opcionSeleccionada = Methods.datoInt("\tIntroduce la opción deseada: ");
            Methods.limpiarTeclado();
            switch (opcionSeleccionada) {
                case 1: String consultaEliminar = "DELETE FROM digimon WHERE nombreDig = '"+nombreDigimonEliminar+"'";
                        PreparedStatement psEliminar = con.prepareStatement(consultaEliminar);
                        psEliminar.executeUpdate();
                        System.out.println("\t"+nombreDigimonEliminar+" ha sido eliminado correctamente.\n");
                        break;
                        
                case 2: break;
                
                default:System.err.print("Debe introducir 1 o 2\n\n");
                        break;
            }
        }
        ps.close();
        con.close();
    }
}
