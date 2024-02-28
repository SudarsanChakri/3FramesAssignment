package com.threeframes.assignment.productapplication;

import java.util.*;

import java.util.stream.Collectors;

public class ProductConfiguration {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		boolean status = true;
		//The loop continues functioning as long as the user presses enter to exit
		while(status==true) {
			System.out.println("Choose required activity");
			System.out.println("1.Add Product 2.Search Product");
			System.out.println("Press enter to exit");
			String choose = scan.nextLine();
			//loop exits if user presses exit key
			if(choose.equals("")) {
				status = false;	
				break;
			}

			//Comes inside if user chooses any function instead of exit
			if(choose.equals("1")) {
				//Code when user selects to add product
				
				//Receiving all the details about product
				System.out.println("Enter product's id");
				String id = scan.nextLine();
				System.out.println("Enter product's name");
				String name = scan.nextLine();
				System.out.println("Enter product's category");
				String category = scan.nextLine();
				System.out.println("Enter product's price");
				int price = scan.nextInt();
				System.out.println("Enter some short description");
				String description = scan.nextLine();
				
				//invoking the method to add the product object
				addProduct(id, name, category, price, description);
			}
			else if(choose.equals("2")) {
				//Code when user selects to search products
				System.out.println("Enter text to search");
				String searchText = scan.nextLine();
				
				//This method receives all the products those are related to the search
				List<Product> searchResults = searchByText(searchText);
				System.out.println("Search Results: " + searchResults);
			}
			else {
				System.out.println("Invalid Selection");
			}
		}
	}


	static List<Product> products = new ArrayList<Product>();
	
	//Method to add product
	public static void addProduct(String id, String name, String category, int price, String description) {
		System.out.println("Coming inside add");
		Product productDetails = new Product();
		productDetails.setId(id);
		productDetails.setName(name);
		productDetails.setCategory(category);
		productDetails.setPrice(price);
		productDetails.setDescription(description);
		products.add(productDetails);
	}


	//Method to search and get related products 
	public static List<Product> searchByText(String searchText) {
		List<Product> op = new ArrayList<Product>();
		//Transversing through the products
		for(Product product : products) {
			//checking for the text match
			if(product.getCategory().toLowerCase().contains(searchText.toLowerCase()) ||
					product.getName().toLowerCase().contains(searchText.toLowerCase()) ||
					product.getDescription().toLowerCase().contains(searchText.toLowerCase())) {
				op.add(product);
			}
		}
		//returns all the products related to search
		return op;
	}
}
