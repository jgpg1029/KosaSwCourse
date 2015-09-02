package team5.test;

import java.sql.*;
import java.util.Scanner;

import team5.dao.*;
import team5.service.ShoppingMallService;

public class Init {
	public static void init(){
		singleton singleton = new singleton();
		if(singleton.isState() != true){
			System.out.println("--------------------------");
			System.out.println("1. 회원가입 |2. 로그인 |3. 종료");
			System.out.println("---------------------------");
			System.out.print("선택>");
				
		}else{
			System.out.println("-------------------------------------------------------------------------------");
			System.out.println("1.로그아웃 | 2.상품목록 | 3.장바구니넣기 | 4.장바구니보기 | 5.주문하기 | 6.전체주문정보 | 7.주문상세정보 ");
			System.out.println("-------------------------------------------------------------------------------");
			System.out.print("선택>");

		}
	}
	
	public static void input
	(Connection conn, Scanner scanner){
		//Dao
		MemberDao memberdao = new MemberDao(conn);//회원정보
		ProductDao productdao = new ProductDao(conn);
		CartDao cartdao = new CartDao(conn);//장바구니
		OrderDao orderdao = new OrderDao(conn);
		OrderItemDao orderitemDao = new OrderItemDao();

		if(singleton.isState() != true){
			try{
				int sel = Integer.parseInt(scanner.next());
					
				switch(sel){
				case 1: //회원가입
					ShoppingMallService.join(scanner, memberdao); break;
				case 2: //로그인
					singleton.setNowMember(ShoppingMallService.login(scanner, memberdao)); break;
				case 3://끝내기
					singleton.setRun(false); break;
				default:
					System.out.println("1~3 사이의 값을 입력해주세요");
					break;
				}
			}catch(Exception e){
				System.out.println("유효하지 않은 입력입니다");
			}
		}else{
			try{
				int sel = Integer.parseInt(scanner.next());		
			
				switch(sel){
				case 1: //로그아웃
					ShoppingMallService.logout(); break;
				case 2: //상품보기
					ShoppingMallService.showProduct(); break;
				case 3: //카트추가
					ShoppingMallService.addcart(cartdao, scanner); break;
				case 4: //카트보기
					ShoppingMallService.showcart(cartdao, productdao, singleton.getNowMember().getId()); break;
				case 5: //주문하기
	//				ShoppingMallService.order(); break;
				case 6: //전체주문정보
	//				ShoppingMallService.showorder(); break;
				case 7: //주문상세정보
	//				ShoppingMallService. ; break;
				default:
					System.out.println("1~7 사이의 값을 입력해주세요"); break;
			}}catch (Exception e){
			System.out.println("유효하지 않은 입력입니다");
		}
		}
		
	}

}
