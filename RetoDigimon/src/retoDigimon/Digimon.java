/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package retoDigimon;

import Methods.Methods;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

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
    int tipoDig; // Pasar a ENUM
    String fotoDig;
    String fotovicDig;
    String fotoderDig;

    public void setNombreDig(String nombreDig) { this.nombreDig = nombreDig; }
    public void setNombreevolucionDig(String nombreevolucionDig) { this.nombreevolucionDig = nombreevolucionDig;}
    public void setNivelDig(int nivelDig) { this.nivelDig = nivelDig; }
    public void setDefensaDig(int defensaDig) { this.defensaDig = defensaDig; }
    public void setAtaqueDig(int ataqueDig) {this.ataqueDig = ataqueDig; }
    public void setTipoDig(int tipoDig) { this.tipoDig = tipoDig; }
    public void setFotoDig(String fotoDig) { this.fotoDig = fotoDig;}
    public void setFotovicDig(String fotovicDig) {this.fotovicDig = fotovicDig;}
    public void setFotoderDig(String fotoderDig) { this.fotoderDig = fotoderDig;}

    public String getNombreDig() { return nombreDig; }
    public String getNombreevolucionDig() { return nombreevolucionDig; }
    public int getNivelDig() { return nivelDig; }
    public int getDefensaDig() { return defensaDig; }
    public int getAtaqueDig() { return ataqueDig; }
    public int getTipoDig() { return tipoDig; }
    public String getFotoDig() { return fotoDig; }
    public String getFotovicDig() {return fotovicDig; }
    public String getFotoderDig() { return fotoderDig; }
    
    Digimon(){
        this.nombreDig = Methods.datoNombre("Nombre de digimón: ","El nombre del digimon tiene una longitud máxima de 30 y no puede contener numeros");
        this.nombreevolucionDig = Methods.datoNombre("Nombre de su digievolución: ","El nombre de su digievolución tiene una longitud máxima de 30 y no puede contener numeros");
        this.nivelDig = Methods.datoNivel("Nivel de digimón: ","El nivel del digimon debe ser 1,2 o 3");;
        this.ataqueDig = Methods.datoInt("Ataque del digimón: ");
        this.defensaDig = Methods.datoInt("Defensa del digimón: ");
        this.tipoDig = Methods.datoInt("Tipo del digimón: ");
       
        this.fotoDig = "hola";
        this.fotovicDig = "hola";
        this.fotoderDig = "hola";
    }
    
    public void crearDigimon() throws SQLException{
        conexionBD classConexionBD = new conexionBD();
        Connection con = classConexionBD.getConexion();
        Statement statement = con.createStatement();
        String consulta = "INSERT INTO digimon (nombreDig,nombreevolucionDig,nivelDig,defensaDig,ataqueDig,tipoDig,fotoDig,fotovicDig,fotoderDig) VALUES (?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps =  con.prepareStatement(consulta);
        ps.setString(1, getNombreDig());
        ps.setString(2, getNombreevolucionDig());
        ps.setInt(3, getTipoDig());
        ps.setInt(4, getDefensaDig());
        ps.setInt(5, getAtaqueDig());
        ps.setInt(6, getNivelDig());
        ps.setString(7, getFotoDig());
        ps.setString(8, getFotovicDig());
        ps.setString(9, getFotoderDig());
        ps.executeUpdate();
    }
    
}
