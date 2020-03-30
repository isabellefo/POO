package br.com.model.fatec;

public class Service {
	private int _serviceID;
	private String _description;
	
	public Service(int serviceID, String description) {
		_serviceID = serviceID;
		_description = description;
	}
	
	public void setId(int serviceID) {
		_serviceID = serviceID;
	}
	
	public int getId() {
		return _serviceID;
	}
	
	public void setDescription(String description) {
		_description = description;
	}
	
	public String getDescription() {
		return _description;
	}
	
	
}
