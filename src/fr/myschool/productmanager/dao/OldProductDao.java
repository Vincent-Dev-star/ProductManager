package fr.myschool.productmanager.dao;

import java.util.ArrayList;
 	import java.util.List;

import fr.myschool.productmanager.entity.Product;

public class OldProductDao {

 public static ArrayList<Product> products = new ArrayList<Product>();
	

	public static List<Product> getAllProducts(){
		return products;
	}
	
	public static void addProduct(Product p){
		
		products.add(p);
	
	}
	
	public static Product findProduct(long id){
		for(Product product : products ){
			if(product.getId().equals(id)) {
				return product;
			}
		}
		return null;
	}
	
	public static void removeProduct(long id){

		Product product = findProduct(id);
		products.remove(product);

	}
}

