package com.metacube.shoppingcart.view;

import java.util.Scanner;

import com.metacube.shoppingcart.controller.Controller;
import com.metacube.shoppingcart.entity.Product;

public class Input {
	static Scanner input  = new Scanner(System.in);
	Controller control = new Controller();
	public void takeInput(){
		int choice;
		do{
			System.out.println("***Menu***");
			System.out.println("1. Add Product");
			System.out.println("2. Delete Product");
			System.out.println("3. Update Product");
			System.out.println("4. Show Products");
			System.out.println("5. Exit");
			System.out.println("Enter ur choice");
			choice = input.nextInt();
			switch(choice) {
				case 1: 
					System.out.println("Enter name and Price of new Product");
					String name = input.next();
					float price = input.nextFloat();
					Product product = new Product(name,price);
					System.out.println(control.addProduct(product));
					break;
				case 2: 
					int id = input.nextInt();
					System.out.println(control.removeProduct(id));
					break;
				case 3:
					System.out.println("Enter id of the product to be upated");
					id = input.nextInt();
					System.out.println("Enter new name and Price of the Product to be updated");
					name = input.next();
					price = input.nextFloat();
					System.out.println(control.updateProduct(id,name,price));
					break;
				case 4: 
					for(Product s: control.getAll()){
						System.out.println("Id= "+s.getId()+" name= "+s.getName()+" price= "+s.getPrice());
					}
					break;
				case 5:
					System.exit(0);
					break;
				default:
					System.out.println("Please enter a valid option");
			}
		}while(true);
	}
}
