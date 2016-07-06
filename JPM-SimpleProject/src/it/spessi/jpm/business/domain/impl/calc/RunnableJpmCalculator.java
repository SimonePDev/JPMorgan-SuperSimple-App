package it.spessi.jpm.business.domain.impl.calc;

import it.spessi.jpm.business.domain.ifaces.trade.ITrade;
import it.spessi.jpm.business.domain.impl.trade.BuyTrade;
import it.spessi.jpm.business.domain.impl.trade.SellTrade;
import it.spessi.jpm.persistenceSurrogate.domain.ifaces.IGBCEStock;
import it.spessi.jpm.util.DateUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class RunnableJpmCalculator extends BaseJpmCalculator implements
		Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<ITrade> lastFifteenMinsTradeList = new ArrayList<ITrade>();
	private double summatoryQuantityPerPrice = 0d;
	private double summatoryQuantity = 0d;
	private int howMuchTimeHasTopPassBeforCalc = 0;

	/**
	 * the time must be expressed in minutes
	 * 
	 * @param selectedStock
	 * @param howMuchTimeHasTopPassBeforCalc
	 */
	public RunnableJpmCalculator(IGBCEStock selectedStock,
			int howMuchTimeHasTopPassBeforCalc) {
		super(selectedStock);
		this.howMuchTimeHasTopPassBeforCalc = howMuchTimeHasTopPassBeforCalc;
	}

	public double getSummatoryQuantityPerPrice() {
		return summatoryQuantityPerPrice;
	}

	public void setSummatoryQuantityPerPrice(double summatoryQuantityPerPrice) {
		this.summatoryQuantityPerPrice = summatoryQuantityPerPrice;
	}

	public double getSummatoryQuantity() {
		return summatoryQuantity;
	}

	public void setSummatoryQuantity(double summatoryQuantity) {
		this.summatoryQuantity = summatoryQuantity;
	}

	public List<ITrade> getLastFifteenMinsTradeList() {
		return lastFifteenMinsTradeList;
	}

	public void setLastFifteenMinsTradeList(
			List<ITrade> lastFifteenMinsTradeList) {
		this.lastFifteenMinsTradeList = lastFifteenMinsTradeList;
	}

	public int getHowMuchTimeHasTopPassBeforCalc() {
		return howMuchTimeHasTopPassBeforCalc;
	}

	public void setHowMuchTimeHasTopPassBeforCalc(
			int howMuchTimeHasTopPassBeforCalc) {
		this.howMuchTimeHasTopPassBeforCalc = howMuchTimeHasTopPassBeforCalc;
	}

	@Override
	public void run() {

		double buySellGEnerator = Math.random() * 10;
		ITrade trade;
		if (buySellGEnerator > 5) {
			trade = new BuyTrade((int) (Math.random() * 100), selectedStock);
		} else {
			trade = new SellTrade((int) (Math.random() * 100), selectedStock);
		}
		lastFifteenMinsTradeList.add(trade);
		summatoryQuantity += trade.getQuantity();
		summatoryQuantityPerPrice += trade.calculateTotalPrice();
		System.out.println("trade registered: " + trade.toString());

		// if true, calculates stock price and then empty the list and
		// calculations
		if (lastFifteenMinsTradeList.size() > 1
				&& DateUtil.isPAssedGivenTimeRange(lastFifteenMinsTradeList
						.get(0).getTransactionDate(), trade
						.getTransactionDate(), howMuchTimeHasTopPassBeforCalc,
						TimeUnit.MINUTES)) {
			double stockPrice = summatoryQuantityPerPrice / summatoryQuantity;
			System.out.println("here it is your stock price "
					+ Math.abs(stockPrice));
			lastFifteenMinsTradeList = new ArrayList<ITrade>();
			summatoryQuantityPerPrice = 0d;
			summatoryQuantity = 0d;
		}
	}
}
