package view;

import java.util.Scanner;

/**
 * Created by Виктор on 04.12.2015.
 */
public class StartView {
    public void showStartMenu(){
        Scanner scn = new Scanner(System.in);
        System.out.println("Выберите как зайти: 1 - пользователь 2 - администратор");
        if(scn.hasNextInt()){
            switch (scn.nextInt()){
                case 1: UserView.getInstance().showStartUser();
                    break;
                case 2:
                    break;
                default: showStartMenu();
                    break;
            }
        } else showStartMenu();
    }
}
