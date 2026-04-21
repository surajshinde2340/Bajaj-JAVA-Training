package excel;

import java.util.Date;

public class BillBoard {
	int billNo;
	Date billDate;
	String Product;
	int quantity;
	double total;
	public int getBillNo() {
		return billNo;
	}
	public void setBillNo(int billNo) {
		this.billNo = billNo;
	}
	public Date getBillDate() {
		return billDate;
	}
	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}
	public String getProduct() {
		return Product;
	}
	public void setProduct(String product) {
		Product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public BillBoard(int billNo, Date billDate, String product, int quantity, double total) {
		
		this.billNo = billNo;
		this.billDate = billDate;
		Product = product;
		this.quantity = quantity;
		this.total = total;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	

}
