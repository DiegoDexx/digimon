package retoDigimon;
import java.sql.*;
import java.util.HashMap;
import java.util.Iterator;
/**
 *
 * @author Rubén, Inma, Diego & Jaime
 */
public class retoDigimon {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        conexionBD classConexionBD = new conexionBD();
        Connection con = classConexionBD.getConexion();
        
        
        Digimon d1 = new Digimon();
        Statement statement = con.createStatement();
        String consulta = "INSERT INTO digimon (nombreDig,nombreevolucionDig,nivelDig,defensaDig,ataqueDig,tipoDig,fotoDig,fotovicDig,fotoderDig) VALUES (?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps =  con.prepareStatement(consulta);
        ps.setString(1, d1.getNombreDig());
        ps.setString(2, d1.getNombreevolucionDig());
        ps.setInt(3, d1.getTipoDig());
        ps.setInt(4, d1.getDefensaDig());
        ps.setInt(5, d1.getAtaqueDig());
        ps.setInt(6, d1.getNivelDig());
        ps.setString(7, d1.getFotoDig());
        ps.setString(8, d1.getFotovicDig());
        ps.setString(9, d1.getFotoderDig());
        ps.executeUpdate();
        
        /*String consulta = "SELECT * FROM digimon";
        PreparedStatement ps =  con.prepareStatement(consulta);
        ResultSet rs = ps.executeQuery(consulta);
        while(rs.next()){
        System.out.println(rs.getString("nombreDig"));
        }*/
        
        /*String consulta = "INSERT INTO digimon (nombreDig,nombreevolucionDig,nivelDig,defensaDig,ataqueDig,tipoDig,fotoDig,fotovicDig,fotoderDig) "
                        + "VALUES (d1.getNombreDig(),d1.getNombreevolucionDig(),d1.getNivelDig(),d1.getDefensaDig(),d1.getAtaqueDig(),d1.getTipoDig(),d1.getFotoDig(),d1.getFotovicDig(),d1.getFotoderDig()";
        PreparedStatement ps =  con.prepareStatement(consulta);
        ResultSet rs = ps.executeQuery(consulta);
        System.out.print(rs);*/
        //HashMap<String, Digimon> digimones = new HashMap<>();
        //digimones.put(d1.getNombreDig(), d1);
        
      //  for(Digimon d : digimones.values()){
       //     System.out.println(d.getNombreDig());
        //}
        
        //digimones.remove("Hola");
    }
    
}
