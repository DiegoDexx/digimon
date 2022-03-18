/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Methods;
import java.sql.*;
import java.util.*;
import retoDigimon.conexionBD;
/**
 *
 * @author usuario
 */
public class Methods {
    
    public static Scanner teclado = new Scanner(System.in);

    public static void limpiarTeclado() {

        try {
            if (teclado.hasNextLine()) {
                teclado.nextLine();
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    
    // ********************** MÉTODOS SIN PARÁMETRO ********************
    
    public static int datoInt() {
        boolean leido = false;
        int num = 0;
        do {
            try {
                num = 0;
                num = teclado.nextInt();
                leido = true;
            } catch (InputMismatchException e) {
                System.err.println("Error, por favor introduce dato de nuevo...");
                limpiarTeclado();
            }
        } while (leido == false);
        return num;
    }
    
    public static double datoDouble() {
        boolean leido = false;
        double num = 0;
        do {
            try {
                num = 0;
                num = teclado.nextDouble();
                leido = true;
            } catch (InputMismatchException e) {
                System.err.println("Error, por favor introduce dato de nuevo...");
                limpiarTeclado();
            }
        } while (leido == false);
        return num;
    }

    // ********************** MÉTODOS CON PARÁMETRO ********************

    public static int datoInt(String mensaje) {
        boolean leido = false;
        int num = 0;
        do {
            try {
                num = 0;
                System.out.print(mensaje);
                num = teclado.nextInt();
                leido = true;
            } catch (InputMismatchException e) {
                System.err.println("Error, por favor introduce dato de nuevo...");
                limpiarTeclado();
            }
        } while (leido == false);
        return num;
    }

    public static double datoDouble(String mensaje) {
        boolean leido = false;
        double num = 0;
        do {
            try {
                num = 0;
                System.out.print(mensaje);
                num = teclado.nextDouble();
                leido = true;
            } catch (InputMismatchException e) {
                System.err.println("Error, por favor introduce dato de nuevo...");
                limpiarTeclado();
            }
        } while (leido == false);
        return num;
    }

    public static String datoString(String mensaje) {
        boolean leido = false;
        String dato = null;
        do {
            try {
                dato = null;
                System.out.print(mensaje);
                dato = teclado.nextLine();
                leido = true;
            } catch (InputMismatchException e) {
                System.err.println("Error, por favor introduce dato de nuevo...");
                limpiarTeclado();
            }
            System.out.println(dato);
        } while (leido == false);
        return dato;
    }
    
    public static boolean datoIntIsPar(int num){
            if(num%2 == 0){ return true; }else{ return false; }
    }
    
    public static boolean datoIntIsPositivo(int num){
        if(num >= 0){ return true; }else{ return false; }
    }
    
    public static StringBuffer datoIntToRomano(int numero){
        StringBuffer romano = new StringBuffer(numero);
        while(numero > 0) {
            if(numero >= 1000){ numero-=1000; romano.append("M"); }
            else if(numero >= 900){ numero-=900; romano.append("CM"); }
            else if(numero >= 500){ numero-=500; romano.append("D"); }
            else if(numero >= 400){ numero-=400; romano.append("CD"); }
            else if(numero >= 100){ numero-=100; romano.append("C"); }
            else if(numero >= 90){ numero-=90; romano.append("XC"); }
            else if(numero >= 50){ numero-=50; romano.append("L");}
            else if(numero >= 40){ numero-=40; romano.append("XL"); }
            else if(numero >= 10){ numero-=10; romano.append("X"); }
            else if(numero >= 9){ numero-=9; romano.append("IX"); }
            else if(numero >= 5){ numero-=5; romano.append("V"); }
            else if(numero >= 4){ numero-=4; romano.append("IV"); }
            else{ numero-=1; romano.append("I"); }
        }
        return romano;
    }
    
    public static boolean datoIntIsPrimo(int num) {
        int divisible=0;
        for(int i = 1; i <= num;i++){
            if(num%i == 0) { divisible++; }
        }
        if(divisible == 2) { return true; }
        else{ return false; }
    }
    
    public static String datoFechaValida(String mensaje) {
        boolean leido = false;
        String dato = null;
        int datoLength;
        String simbolo1 = null;
        String simbolo2 = null;
        int dia=0;
        int mes=0;
        do {
            try {
                dato = null;
                System.out.print(mensaje);
                dato = teclado.nextLine();
                datoLength = dato.length();
                if(datoLength == 10) { 
                    simbolo1 = dato.substring(2,3);
                    simbolo2 = dato.substring(5,6);
                    dia = Integer.parseInt(dato.substring(0,2));
                    mes = Integer.parseInt(dato.substring(3,5));
                }
                if((!(mes == 2 && dia > 29) && dia > 0 && dia <= 31 && mes > 0 && mes <= 12 && datoLength == 10 && "/".equals(simbolo1) || "-".equals(simbolo1)) && ("/".equals(simbolo2) || "-".equals(simbolo2))) { leido = true; }
                else{ System.err.println("Error, por favor introduce dato de nuevo...\n"); leido = false; dato = null; }
            } catch (InputMismatchException e) {
                System.err.println("Error, por favor introduce dato de nuevo...\n");
                limpiarTeclado();
            }
        } while (leido == false);
        return dato;
    }
    
    public static void datoTablaMultiplicar(int numero){
        int multiplicador = 1;
        int resultado = 0;
        for(int i=1;i < 10;i++){
                resultado = numero*multiplicador;
                System.out.println(numero+" x "+multiplicador+" = "+resultado);
                multiplicador++;
        }
        multiplicador = 1;
    }
    
    // DIGIMON
    public static String datoNombre(String mensaje, String error) throws SQLException {
        boolean leido = false;
        String dato = null;
        do {
            try {
                dato = null;
                System.out.print(mensaje);
                dato = teclado.nextLine();
                char[] caracteres = dato.toCharArray();
                if(dato.length() <= 30 && dato.length() > 0){
                    conexionBD classConexionBD = new conexionBD();
                    Connection con = classConexionBD.getConexion();

                    String consulta = "SELECT * FROM digimon WHERE nombreDig='"+dato+"';";
                    PreparedStatement ps =  con.prepareStatement(consulta);
                    ResultSet rs = ps.executeQuery(consulta);
                    if(rs.next()){
                    System.err.println("\t"+dato+" ya existe en la base de datos\n"); leido = false;
                    }else{
                        leido = true;
                        for(int i = 0; i < dato.length(); i++){
                            if(Character.isDigit(caracteres[i])){
                                System.err.println("\t"+error+"\n"); leido = false; break;
                            }
                        }
                    }
                }else{ System.err.println("\t"+error+"\n"); leido = false; }
            } catch (InputMismatchException e) {
                System.err.println("Error, por favor introduce dato de nuevo...");
                limpiarTeclado();
            }
        } while (leido == false);
        return dato;
    }
    
    public static String datoNombreEvolucion(String mensaje, String error, String nombreDig) throws SQLException {
        boolean leido = false;
        String dato = null;
        do {
            try {
                dato = null;
                System.out.print(mensaje);
                dato = teclado.nextLine();
                char[] caracteres = dato.toCharArray();
                if(dato.length() <= 30 && dato.length() > 0){
                    conexionBD classConexionBD = new conexionBD();
                    Connection con = classConexionBD.getConexion();

                    String consulta = "SELECT * FROM digimon WHERE nombreDig='"+dato+"';";
                    PreparedStatement ps =  con.prepareStatement(consulta);
                    ResultSet rs = ps.executeQuery(consulta);
                    if(!rs.next()){
                        if(!dato.equals(nombreDig)) { System.err.println("\t"+dato+" no existe en la base de datos\n"); leido = false; }else{
                          leido = true;
                            for(int i = 0; i < dato.length(); i++){
                                if(Character.isDigit(caracteres[i])){
                                    System.err.println("\t"+error+"\n"); leido = false; break;
                                }
                            }  
                        }
                    }else{
                        leido = true;
                            for(int i = 0; i < dato.length(); i++){
                                if(Character.isDigit(caracteres[i])){
                                    System.err.println("\t"+error+"\n"); leido = false; break;
                                }
                            } 
                    }
                }else{ System.err.println("\t"+error+"\n"); leido = false; }
            } catch (InputMismatchException e) {
                System.err.println("Error, por favor introduce dato de nuevo...");
                limpiarTeclado();
            }
        } while (leido == false);
        return dato;
    }
    
    public static int datoNivel(String mensaje, String error) {
        boolean leido = false;
        int num = 0;
        do {
            try {
                num = 0;
                System.out.print(mensaje);
                num = teclado.nextInt();
                if(num <1 || num >3){ System.err.println(error+"\n"); leido = false; }else{ leido = true; }
            } catch (InputMismatchException e) {
                System.err.println("Error, por favor introduce dato de nuevo...");
                limpiarTeclado();
            }
        } while (leido == false);
        return num;
    }
}
