package team5.dao;

public class OrderItem {
	private int orderno;
	private int orderproductamount;
	private int productno;
	private int orderproductno;
	
	public int getOrderproductno() {return orderproductno;}
	public void setOrderproductno(int orderproductno) {this.orderproductno = orderproductno;}
	public int getOrderno() {return orderno;}
	public void setOrderno(int orderno) {this.orderno = orderno;}
	public int getOrderproductamount() {return orderproductamount;}
	public void setOrderproductamount(int oderproductamount) {this.orderproductamount = oderproductamount;}
	public int getProductno() {return productno;}
	public void setProductno(int productno) {this.productno = productno;}

}
