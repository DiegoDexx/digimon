/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package retoDigimon;
import Sleer1.SLeer1;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;

/**
 *
 * @author Diego
 */
public class Usuario {
    private int codigousu;
    private static String contraseñausu[]= new String[3];
    static String nombreusu[] = new String[3];
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
         
         for ( int j=0; j<nombreusu.length; j++) {
            nombreusu[j]= SLeer1.datoString("Inserta el nombre de usuario: ");
            contraseñausu[j]= SLeer1.datoString("Inserta la contraseña: ");
            
            HashMap<String, String> pideuyc = new HashMap<String, String>();
            pideuyc.put(nombreusu[0],contraseñausu[0]); 
            
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
        
    for ( int j=2; j<nombreusu.length; j++ ){
        for (int k=0; k<partidasgan.length; k++) {  
        System.out.println("Partidas ganadas de "+nombreusu[j]+":"+partidasgan[k]);
    }   
    }
    }    
        
    
    
    public static void getEvoluciones() {
            for ( int j=2; j<nombreusu.length; j++ ) {
        for (int k=0; k<evoluciones.length; k++) {  
        System.out.println("Digimons evolucionados de "+nombreusu[j]+":"+evoluciones[0]);
    }   
    }
    } 
    
    
   }
    

    
 