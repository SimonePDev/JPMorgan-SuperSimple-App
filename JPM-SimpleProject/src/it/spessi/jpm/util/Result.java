package it.spessi.jpm.util;

import java.io.Serializable;

public class Result implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	private double calculationResult;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public double getResult() {
		return calculationResult;
	}

	public void setResult(double result) {
		this.calculationResult = result;
	}

	@Override
	public String toString() {
		return String.format("Result [message=%s, result=%s]", message, calculationResult);
	}

}
