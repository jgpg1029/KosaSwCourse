package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDao {
	private Connection conn;

	// 생성자 주입 방식
	public BoardDao(Connection conn) {
		this.conn = conn;
	}

	// 데이터 작업 메소드
	public Integer insert(Board board) throws SQLException {// int나 long일 경우
															// Integer이나Long으로
															// 한다=> return값을
															// null로 하기위해.
		Integer pk = null;
		String sql = "insert into boards (board_title, board_content,board_writer) values(?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, board.getTitle());// (?의 순번,)
		pstmt.setString(2, board.getContent());
		pstmt.setInt(3, board.getHitcount());
		
		pk = pstmt.executeUpdate();// insert된 행의 수

		pstmt.close();
		return pk;
	}

	// 데이터 작업 메소드
	public int update(Board board) throws SQLException {// int나 long일 경우
														// Integer이나Long으로 한다=>
														// return값을 null로 하기위해.
		int rows = 0;
		String sql = "update boards set board_title=?, board_content=?,board_hitcount=? where board_no=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, board.getTitle());// (?의 순번,)
		pstmt.setString(2, board.getContent());
		pstmt.setInt(3, board.getHitcount());
		pstmt.setInt(4, board.getNo());
		rows = pstmt.executeUpdate();// insert된 행의 수
		pstmt.close();
		return rows;
	}

	public int updateTitleContent(Board board) {
		int rows = 0;
		String sql = "update boards set board_title=?, board_content=? where board_no=?";

		return rows;

	}

	public int updateHitCount(Board board) {
		int rows = 0;
		String sql = "update boards set board_title=?, board_content=?,board_hitcount=? where board_no=?";

		return rows;

	}

	public int delete(int boardNo) throws SQLException {
		int rows = 0;
		String sql = "delete from boards where board_no=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, boardNo);// (?의 순번,)

		rows = pstmt.executeUpdate();// insert된 행의 수
		pstmt.close();

		return rows;
	}

	public Board selectByPk(int boardNo) throws SQLException {
		Board board = null;
		String sql = "select *from boards where board_no=?";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, boardNo);
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			board = new Board();
			board.setNo(rs.getInt("board_no"));
			board.setTitle(rs.getString("board_title"));
			board.setContent(rs.getString("board_content"));
			board.setDate(rs.getDate("board_date"));
			board.setWriter(rs.getString("board_writer"));
			board.setHitcount(rs.getInt("board_hitcount"));

		}
		rs.close();

		pstmt.close();
		return board;

	}

	public List<Board> selectByPage(int pageNo, int rowsPerPage) throws SQLException {
		List<Board> list = new ArrayList<Board>();
	/*	String sql = "";
		sql += "select rn ,board_no,board_title,board_writer,board_date,board_hitcount ";
		sql += "from ";
		sql += "( ";
		sql += "select rownum rn,board_no,board_title,board_writer,board_date,board_hitcount ";
		sql += "from ";
		sql += "( ";
		sql += "select board_no,board_title,board_writer,board_date,board_hitcount ";
		sql += "from boards ";
		sql += "order by board_no desc ";
		sql += ") ";
		sql += "where rownum<=? ";
		sql += ") ";
		sql += "where rn >=? ";*/
		//Mysql
		String sql="";
		sql += "select board_no,board_title,board_writer,board_date,board_hitcount ";
		sql += "from boards ";
		sql += "order by board_no desc ";
		sql += "limit ?,? ";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		//Oracle
		//pstmt.setInt(1, pageNo * rowsPerPage);
		//pstmt.setInt(2, (pageNo - 1) * rowsPerPage + 1);

		
		//MySQL
		pstmt.setInt(1,(pageNo-1)*rowsPerPage) ;
		pstmt.setInt(2, rowsPerPage);
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			Board board = new Board();
			board.setNo(rs.getInt("board_no"));
			board.setTitle(rs.getString("board_title"));
			board.setDate(rs.getDate("board_date"));
			board.setWriter(rs.getString("board_writer"));
			board.setHitcount(rs.getInt("board_hitcount"));

			list.add(board);
		}
		rs.close();
		pstmt.close();
		return list;
	}

}
