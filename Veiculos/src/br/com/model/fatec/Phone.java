package br.com.model.fatec;

public class Phone {
	private String _number;
	
	public Phone(String number) {
		_number = number;
	}
	
	public String getNumber() {
		String n = _number;
		if(this._number.length() == 9) {
			n = this._number.substring(0, 5) + "-";
			n += this._number.substring(5);
		}else if(this._number.length() == 9) {
			n = this._number.substring(0, 4) + "-";
			n += this._number.substring(4);
		}
		
		return n;
	}
	
	public void setNumber(String number) {
		_number = number;
	}
}
