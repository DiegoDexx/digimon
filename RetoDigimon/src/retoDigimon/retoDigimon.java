package retoDigimon;
import java.sql.*;
/**
 *
 * @author Rubén, Inma, Diego & Jaime
 */
public class retoDigimon {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        //conexionBD classConexionBD = new conexionBD();
        //Connection con = classConexionBD.getConexion();

        MenuInicial menu = new MenuInicial();
        menu.pideMenu(menu.mostrarMenu());
        
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
