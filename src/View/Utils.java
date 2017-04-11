/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.text.Normalizer;
import java.util.Scanner;

/**
 *
 * @author nomezing
 */
public class Utils {
    
    private static final Scanner SC = new Scanner(System.in);
    
    /**
     * Méthode générique pour lire un entier compris entre min et max
     * (bornes min et max comprises)
     * @param min
     * @param max
     * @return l'entier saisi dans la console
     */
    public static int lireEntier(int min, int max) {
        int saisie;

        while (true) {
            System.out.print("Choisissez un numero entre "+min+ " et "+ max + " : ");
            try {
                saisie = Integer.parseInt(SC.nextLine());
                            if (saisie >=min && saisie <= max) {
                return saisie;
                } else {
                    System.out.print("Choix incorrect. ");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Vous devez saisir un entier!");
            }
        }
    }
    
    
    /**
     * Méthode pour normaliser le chaines de caractère pour pouvoir les insérer 
     * en base. remplace les caractère accentué et enlève tous les caractères non ascci
     */
    public static String netoyerString(String sourceString) {
        String normalized = Normalizer.normalize(sourceString, Normalizer.Form.NFD);
        return normalized.replaceAll("[^\\p{ASCII}]", "");
        
        
    }
}
