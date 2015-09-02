package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Board;
import dto.Boardex;

public class BoardexDao {
	private Connection connec;
	
	public BoardexDao(Connection connec) {
		this.connec = connec;
	}
	
	public Integer insert(Boardex board) throws SQLException {
		Integer pk = null;
		String sql = "insert into ExProducts (product_name, product_price) values(?, ?)";
		PreparedStatement pstmt = connec.prepareStatement(sql, new String[] {"product_no"});
		pstmt.setString(1, board.getName());
		pstmt.setInt(2, board.getPrice());
		
		int rows = pstmt.executeUpdate();
		if(rows==1) {
			ResultSet rs = pstmt.getGeneratedKeys();
			if(rs.next()) {
				pk = rs.getInt(1);
			}
			rs.close();
		}
		pstmt.close();
		return pk;
	}
	
	public List<Boardex> selectByPage(int pageNo,int rowsPerPage) throws SQLException{
		List<Boardex> list=new ArrayList<Boardex>();
		String sql="";
		sql += "select product_no,product_name,product_price ";
		sql += "from ExProducts ";
		sql += "order by product_no desc ";
		sql += "limit ?,? ";
		PreparedStatement pstmt=connec.prepareStatement(sql);
		pstmt.setInt(1, (pageNo-1)*rowsPerPage);
		pstmt.setInt(2, rowsPerPage);
		ResultSet rs=pstmt.executeQuery();
		
		while(rs.next()){
			Boardex board=new Boardex();
			board.setNo(rs.getInt("product_no"));
			board.setName(rs.getString("product_name"));
			board.setPrice(rs.getInt("product_price"));
			
			list.add(board);
		
		}
		rs.close();
		pstmt.close();
		
		return list;
	}
	
	public Boardex selectByPk(int productNo) throws SQLException{
		Boardex board=null;
		String sql="select * from ExProducts where product_no=?";
		
		PreparedStatement pstmt=connec.prepareStatement(sql);
		pstmt.setInt(1, productNo);
		ResultSet rs=pstmt.executeQuery();
		
		if(rs.next()){
			board=new Boardex();
			board.setNo(rs.getInt("product_no"));
			board.setName(rs.getString("product_name"));
			board.setPrice(rs.getInt("product_price"));
		
		}
		rs.close();
		pstmt.close();
		
		return board;
	}
	
	public int update(Boardex board) throws SQLException {
		int rows = 0;
		String sql = "update ExProducts set product_name=?, product_price=? where product_no=?";
		PreparedStatement pstmt = connec.prepareStatement(sql);
		pstmt.setString(1, board.getName());
		pstmt.setInt(2, board.getPrice());
		pstmt.setInt(3, board.getNo());
		rows=pstmt.executeUpdate();
		
		pstmt.close();
		return rows;
	}
	
	public int delete(int productNo) throws SQLException {
		int rows = 0;
		String sql = "delete from ExProducts where product_no=?";
		PreparedStatement pstmt = connec.prepareStatement(sql);
		pstmt.setInt(1, productNo);
		rows=pstmt.executeUpdate();
		pstmt.close();
		return rows;
	}
	

}