package application;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Product> list = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		for(int i = 1; i <= n; i++) {
			System.out.println("Product " + i + " data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			char ch = sc.next().charAt(0); 
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Price: ");
			Double price = sc.nextDouble();
			
			if(ch == 'i') {
				System.out.print("Customs fee: ");
				Double customs = sc.nextDouble();
				ImportedProduct importedProduct = new ImportedProduct(name, price, customs);
				list.add(importedProduct);

			}else if(ch == 'c'){
				Product product = new Product(name, price);
				list.add(product);
				
			}else if(ch == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				LocalDate date = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				UsedProduct usedProduct = new UsedProduct(name, price, date);
				list.add(usedProduct);
			}
			
		}
		
		System.out.println();
		System.out.println("PRICE TAGS:");
		for(Product prod : list) {
			System.out.println(prod.priceTag());
		}
		
		sc.close();

	}

}
