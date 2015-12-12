package view;

import control.AdminController;
import control.EnterController;

/**
 * Created by Виктор on 12.12.2015.
 */
public class AuthorizationView {
    private EnterController enter;
    private AdminController adminController;
    private AdminViewImpl adminView;

    public AuthorizationView(){}

    public void authorizationUser(){
        System.out.println("Введите имя");
        String name = enter.toString();
        System.out.println("Введите пароль");
        String pass = enter.toString();
        if(adminController.authorization(name,pass)) adminView.showStartAdmin();
        else {
            System.out.println("Неверный логин или пароль");
            authorizationUser();
        }
    }


    public EnterController getEnter() {
        return enter;
    }

    public AdminController getAdminController() {
        return adminController;
    }

    public AdminViewImpl getAdminView() {
        return adminView;
    }

    public void setEnter(EnterController enter) {
        this.enter = enter;
    }

    public void setAdminController(AdminController adminController) {
        this.adminController = adminController;
    }

    public void setAdminView(AdminViewImpl adminView) {
        this.adminView = adminView;
    }
}
