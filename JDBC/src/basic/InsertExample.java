package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertExample {

	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		// TODO Auto-generated method stub
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(//url:연결 문자열(Connection String)1.IP 2.포트번호 3.db명
					"jdbc:mysql://blueskii.iptime.org:3306/team5"
					,"team5","123456"
					);
			
			String sql="insert into user3_boards(board_title, board_content,board_writer,board_date) values(?,?,?,now())";//?:매개변수
			pstmt=conn.prepareStatement(sql,new String[]{"board_no"});//기본키 값을 받아옴. board_no의 값을 검사해서 가져옴.
			pstmt.setString(1, "오늘은 화요일");//(?의 순번,)
			pstmt.setString(2, "쉽시다");
			pstmt.setString(3, "홍이길이동이");
			int row=pstmt.executeUpdate();//insert된 행의 수
			//pstmt.executeUpdate();//실행
			int boardNo=0;
			if(row==1){
				ResultSet rs=pstmt.getGeneratedKeys();
				if(rs.next()){
					boardNo=rs.getInt(1);//자동증가된 컬럼 가져오기.1로 해야함
				}
				rs.close();
			}
			
			
			System.out.println(boardNo+"번 게시물이 저장됨");
			
			
		} catch (Exception e){
		
			e.printStackTrace();
		}finally{
			try {pstmt.close();} catch (SQLException e1) {}
		}
			try {conn.close();} catch (SQLException e) {}
		}

	}
