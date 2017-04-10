/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DataTransfertObject;

import Model.ArtistePrincipal;

/**
 *
 * @author piersonr
 */
public interface PrincipalDAO {
    public boolean update(ArtistePrincipal principal);
    public boolean insert(ArtistePrincipal principal);
    public boolean delete(ArtistePrincipal principal);
}
