/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DataAccessLayer;

import Model.Numero;
import Model.Spectacle;
import java.util.List;

/**
 *
 * @author milang
 */
public interface SpectacleDAO {
    public boolean update(Spectacle spectacle);
    public boolean insert(Spectacle spectacle);
    public boolean delete(Spectacle spectacle);
    public boolean addNumero(Spectacle spectacle, Numero numero,int heure);
    public List<Spectacle> getAllSpectacle();  
}
