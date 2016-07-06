package it.spessi.jpm.business.domain.ifaces.trade;

import java.util.Date;

public interface ITrade {
	
	public Date getTransactionDate();
	
	public String toString();
	
	public double calculateTotalPrice();
	
	public int getQuantity();

}
