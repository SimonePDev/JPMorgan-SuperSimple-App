package it.spessi.jpm.persistenceSurrogate.domain.impl;

import it.spessi.jpm.util.enumerators.EnumGBCEType;

public class GBCEStockCommon extends BaseGBCEStock {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final EnumGBCEType enumGBCEType = EnumGBCEType.COMMON;

	public GBCEStockCommon(String stockSymbol, double lastDividend,
			double parValue, double tickerPrice) {
		super(stockSymbol, lastDividend, parValue, tickerPrice);

	}

	public static EnumGBCEType getEnumgbcetype() {
		return enumGBCEType;
	}

	@Override
	public double calculateDividendYeld() {
		return this.lastDividend / tickerPrice;
	}

}
