package tiegoandrade.github.jogodavelha;

/**
 * Representa uma exce��o gen�rica do Jogo da Velha
 * 
 * @author Tiego
 */
public class JogoDaVelhaException extends Exception {
	
	/**
	 * Exibe uma mensagem caso essa exce��o seja lan�ada.
	 * 
	 * @param message
	 *        Recebe a mensagem que ser� apresentada caso a exce��o
	 *        aconte�a.
	 */
	public JogoDaVelhaException(String message) {
		super(message);
	}
}
