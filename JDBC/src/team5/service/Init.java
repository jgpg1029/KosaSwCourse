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
			System.out.println("1. ȸ������ |2. �α��� |3. ����");
			System.out.println("---------------------------");
			System.out.print("����>");
				
		}else{
			System.out.println("-------------------------------------------------------------------------------");
			System.out.println("1.�α׾ƿ� | 2.��ǰ��� | 3.��ٱ��ϳֱ� | 4.��ٱ��Ϻ��� | 5.�ֹ��ϱ� | 6.��ü�ֹ����� | 7.�ֹ������� ");
			System.out.println("-------------------------------------------------------------------------------");
			System.out.print("����>");

		}
	}
	
	public static void input
	(Connection conn, Scanner scanner){
		//Dao
		MemberDao memberdao = new MemberDao(conn);//ȸ������
		ProductDao productdao = new ProductDao(conn);
		CartDao cartdao = new CartDao(conn);//��ٱ���
		OrderDao orderdao = new OrderDao(conn);
		OrderItemDao orderitemDao = new OrderItemDao();

		if(singleton.isState() != true){
			try{
				int sel = Integer.parseInt(scanner.next());
					
				switch(sel){
				case 1: //ȸ������
					ShoppingMallService.join(scanner, memberdao); break;
				case 2: //�α���
					singleton.setNowMember(ShoppingMallService.login(scanner, memberdao)); break;
				case 3://������
					singleton.setRun(false); break;
				default:
					System.out.println("1~3 ������ ���� �Է����ּ���");
					break;
				}
			}catch(Exception e){
				System.out.println("��ȿ���� ���� �Է��Դϴ�");
			}
		}else{
			try{
				int sel = Integer.parseInt(scanner.next());		
			
				switch(sel){
				case 1: //�α׾ƿ�
					ShoppingMallService.logout(); break;
				case 2: //��ǰ����
					ShoppingMallService.showProduct(); break;
				case 3: //īƮ�߰�
					ShoppingMallService.addcart(cartdao, scanner); break;
				case 4: //īƮ����
					ShoppingMallService.showcart(cartdao, productdao, singleton.getNowMember().getId()); break;
				case 5: //�ֹ��ϱ�
	//				ShoppingMallService.order(); break;
				case 6: //��ü�ֹ�����
	//				ShoppingMallService.showorder(); break;
				case 7: //�ֹ�������
	//				ShoppingMallService. ; break;
				default:
					System.out.println("1~7 ������ ���� �Է����ּ���"); break;
			}}catch (Exception e){
			System.out.println("��ȿ���� ���� �Է��Դϴ�");
		}
		}
		
	}

}
