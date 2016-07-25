package tiegoandrade.github.jogodavelha;

/**
 * Representa uma exceção genérica do Jogo da Velha
 * 
 * @author Tiego
 */
public class JogoDaVelhaException extends Exception {
	
	/**
	 * Exibe uma mensagem caso essa exceção seja lançada.
	 * 
	 * @param message
	 *        Recebe a mensagem que será apresentada caso a exceção
	 *        aconteça.
	 */
	public JogoDaVelhaException(String message) {
		super(message);
	}
}
