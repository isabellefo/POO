package br.com.model.fatec;

public class Vehicle {
	private String _plateNumber;
	private String _version;
	private int _yearManufacture;
	private double _value;
	
	public Vehicle(String plateNumber, String version, int yearManufacture, double value) {
		_plateNumber = plateNumber;
		_version = version;
		_yearManufacture = yearManufacture;
		_value = value;
	}
	
	public void setPlateNumber(String plateNumber) {
		_plateNumber = plateNumber;
	}
	
	public String getPlateNumber() {
		return _plateNumber;
	}
	
	public void setVersion(String version) {
		_version = version;
	}
	
	public String getVersion() {
		return _version;
	}
	
	public void setYearManufacture(int yearManufacture) {
		_yearManufacture = yearManufacture;
	}
	
	public int getYearManufacture() {
		return _yearManufacture;
	}
	
	public void setValue(double value) {
		_value = value;
	}
	
	public double getValue() {
		return _value;
	}
}
