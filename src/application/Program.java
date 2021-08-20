package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException{
		// TODO Auto-generated method stub
		
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date manufactureDate = sdf.parse("30/12/1974");
		Scanner sc = new Scanner(System.in);
		List<Product> list = new ArrayList<>();
		
		System.out.print("Enter number of products: ");
		int n = sc.nextInt();
		
		for (int i = 1; i <= n; i ++ ) {
			
			System.out.println("Product #" + i + " data:");
			
			System.out.print("Common, used or imported (c/u/i)? ");
			char type = sc.next().charAt(0);
			
			System.out.print("Name: ");
			String name = sc.next();
			
			System.out.print("Price");
			Double price = sc.nextDouble();
			
			if (type == 'c') {
				list.add(new Product(name, price));
			}
			
			else if (type == 'u') {
				System.out.print("Manufacture date (dd/MM/yyyy)");
				manufactureDate = sdf.parse(sc.next());
				list.add(new UsedProduct(name, price, manufactureDate));
			}
			
			else if (type == 'i') {
				System.out.print("Customs fee: ");
				Double customsFee = sc.nextDouble();
				
				list.add(new ImportedProduct(name, price, customsFee));
			}				
		}
		
		System.out.println("\nPRICE TAGS: ");
		for (Product prod : list) {
			System.out.println(prod.priceTag());
		}
		
		/*
		 * ImportedProduct ip = new ImportedProduct("Tablet", 260.0, 20.0);
		 * System.out.println(ip.priceTag());
		 * 
		 * Product cp = new Product("Notebood", 1100.0);
		 * System.out.println(cp.priceTag());
		 * 
		 * UsedProduct up = new UsedProduct("Iphone", 400.0, date);
		 * System.out.println(up.priceTag());
		 */

	}

}
