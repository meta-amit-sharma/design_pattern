package com.metacube.shoppingcart.view;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import com.metacube.shoppingcart.controller.CartController;
import com.metacube.shoppingcart.controller.Controller;
import com.metacube.shoppingcart.dao.EntityType;
import com.metacube.shoppingcart.entity.Product;
import com.metacube.shoppingcart.entity.ShoppingCart;
import com.metacube.shoppingcart.entity.User;

public class Input {
	static Scanner input  = new Scanner(System.in);
	@SuppressWarnings("rawtypes")
	Controller control = new Controller();
	CartController cartControl = new CartController();
	@SuppressWarnings("unchecked")
	public void takeInput(){
		int choice;
		do{
			System.out.println("***Menu***");
			System.out.println("1. Add Product");
			System.out.println("2. Delete Product");
			System.out.println("3. Update Product");
			System.out.println("4. Show Products");
			System.out.println("5. Add User");
			System.out.println("6. Delete User");
			System.out.println("7. Update User");
			System.out.println("8. Show Users");
			System.out.println("9. Shop");
			System.out.println("10. Exit");
			System.out.println("Enter ur choice");
			choice = input.nextInt();
			switch(choice) {
				case 1: 
					System.out.println("Enter name and Price of new Product");
					String name = input.next();
					float price = input.nextFloat();
					Product product = new Product(name,price);
					System.out.println(control.add(EntityType.Product,product));
					break;
				case 2: 
					int id = input.nextInt();
					System.out.println(control.remove(EntityType.Product,id));
					break;
				case 3:
					System.out.println("Enter id of the product to be upated");
					id = input.nextInt();
					System.out.println("Enter new name and Price of the Product to be updated");
					name = input.next();
					price = input.nextFloat();
					System.out.println(control.update(EntityType.Product,id,name,price));
					break;
				case 4: 
					for(Object obj: control.getAll(EntityType.Product)){
						Product s = (Product)obj;
						System.out.println("Id= "+s.getId()+" name= "+s.getName()+" price= "+s.getPrice());
					}
					break;
				case 5: 
					System.out.println("Enter UserID, UserName and Password of new User");
					String uid = input.next();
					name = input.next();
					String password = input.next();
					User user = new User(uid,name,password);
					System.out.println(control.add(EntityType.User,user));
					break;
				case 6: 
					uid = input.next();
					System.out.println(control.remove(EntityType.User,uid));
					break;
				case 7:
					System.out.println("Enter UserID of the user to be upated");
					uid = input.next();
					System.out.println("Enter new name and password of the user to be updated");
					name = input.next();
					password = input.next();
					System.out.println(control.update(EntityType.User,uid,name,password));
					break;
				case 8: 
					for(Object obj: control.getAll(EntityType.User)){
						User s = (User)obj;
						System.out.println("UserId= "+s.getUserid()+" Username= "+s.getName()+" Password = "+s.getPassword());
					}
					break;
				case 9:
					System.out.println("Enter UserID");
					uid = input.next();
					if(cartControl.checkUser(uid)){
						shopping(uid);
					} else {
						System.out.println("User id not found");
					}
					break;
				case 10:
					System.exit(0);
					break;
				default:
					System.out.println("Please enter a valid option");
			}
		}while(true);
	}
	private void shopping(String uid) {
		int choice,quantity;
		int pid;
		String user=uid;
		ShoppingCart cart = new ShoppingCart();
		cartControl.newCart(uid, cart);
		do{
			System.out.println("Available products are:");
			for(Object obj: control.getAll(EntityType.Product)){
				Product s = (Product)obj;
				System.out.println("Id= "+s.getId()+" name= "+s.getName()+" price= "+s.getPrice());
			}
			System.out.println("Your cart:");
			if(cartControl.getList(user).size() > 0 ){
			displayCart(cartControl.getList(user));
			System.out.println("\t\t\t\t\t\t\tTotal Price="+cartControl.getTotPrice(uid));
			} else {
				System.out.println("No product");
			}
			System.out.println("1.Add product");
			System.out.println("2.Remove product");
			System.out.println("3.Checkout");
			System.out.println("4.Return without Checkout");
			choice = input.nextInt();
			switch(choice){
			case 1:
				System.out.println("Enter product id and quantity");
				pid = input.nextInt();
				quantity = input.nextInt();
				System.out.println(cartControl.addToCart(user, pid, quantity));
				break;
			case 2:
				System.out.println("Enter product id to be removed");
				pid = input.nextInt();
				System.out.println(cartControl.removeFromCart(uid, pid));
				break;
			case 3:
				cartControl.removeCart(uid);
				return;
			case 4:
				return;
			default:
				System.out.println("Enter valid choice");
			}
		} while(true);
		
		
	}
	private void displayCart(Map<Product, Integer> list) {
		int count = 0;
		System.out.println("SlNo.\t\tName\t\tPrice\t\tQuantity");
		for(Entry<Product, Integer> m : list.entrySet()){
			System.out.println((count++) + "\t\t" +m.getKey().getName()+ "\t\t" +m.getKey().getPrice()+ "\t\t" +m.getValue());
		}
		
	}
}
