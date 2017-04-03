/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.util.Iterator;

/**
 *
 * @author luud
 */
public class TextualInterface extends UserInterface {
    public void printListeDesNumero(Iterator<Numero> it) {
        Numero num;
        while(it.hasNext()) {
            num = it.next();
            System.out.println(num);
        }
    }
}
