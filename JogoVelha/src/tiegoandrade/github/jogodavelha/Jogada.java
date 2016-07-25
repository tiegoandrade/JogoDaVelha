package tiegoandrade.github.jogodavelha;

/**
 * A classe representa uma jogada feita pelo jogador.
 * 
 * @author Tiego
 */
public class Jogada {

	/** É a posição que representa a linha da matriz. */
	private int i;

	/** É a posição que representa a coluna da matriz. */
	private int j;

	/**
	 * Construtor
	 * 
	 * @param jogada
	 *        É uma jogada feita por um jogador, representada por uma String
	 *        no formato "i,j".
	 * 
	 * @throws JogadaInvalidaException
	 *         Lança uma exceção se a jogada for inválida.
	 */
	public Jogada(String jogada) throws JogadaInvalidaException {
		parseString(jogada);
	}

	/**
	 * Atribui o índice da linha e da coluna aos tokens.
	 *
	 * @param jogada
	 *        String no formato "i,j" vindo do construtor.
	 * 
	 * @throws JogadaInvalidaException
	 *         Lança uma exceção se a jogada for inválida.
	 */
	private void parseString(String jogada) throws JogadaInvalidaException {
		try {

			/*
			 * Separa o parâmetro que foi passado no construtor no lugar que
			 * tiver vírgula.
			 */
			String[] tokens = jogada.split(",");

			/*
			 *  Atribui ao atributo "i" o valor da linha em forma de inteiro, 
			 *  removendo os espaços.
			 */
			this.i = Integer.parseInt(tokens[0].trim());

			/* 
			 * Atribui ao atributo "j" o valor da coluna em forma de inteiro, 
			 * removendo os espaços.
			 */
			this.j = Integer.parseInt(tokens[1].trim());
		} catch (Exception e) {

			// Lança uma exceção se os parâmetros passados forem inválidos.
			throw new JogadaInvalidaException("A jogada " + i + ", " + j
											   + " é inválida.");
		}
	}

	/**
	 * Obtém a posição i (linha).
	 * 
	 * @return Posição i.
	 */
	public int getI() {
		return i;
	}

	/**
	 * Obtém a posição j (coluna).
	 * 
	 * @return Posição j.
	 */
	public int getJ() {
		return j;
	}
}
