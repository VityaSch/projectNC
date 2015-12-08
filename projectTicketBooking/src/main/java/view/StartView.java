package view;

import main.Main;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created by Виктор on 04.12.2015.
 */
public class StartView {
     ApplicationContext contextViewStart = new ClassPathXmlApplicationContext("spring-config.xml");
     UserView userView = null;
     AdminView adminView = null;
    public void showStartMenu() throws SQLException {

        Scanner scn = new Scanner(System.in);
        System.out.println("Выберите как зайти: 1 - пользователь 2 - администратор");
        if(scn.hasNextInt()){
            switch (scn.nextInt()){
                case 1:{
                    userView = (UserView) contextViewStart.getBean("userView");
                    userView.showStartUser();
                    userView = null;
                }
                    break;
                case 2: {
                    adminView = (AdminView) contextViewStart.getBean("adminView");
                    adminView.showStartAdmin();
                    adminView = null;
                }
                    break;
                default: showStartMenu();
                    break;
            }
        } else showStartMenu();
    }
}
