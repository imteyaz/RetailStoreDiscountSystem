/**
 * 
 */
package com.retail.store;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.retail.store.pojo.ExceptGroceries;
import com.retail.store.pojo.Groceries;
import com.retail.store.pojo.User;
import com.retail.store.util.exception.StoreBillingException;

/**
 * @author Imteyaz Ahmad
 *
 */
public class StoreBillingTest {
	
	static StoreBilling  instance ;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		instance = StoreBilling.getInstance();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		instance = null;
	}

	/**
	 * Test method for {@link com.retail.store.StoreBilling#calculatePayableAmount(double)}.
	 * @throws StoreBillingException 
	 */
	@Test
	public void testCalculatePayableAmountGroceriesItems() throws StoreBillingException {
		Groceries items = new Groceries();
		User user = new User();
		double expected =240;
		double actualPayableAmount = instance.calculatePayableAmount(items, user, 250);
		assertEquals(expected, actualPayableAmount,0.0);
	}
	
	/**
	 * Test method for {@link com.retail.store.StoreBilling#calculatePayableAmount(double)}.
	 * @throws StoreBillingException 
	 */
	@Test
	public void testCalculatePayableAmountExceptGroceriesItemsUserTypeEmployeeOfStore() throws StoreBillingException {
		ExceptGroceries items = new ExceptGroceries();
		User user = new User();
		user.setUserType("EmployeeOfStore");
		double expected =635;
		double actualPayableAmount = instance.calculatePayableAmount(items, user, 950);
		assertEquals(expected, actualPayableAmount,0.0);
	}
	
	/**
	 * Test method for {@link com.retail.store.StoreBilling#calculatePayableAmount(double)}.
	 * @throws StoreBillingException 
	 */
	@Test
	public void testCalculatePayableAmountExceptGroceriesItemsUserTypeAffliateOfStore() throws StoreBillingException {
		ExceptGroceries items = new ExceptGroceries();
		User user = new User();
		user.setUserType("AffliateOfStore");
		double expected =815;
		double actualPayableAmount = instance.calculatePayableAmount(items, user, 950);
		assertEquals(expected, actualPayableAmount,0.0);
	}
	
	@Test
	public void testCalculatePayableAmountExceptGroceriesItemsUserLoyalityPeriod() throws StoreBillingException {
		ExceptGroceries items = new ExceptGroceries();
		User user = new User();
		user.setUserLoyalityPeriod(2.5);
		double expected =677.5;
		double actualPayableAmount = instance.calculatePayableAmount(items, user, 750);
		assertEquals(expected, actualPayableAmount,0.0);
	}
	@Test
	public void testCalculatePayableAmountExceptGroceriesItemsUserTypeAffliateOfStoreUserLoyalityPeriod() throws StoreBillingException {
		ExceptGroceries items = new ExceptGroceries();
		User user = new User();
		user.setUserType("AffliateOfStore");
		user.setUserLoyalityPeriod(2.5);
		double expected =815;
		double actualPayableAmount = instance.calculatePayableAmount(items, user, 950);
		assertEquals(expected, actualPayableAmount,0.0);
	}
	
	@Test
	public void testCalculatePayableAmountExceptGroceriesItemsUserTypeEmployeeOfStoreUserLoyalityPeriod() throws StoreBillingException {
		ExceptGroceries items = new ExceptGroceries();
		User user = new User();
		user.setUserType("EmployeeOfStore");
		user.setUserLoyalityPeriod(2.5);
		double expected =635;
		double actualPayableAmount = instance.calculatePayableAmount(items, user, 950);
		assertEquals(expected, actualPayableAmount,0.0);
	}

}
