package team5.service;

import java.sql.Connection;
import java.util.List;

import team5.dao.ConnectionManager;
import team5.dao.OrderItem;
import team5.dao.OrderItemDao;
import team5.dao.Product;

public class OrderItemService {

	public void insertorderitem(OrderItem orderitem) {

		try {
			Connection conn = ConnectionManager.getConnection();
			OrderItemDao orderitemDao = new OrderItemDao(conn);

			Integer rows = orderitemDao.insert(orderitem);

		} catch (Exception e) {
			System.out.println("������");
		}

	}

	public void showorderitem(int key) {
		System.out.println("----------------------------------");
		System.out.println("��ǰ��ȣ    ��ǰ��      ����    ����");
		System.out.println("----------------------------------");

		Connection conn = null;
		try {
			conn = ConnectionManager.getConnection();
			Product product = new Product();

			OrderItemDao orderitemDao = new OrderItemDao(conn);
			List<OrderItem> list = orderitemDao.selectByNo(key);

			for (OrderItem orderitem : list) {
				System.out.print(orderitem.getProductno() + "\t");
				System.out.print(product.getProduct_name() + "\t");
				System.out.print(orderitem.getOrderproductamount() + "\t");
				System.out.print(product.getProduct_price());
				System.out.println();
			}

		} catch (Exception e) {
			System.out.println("�ֹ��� ��ǰ�� �����ϴ�. �� �����ڽľ�");
		} finally {

			try {
				conn.close();
			} catch (Exception e) {
			}
		}
	}
}
