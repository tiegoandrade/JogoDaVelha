package tiegoandrade.github.jogodavelha;

/**
 * Representa uma jogada inv�lida feita pelo jogador.
 * 
 * @author Tiego
 */
public class JogadaInvalidaException extends JogoDaVelhaException {

	/**
	 * Construtor
	 * 
	 * @param message
	 *        Recebe a mensagem que ser� apresentada caso a exce��o
	 *        aconte�a.
	 */
	public JogadaInvalidaException(String message) {
		super(message);
	}

}
