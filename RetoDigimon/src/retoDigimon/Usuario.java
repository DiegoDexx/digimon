/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package retoDigimon;
import Sleer1.SLeer1;
import java.util.HashMap;

/**
 *
 * @author Diego
 */
public class Usuario {
    private int codigousu;
    private static String contraseñausu[]= new String[3];
    static String nombreusu[]= new String[3];;
    static int partidasgan[] = new int[3];;
    static int evoluciones[]= new int[3];
    
    Usuario(){
         
       partidasgan[0]=1999;
       partidasgan[1]=2000;
       partidasgan[2]=7151;
       
       evoluciones[0]=5;
       evoluciones[1]=6;
       evoluciones[2]=2;
       
    }
    
     public static void creaUsuario() {
         
         for ( int i=0; i<nombreusu.length; i++) {
            nombreusu[i]= SLeer1.datoString("Inserta el nombre de usuario: ");
            contraseñausu[i]= SLeer1.datoString("Inserta la contraseña: ");
            
            HashMap<String, String> pideuyc = new HashMap<String, String>();
            pideuyc.put(nombreusu[i],contraseñausu[i]); 
            
            System.out.println("***USUARIO Y CONTRASEÑA*** :" +pideuyc);
        }
    }
     
     
    public void getcodynom(int code) { 
        
        this.codigousu=code;
        
        for ( int j=0; j<nombreusu.length; j++){  
            code= (int)(Math.random()*100000+1);
            HashMap<String, Integer> nombreycod = new HashMap<String, Integer>();
            nombreycod.put(nombreusu[j], code); 
            System.out.println("\nUsuario y codigo: "+nombreycod);
    }
    }
    
    
    public static void getPartidasGanadas() {
        
        for ( int j=0; j<nombreusu.length; j++ ){
            for (int k=2; k<partidasgan.length; k++) {  
            HashMap<String, Integer> hashpart = new HashMap<String, Integer>();
            hashpart.put("Partidas ganadas de "+nombreusu[j]+": ",+partidasgan[k]);
            System.out.println("\n"+hashpart);
    }   
    }
    }    
        
    
    public static void getEvoluciones() {
        
        for ( int j=0; j<nombreusu.length; j++ ) {
            for (int k=2; k<evoluciones.length; k++) {  
            HashMap<String, Integer> hash_evo = new HashMap<String, Integer>();
            hash_evo.put("Partidas ganadas de "+nombreusu[j]+": ",+evoluciones[k]);
            System.out.println("\n"+hash_evo);
    }   
    }
    } 
    
    
   }
    

    
 