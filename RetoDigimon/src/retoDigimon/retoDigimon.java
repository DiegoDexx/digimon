package retoDigimon;
import Sleer1.SLeer1;
import java.util.ArrayList;

/**
 *
 * @author Rubén, Inma, Diego & Jaime
 */
public class retoDigimon {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Usuario us= new Usuario();
        
        
        System.out.println("----Panel de usuarios digimon----");
        Usuario.creaUsuario();
        us.getcodynom(0);
        
       
        
        System.out.println("\n---Partidas Ganadas---");
        Usuario.getPartidasGanadas();
        
        System.out.println("\n---Evoluciones---");
        Usuario.getEvoluciones();
        
        
        
        
        
        
    }
    
}
