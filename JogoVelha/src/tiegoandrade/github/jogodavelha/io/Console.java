package tiegoandrade.github.jogodavelha.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Classe usada para ler dados do console.
 * 
 * @author Tiego
 */
public class Console {
	
	/**
	 * Lê uma String do console.
	 *
	 * @return Retorna a String lida
	 */
	public static String readString() {
		try {
			
			// Recebe as entradas do console.
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			
			// Retorna uma linha lida do console.
			return reader.readLine();
		} catch (IOException e) {
			throw new RuntimeException("Erro ao ler dados do teclado.");
		}
	}
	
	
}
