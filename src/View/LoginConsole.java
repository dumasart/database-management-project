/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.LoginConsoleController;
import Model.DataTransfertObject.User;
import java.util.Scanner;

/**
 *
 * @author nomezing
 */
public class LoginConsole {
    
    private Scanner terminalInput;
    private LoginConsoleController controller;
    
    public LoginConsole() {
        this.terminalInput = new Scanner(System.in);
        this.controller = new LoginConsoleController();
    }
    
    
    
    public User readLoginAndPassword() {
        User user;
        do {
            System.out.print("ID: ");
            String userName = terminalInput.nextLine();
            System.out.print("Password: ");
            String password = terminalInput.nextLine();
            user = controller.identifieUser(userName, password);
        } while (user == null);

        return user;
    }
    
}
