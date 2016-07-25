package tiegoandrade.github.jogodavelha;

/**
 * Classe para execução do jogo.
 * 
 * @author Tiego
 *
 */
public class Main {
	
	/**
	 * Método main que será executado pela JVM
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
