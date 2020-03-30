package br.com.modelo.fatec;

import java.util.ArrayList;
import java.util.Scanner;

public class Caixa {
	
	private String[] grupoPFisica = {"Salario", "Investimento"};
	private String[] grupoPJuridica = {"Receitas de vendas", "Investimento"};
	Login login = new Login();
	Usuario u;
	Scanner scanner = new Scanner(System.in);
	ArrayList<Entrada> entradas = new ArrayList<Entrada>();
	
	public void cadastrarEntrada() {
		u = login.userLogado();
		
		//Tipo
		System.out.println("Selecione o tipo de entrada:");
		int i = 0;
		if(u.getTipo() == 1) {
			while(i<=1) {
				System.out.println(grupoPFisica[i]);
			}
		}else {
			while(i<=1) {
				System.out.println(grupoPJuridica[i]);
			}
		}
		int t = Integer.parseInt(scanner.nextLine());
		
		//Valor
		System.out.println("Digite o valor:");
		double v = Double.parseDouble(scanner.nextLine());
		
		//Data
		System.out.println("Digite a data:");
		String d = scanner.nextLine();
		
		Entrada entrada = new Entrada(u, v, d, t);
		
		entradas.add(entrada);
		
	}
	


}
