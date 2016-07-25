package tiegoandrade.github.jogodavelha;

/**
 * Representa uma jogada inválida feita pelo jogador.
 * 
 * @author Tiego
 */
public class JogadaInvalidaException extends JogoDaVelhaException {

	/**
	 * Construtor
	 * 
	 * @param message
	 *        Recebe a mensagem que será apresentada caso a exceção
	 *        aconteça.
	 */
	public JogadaInvalidaException(String message) {
		super(message);
	}

}
