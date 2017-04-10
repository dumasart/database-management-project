/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DataTransfertObject;

import Model.ArtisteParticipant;
import Model.Expert;

/**
 *
 * @author piersonr
 */
public interface ParticipantDAO {
    public boolean update(ArtisteParticipant participant);
    public boolean insert(ArtisteParticipant participant);
    public boolean delete(ArtisteParticipant participant);
}
