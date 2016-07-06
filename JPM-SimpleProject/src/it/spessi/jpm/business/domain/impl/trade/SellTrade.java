package it.spessi.jpm.business.domain.impl.trade;

import it.spessi.jpm.persistenceSurrogate.domain.ifaces.IGBCEStock;
import it.spessi.jpm.util.enumerators.EnumTradeType;

public class SellTrade extends BaseTrade {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SellTrade(int quantity, IGBCEStock stock) {
		super(quantity, stock);
		super.buySellIndicator = EnumTradeType.SELL;
	}

	@Override
	public String toString() {
		return String
				.format("SellTrade [transactionDate=%s, quantity=%s, buySellIndicator=%s, stock=%s]",
						transactionDate, quantity, buySellIndicator, stock);
	}

}
