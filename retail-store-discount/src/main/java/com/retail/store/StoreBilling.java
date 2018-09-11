package com.retail.store;

import com.retail.store.pojo.ExceptGroceries;
import com.retail.store.pojo.User;
import com.retail.store.util.ClassNameEnum;
import com.retail.store.util.exception.ErrorCode;
import com.retail.store.util.exception.StoreBillingException;
import com.retail.store.util.logging.StoreBillingLogger;
import com.retail.store.util.logging.StoreBillingLogger.LOG_LEVEL;

/**
 * Singleton main class of the StoreBilling .
 * 
 * @author Imteyaz Ahmad
 *
 */
public class StoreBilling {

	private static StoreBillingLogger logger = new StoreBillingLogger(StoreBilling.class);
	
	/**
	 * singleton instance of the StoreBilling
	 */
	private static final StoreBilling INSTANCE = new StoreBilling();

	private StoreBilling() {
	}

	/**
	 * Provides the StoreBilling instance
	 * 
	 * @return StoreBilling
	 */
	public static StoreBilling getInstance() {
		return INSTANCE;
	}
	
	public double calculatePayableAmount(Object items, User user, double amount) throws StoreBillingException {

		try {
		Double discount = calculateDiscount(items, user, amount);
		double billAmount = amount - discount;

		if (billAmount >= 100) {
			discount = billAmount/100;
			int dis= discount.intValue();
			 
			discount = dis*5.0;
		}
		logger.logMsg(LOG_LEVEL.INFO, "", "Net Payable Amount" + (billAmount - discount));
		return (billAmount - discount);
		}catch(Exception exe) {
			throw new StoreBillingException(ErrorCode.BILLING_EXCEPTION,"Exception occured while processing bill");
		}
		
	}

	private static double calculateDiscount(Object items, User user, double amount) {
		double discount = 0.0;
		ClassNameEnum className = ClassNameEnum.valueOf(items.getClass().getSimpleName());

		switch (className) {
		case Groceries:
			discount = 0.0;
			break;
		case ExceptGroceries:
			if(user != null) {
				if(user.getUserType()!=null) {
					if (user.getUserType().equalsIgnoreCase("EmployeeOfStore")) {
						return discount = amount * .3;
					} else if (user.getUserType().equalsIgnoreCase("AffliateOfStore")) {
						return discount = amount * .1;
					}
				} else if (user.getUserLoyalityPeriod() >= 2) {
					discount = amount * .05;
				}
			}
			break;
		default:
			discount = 0.0;
			break;
		}
		return discount;
	}
	
	public static void main(String[] args) throws StoreBillingException {
		ExceptGroceries items = new ExceptGroceries();
		User user = new User();
		user.setUserType("EmployeeOfStore");
		StoreBilling.getInstance().calculatePayableAmount(items, user, 960);
	}
}
