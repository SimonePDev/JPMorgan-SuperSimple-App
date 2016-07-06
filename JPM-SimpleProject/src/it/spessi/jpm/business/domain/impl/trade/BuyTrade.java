package it.spessi.jpm.business.domain.impl.trade;

import it.spessi.jpm.persistenceSurrogate.domain.ifaces.IGBCEStock;
import it.spessi.jpm.util.enumerators.EnumTradeType;

public class BuyTrade extends BaseTrade {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BuyTrade(int quantity, IGBCEStock stock) {
		super(quantity, stock);
		super.buySellIndicator = EnumTradeType.BUY;
	}

	@Override
	public String toString() {
		return String
				.format("BuyTrade [transactionDate=%s, quantity=%s, buySellIndicator=%s, stock=%s]",
						transactionDate, quantity, buySellIndicator, stock);
	}

}
