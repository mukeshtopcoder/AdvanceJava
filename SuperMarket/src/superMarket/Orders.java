package superMarket;

import java.util.ArrayList;

public class Orders {
	int oid;
	int uid;
	String fname;
	String pname;
	int qty;
	int price;
	int total;
	int gst;
	int gtotal;
	public static void ViewOrderById(int uid) {
		ArrayList<Orders> al = Dao.ViewOrderById(uid);
		System.out.println("Your All Orders!");
		System.out.println("-------------------------------------");
		for(Orders o : al) {
			System.out.println("");
		}
	}
	public Orders(int uid, String fname, String pname, int qty, int price, int total, int gst, int gtotal) {
		super();
		this.uid = uid;
		this.fname = fname;
		this.pname = pname;
		this.qty = qty;
		this.price = price;
		this.total = total;
		this.gst = gst;
		this.gtotal = gtotal;
	}
	public Orders() {
		super();
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getGst() {
		return gst;
	}
	public void setGst(int gst) {
		this.gst = gst;
	}
	public int getGtotal() {
		return gtotal;
	}
	public void setGtotal(int gtotal) {
		this.gtotal = gtotal;
	}
}