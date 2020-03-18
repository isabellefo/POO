package br.com.model.fatec;

public class Phone {
	private String _number;
	
	public Phone(String number) {
		_number = number;
	}
	
	public String getNumber() {
		String n = _number.substring(0, 5) + "-";
		n += _number.substring(5);
		return n;
	}
	
	public void setNumber(String number) {
		_number = number;
	}
}
