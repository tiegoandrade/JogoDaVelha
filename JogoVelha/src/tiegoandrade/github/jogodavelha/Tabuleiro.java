package tiegoandrade.github.jogodavelha;

/**
 * Representa o tabuleiro do jogo
 * 
 * @author Tiego
 */
public class Tabuleiro {

	/** Matriz que representa o jogo */
	private char[][] matriz;

	/** Construtor */
	public Tabuleiro() {

		// Cria uma matriz 3x3 que representar� o tabuleiro.
		matriz = new char[3][3];

		// Zera todos os elementos da matriz.
		zerar();
	}

	/** Zera os elementos da matriz. */
	public void zerar() {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				matriz[i][j] = ' ';
			}
		}
	}

	/** Imprime o tabuleiro, junto com sua formata��o e seus elementos. */
	public void imprimir() {
		for (int i = 0; i < matriz.length; i++) {
			
			for (int j = 0; j < matriz[0].length; j++) {
				System.out.print(matriz[i][j]);
				
				if (j < matriz[0].length - 1) {
					System.out.print(" | ");
				}
			}
			System.out.println();

			if (i < matriz.length - 1) {
				System.out.println("---------");
			}
		}
		System.out.println();
	}

	/**
	 * Verifica se todas as posi��es do tabuleiro est�o completas.
	 * 
	 * @return true se o tabuleiro est� completo; false, caso haja posi��es a
	 *         ser preenchidas
	 */
	public boolean isCompleto() {
		for (int i = 0; i < matriz[0].length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {

				// Se alguma posi��o est� vazia, o tabuleiro n�o est� completo.
				if (matriz[i][j] == ' ') {
					return false;
				}
			}
		}

		return true;
	}

	/**
	 * Realiza uma jogada feita por um jogador.
	 * 
	 * @param jogada
	 *        Representa o valor de uma linha e coluna, 
	 *        que � a jogada de um jogador.
	 * 
	 * @param simbolo
	 *        Representa o s�mbolo usado pelo jogar, 
	 *        pode ser um "X" ou um "O".
	 * 
	 * @return Se uma sequ�ncia for encontrada retorna true e o jogador vence,
	 *         Se uma sequ�ncia n�o for encontrada retorna false e o jogo
	 *         continua.
	 * 
	 * @throws JogadaInvalidaException
	 *         Lan�ada se ocorrer algum problema com a jogada.
	 */
	public boolean efetuarJogada(Jogada jogada, char simbolo)
			throws JogadaInvalidaException {

		// Recebe o valor da linha da matriz.
		int i = jogada.getI();

		// Recebe o valor da coluna da matriz.
		int j = jogada.getJ();

		// Identifica se o valor da linha e coluna passados s�o v�lidos.
		if (i < 0 || j < 0 || i >= matriz.length || j >= matriz[0].length) {
			throw new JogadaInvalidaException("A jogada " + i + ", " + j
					+ "� inv�lida");
		}

		/*
		 * Identifica se a posi��o da matriz j� est� preenchida. Isso
		 * significar� que uma determinada jogada j� foi feita naquela posi��o.
		 */
		if (matriz[i][j] != ' ') {
			throw new JogadaInvalidaException("A jogada " + i + "," + j
											   + "j� foi realizada");
		}

		// Adiciona um s�mbolo a uma posi��o da matriz.
		matriz[i][j] = simbolo;

		/*
		 * Chama um m�todo para verificar se algum jogador conseguiu realizar
		 * uma combina��o v�lida e ganhou a partida.
		 */
		return isSequenciaEncontrada();
	}

	/**
	 * Checa se uma sequ�ncia de 3 s�mbolos foi encontrada.
	 * 
	 * @return true se uma sequ�ncia foi encontrada; false, caso contr�rio.
	 */
	private boolean isSequenciaEncontrada() {

		/* 
		 * Verifica se h� uma sequ�ncia de um mesmo s�mbolo 
		 * na horizontal da primeira linha.
		 */
		if (matriz[0][0] == matriz[0][1] && matriz[0][1] == matriz[0][2]
				&& matriz[0][0] != ' ') {
			return true;
		}
		
		/* 
		 * Verifica se h� uma sequ�ncia de um mesmo s�mbolo 
		 * na horizontal da segunda linha.
		 */
		if (matriz[1][0] == matriz[1][1] && matriz[1][1] == matriz[1][2]
				&& matriz[1][0] != ' ') {
			return true;
		}
		
		/* 
		 * Verifica se h� uma sequ�ncia de um mesmo s�mbolo 
		 * na horizontal da terceira linha.
		 */
		if (matriz[2][0] == matriz[2][1] && matriz[2][1] == matriz[2][2]
				&& matriz[2][0] != ' ') {
			return true;
		}
		
		/* 
		 * Verifica se h� uma sequ�ncia de um mesmo s�mbolo 
		 * na vertical da primeira coluna.
		 */
		if (matriz[0][0] == matriz[1][0] && matriz[1][0] == matriz[2][0]
				&& matriz[0][0] != ' ') {
			return true;
		}
		
		/* 
		 * Verifica se h� uma sequ�ncia de um mesmo s�mbolo 
		 * na vertical da segunda coluna.
		 */
		if (matriz[0][1] == matriz[1][1] && matriz[1][1] == matriz[2][1]
				&& matriz[0][1] != ' ') {
			return true;
		}
		
		/* 
		 * Verifica se h� uma sequ�ncia de um mesmo s�mbolo 
		 * na vertical da terceira coluna.
		 */
		if (matriz[0][2] == matriz[1][2] && matriz[1][2] == matriz[2][2]
				&& matriz[0][2] != ' ') {
			return true;
		}
		
		/* 
		 * Verifica se h� uma sequ�ncia de um mesmo s�mbolo 
		 * na diagonal � direita.
		 */
		if (matriz[0][0] == matriz[1][1] && matriz[1][1] == matriz[2][2]
				&& matriz[0][0] != ' ') {
			return true;
		}
		
		/* 
		 * Verifica se h� uma sequ�ncia de um mesmo s�mbolo 
		 * na diagonal � esquerda.
		 */
		if (matriz[0][2] == matriz[1][1] && matriz[1][1] == matriz[2][0]
				&& matriz[0][2] != ' ') {
			return true;
		}
		
		// Retorna false, caso n�o seja encontrado nenhuma sequ�ncia v�lida.
		return false;
	}
}
