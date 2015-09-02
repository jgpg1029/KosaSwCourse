package Rightdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDao {
	//싱글톤으로 사용
	private static BoardDao singleton = new BoardDao();
	private BoardDao() {}
	public static BoardDao getInstance() {
		return singleton;
	}
	//데이터 작업 메소드
	public Integer insert(Board board) {
		Integer pk = null;
		String sql = "insert into boards (board_title, board_content, board_writer) values (?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@70.12.108.154:1521:orcl", 
					"user0", "12345"
			);
			pstmt = conn.prepareStatement(sql, new String[]{"board_no"});
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setString(3, board.getWriter());
			int row = pstmt.executeUpdate();
			if(row == 1) {
				ResultSet rs = pstmt.getGeneratedKeys();
				if(rs.next()) {
					pk = rs.getInt(1);
				}
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { pstmt.close(); } catch (SQLException e1) {}
			try { conn.close(); } catch (SQLException e) {}
		}
		
		return pk;
	}
	
	public int update(Board board) {
		int rows = 0;
		String sql = "update boards set board_title=?, board_content=?, board_hitcount=? where board_no=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = ConnectionManager.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setInt(3, board.getHitcount());
			pstmt.setInt(4, board.getNo());
			
			rows = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { pstmt.close(); } catch (SQLException e1) {}
			try { conn.close(); } catch (SQLException e) {}
		}
		
		return rows;
	}
	
	public int delete(int boardNo) {
		int rows = 0;
		String sql = "delete from boards where board_no=?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = ConnectionManager.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			
			rows = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { pstmt.close(); } catch (SQLException e1) {}
			try { conn.close(); } catch (SQLException e) {}
		}		
		
		return rows;
	}
	
	public Board selectByPk(int boardNo) {
		Board board = null;
		String sql = "select * from boards where board_no=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = ConnectionManager.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,  boardNo);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				board = new Board();
				board.setNo( rs.getInt("board_no") );
				board.setTitle( rs.getString("board_title") );
				board.setContent( rs.getString("board_content") );
				board.setDate( rs.getDate("board_date") );
				board.setWriter( rs.getString("board_writer") );
				board.setHitcount( rs.getInt("board_hitcount") );
			}
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { pstmt.close(); } catch (SQLException e1) {}
			try { conn.close(); } catch (SQLException e) {}
		}
		
		return board;
	}
	
	public List<Board> selectByAll() {
		List<Board> list = new ArrayList<Board>();
		String sql = "select * from boards";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = ConnectionManager.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Board board = new Board();
				board.setNo( rs.getInt("board_no") );
				board.setTitle( rs.getString("board_title") );
				board.setContent( rs.getString("board_content") );
				board.setDate( rs.getDate("board_date") );
				board.setWriter( rs.getString("board_writer") );
				board.setHitcount( rs.getInt("board_hitcount") );
				list.add(board);
			}
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { pstmt.close(); } catch (SQLException e1) {}
			try { conn.close(); } catch (SQLException e) {}
		}
		
		return list;
	}
	
	public List<Board> selectByPage(int pageNo, int rowsPerPage) {
		List<Board> list = new ArrayList<Board>();
		String sql = "";
		sql += "select rn, board_no, board_title, board_writer, board_date, board_hitcount ";
		sql += "from ";
		sql += "( ";
		sql += "select rownum rn, board_no, board_title, board_writer, board_date, board_hitcount ";
		sql += "from ";
		sql += "( ";
		sql += "select board_no, board_title, board_writer, board_date, board_hitcount " ;
		sql += "from boards ";
		sql += "order by board_no desc ";
		sql += ") ";
		sql += "where rownum<=? ";
		sql += ") ";
		sql += "where rn>=? ";	
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = ConnectionManager.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pageNo*rowsPerPage);
			pstmt.setInt(2, (pageNo-1)*rowsPerPage+1);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Board board = new Board();
				board.setNo( rs.getInt("board_no") );
				board.setTitle( rs.getString("board_title") );
				board.setDate( rs.getDate("board_date") );
				board.setWriter( rs.getString("board_writer") );
				board.setHitcount( rs.getInt("board_hitcount") );
				list.add(board);
			}
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { pstmt.close(); } catch (SQLException e1) {}
			try { conn.close(); } catch (SQLException e) {}
		}
		
		return list;
	}
}




