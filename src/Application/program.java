package Application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class program {
	public static void main(String[] args) throws ParseException {
		try {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter cliente data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());
		
		Client client = new Client(name,email,birthDate);
		
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		
		Order order = new Order(new Date(), status, client);
		
		System.out.print("How many items to this order?");
		int num = sc.nextInt();
		
		for (int i = 1; i <=num; i++) {
			System.out.println("Enter #"+i+" data:");
			System.out.print("Product Name: ");
			sc.nextLine();
			String productN = sc.nextLine();
			System.out.print("Product price: ");
			double priceP = sc.nextDouble();
			Product product = new Product(productN,priceP );
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			
			OrderItem orderItem = new OrderItem(quantity, priceP, product);
			order.addItem(orderItem);
			
			
			
		}
		System.out.println();
		System.out.println("ORDER SUMMARY:");
		System.out.println(order);
		sc.close();
		
		
	}catch (NumberFormatException erro) {
		System.out.println("\n" + 
				"There was an error, just enter numeric characters"+ erro.toString());
	}
	}
}
