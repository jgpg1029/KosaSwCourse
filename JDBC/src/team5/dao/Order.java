package team5.dao;

import java.util.Date;

public class Order {
   private int no;
   private Date date;
   private String payment;
   private int price;
   private String Id;
   
   public String getId() {
      return Id;
   }
   public void setId(String id) {
      Id = id;
   }
   public int getNo() {
      return no;
   }
   public void setNo(int no) {
      this.no = no;
   }
   public Date getDate() {
      return date;
   }
   public void setDate(Date date) {
      this.date = date;
   }
   public String getPayment() {
      return payment;
   }
   public void setPayment(String payment) {
      this.payment = payment;
   }
   public int getPrice() {
      return price;
   }
   public void setPrice(int price) {
      this.price = price;
   }
   
   
}