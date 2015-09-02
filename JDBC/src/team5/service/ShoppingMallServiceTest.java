package team5.test;

import java.sql.Connection;
import java.util.Scanner;

import team5.dao.*;

public class ShoppingMallServiceTest {

	public static void main(String [] args){
		singleton singlton = new singleton();	
		
		Scanner scanner = new Scanner(System.in);
		Connection conn = null;
		try {
			conn = ConnectionManager.getConnection();
		} catch (Exception e) {System.out.println("Connect fail");}
		
		while(singlton.isRun()){
			Init.init(); //그리기
			Init.input(conn, scanner); //입력
		}
		scanner.close();
	}
}
