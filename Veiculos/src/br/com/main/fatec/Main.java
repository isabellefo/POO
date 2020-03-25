package br.com.main.fatec;

import br.com.business.fatec.Controller;
import br.com.business.fatec.Menu;
import br.com.model.fatec.Options;

public class Main {

	//Arrumar menu. Provisório para testes
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
				break;
			case 3:
				optionControl.createService();
				break;
			case 4:
				optionControl.scheduleReview();
				break;
			case 7:
				//PROVISÓRIO
				optionControl.printSchedule();
				break;
			case 5:
				optionControl.changeSchedule();
				break;
			case 6:
				optionControl.deleteSchedule();
				break;
			default:
				menu.ShowMenu();
			}
		 }while(op != 0);
	}

}
