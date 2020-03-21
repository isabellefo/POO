package br.com.model.fatec;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Schedule {

	private String _service;
	private Date _date;
	
	public Schedule(String service, String date) {
		_service  = service;
		try {
			_date = new SimpleDateFormat("dd/MM/yyyy").parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Date get_date() {
		return _date;
	}
	
	public String get_service() {
		return _service;
	}
	
	public void set_date(Date date) {
		this._date = date;
	}
	
	public void set_service(String service) {
		this._service = service;
	}
	

}
