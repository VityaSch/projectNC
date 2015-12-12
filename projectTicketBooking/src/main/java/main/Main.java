package main;


import java.sql.SQLException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import view.StartView;

public class Main {
	public static void main(String[] args) throws SQLException{
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		StartView start = (StartView) context.getBean("startView");
		start.showStartMenu();
	}
}
