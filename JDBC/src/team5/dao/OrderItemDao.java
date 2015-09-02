package team5.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderItemDao {
	private Connection conn;

	// ������ ���� ���
	public OrderItemDao(Connection conn) {
		this.conn = conn;

	}

	// ������ �۾� �޼ҵ�
	public Integer insert(OrderItem orderitem) throws SQLException {// int��
																	// long�� ���
		// Integer�̳�Long����
		// �Ѵ�=> return����
		// null�� �ϱ�����.
		Integer pk = null;
		String sql = "insert into ORDERPRODUCTS (order_no, product_no, orderproduct_amount) values (?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql, new String[]{"ORDERPRODUCT_NO"});
		pstmt.setInt(1, orderitem.getOrderno());// (?�� ����,)
		pstmt.setInt(2, orderitem.getProductno());
		pstmt.setInt(3, orderitem.getOrderproductamount());

		pk = pstmt.executeUpdate();// insert�� ���� ��

		pstmt.close();
		return pk;
	}

	public List<OrderItem> selectByNo(int orderItemNo) throws SQLException {
		List<OrderItem> list = new ArrayList<OrderItem>();
		String sql = "select *from Orderproducts where Order_no=?";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, orderItemNo);
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			OrderItem orderitem = new OrderItem();
			orderitem.setOrderproductamount(rs.getInt("orderproduct_amount"));

			list.add(orderitem);
		}
		rs.close();
		pstmt.close();
		return list;

	}

}