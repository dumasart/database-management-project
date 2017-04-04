/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import Model.Business.Numero;
import java.util.ArrayList;

/**
 *
 * @author milang
 */
public class ResultatsNumeros extends ResultatRequete {
    private ArrayList<Numero> numeros;
    ResultatsNumeros() {
        numeros= new ArrayList<>();
    }
    public Numero getNumeroById(int id) {
        return numeros.get(id);
    }
    public void add(Numero num) {
        numeros.add(num);
    }
}
