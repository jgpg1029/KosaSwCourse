package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BoardDao;
import dao.BoardexDao;
import dao.ConnectionManager;
import dao.ConnectionexManager;
import dto.Board;
import dto.Boardex;

public class BoardexService{
	public void add(Boardex board){
		Connection connec = null;
		try {
			connec = ConnectionexManager.getConnection();
			BoardexDao boardexDao = new BoardexDao(connec);
			boardexDao.insert(board);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { connec.close(); } catch (SQLException e) {}
		}
	}
	
	public List<Boardex> getPage(int pageNo,int rowsPerPage){
		List<Boardex> list=new ArrayList<Boardex>();
		Connection connec = null;
		try {
			connec = ConnectionexManager.getConnection();
			BoardexDao boardexDao = new BoardexDao(connec);
			list=boardexDao.selectByPage(pageNo,rowsPerPage);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { connec.close(); } catch (SQLException e) {}
		}
		return list;
		
	}
	
	public Boardex getBoard(int productNo){
		Boardex boardex=null;
		Connection connec = null;
		try {
			connec = ConnectionexManager.getConnection();
			BoardexDao boardexDao = new BoardexDao(connec);
			boardex=boardexDao.selectByPk(productNo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { connec.close(); } catch (SQLException e) {}
		}
		return boardex;
	}
	
	public void modify(Boardex board) {
		Connection connec = null;
		try {
			connec = ConnectionexManager.getConnection();
			BoardexDao boardexDao = new BoardexDao(connec);
			boardexDao.update(board);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { connec.close(); } catch (SQLException e) {}
		}
	}
	
	public void remove(int productNo) {
		Connection connec = null;
		try {
			connec = ConnectionexManager.getConnection();
			BoardexDao boardexDao = new BoardexDao(connec);
			boardexDao.delete(productNo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { connec.close(); } catch (SQLException e) {}
		}
	}
	
}