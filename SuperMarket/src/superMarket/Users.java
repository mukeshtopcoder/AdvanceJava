package superMarket;
import java.util.ArrayList;
import java.util.Scanner;
public class Users {
	private int uid;
	private String fname;
	private String email;
	private String pwd;
	private String roles;
	private static Scanner sc = new Scanner(System.in);
	private static Scanner scanner = new Scanner(System.in);
	public static void ViewUsers(String roles) {
		ArrayList<Users> al = Dao.ViewUsers(roles);
		System.out.println("Here Is All Customer Details");
		System.out.println("  UID         Name            Email              ");
		System.out.println("---------------------------------------------");
		for(Users u : al) {
			System.out.printf("%5d%15s%25s\n",u.getUid(),u.getFname(),u.getEmail());
		}
		System.out.println("---------------------------------------------");
		System.out.println("Press Enter Key To Exit...");
		scanner.nextLine();
	}
	public static void Login(String roles) {
		System.out.print("Enter Email ID : ");
		String email = sc.next();
		System.out.print("Enter Password : ");
		String pwd = sc.next();
		Users u = Dao.CheckUser(email,pwd,roles);
		if(u!=null) {
			if(u.getRoles().equals("Admin")) {
				AdminDashboard();
			}else {
				CustomerDashboard();
			}
		}else {
			System.out.println("User is Not Available");
		}
	} 
	public static void AdminDashboard() {
		int flag=1;
		while(flag==1) {
			System.out.println("\n\n\n***** ADMIN *****\n");
			System.out.println("1. Add Product");
			System.out.println("2. View All Products");
			System.out.println("3. View All Customers");
			System.out.println("4. Delete Product");
			System.out.println("5. View All Orders");
			System.out.println("6. Active/Unactive User");
			System.out.println("7. Exit");
			System.out.print("Enter Your Choice : ");
			int choice = sc.nextInt();
			switch(choice) {
			case 1: 
				Products.AddProduct(sc);
				break;
			case 2:
				Products.ViewProducts();
				break;
			case 3: 
				ViewUsers("Customer");
				break;
			case 4:
				Products.DeleteProduct(sc);
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				System.out.println("\nBye-Bye ADMIN!\n");
				flag=0;
				break;
			default:
				System.out.println("Please Try Again!\n");
			}
		}
	}
	public static void CustomerDashboard() {
		
	}
	public static void AddUser(String roles) {
		System.out.print("Enter First Name : ");
		String fname = sc.next();
		System.out.print("Enter Email : ");
		String email = sc.next();
		System.out.print("Enter Password : ");
		String pwd = sc.next();
		Users u = new Users(fname,email,pwd,roles);
		if(Dao.AddUser(u)) {
			System.out.println("Customer Added Success!");
			System.out.println("Welcome! "+u.getFname());
		}else {
			System.out.println("Failed To Add Customer!");
		}
	}
	public Users(String fname, String email, String pwd, String roles) {
		super();
		this.fname = fname;
		this.email = email;
		this.pwd = pwd;
		this.roles = roles;
	}
	public Users() {
		super();
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
}