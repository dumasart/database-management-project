/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DataAccessLayer;

import Model.Expert;
import Model.Numero;
import Model.Spectacle;
import Model.Theme;
import java.util.List;

/**
 *
 * @author nomezing
 */
public interface NumeroDAO {
    public boolean update(Numero numero);
    public boolean insert(Numero numero);
    public boolean delete(Numero numero);
    public List<Numero> getAllNumero();
    public List<Numero> getNumeroByExpert(Expert expert);
    public List<Numero> getNumerosBySpectacle(Spectacle spectacle);
    public List<Numero> getNumerosRankedByTheme(Theme theme);
    public List<Numero> getNumerosByTheme(Theme theme);
    
    //TODO à compléter
}
