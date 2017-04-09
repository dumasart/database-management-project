/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DataAccessLayer;

import Model.Business.User;


/**
 *
 * @author bonhomme
 */
public interface UserDAO {
    public boolean update(User u, String newPwd, String oldPwd);
    public boolean insert(User u, String pwd);
    public boolean delete(User u);
    
}
