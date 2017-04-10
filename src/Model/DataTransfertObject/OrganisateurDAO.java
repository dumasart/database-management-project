/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DataTransfertObject;

import Model.Artiste;

/**
 *
 * @author romain
 */
public interface OrganisateurDAO {
    public boolean update(Artiste organisateur);
    public boolean insert(Artiste organisateur);
    public boolean delete(Artiste organisateur);
}
