package application;

import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Main {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter client data: ");
		System.out.print("Name: ");
		String clientName = sc.nextLine();
		System.out.print("Email: ");
		String clientEmail = sc.next();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date clientBirthDate = Client.SDF.parse(sc.next());
		
		Client client = new Client(clientName, clientEmail, clientBirthDate);
		
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		OrderStatus orderStatus = OrderStatus.valueOf(sc.next());
		System.out.print("How many items to this order? ");
		Integer itemNumber = sc.nextInt();
		
		Order order = new Order(orderStatus, client);
		
		for (int index = 1; index <= itemNumber; index++) {
			System.out.println("Enter item #" + index + " data: ");
			System.out.print("Product name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			Double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			Integer qtdItem = sc.nextInt();
			
			Product product = new Product(productName, productPrice);
			OrderItem item = new OrderItem(product, qtdItem);
			order.addItem(item);
		}
		
		System.out.println("");
		System.out.println(order);
		
		sc.close();
	}

}
