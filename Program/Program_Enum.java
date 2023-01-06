package program;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.ProductEnum;
import entities.enums.orderStatus;


public class Program_Enum {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Locale.setDefault(Locale.US);
		Scanner leitor = new Scanner(System.in);
		
		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String name = leitor.nextLine();
		System.out.print("Email: ");
		String email = leitor.next();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(leitor.next());
		
		Client client = new Client(name, email, birthDate);
		
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		orderStatus status = orderStatus.valueOf(leitor.next());
		
		Order order = new Order(new Date(), status, client);
		
		System.out.print("How many items to this order? ");
		int N = leitor.nextInt();
		for (int i=1; i<=N; i++) {
			System.out.println("Enter #" + i + " item data:");
			System.out.print("Product name: ");
			leitor.nextLine();
			String productName = leitor.nextLine();
			System.out.print("Product price: ");
			double productPrice = leitor.nextDouble();
			System.out.print("Quantity: ");
			int quantity = leitor.nextInt();
			
			ProductEnum product = new ProductEnum(productName, productPrice);
			
			OrderItem it = new OrderItem(quantity, productPrice, product);
			
			order.addItem(it);			
		}
		
		System.out.println();
		System.out.println(order);
		
		
		
	}

}
