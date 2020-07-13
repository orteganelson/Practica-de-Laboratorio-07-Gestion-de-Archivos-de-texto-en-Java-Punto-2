/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author  Nelson Ortega
 * @version 8.2
 * @author Anahi Cabrera
 * @version 8.2
 */
public class ControladorTexto {
     /**
     * Declaracion de atributos
     */
    private String ruta;
    private File fichero;
    private List<Character> abecedario;
    private Map<Character, Character> diccionario;
    
    /**
     * Metodo constructor controladorTexto: hace la instancia de los atributos abecedario,
     * diccionario crearDicionario. Este último servirá para cada vez que se cree un objeto 
     * de esta clase.
     */
    
    
    public ControladorTexto() {
        abecedario = new ArrayList<>();
        diccionario = new HashMap<>();
        diccionario = crearDiccionario();
    }
     /**
     * El metodo crearDiccionario no recibe ningun tipo de parámetro por ello
     * declaramos nuevas variables de tipo String e int.
     *
     * @return diccionario
     */
    public Map<Character, Character> crearDiccionario() {
        //Declaracion de nuevas varibles
        String abecedario2 = "abcdefghijklmnñopqrstuvwxyz";
        String abecedario = "nopqrstuvwxyza☼bcdefghijklm";
        String numeros2 = "0123456789 ";
        String numeros="♫►◄↕¶§▬↨↑↓♪";        
        String espacio = " ";


        for (int i = 0; i < abecedario.length(); i++) {
            diccionario.put(abecedario.charAt(i), abecedario2.charAt(i));
        }
        
        for (int i = 0; i < numeros.length(); i++) {
            diccionario.put(numeros.charAt(i), numeros2.charAt(i));
        }
       // diccionario.put(numeros2.charAt(10), espacio.charAt(0));
        return diccionario;
    }
    /**
     * El metodo desencriptar tiene una variable auxiliar que sirve para
     *  asignar a los sindicales, nuevos datos de tipo String. Este método, mediante la clase File y sus métodos de leer
     * y escribir, nos permite realizar la desencriptación del texto.
     *
     * @param rutaAbsoluta 
     * @param texto 
     * @throws Error: ruta no encontrada, escritura, general
     */
    
    public String desencriptar(String texto) {
        String aux = "";
        for (int i = 0; i < texto.length(); i++) {
            char letra = texto.charAt(i);
            String le1 = String.valueOf(letra);
            for (Map.Entry<Character, Character> letra2 : diccionario.entrySet()) {
                String le2 = String.valueOf(letra2.getKey());
                if (le1.equalsIgnoreCase(le2)) {
                    
                    if (Character.isUpperCase(letra)) {
                        aux = aux.concat(String.valueOf(letra2.getValue()).toUpperCase());                       
                    } else {
                        aux = aux.concat(String.valueOf(letra2.getValue()));                     
                    }
                }
            }
        }
        return aux;
    }
     /**
     * Este metodo recibe como parametro un dato de tipo String ruta, y
     * comprueba que la ruta ingresada sea correcta y exista en el computador.
     *
     * @param ruta 
     * @return Boolean (Si la ruta existe retornará true).
     */
    public boolean comprobarRuta(String ruta) {
        fichero = new File(ruta);

        if (fichero.exists()) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * El metodo concatena el nombre del archivo con "txt" y comprueba que el
     * fichero exista en la ruta y el File.separator indica separador de directorios 
     * que existe en el sistema operativo del computador que se esté utilizando.
     *
     * @param ruta
     * @param nombre 
     * @return Boolean (Retorna true or false dependiendo si la ruta existe)
     */
    public boolean comprobar(String ruta, String nombre) {
        nombre = nombre.concat(".txt");
        
        fichero = new File(ruta + File.separator + nombre);

        if (fichero.exists()) {
            return true;
            
        } else {
            return false;
            
        }
    }
    

}

