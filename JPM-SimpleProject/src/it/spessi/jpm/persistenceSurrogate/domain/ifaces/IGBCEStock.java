package it.spessi.jpm.persistenceSurrogate.domain.ifaces;

public interface IGBCEStock {

	public String toString();

	public double calculateDividendYeld();

	public double calculatePERatio();
	
	public double getTickerPrice();
	
	public boolean isEmpty();

}
