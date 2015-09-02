package Rightdao;

public class BoardDaoUpdateTest {

	public static void main(String[] args) {
		BoardDao boardDao = BoardDao.getInstance();
		int rows = boardDao.delete(34);
		if(rows == 1) {
			System.out.println(34 + "번 게시물이 삭제됨");
		} else {
			System.out.println(34 + "번 게시물이 존재하지 않음");
		}
	}

}
