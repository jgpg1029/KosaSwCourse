package Rightdao;

public class BoardDaoSelectByPkTest {

	public static void main(String[] args) {
		BoardDao boardDao = BoardDao.getInstance();
		Board board = boardDao.selectByPk(60);
		if(board != null) {
			System.out.println("��ȣ: " + board.getNo());
			System.out.println("����: " + board.getTitle());
			System.out.println("����: " + board.getContent());
			System.out.println("��¥: " + board.getDate());
			System.out.println("�۾���: " + board.getWriter());
			System.out.println("��ȸ��: " + board.getHitcount());
		} else {
			System.out.println(60 + "�� �Խù��� �������� ����");
		}
	}

}
