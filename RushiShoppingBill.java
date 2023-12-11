
import java.awt.List;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class RushiShoppingBill {

	public static void main(String[] args) {
		
//		variables
		
		String id =null;
		String productName=null;
		int quantity = 0;
		double price =0.0;
		double totalprice =0.0;
		double OverAllPrice =0.0;
		double CGST , SGST, subtotal= 0.0 , discount =0.0;
		char choice ='\0';
		System.out.println("------------------------------------------------Invoice----------------------------------------------------------");
		System.out.println("\t\t\t\t\t "+" " +"Metro Mart Shop Now.. ");
		System.out.println("\t\t\t\t Chatrapati Shivaji Maharaj Nager Nashik\t\t");
		System.out.println("GSTIN:03AWBPP8756K592" +"\t\t\t\t\t\t\t\t\tcontact: (+91) 9322665933");
		
//		format of date and time
		SimpleDateFormat  formatter = new SimpleDateFormat ("DD/mm/YYYY  HH:mm:ss");
		Date date = new Date();
		Calendar calender = Calendar.getInstance();
		String[] days = new String[] {"Sunday","Monday","Tuesday","wednesday","Thursday","Saturday"};
		
//		print current date and time
		System.out.println("Date: " +formatter.format(date) + "  " + days[calender.get (calender.DAY_OF_MONTH) -1]
				+ "\t\t\t\t\t\t\t\t (+91) 9322665933");
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Customer  Name: ");
		String customername = scan.nextLine();
		
//		CREATE SCANNER CLASS OBJECT
//      CREATING AN ARRAYLIST TO STORE THE PRODUCT

		ArrayList<product> product  =new ArrayList<product>();
		
		do {
//			read input values
			System.out.println("Enter the product details: ");
			System.out.println("product ID: ");
			id = scan.nextLine();
			System.out.println("Product Name:  ");
			productName = scan.nextLine();
			System.out.println("Quatity: ");
			quantity = scan.nextInt();
			System.out.println("Price (per unit): ");
			price = scan.nextDouble();
			totalprice =  price *quantity;
			OverAllPrice = OverAllPrice +totalprice;
			product.add(new product(id,productName ,quantity,price,totalprice));
			System.out.println("want to add more item ?(y or n):");
			choice = scan.next().charAt(0);
			scan.nextLine();
			
		} while (choice =='y' || choice =='Y');
//		product.displayFormat();
		for(product p:product) {
			p.display();
			
		}
		System.out.println("\n\t\t\t\t\t\t\t\t\t\tTotal Amount (Rs.)"+OverAllPrice);
		discount = OverAllPrice *2/100;
		System.out.println("\n\t\t\t\t\t\t\t\t\t\t   Discount (Rs.)"+discount);
		subtotal = OverAllPrice -discount;
		System.out.println("\n\t\t\t\t\t\t\t\t\t\t    subtotal" +subtotal);
		SGST = OverAllPrice *12/100;
		System.out.println("\n\t\t\t\t\t\t\t\t\t\t    SGST (%)" +SGST);
		CGST = OverAllPrice*12/100;
		System.out.println("\n\t\t\t\t\t\t\t\t\t\t     CGST *%)"+ CGST);
		System.out.println("\n\t\t\t\t\t\t\t\t\t\t   Invoice Total "+(subtotal + CGST +  SGST));
		System.out.println("-------------------------------------Thank You for Shopping !!--------------------------------------------------- ");
		System.out.println("\t\t\t                 visit Again");
		scan.close();

		
		
		
	}
}
