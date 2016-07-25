package tiegoandrade.github.jogodavelha;

import java.util.ArrayList;
import java.util.List;

import tiegoandrade.github.jogodavelha.io.Console;
import tiegoandrade.github.jogodavelha.pontuacao.GerenciadorPontuacao;
import tiegoandrade.github.jogodavelha.pontuacao.GerenciadorPontuacaoArquivo;

/**
 * Possui a lógica do jogo
 * 
 * @author Tiego
 */
public class Jogo {

	/** Cria o tabuleiro do jogo */
	private Tabuleiro tabuleiro = new Tabuleiro();

	/** Cria uma lista onde será inserido dois jogadores. */
	private List<Jogador> jogadores = new ArrayList<Jogador>();

	/** Cria um gerenciador de Pontuação. */
	private GerenciadorPontuacao gerenciadorPontuacao;

	/**
	 * Inicia o jogo.
	 * 
	 * @throws JogoDaVelhaException
	 *         Lançada se ocorrer algum problema durante o jogo.
	 */
	public void jogar() throws JogoDaVelhaException {
		System.out.println("=================");
		System.out.println("| JOGO DA VELHA |");
		System.out.println("=================");
		System.out.println();

		// Inicializa o gerenciador de partida.
		gerenciadorPontuacao = new GerenciadorPontuacaoArquivo();
		
		// Solicita o nome do primeiro jogador.
		System.out.println("Nome do Jogador 1: ");
		
		// O console lê o nome e o atribui para uma variável.
		String nome = Console.readString();
		
		// Adiciona o jogador na lista de jogadores.
		jogadores.add(new Jogador(nome, 'X'));
		
		// Recupera a pontuação desse jogador, caso ele tenha.
		Integer pontuacao = gerenciadorPontuacao.getPontuacao(nome);
		
		// Se o jogador tiver pontuação, é apresentado o número de vitórias dele.
		if (pontuacao != null) {
			System.out.println("O jogador " + nome + "já possui " + pontuacao
								+ "vitórias!");
		}
		
		// Solicita o nome do segundo jogador.
		System.out.println("Nome do Jogador 2: ");
		
		// O console lê o nome e o atribui à variável.
		nome = Console.readString();
		
		// Adiciona o segundo jogador a lista de jogadores.
		jogadores.add(new Jogador(nome, 'O'));
		
		// Recupera a pontuação desse jogador, caso ele tenha.
		pontuacao = gerenciadorPontuacao.getPontuacao(nome);
		
		// Se o jogagor tiver alguma pontuação, ela é apresentada. 
		if (pontuacao != null) {
			System.out.println("O jogador " + nome + " já possui " + pontuacao
								+ "vitória(s)!");
		}
		
		// Variável que identifica se algum jogador ganhou ou se houve empate.
		boolean finalizado = false;
		
		/* 
		 * Variável que identifica quem é que fará a jogada.
		 * Número 0 indica a vez do jogador 1
		 * e 1 indica a vez do jogador 2.	
		 */
		int indexJogadorAtual = 0;

		// Variável que identifica o vencedor ou se houve empate.
		Jogador vencedor = null;
		
		// Enquanto ninguém ganhar ou o jogo não empatar, a partida continuará.
		while (!finalizado) {
			
			// Mostra o tabuleiro.
			tabuleiro.imprimir();
			
			// Descobre qual o jogador que realizará a jogada atual.
			Jogador jogador = jogadores.get(indexJogadorAtual);
			System.out.println("Informe sua jogada, " + jogador.getNome() + ": ");

			// Variável que identifica se alguma sequência foi encontrada.
			boolean sequenciaEncontrada;

			try {
				
				// Obtém a jogada feita por um dos jogadores.
				Jogada jogada = jogador.obterJogada();
				
				// Efetua a jogada feita por um dos jogadores.
				sequenciaEncontrada = tabuleiro.efetuarJogada(jogada,
						jogador.getSimbolo());
			} catch (JogadaInvalidaException e) {
				
				// Se a jogada foi inválida, mostra o erro e solicita a jogada nvoamente.
				System.out.println("Erro: " + e.getMessage());
				continue;
			}
			
			/* 
			 * Se a sequência correta foi encontrada, 
			 * o jogo é finalizado e o vencedor é descoberto.
			 */
			if (sequenciaEncontrada) {
				vencedor = jogador;
				finalizado = true;
			
			// Se o tabuleiro estiver completo, é declarado um empate.
			} else if (tabuleiro.isCompleto()) {
				finalizado = true;
			}
			
			// Identifica o próximo jogador a realizar uma jogada.
			indexJogadorAtual = (indexJogadorAtual + 1) % jogadores.size();
		}

		System.out.println();
		
		// Se não há vencedores, o jogo empatou.
		if (vencedor == null) {
			System.out.println("O jogo terminou empatado");
		
		/* 
		 * Senão é mostrado o nome do jogador que venceu a partida 
		 * e é gravado sua pontuação.
		 */
		} else {
			System.out.println("O jogador '" + vencedor.getNome()
								+ "' venceu o jogo!");
			
			gerenciadorPontuacao.gravarPontuacao(vencedor.getNome());
		}
		
		// Mostra como ficou o tabuleiro no final da partida.
		tabuleiro.imprimir();
	}
}
