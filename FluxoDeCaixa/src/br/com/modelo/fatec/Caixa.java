package br.com.modelo.fatec;

import java.util.ArrayList;
import java.util.Scanner;

public class Caixa {
	
	private String[] grupoEPFisica = {"Salario", "Investimento"};
	private String[] grupoEPJuridica = {"Receitas de vendas", "Investimento"};
	private String[] grupoSPFisica = {"Energia", "Gás","Alimentação em casa", "Alimentação fora de casa", "Locomoção", "Outros"};
	private String[] grupoSPJuridica = {"Energia", "Gás","Alimentação interna", "Locomoção", "Outros"};
	Login login = new Login();
	Usuario u;
	Scanner scanner = new Scanner(System.in);
	ArrayList<Entrada> entradas = new ArrayList<Entrada>();
	ArrayList<Saida> saidas = new ArrayList<Saida>();
	
	public void cadastrarEntrada() {
		u = login.userLogado();
		
		//Tipo
		System.out.println("Selecione o tipo de entrada:");
		int i = 0;
		if(u.getTipo() == 1) {
			while(i<=1) {
				System.out.println(grupoEPFisica[i]);
			}
		}else {
			while(i<=1) {
				System.out.println(grupoEPJuridica[i]);
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
	
	public void cadastrarSaida() {
		u = login.userLogado();
		
		//Tipo
		System.out.println("Selecione o tipo de entrada:");
		int i = 0;
		if(u.getTipo() == 1) {
			while(i<=1) {
				System.out.println(grupoSPFisica[i]);
			}
		}else {
			while(i<=1) {
				System.out.println(grupoSPJuridica[i]);
			}
		}
		int t = Integer.parseInt(scanner.nextLine());
		
		//Valor
		System.out.println("Digite o valor:");
		double v = Double.parseDouble(scanner.nextLine());
		
		//Data
		System.out.println("Digite a data:");
		String d = scanner.nextLine();
		
		Saida saida = new Saida(u, v, d, t);
		
		saidas.add(saida);
		
	}
	


}
