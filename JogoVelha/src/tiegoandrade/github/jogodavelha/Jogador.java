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

	/** S�mbolo usado pelo jogador. */
	private char simbolo;

	/**
	 * Construtor
	 * 
	 * @param nome
	 *        Representa o nome do jogador que participar� da partida.
	 * 
	 * @param simbolo
	 *            Representa o s�mbolo usado pelo jogador na partida.
	 */
	public Jogador(String nome, char simbolo) {
		this.nome = nome;
		this.simbolo = simbolo;
	}

	/**
	 * Obt�m o nome do jogador.
	 * 
	 * @return nome do jogador.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Obt�m o s�mbolo usado pelo jogador.
	 * 
	 * @return S�mbolo do jogador
	 */
	public char getSimbolo() {
		return simbolo;
	}
	
	/**
	 * Obt�m uma jogada feita por um dos jogadores.
	 * 
	 * @return A jogada feita por um jogador, que foi digitada no console.
	 * 
	 * @throws JogadaInvalidaException
	 * 		   Lan�ada se a jogada for inv�lida.
	 */
	public Jogada obterJogada() throws JogadaInvalidaException {
		String str = Console.readString();
		return new Jogada(str);
	}
}
