package it.spessi.jpm.util.enumerators;

import java.io.Serializable;

public enum EnumTradeType implements Serializable {
	
	BUY(1),
	SELL(-1);
	
	
	int tradeTypeIndicator;
	EnumTradeType(int tradeTypeIndicator){
		this.tradeTypeIndicator = tradeTypeIndicator;
	}
	public int getTradeTypeIndicator() {
		return tradeTypeIndicator;
	}
}
