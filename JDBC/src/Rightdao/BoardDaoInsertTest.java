package Rightdao;

public class BoardDaoInsertTest {

	public static void main(String[] args) {
		Board board = new Board();
		board.setTitle("������ DAO�� ����� ��");
		board.setContent("DAO�� �� �����ϳ׿�. ������ ���� �ؾ� �� �� �����ϴ�.");
		board.setWriter("ȫ�浿");

		BoardDao boardDao = BoardDao.getInstance();
		Integer pk = boardDao.insert(board);
		if(pk != null) {
			System.out.println(pk + "�� �Խù��� �����");
		} else {
			System.out.println("���� ����");
		}
	}

}
