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
			//트랜잭션 작업 시작
			conn.setAutoCommit(false);
			
			
			AccountDao accountDao=new AccountDao(conn);
			
			
			//출금작업
			Account fromAccount=accountDao.selectByPk(from);
			fromAccount.setBalance(fromAccount.getBalance()-amount);
			accountDao.update(fromAccount);
			
			//입금작업
			Account toAccount=accountDao.selectByPk(to);
			toAccount.setBalance(toAccount.getBalance()+amount);
			accountDao.update(toAccount);
			
			conn.commit();
			System.out.println("계좌이체성공");
			
			
		} catch (Exception e){
			try {
				conn.rollback();
			} catch (SQLException e1) {
			}
			System.out.println("계좌이체실패");
			e.printStackTrace();
		}finally{
			try{conn.close();} catch(Exception e){}
		}
	}

}
