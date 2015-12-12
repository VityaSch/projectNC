package view;

import control.EnterController;
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
    private AuthorizationView viewAdmin;
    private ViewUser viewUser;
    private EnterController enter;


    public StartView(){
    }

    public void showStartMenu(){
        System.out.println("Выберите как зайти: 1 - пользователь 2 - администратор");

        switch (enter.getInt()){
            case 1: viewUser.showStartUser();
                break;
            case 2:  viewAdmin.authorizationUser();
                break;
            default: showStartMenu();
                break;
            }
    }

    public AuthorizationView getAuthorizationView() {
        return viewAdmin;
    }

    public ViewUser getViewUser() {
        return viewUser;
    }

    public EnterController getEnter() {
        return enter;
    }

    public void setEnter(EnterController enter) {
        this.enter = enter;
    }

    public void setAuthorizationView(AuthorizationView viewAdmin) {
        this.viewAdmin = viewAdmin;
    }

    public void setViewUser(ViewUser viewUser) {
        this.viewUser = viewUser;
    }
}
