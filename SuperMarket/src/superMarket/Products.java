package superMarket;
import java.util.ArrayList;
import java.util.Scanner;
public class Products {
	private int pid;
	private String pname;
	private int qty;
	private int price;
	private static Scanner scanner = new Scanner(System.in);
	public static void DeleteProduct(Scanner sc) {
		ViewProducts();
		System.out.println("Enter Product ID To Delete : ");
		int pid = sc.nextInt();
		Products p = Dao.getProductById(pid);
		System.out.println("\nYour Selected Product");
		System.out.println("Product ID : "+p.getPid());
		System.out.println("Product Name : "+p.getPname());
		System.out.println("Product Quantity : "+p.getQty());
		System.out.println("Product Price : "+p.getPrice());
		System.out.print("---------------------------------\nPress 1 to Delete : ");
		int del = sc.nextInt();
		if(del==1) {
			if(Dao.DeleteProduct(pid))
				System.out.println("Product Deleted!");
			else
				System.out.println("Failed To Delete!");
		}else {
			System.out.println("Have A Nice Day!");
		}
	}
	public static void ViewProducts() {
		ArrayList<Products> al = Dao.ViewProducts();
		System.out.println("Here Are Your All Products Details");
		System.out.println("    ID    Product Name       Qty    Price");
		System.out.println("-------------------------------------------");
		for(Products p : al) {
			System.out.printf("%5d%20s%6d%10d\n",p.getPid(),p.getPname(),p.getQty(),p.getPrice());
		}
		System.out.println("-------------------------------------------");
		System.out.println("Press Enter Key To Exit...");
		scanner.nextLine();
	}
	public static void AddProduct(Scanner sc) {
		System.out.print("Enter Product Name in One Word : ");
		String pname = sc.next();
		System.out.print("Enter Quantity : ");
		int qty = sc.nextInt();
		System.out.print("Enter Price : ");
		int price = sc.nextInt();
		Products p = new Products(pname,qty,price);
		if(Dao.AddProduct(p)) {
			System.out.println("Product Added Successfully!");
		}else {
			System.out.println("Failed To Add!");
		}
	}
	public Products(String pname, int qty, int price) {
		super();
		this.pname = pname;
		this.qty = qty;
		this.price = price;
	}
	public Products() {
		super();
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
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
}