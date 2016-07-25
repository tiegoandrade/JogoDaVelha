package tiegoandrade.github.jogodavelha;

/**
 * A classe representa uma jogada feita pelo jogador.
 * 
 * @author Tiego
 */
public class Jogada {

	/** � a posi��o que representa a linha da matriz. */
	private int i;

	/** � a posi��o que representa a coluna da matriz. */
	private int j;

	/**
	 * Construtor
	 * 
	 * @param jogada
	 *        � uma jogada feita por um jogador, representada por uma String
	 *        no formato "i,j".
	 * 
	 * @throws JogadaInvalidaException
	 *         Lan�a uma exce��o se a jogada for inv�lida.
	 */
	public Jogada(String jogada) throws JogadaInvalidaException {
		parseString(jogada);
	}

	/**
	 * Atribui o �ndice da linha e da coluna aos tokens.
	 *
	 * @param jogada
	 *        String no formato "i,j" vindo do construtor.
	 * 
	 * @throws JogadaInvalidaException
	 *         Lan�a uma exce��o se a jogada for inv�lida.
	 */
	private void parseString(String jogada) throws JogadaInvalidaException {
		try {

			/*
			 * Separa o par�metro que foi passado no construtor no lugar que
			 * tiver v�rgula.
			 */
			String[] tokens = jogada.split(",");

			/*
			 *  Atribui ao atributo "i" o valor da linha em forma de inteiro, 
			 *  removendo os espa�os.
			 */
			this.i = Integer.parseInt(tokens[0].trim());

			/* 
			 * Atribui ao atributo "j" o valor da coluna em forma de inteiro, 
			 * removendo os espa�os.
			 */
			this.j = Integer.parseInt(tokens[1].trim());
		} catch (Exception e) {

			// Lan�a uma exce��o se os par�metros passados forem inv�lidos.
			throw new JogadaInvalidaException("A jogada " + i + ", " + j
											   + " � inv�lida.");
		}
	}

	/**
	 * Obt�m a posi��o i (linha).
	 * 
	 * @return Posi��o i.
	 */
	public int getI() {
		return i;
	}

	/**
	 * Obt�m a posi��o j (coluna).
	 * 
	 * @return Posi��o j.
	 */
	public int getJ() {
		return j;
	}
}
