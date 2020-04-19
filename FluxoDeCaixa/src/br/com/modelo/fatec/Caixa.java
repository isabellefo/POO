package br.com.modelo.fatec;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

import br.com.negocio.fatec.Menu;

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
		System.out.println("Digite a data: (dd/mm/aaaa)");
		String d = scanner.nextLine();
		
		Entrada entrada = new Entrada(u, v, d, t);
		
		entradas.add(entrada);
		System.out.println("Nova entrada cadastrada!");
		
	}
	
	public void cadastrarSaida() {
		u = login.userLogado();
		
		//Tipo
		System.out.println("Selecione o tipo de saída:");
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
		System.out.println("Nova saída cadastrada!");
		
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
	//Relatório mensal
	public void relatorioMensal() {
		System.out.println("Digite o mês e o ano do relatório: (mm/aaaa)");
		String d = scanner.nextLine();
		int m = Integer.parseInt(d.substring(0,2));
		int a = Integer.parseInt(d.substring(3));
		double totalPMensal = 0;
		double totalNMensal = 0;
		System.out.println("|--------RELATÓRIO MENSAL--------|");
		System.out.println("----ENTRADA----");
		for (Entrada entrada : entradas) {
			if((entrada.getData().getMonth()+1 == m)&&(entrada.getData().getYear()+1900 == a)){
				if(u.getTipo() == 1)
					System.out.println(grupoEPFisica[entrada.getGrupo()]+ ": " +"R$"+entrada.getValor());
				else
					System.out.println(grupoEPJuridica[entrada.getGrupo()]+ ": " +"R$"+entrada.getValor());
				System.out.println("Data: " + f.format(entrada.getData())+ "\n");
				totalPMensal+=entrada.getValor();
			}
		}
		
		System.out.println("\n----SAIDA----");
		for (Saida saida: saidas) {
			if((saida.getData().getMonth()+1 == m)&&(saida.getData().getYear()+1900 == a)){
				if(u.getTipo() == 1)
					System.out.println(grupoSPFisica[saida.getGrupo()]+ ": " +"R$"+saida.getValor());
				else
					System.out.println(grupoSPJuridica[saida.getGrupo()]+ ": " +"R$"+saida.getValor());
				System.out.println("Data: " + f.format(saida.getData())+ "\n");
				totalNMensal+=saida.getValor();
			}
		}

		System.out.println("\nFluxo do mês: R$"+(totalPMensal-totalNMensal));
		
	}
	
	//Relatório semanal
	public void relatorioSemanal() {
		Calendar calendar = new GregorianCalendar();
		Calendar calendar2 = new GregorianCalendar();
		//Date trialTime = new Date();   
		
		System.out.println("Digite a data que deseja receber o relatório: (dd/mm/aaaa)");
		String d = scanner.nextLine();
		Date dataFormatada = null;
		try {
			dataFormatada = f.parse(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		calendar.setTime(dataFormatada);     
		int semana = calendar.get(Calendar.WEEK_OF_YEAR); 
		int semana2;
		
		double totalPSemanal= 0;
		double totalNSemanal = 0;
		System.out.println("|--------RELATÓRIO SEMANAL--------|");
		System.out.println("----ENTRADA----");
		for (Entrada entrada : entradas) {
			calendar2.setTime(entrada.getData());
			semana2 = calendar2.get(Calendar.WEEK_OF_YEAR);
			if(semana == semana2) {
				if(u.getTipo() == 1)
					System.out.println(grupoEPFisica[entrada.getGrupo()]+ ": " +"R$"+entrada.getValor());
				else
					System.out.println(grupoEPJuridica[entrada.getGrupo()]+ ": " +"R$"+entrada.getValor());
				System.out.println("Data: "+f.format(entrada.getData())+"\n");
				totalPSemanal+=entrada.getValor();
			}
		}
		
		System.out.println("\n----SAIDA----");
		for (Saida saida : saidas) {
			calendar2.setTime(saida.getData());
			semana2 = calendar2.get(Calendar.WEEK_OF_YEAR);
			if(semana == semana2) {
				if(u.getTipo() == 1)
					System.out.println(grupoSPFisica[saida.getGrupo()]+ ": " +"R$"+saida.getValor());
				else
					System.out.println(grupoSPJuridica[saida.getGrupo()]+ ": " +"R$"+saida.getValor());
				System.out.println("Data: "+f.format(saida.getData())+"\n");
				totalNSemanal+=saida.getValor();
			}
		}
		
		System.out.println("\nFluxo da semana: R$"+(totalPSemanal-totalNSemanal));
	}
		

	public void menuPrincipal() {
		Menu menu = new Menu();
		int op = 1000;
		
		while(op != 0) {
			menu.imprimirMenu();
			
			op = Integer.parseInt(scanner.nextLine());
			switch (op) {
			case 1:
				login.cadastrarUsuario();
				break;
			case 2:
				cadastrarEntrada();
				break;
			case 3:
				cadastrarSaida();
				break;
			case 4:
				relatorioMensal();
				break;
			case 5:
				relatorioSemanal();
				break;
			case 6:
				login.trocarDeUsuario();
				login.menuIniciar();
				op = 0;
				break;
			case 7:
				login.imprimirUsuario();
				break;
			default:
				menu.imprimirMenu();
			}
		}
	}
	
	
}
	



