package application;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Main {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Product> prods = new ArrayList<Product>();
		
		System.out.print("Enter the number of products: ");
		Integer numberProducts = sc.nextInt();
		
		for (int index = 1; index <= numberProducts; index++) {
			System.out.println("Product #" + index + " data: ");
			System.out.print("Common, used or imported (c/u/i)?");
			char ch = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.print("Price: ");
			Double productPrice = sc.nextDouble();
			
			if (ch == 'c') {
				prods.add(new Product(productName, productPrice));
			}
			else if (ch == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date manufactureDate = Product.SDF.parse(sc.next());
				prods.add(new UsedProduct(productName, productPrice, manufactureDate));
			}
			else if (ch == 'i') {
				System.out.print("Customs fee: ");
				Double customsFee = sc.nextDouble();
				prods.add(new ImportedProduct(productName, productPrice, customsFee));
			}
		}
		
		System.out.println("Price Tags: ");
		
		for (Product prod : prods) {
			System.out.println(prod.priceTag());
		}
		
		sc.close();
	}

}
