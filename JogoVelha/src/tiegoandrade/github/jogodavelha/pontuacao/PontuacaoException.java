package tiegoandrade.github.jogodavelha.pontuacao;

import tiegoandrade.github.jogodavelha.JogoDaVelhaException;

/**
 * Exce��o relacionada � problemas na pontua��o
 * 
 * @author Tiego
 *
 */
public class PontuacaoException extends JogoDaVelhaException {

	/**
	 * Construtor
	 * 
	 * @param message
	 *        Mensagem utilizada para informar sobre a exce��o.
	 */
	public PontuacaoException(String message) {
		super(message);
	}
}
