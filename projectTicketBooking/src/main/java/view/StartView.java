package view;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import view.interfac.ViewAdmin;
import view.interfac.ViewUser;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created by Виктор on 04.12.2015.
 */
public class StartView {
    private ViewAdmin viewAdmin;
    private ViewUser viewUser;

    public StartView(){
    }

    public void showStartMenu() throws SQLException {
        Scanner scn = new Scanner(System.in);
        System.out.println("Выберите как зайти: 1 - пользователь 2 - администратор");
        if(scn.hasNextInt()){
            switch (scn.nextInt()){
                case 1: viewUser.showStartUser();
                    break;
                case 2:  viewAdmin.showStartAdmin();
                    break;
                default: showStartMenu();
                    break;
            }
        } else showStartMenu();
    }

    public ViewAdmin getViewAdmin() {
        return viewAdmin;
    }

    public ViewUser getViewUser() {
        return viewUser;
    }

    public void setViewAdmin(ViewAdmin viewAdmin) {
        this.viewAdmin = viewAdmin;
    }

    public void setViewUser(ViewUser viewUser) {
        this.viewUser = viewUser;
    }
}
