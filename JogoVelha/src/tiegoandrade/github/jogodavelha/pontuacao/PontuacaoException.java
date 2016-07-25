package tiegoandrade.github.jogodavelha.pontuacao;

import tiegoandrade.github.jogodavelha.JogoDaVelhaException;

/**
 * Exceção relacionada à problemas na pontuação
 * 
 * @author Tiego
 *
 */
public class PontuacaoException extends JogoDaVelhaException {

	/**
	 * Construtor
	 * 
	 * @param message
	 *        Mensagem utilizada para informar sobre a exceção.
	 */
	public PontuacaoException(String message) {
		super(message);
	}
}
