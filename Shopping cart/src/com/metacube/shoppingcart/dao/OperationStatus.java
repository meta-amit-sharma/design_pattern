package com.metacube.shoppingcart.dao;

/**
 * stores the status of operatio0n being performed as a data member
 * 
 * @author Amit Sharma
 *
 */
public enum OperationStatus {
	Product_added,
	Product_removed,
	No_such_product_found,
	Update_successfull,
	Duplicate_User_Exist,
	User_removed,
	No_such_User_found,
	User_added, Error,
	Remove_successfull,
	No_such_product_in_your_cart;
}
