package br.com.model.fatec;

public class Address {
	private String _neighborhood;
	
	public Address(String neighborhood) {
		_neighborhood = neighborhood;
	}
	
	public String getNeighborhood() {
		return _neighborhood;
	}
	
	public void setNeighborhood(String neighborhood) {
		_neighborhood = neighborhood;
	}
}
