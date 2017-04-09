/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import Model.Business.Expert;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author milang
 */
public class ResultatsExperts extends ResultatRequete {
    private ArrayList<Expert> experts;

    ResultatsExperts() {
        experts = new ArrayList<>();
    }
    
    public Expert getExpertById(int id) {
        return experts.get(id);
    }
    
    public Collection<Expert> getExperts() {
        return this.experts;
    }
    
    public void add(Expert exp) {
        experts.add(exp);
    }
}
