package service;

import java.sql.Connection;
import java.sql.SQLException;

import Rightdao.ConnectionManager;
import dao.Account;
import dao.AccountDao;

public class BankService {
	public void transfer(int from, int to, int amount){
		Connection conn=null;
		try {
			conn=ConnectionManager.getConnection();
			//Ʈ����� �۾� ����
			conn.setAutoCommit(false);
			
			
			AccountDao accountDao=new AccountDao(conn);
			
			
			//����۾�
			Account fromAccount=accountDao.selectByPk(from);
			fromAccount.setBalance(fromAccount.getBalance()-amount);
			accountDao.update(fromAccount);
			
			//�Ա��۾�
			Account toAccount=accountDao.selectByPk(to);
			toAccount.setBalance(toAccount.getBalance()+amount);
			accountDao.update(toAccount);
			
			conn.commit();
			System.out.println("������ü����");
			
			
		} catch (Exception e){
			try {
				conn.rollback();
			} catch (SQLException e1) {
			}
			System.out.println("������ü����");
			e.printStackTrace();
		}finally{
			try{conn.close();} catch(Exception e){}
		}
	}

}
