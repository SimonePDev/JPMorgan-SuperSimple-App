package it.spessi.jpm.business.domain.impl.trade;

import it.spessi.jpm.business.domain.ifaces.trade.ITrade;
import it.spessi.jpm.persistenceSurrogate.domain.ifaces.IGBCEStock;
import it.spessi.jpm.util.enumerators.EnumTradeType;

import java.io.Serializable;
import java.util.Date;

public abstract class BaseTrade implements ITrade,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Date transactionDate;
	protected int quantity;
	protected EnumTradeType buySellIndicator; // it will be use for calculation -- noone can set this attribute
	protected IGBCEStock stock;
	
	
	/**
	 * we should not permit the use to set the datetime of trnsaction. when he does it, the time is registered 
	 * @param quantity
	 * @param price
	 */
	public BaseTrade(int quantity, IGBCEStock stock) {
		super();
		transactionDate = new Date();
		this.quantity = quantity;
		this.stock = stock;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public EnumTradeType getBuySellIndicator() {
		return buySellIndicator;
	}

	public IGBCEStock getStock() {
		return stock;
	}

	public void setStock(IGBCEStock stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return String
				.format("BaseTrade [transactionDate=%s, quantity=%s, buySellIndicator=%s, price=%s]",
						transactionDate, quantity, buySellIndicator, stock);
	}
	
	public double calculateTotalPrice(){
		return (quantity*stock.getTickerPrice())*buySellIndicator.getTradeTypeIndicator();
	}

}
