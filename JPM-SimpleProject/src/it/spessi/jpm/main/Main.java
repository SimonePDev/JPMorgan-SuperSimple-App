/**
 * 
 */
package it.spessi.jpm.main;

import it.spessi.jpm.business.domain.impl.calc.JpmCalculator;
import it.spessi.jpm.business.domain.impl.calc.RunnableJpmCalculator;
import it.spessi.jpm.persistenceSurrogate.dao.ifaces.IGBCEDataDAO;
import it.spessi.jpm.persistenceSurrogate.dao.impl.GBCEDataDAOImpl;
import it.spessi.jpm.persistenceSurrogate.domain.ifaces.IGBCEStock;
import it.spessi.jpm.util.Result;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author Simone
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			IGBCEDataDAO dao = new GBCEDataDAOImpl();
			List<IGBCEStock> allStocksList = dao.retrieveAllAsList();
			HashMap<String, IGBCEStock> retrieveAllAsHAshMap = dao.retrieveAllAsHAshMap();
			IGBCEStock selectedStock = retrieveAllAsHAshMap.get("GIN");
			JpmCalculator calculator = new JpmCalculator(allStocksList, selectedStock);
			Result dividendYeld = calculator.calculateDividendYeldForSingleStock();
			Result calculateGbceAllShareIndex = calculator.calculateGbceAllShareIndex();
			Result calculatePeRatioSingleStock = calculator.calculatePeRatioSingleStock();
			System.out.println("Dividend yeld calculation: "+dividendYeld.toString());
			System.out.println("GBCE All Shares"+calculateGbceAllShareIndex.toString());
			System.out.println("PE Ratio"+calculatePeRatioSingleStock.toString());
			
			System.out.println("Starting price schedulation");
			RunnableJpmCalculator helloRunnable = new RunnableJpmCalculator(selectedStock,3);
			ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
			executor.scheduleAtFixedRate(helloRunnable, 0, 20, TimeUnit.SECONDS);
		}catch(Exception e){
			System.out.println( "something gone really wrong " +e);
		}
	}

}
