package br.com.main.fatec;

import br.com.business.fatec.Controller;
import br.com.business.fatec.Menu;
import br.com.model.fatec.Options;

public class Main {

	public static void main(String[] args) {
		Menu menu = new Menu();
		Options optionControl = new Options();
		int op = 0;
		do{
			menu.ShowMenu();
			Controller controle = new Controller();
			op = controle.opcao();
			switch (op) {
			case 1:
				optionControl.createClient();
				break;
			case 2:
				optionControl.createVehicle();
			case 3:
			case 5:
			case 6:
			case 7:
			default:
				menu.ShowMenu();
			}
		 }while(op != 0);
	}

}
