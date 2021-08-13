package br.com.luizgcl.market.backend;

public interface Database {
	
	/*
	 * Connection Manager
	 */
	
	void connect() throws Exception;
	
	boolean isConnected();
	
	void close();
	
}
