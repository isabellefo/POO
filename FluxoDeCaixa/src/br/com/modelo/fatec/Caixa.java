package br.com.modelo.fatec;

import java.text.SimpleDateFormat;
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
	SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
	
	public void cadastrarEntrada() {
		u = login.userLogado();
		
		//Tipo
		System.out.println("Selecione o tipo de entrada:");
		int i = 0;
		if(u.getTipo() == 1) {
			while(i<=1) {
				System.out.println("[ "+ i +" ]"+grupoEPFisica[i]);
				i++;
			}
		}else {
			while(i<=1) {
				System.out.println("[ "+ i +" ]"+grupoEPJuridica[i]);
				i++;
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
			while(i<6) {
				System.out.println("[ "+ i +" ]"+grupoSPFisica[i]);
				i++;
			}
		}else {
			while(i<5) {
				System.out.println("[ "+ i +" ]"+grupoSPJuridica[i]);
				i++;
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
	
	public void imprimirEntrada() {
		for (Entrada entrada : entradas) {
			System.out.println("Usuario: " + entrada.getUsuario().getNome());
			System.out.println("Valor: " + entrada.getValor());
			System.out.println("Data: " + entrada.getData());
			System.out.println("Tipo: " + entrada.getGrupo());
		}
	}
	
	//Funcional
	//Arrumar as saídas(system.out)
	public void relatorioMensal() {
		System.out.println("Digite a data que deseja receber o relatório: (dd/mm/aaaa)");
		String d = scanner.nextLine();
		int m = Integer.parseInt(d.substring(3,5));
		int a = Integer.parseInt(d.substring(6));
		int totalPositivo = 0;
		int totalNegativo = 0;
		for (Entrada entrada : entradas) {
			if((entrada.getData().getMonth()+1 == m)&&(entrada.getData().getYear()+1900 == a)){
				System.out.println(entrada.getGrupo()+ ": " +"R$"+entrada.getValor());
				System.out.println(f.format(entrada.getData()));
				totalPositivo+=entrada.getValor();
			}
		}
		
		for (Saida saida: saidas) {
			if((saida.getData().getMonth()+1 == m)&&(saida.getData().getYear()+1900 == a)){
				System.out.println(saida.getGrupo()+ ": " +"R$"+saida.getValor());
				System.out.println(f.format(saida.getData()));
				totalNegativo+=saida.getValor();
			}
		}
		
		System.out.println("Fluxo do mês: R$"+(totalPositivo-totalNegativo));
		
	}
	
	public void relatorioSemanal() {
		/*System.out.println("Digite a data que deseja receber o relatório: (dd/mm/aaaa)");
		String d = scanner.nextLine();
		for (Entrada entrada : entradas) {
			if(entrada.getData().ge ) {
				
			}
		}*/
	}
	


}
