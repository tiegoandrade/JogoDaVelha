package tiegoandrade.github.jogodavelha.pontuacao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Classe que armazena a pontua��o em um arquivo.
 *
 * @author Tiego
 *
 */
public class GerenciadorPontuacaoArquivo implements GerenciadorPontuacao {

	/**
	 * Constante que armazena o nome do arquivo que conter� as pontua��es dos
	 * jogadores
	 */
	private static final String ARQUIVO_PONTUACAO = "pontuacao.txt";

	/**
	 * Mapa que armazena o nome do jogador e sua pontua��o correspondente.
	 */
	private Map<String, Integer> pontuacaoMap = new HashMap<String, Integer>();

	/**
	 * Construtor.
	 * 
	 * @throws PontuacaoException
	 *         Lan�ado caso haja um problema com a cria��o do arquivo com as
	 *         pontua��es.
	 */
	public GerenciadorPontuacaoArquivo() throws PontuacaoException {

		// Inicializa o Gerenciador de Pontua��o.
		inicializar();
	}

	/**
	 * Inicializa o gerenciador de pontua��o.
	 * 
	 * @throws PontuacaoException
	 *         Lan�ado caso haja um problema com a cria��o do arquivo com as
	 *         pontua��es.
	 */
	private void inicializar() throws PontuacaoException {

		// � passado um arquivo com a pontua��o dos jogadores.
		File arquivo = new File(ARQUIVO_PONTUACAO);

		// Verificar se o arquivo com a pontua��o dos jogadores j� existe.
		if (!arquivo.exists()) {
			try {

				// Se n�o existir o arquivo, ele � criado.
				arquivo.createNewFile();
			} catch (IOException e) {
				throw new PontuacaoException(e.getMessage());
			}
		}

		// L� as Strings do arquivo.
		try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {

			// Vari�vel que representa as linhas do documento.
			String line;

			// Enquanto tiver linhas no arquivo, esse la�o ser� executado.
			while ((line = reader.readLine()) != null) {

				// Separa a linha quando encontrar o caracter "|".
				String[] tokens = line.split("\\|");

				/*
				 * Recupera os elementos separados, colocando o nome na String
				 * do mapa e sua pontua��o no Integer do mapa.
				 */
				pontuacaoMap.put(tokens[0].toUpperCase(),
						new Integer(tokens[1]));
			}
		} catch (IOException e) {
			throw new PontuacaoException(e.getMessage());
		}
	}

	/**
	 * Recupera a pontua��o de um jogador
	 * 
	 * @param nome
	 *        Nome do Jogador.
	 *
	 * @return a pontua��o do jogador.
	 */
	@Override
	public Integer getPontuacao(String nome) {
		return pontuacaoMap.get(nome.toUpperCase());
	}
	
	/** Grava a pontua��o de uma partida em um arquivo. */
	@Override
	public void gravarPontuacao(String nome) throws PontuacaoException {
		
		// Recupera a pontua��o do jogador.
		Integer pontuacao = getPontuacao(nome);
		
		// � informado que o jogador n�o tem pontua��o alguma.
		if (pontuacao == null) {
			pontuacao = 0;
		}
		
		// Coloca no Mapa as vit�rias de um jogador. 
		pontuacaoMap.put(nome.toUpperCase(), pontuacao + 1);
		
		// Armazena as entradas do Mapa em um determinado arquivo.
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO_PONTUACAO))) {
			
			// Percorre o mapa, inserindo seus dados em um arquivo.
			for (Map.Entry<String, Integer> entry : pontuacaoMap.entrySet()) {
				
				// Armazena no arquivo as informa��es da pontua��o no formato "nome|pontua��o" 
				writer.write(entry.getKey() + "|" + entry.getValue());
				
				// Quebra uma linha.
				writer.newLine();
			}
		} catch (IOException e) {
			throw new PontuacaoException(e.getMessage());
		}
	}
}
