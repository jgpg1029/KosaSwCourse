package Rightdao;

public class BoardDaoDeleteTest {

	public static void main(String[] args) {
		Board board = new Board();
		board.setNo(34);
		board.setTitle("������ DAO�� �մϴ�.");
		board.setContent("DAO�� �� ���׿�. ����־��.");
		board.setHitcount(2);

		BoardDao boardDao = BoardDao.getInstance();
		int rows = boardDao.update(board);
		if(rows == 1) {
			System.out.println(board.getNo() + "�� �Խù��� ������");
		} else {
			System.out.println(board.getNo() + "�� �Խù��� �������� ����");
		}
	}

}
