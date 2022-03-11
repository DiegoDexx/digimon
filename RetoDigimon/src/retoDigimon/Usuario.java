/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package retoDigimon;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;

/**
 *
 * @author Diego
 */
public class Usuario {
    private int codigousu;
    private String contraseñausu;
    static String nombreusu[]= new String[3];
    static int partidasgan[] = new int[3];;
    static int evoluciones[]= new int[3];
    
    Usuario(){
       nombreusu[0]="Rubencito";
       nombreusu[1]="javi";
       nombreusu[2]="imma";
       
       partidasgan[0]=1999;
       partidasgan[1]=2000;
       partidasgan[2]=7151;
       
       evoluciones[0]=5;
       evoluciones[1]=6;
       evoluciones[2]=2;
       
    }
    
    public void getcodynom(int cod1, int cod2, int cod3) { 
        this.codigousu=cod1;
        this.codigousu=cod2;
        this.codigousu=cod3;
        
        cod1= (int)(Math.random()*100000+1);
        cod2= (int)(Math.random()*100000+1);
        cod3= (int)(Math.random()*100000+1);
        
        HashMap<String, Integer> nombreycod = new HashMap<String, Integer>();
        nombreycod.put(nombreusu[0], cod1);
        nombreycod.put(nombreusu[1], cod2);
        nombreycod.put(nombreusu[2], cod3);
        
        System.out.println("Usuario y codigo: "+nombreycod);
    }
    
    
    public static void setContraseñas() { 
        ArrayList <String> Contraseña = new ArrayList <String>();
            Contraseña.add("ZXDCCD");
            Contraseña.add("12WDD");
            Contraseña.add("12344");
    
            System.out.println("Contraseña de "+nombreusu[0]+":"+Contraseña.get(0));
            System.out.println("contraseña de "+nombreusu[1]+":"+Contraseña.get(1));
            System.out.println("contraseña de "+nombreusu[2]+":"+Contraseña.get(2));
          
    }
    
    public static void getPartidasGanadas() {
        
            System.out.println("Partidas ganadas de "+nombreusu[0]+":"+partidasgan[0]);
            System.out.println("Partidas ganadas de "+nombreusu[1]+":"+partidasgan[1]);
            System.out.println("Partidas ganadas de "+nombreusu[2]+":"+partidasgan[2]);
        
    }
    
    public static void getEvoluciones() {
            System.out.println("Digimons evolucionados de "+nombreusu[0]+":"+evoluciones[0]);
            System.out.println("Digimons evolucionados de "+nombreusu[1]+":"+evoluciones[1]);
            System.out.println("Digimons evolucionados de "+nombreusu[2]+":"+evoluciones[2]);
    }
}
    
 