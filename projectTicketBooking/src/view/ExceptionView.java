package view;

/**
 * Created by Виктор on 03.12.2015.
 */
public class ExceptionView {
    private static ExceptionView exceptionView = null;

    public static synchronized ExceptionView getInstance(){
        if (exceptionView == null){
            exceptionView = new ExceptionView();
        }
        return exceptionView;
    }

    public void showErrorGenreInAddMovie(){
        System.out.println("============================================");
        System.out.println("Такого жанра не существует, начните сначала.");
        System.out.println("============================================");
    }

    public void showErrorInputString(){
        System.out.println("====================================");
        System.out.println("Введена строка, а нужно ввести число");
        System.out.println("====================================");
    }

}
