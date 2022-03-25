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
        MenuInicial menu = new MenuInicial();
        menu.pideMenu(menu.mostrarMenu());    
    }
    
}
