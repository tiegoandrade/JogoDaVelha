package tiegoandrade.github.jogodavelha;

import java.util.ArrayList;
import java.util.List;

import tiegoandrade.github.jogodavelha.io.Console;
import tiegoandrade.github.jogodavelha.pontuacao.GerenciadorPontuacao;
import tiegoandrade.github.jogodavelha.pontuacao.GerenciadorPontuacaoArquivo;

/**
 * Possui a l�gica do jogo
 * 
 * @author Tiego
 */
public class Jogo {

	/** Cria o tabuleiro do jogo */
	private Tabuleiro tabuleiro = new Tabuleiro();

	/** Cria uma lista onde ser� inserido dois jogadores. */
	private List<Jogador> jogadores = new ArrayList<Jogador>();

	/** Cria um gerenciador de Pontua��o. */
	private GerenciadorPontuacao gerenciadorPontuacao;

	/**
	 * Inicia o jogo.
	 * 
	 * @throws JogoDaVelhaException
	 *         Lan�ada se ocorrer algum problema durante o jogo.
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
		
		// O console l� o nome e o atribui para uma vari�vel.
		String nome = Console.readString();
		
		// Adiciona o jogador na lista de jogadores.
		jogadores.add(new Jogador(nome, 'X'));
		
		// Recupera a pontua��o desse jogador, caso ele tenha.
		Integer pontuacao = gerenciadorPontuacao.getPontuacao(nome);
		
		// Se o jogador tiver pontua��o, � apresentado o n�mero de vit�rias dele.
		if (pontuacao != null) {
			System.out.println("O jogador " + nome + "j� possui " + pontuacao
								+ "vit�rias!");
		}
		
		// Solicita o nome do segundo jogador.
		System.out.println("Nome do Jogador 2: ");
		
		// O console l� o nome e o atribui � vari�vel.
		nome = Console.readString();
		
		// Adiciona o segundo jogador a lista de jogadores.
		jogadores.add(new Jogador(nome, 'O'));
		
		// Recupera a pontua��o desse jogador, caso ele tenha.
		pontuacao = gerenciadorPontuacao.getPontuacao(nome);
		
		// Se o jogagor tiver alguma pontua��o, ela � apresentada. 
		if (pontuacao != null) {
			System.out.println("O jogador " + nome + " j� possui " + pontuacao
								+ "vit�ria(s)!");
		}
		
		// Vari�vel que identifica se algum jogador ganhou ou se houve empate.
		boolean finalizado = false;
		
		/* 
		 * Vari�vel que identifica quem � que far� a jogada.
		 * N�mero 0 indica a vez do jogador 1
		 * e 1 indica a vez do jogador 2.	
		 */
		int indexJogadorAtual = 0;

		// Vari�vel que identifica o vencedor ou se houve empate.
		Jogador vencedor = null;
		
		// Enquanto ningu�m ganhar ou o jogo n�o empatar, a partida continuar�.
		while (!finalizado) {
			
			// Mostra o tabuleiro.
			tabuleiro.imprimir();
			
			// Descobre qual o jogador que realizar� a jogada atual.
			Jogador jogador = jogadores.get(indexJogadorAtual);
			System.out.println("Informe sua jogada, " + jogador.getNome() + ": ");

			// Vari�vel que identifica se alguma sequ�ncia foi encontrada.
			boolean sequenciaEncontrada;

			try {
				
				// Obt�m a jogada feita por um dos jogadores.
				Jogada jogada = jogador.obterJogada();
				
				// Efetua a jogada feita por um dos jogadores.
				sequenciaEncontrada = tabuleiro.efetuarJogada(jogada,
						jogador.getSimbolo());
			} catch (JogadaInvalidaException e) {
				
				// Se a jogada foi inv�lida, mostra o erro e solicita a jogada nvoamente.
				System.out.println("Erro: " + e.getMessage());
				continue;
			}
			
			/* 
			 * Se a sequ�ncia correta foi encontrada, 
			 * o jogo � finalizado e o vencedor � descoberto.
			 */
			if (sequenciaEncontrada) {
				vencedor = jogador;
				finalizado = true;
			
			// Se o tabuleiro estiver completo, � declarado um empate.
			} else if (tabuleiro.isCompleto()) {
				finalizado = true;
			}
			
			// Identifica o pr�ximo jogador a realizar uma jogada.
			indexJogadorAtual = (indexJogadorAtual + 1) % jogadores.size();
		}

		System.out.println();
		
		// Se n�o h� vencedores, o jogo empatou.
		if (vencedor == null) {
			System.out.println("O jogo terminou empatado");
		
		/* 
		 * Sen�o � mostrado o nome do jogador que venceu a partida 
		 * e � gravado sua pontua��o.
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
