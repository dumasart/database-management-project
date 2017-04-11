/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Console;

import Controller.LoginConsoleController;
import java.util.Scanner;

/**
 *
 * @author nomezing
 */
public class LoginConsole {
    
    private Scanner scan = new Scanner(System.in);;
    private LoginConsoleController controller= new LoginConsoleController();
    
    
    public boolean readLoginAndPassword() {       
        System.out.print("ID: ");
        String userName = scan.nextLine();
        System.out.print("Password: ");
        //TODO voir si readPassword fonctionne bien (execution console hors IDE)
        // c'est a dire cache est ce qu'il cahce les caractères saisis
        //String password = new String(System.console().readPassword());//scan.nextLine();
        String password = scan.nextLine();
        return controller.identifyUser(userName, password);
    }
}
