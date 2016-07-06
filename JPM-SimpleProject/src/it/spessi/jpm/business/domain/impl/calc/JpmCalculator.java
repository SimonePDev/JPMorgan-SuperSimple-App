package it.spessi.jpm.business.domain.impl.calc;

import it.spessi.jpm.persistenceSurrogate.domain.ifaces.IGBCEStock;
import it.spessi.jpm.util.Result;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Simone
 * */
public class JpmCalculator extends BaseJpmCalculator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<IGBCEStock> allStockList = new ArrayList<IGBCEStock>();
	

	public JpmCalculator(List<IGBCEStock> allStockList, IGBCEStock selectedStock)
			throws Exception {
		super(selectedStock);
		if (allStockList == null || allStockList.isEmpty())
			throw new Exception("You cannot pass me an ampty List!!!");
		if (selectedStock == null || selectedStock.isEmpty())
			throw new Exception("You have to select one stock, mate!!!");
		this.allStockList = allStockList;
		this.selectedStock = selectedStock;

	}

	/**
	 * it was not mandatory to have a finally block in this case, but i just
	 * added it to show how it is used
	 * 
	 * @return
	 */
	public Result calculateGbceAllShareIndex() {
		Result result = new Result();
		String message = "";
		double calculationResult = 0d;
		int numberOfPrices = 0;
		try {
			numberOfPrices = allStockList.size();
			double sum = 1d;
			for (IGBCEStock igbceData : allStockList) {
				sum *= igbceData.getTickerPrice();
			}
			calculationResult = Math.pow(sum, (1d / numberOfPrices));
			message = "everything ok";
		} catch (Exception e) {
			e.printStackTrace();
			message = "everything wrong" + e.getMessage();
		} finally {
			result.setMessage(message);
			result.setResult(calculationResult);
		}
		return result;
	}

	/**
	 * 
	 * @return
	 */
	public Result calculateDividendYeldForSingleStock() {
		Result result = new Result();
		String message = "";
		double calculationResult = 0d;
		try {
			calculationResult = selectedStock.calculateDividendYeld();
			message = "Everything Ok, Dude";
		} catch (Exception e) {

		} finally {
			result.setMessage(message);
			result.setResult(calculationResult);
		}
		return result;
	}

	/**
	 * 
	 * @return
	 */
	public Result calculatePeRatioSingleStock() {
		Result result = new Result();
		String message = "";
		double calculationResult = 0d;
		try {
			calculationResult = selectedStock.calculatePERatio();
			message = "Everything Ok, Dude";
		} catch (Exception e) {

		} finally {
			result.setMessage(message);
			result.setResult(calculationResult);
		}
		return result;
	}

	@Override
	public String toString() {
		return String.format(
				"JpmCalculator [allStockList=%s, selectedStock=%s]",
				allStockList, selectedStock);
	}

}
