package it.spessi.jpm.persistenceSurrogate.domain.impl;

import it.spessi.jpm.persistenceSurrogate.domain.ifaces.IGBCEStock;

import java.io.Serializable;

/**
 * 
 * @author Simone
 *
 */
public abstract class BaseGBCEStock implements IGBCEStock, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String stockSymbol = null;;
	protected double lastDividend = Double.MIN_VALUE;
	protected double parValue = Double.MIN_VALUE;
	protected double tickerPrice = Double.MIN_VALUE;
	
	

	public BaseGBCEStock(String stockSymbol, double lastDividend,
			double parValue, double tickerPrice) {
		super();
		this.stockSymbol = stockSymbol;
		this.lastDividend = lastDividend;
		this.parValue = parValue;
		this.tickerPrice = tickerPrice;
	}

	public String getStockSymbol() {
		return stockSymbol;
	}

	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}

	public double getLastDividend() {
		return lastDividend;
	}

	public void setLastDividend(double lastDividend) {
		this.lastDividend = lastDividend;
	}

	public double getParValue() {
		return parValue;
	}

	public void setParValue(double parValue) {
		this.parValue = parValue;
	}

	public double getTickerPrice() {
		return tickerPrice;
	}

	public void setTickerPrice(double tickerPrice) {
		this.tickerPrice = tickerPrice;
	}
	
	
	
	@Override
	public double calculatePERatio() {
		return tickerPrice/(lastDividend==0?1d:lastDividend);
	}

	@Override
	public String toString() {
		return "BaseGBCEData [stockSymbol=" + stockSymbol + ", lastDividend="
				+ lastDividend + ", parValue=" + parValue + ", toString()="
				+ super.toString() + "]";
	}
	
	@Override
	public boolean isEmpty() {
		return stockSymbol == null || lastDividend == Double.MIN_VALUE || parValue == Double.MIN_VALUE || tickerPrice == Double.MIN_VALUE;
	}

}
