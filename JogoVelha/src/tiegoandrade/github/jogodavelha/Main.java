package tiegoandrade.github.jogodavelha;

/**
 * Classe para execu��o do jogo.
 * 
 * @author Tiego
 *
 */
public class Main {
	
	/**
	 * M�todo main que ser� executado pela JVM
	 * 
	 * @param args
	 * 
	 * @throws Exception
	 */
	
	public static void main(String[] args) throws Exception {
		
		// Instancia o jogo e inicia a partida
		Jogo jogo = new Jogo();
		jogo.jogar();

	}

}
