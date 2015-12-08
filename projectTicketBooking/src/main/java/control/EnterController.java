package control;

import java.util.Scanner;

/**
 * Created by Виктор on 08.12.2015.
 */
public class EnterController {
    @Override
    public String toString(){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        if(str.trim().length() == 0) toString();

        return str;
    }

    public int getInt(){
        Scanner scanner = new Scanner(System.in);
        int rezult = 0;
        if(scanner.hasNextInt()){
            rezult = scanner.nextInt();
            if(rezult < 0) {
                System.out.println("Вы ввели отрицательное значение");
                getInt();
            }
        }else {
            System.out.println("Вы ввели строку, а нужно число");
            getInt();
        }
        return rezult;
    }
}
