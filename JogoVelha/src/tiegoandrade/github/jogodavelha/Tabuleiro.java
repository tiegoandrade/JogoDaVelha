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

		// Cria uma matriz 3x3 que representará o tabuleiro.
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

	/** Imprime o tabuleiro, junto com sua formatação e seus elementos. */
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
	 * Verifica se todas as posições do tabuleiro estão completas.
	 * 
	 * @return true se o tabuleiro está completo; false, caso haja posições a
	 *         ser preenchidas
	 */
	public boolean isCompleto() {
		for (int i = 0; i < matriz[0].length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {

				// Se alguma posição está vazia, o tabuleiro não está completo.
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
	 *        que é a jogada de um jogador.
	 * 
	 * @param simbolo
	 *        Representa o símbolo usado pelo jogar, 
	 *        pode ser um "X" ou um "O".
	 * 
	 * @return Se uma sequência for encontrada retorna true e o jogador vence,
	 *         Se uma sequência não for encontrada retorna false e o jogo
	 *         continua.
	 * 
	 * @throws JogadaInvalidaException
	 *         Lançada se ocorrer algum problema com a jogada.
	 */
	public boolean efetuarJogada(Jogada jogada, char simbolo)
			throws JogadaInvalidaException {

		// Recebe o valor da linha da matriz.
		int i = jogada.getI();

		// Recebe o valor da coluna da matriz.
		int j = jogada.getJ();

		// Identifica se o valor da linha e coluna passados são válidos.
		if (i < 0 || j < 0 || i >= matriz.length || j >= matriz[0].length) {
			throw new JogadaInvalidaException("A jogada " + i + ", " + j
					+ "é inválida");
		}

		/*
		 * Identifica se a posição da matriz já está preenchida. Isso
		 * significará que uma determinada jogada já foi feita naquela posição.
		 */
		if (matriz[i][j] != ' ') {
			throw new JogadaInvalidaException("A jogada " + i + "," + j
											   + "já foi realizada");
		}

		// Adiciona um símbolo a uma posição da matriz.
		matriz[i][j] = simbolo;

		/*
		 * Chama um método para verificar se algum jogador conseguiu realizar
		 * uma combinação válida e ganhou a partida.
		 */
		return isSequenciaEncontrada();
	}

	/**
	 * Checa se uma sequência de 3 símbolos foi encontrada.
	 * 
	 * @return true se uma sequência foi encontrada; false, caso contrário.
	 */
	private boolean isSequenciaEncontrada() {

		/* 
		 * Verifica se há uma sequência de um mesmo símbolo 
		 * na horizontal da primeira linha.
		 */
		if (matriz[0][0] == matriz[0][1] && matriz[0][1] == matriz[0][2]
				&& matriz[0][0] != ' ') {
			return true;
		}
		
		/* 
		 * Verifica se há uma sequência de um mesmo símbolo 
		 * na horizontal da segunda linha.
		 */
		if (matriz[1][0] == matriz[1][1] && matriz[1][1] == matriz[1][2]
				&& matriz[1][0] != ' ') {
			return true;
		}
		
		/* 
		 * Verifica se há uma sequência de um mesmo símbolo 
		 * na horizontal da terceira linha.
		 */
		if (matriz[2][0] == matriz[2][1] && matriz[2][1] == matriz[2][2]
				&& matriz[2][0] != ' ') {
			return true;
		}
		
		/* 
		 * Verifica se há uma sequência de um mesmo símbolo 
		 * na vertical da primeira coluna.
		 */
		if (matriz[0][0] == matriz[1][0] && matriz[1][0] == matriz[2][0]
				&& matriz[0][0] != ' ') {
			return true;
		}
		
		/* 
		 * Verifica se há uma sequência de um mesmo símbolo 
		 * na vertical da segunda coluna.
		 */
		if (matriz[0][1] == matriz[1][1] && matriz[1][1] == matriz[2][1]
				&& matriz[0][1] != ' ') {
			return true;
		}
		
		/* 
		 * Verifica se há uma sequência de um mesmo símbolo 
		 * na vertical da terceira coluna.
		 */
		if (matriz[0][2] == matriz[1][2] && matriz[1][2] == matriz[2][2]
				&& matriz[0][2] != ' ') {
			return true;
		}
		
		/* 
		 * Verifica se há uma sequência de um mesmo símbolo 
		 * na diagonal à direita.
		 */
		if (matriz[0][0] == matriz[1][1] && matriz[1][1] == matriz[2][2]
				&& matriz[0][0] != ' ') {
			return true;
		}
		
		/* 
		 * Verifica se há uma sequência de um mesmo símbolo 
		 * na diagonal à esquerda.
		 */
		if (matriz[0][2] == matriz[1][1] && matriz[1][1] == matriz[2][0]
				&& matriz[0][2] != ' ') {
			return true;
		}
		
		// Retorna false, caso não seja encontrado nenhuma sequência válida.
		return false;
	}
}
