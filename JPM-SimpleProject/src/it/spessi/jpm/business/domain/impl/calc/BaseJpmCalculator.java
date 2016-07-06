package it.spessi.jpm.business.domain.impl.calc;

import it.spessi.jpm.persistenceSurrogate.domain.ifaces.IGBCEStock;

import java.io.Serializable;

public abstract class BaseJpmCalculator implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected IGBCEStock selectedStock;

	
	/**
	 * An abstract class cannot be instanciated, so i declare all the blase classes that i do not want to be instanciated as abstract   
	 * @param selectedStock
	 */
	public BaseJpmCalculator(IGBCEStock selectedStock) {
		super();
		this.selectedStock = selectedStock;
	}

}
