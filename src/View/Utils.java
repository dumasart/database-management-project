/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

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
            saisie = Integer.parseInt(SC.nextLine());
            if (saisie >=min && saisie <= max) {
                return saisie;
            } else {
                System.out.print("Choix incorrect. ");
            }
        }
    }
}
