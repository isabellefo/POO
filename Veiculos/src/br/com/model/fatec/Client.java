package br.com.model.fatec;

public class Client {
	private String _name;
	private Phone _phone;
	private Address _address;
	private String _cpf;
	private int _idClient;
	
	private Vehicle _vehicle;
	
	public Client(String name, Phone phone, Address address, String cpf) {
		_name = name;
		_phone = phone;
		_address = address;
		_cpf = cpf;
	}
	
	public void setName(String name) {
		_name=name;
	}
	
	public String getName() {
		return _name;
	}
	
	public Phone getPhone() {
		return _phone;
	}
	
	public void setPhone(Phone phone) {
		_phone = phone;
	}
	
	public Address getAddress() {
		return _address;
	}
	
	public void setAddress(Address address) {
		_address = address;
	}
	
	public String getCpf() {
		return _cpf;
	}
	
	public void setCpf(String cpf) {
		_cpf=cpf;
	}
	
	public void setVehicle(Vehicle vehicle) {
		_vehicle = vehicle;
	}
	
	public Vehicle getVehicle() {
		return _vehicle;
		
	}
	
	public int getIdClient() {
		return _idClient;
	}
	
	public void setIdClient(int idClient) {
		this._idClient = idClient;
	}
	
}
