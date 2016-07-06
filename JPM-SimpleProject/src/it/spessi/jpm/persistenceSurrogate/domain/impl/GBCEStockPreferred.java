package it.spessi.jpm.persistenceSurrogate.domain.impl;

import it.spessi.jpm.util.enumerators.EnumGBCEType;

public class GBCEStockPreferred extends BaseGBCEStock {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final EnumGBCEType enumGBCEType = EnumGBCEType.PREFERRED;

	private double fixedDividend = Double.MIN_VALUE;
	
	public GBCEStockPreferred(String stockSymbol, double lastDividend,
			double parValue, double tickerPrice, double fixedDividend) {
		super(stockSymbol, lastDividend, parValue, tickerPrice);
		this.fixedDividend = fixedDividend;
	}

	public double getFixedDividend() {
		return fixedDividend;
	}

	public void setFixedDividend(double fixedDividend) {
		this.fixedDividend = fixedDividend;
	}

	public static EnumGBCEType getEnumgbcetype() {
		return enumGBCEType;
	}

	@Override
	public double calculateDividendYeld() {
		return ((fixedDividend / 100) * parValue) / tickerPrice;
	}

	@Override
	public boolean isEmpty() {
		return super.isEmpty() || fixedDividend == Double.MIN_VALUE;
	}

	@Override
	public String toString() {
		return String
				.format("GBCEStockPreferred [fixedDividend=%s, lastDividend=%s, parValue=%s, tickerPrice=%s]",
						fixedDividend, lastDividend, parValue, tickerPrice);
	}

	

}
