/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DataAccessLayer;

/**
 *
 * @author luud
 */
public class ConnectionInfo {
    final String CONN_URL;
    final String USER;
    final String PASSWD;

    boolean statusConnection;
    
    public ConnectionInfo (String url, String usr, String passwd) {
	CONN_URL = url; USER = usr; PASSWD = passwd;
    }
}
