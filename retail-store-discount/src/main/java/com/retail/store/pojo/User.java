package com.retail.store.pojo;

import java.io.Serializable;

public class User implements Serializable{

	private static final long serialVersionUID = 22597196809987683L;
	
	private String userType;
	
	private double userLoyalityPeriod;

	/**
	 * @return the userType
	 */
	public String getUserType() {
		return userType;
	}

	/**
	 * @param userType the userType to set
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}

	/**
	 * @return the userLoyalityPeriod
	 */
	public double getUserLoyalityPeriod() {
		return userLoyalityPeriod;
	}

	/**
	 * @param userLoyalityPeriod the userLoyalityPeriod to set
	 */
	public void setUserLoyalityPeriod(double userLoyalityPeriod) {
		this.userLoyalityPeriod = userLoyalityPeriod;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [userType=" + userType + ", userLoyalityPeriod=" + userLoyalityPeriod + "]";
	}

}
