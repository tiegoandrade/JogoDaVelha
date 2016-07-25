package tiegoandrade.github.jogodavelha;

import tiegoandrade.github.jogodavelha.io.Console;

/**
 * Representa um jogador do jogo da velha.
 *
 * @author Tiego
 *
 */
public class Jogador {

	/** Nome do jogador. */
	private String nome;

	/** Símbolo usado pelo jogador. */
	private char simbolo;

	/**
	 * Construtor
	 * 
	 * @param nome
	 *        Representa o nome do jogador que participará da partida.
	 * 
	 * @param simbolo
	 *            Representa o símbolo usado pelo jogador na partida.
	 */
	public Jogador(String nome, char simbolo) {
		this.nome = nome;
		this.simbolo = simbolo;
	}

	/**
	 * Obtém o nome do jogador.
	 * 
	 * @return nome do jogador.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Obtém o símbolo usado pelo jogador.
	 * 
	 * @return Símbolo do jogador
	 */
	public char getSimbolo() {
		return simbolo;
	}
	
	/**
	 * Obtém uma jogada feita por um dos jogadores.
	 * 
	 * @return A jogada feita por um jogador, que foi digitada no console.
	 * 
	 * @throws JogadaInvalidaException
	 * 		   Lançada se a jogada for inválida.
	 */
	public Jogada obterJogada() throws JogadaInvalidaException {
		String str = Console.readString();
		return new Jogada(str);
	}
}
