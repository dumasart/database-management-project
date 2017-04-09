/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Business;


/**
 *
 * @author luud
 */
public class Factory {
    //private static DAO dao = null;
    private static User user;
    private static int x = 0;
    
    public static String createCodeArtiste(){
        x++;
        return "" + x;
    }
    
    /*
    public static synchronized DAO getDAO() {
        return dao == null ? dao = new DAO() : dao;
    }
    */
    
    public static User getUser() {
        return user;
    }
    
    public static void resetUser(){
        user = null;
    }
    
    public static void setUser(User user) {
        user = user;
    }
}
