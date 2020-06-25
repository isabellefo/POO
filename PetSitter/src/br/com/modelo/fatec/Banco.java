package br.com.modelo.fatec;
	
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Banco {
	private File arquivo;
	private FileOutputStream saida;
	private FileInputStream entrada;
	private ObjectOutputStream escritor;
	private ObjectInputStream leitor;
		
	public Banco(String caminho) {
		String nome = "dados.ser";
		arquivo = new File(caminho+"\\"+nome);
	}
		
	public void escrever(Object objeto) throws Exception{
		saida = new FileOutputStream(arquivo);
		escritor = new ObjectOutputStream(saida);
		escritor.writeObject(objeto);
		escritor.close();
	}
		
	public Object ler() throws Exception{
		entrada = new FileInputStream(arquivo);
		leitor = new ObjectInputStream(entrada);
		Object obj = leitor.readObject();
		leitor.close();
		return obj;
	}

}

