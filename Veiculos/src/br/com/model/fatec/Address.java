package br.com.model.fatec;

public class Address {
	private String _city;
	private String _street;
	private String _neighborhood;
	private String _state;
	private String _cep;
	
	public Address(String city,String street,String neighborhood, String state, String cep) {
		_city = city;
		_street = street;
		_neighborhood = neighborhood;
		_state = state;
		_cep = cep;
	}
	
	public String getCity() {
		return _city;
	}
	
	public void setCity(String city) {
		_city= city;
	}
	
	public String getStreet() {
		return _street;
	}
	
	public void setStreet(String street) {
		_street = street;
	}
	
	public String getNeighborhood() {
		return _neighborhood;
	}
	
	public void setNeighborhood(String neighborhood) {
		_neighborhood = neighborhood;
	}
	
	public String getState() {
		return _state;
	}
	
	public void setState(String state) {
		_state= state;
	}
	
	public String getCep() {
		return _cep;
	}
	
	public void setCep(String cep) {
		_cep= cep;
	}
}
