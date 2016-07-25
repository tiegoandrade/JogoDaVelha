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
 * Classe que armazena a pontuação em um arquivo.
 *
 * @author Tiego
 *
 */
public class GerenciadorPontuacaoArquivo implements GerenciadorPontuacao {

	/**
	 * Constante que armazena o nome do arquivo que conterá as pontuações dos
	 * jogadores
	 */
	private static final String ARQUIVO_PONTUACAO = "pontuacao.txt";

	/**
	 * Mapa que armazena o nome do jogador e sua pontuação correspondente.
	 */
	private Map<String, Integer> pontuacaoMap = new HashMap<String, Integer>();

	/**
	 * Construtor.
	 * 
	 * @throws PontuacaoException
	 *         Lançado caso haja um problema com a criação do arquivo com as
	 *         pontuações.
	 */
	public GerenciadorPontuacaoArquivo() throws PontuacaoException {

		// Inicializa o Gerenciador de Pontuação.
		inicializar();
	}

	/**
	 * Inicializa o gerenciador de pontuação.
	 * 
	 * @throws PontuacaoException
	 *         Lançado caso haja um problema com a criação do arquivo com as
	 *         pontuações.
	 */
	private void inicializar() throws PontuacaoException {

		// É passado um arquivo com a pontuação dos jogadores.
		File arquivo = new File(ARQUIVO_PONTUACAO);

		// Verificar se o arquivo com a pontuação dos jogadores já existe.
		if (!arquivo.exists()) {
			try {

				// Se não existir o arquivo, ele é criado.
				arquivo.createNewFile();
			} catch (IOException e) {
				throw new PontuacaoException(e.getMessage());
			}
		}

		// Lê as Strings do arquivo.
		try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {

			// Variável que representa as linhas do documento.
			String line;

			// Enquanto tiver linhas no arquivo, esse laço será executado.
			while ((line = reader.readLine()) != null) {

				// Separa a linha quando encontrar o caracter "|".
				String[] tokens = line.split("\\|");

				/*
				 * Recupera os elementos separados, colocando o nome na String
				 * do mapa e sua pontuação no Integer do mapa.
				 */
				pontuacaoMap.put(tokens[0].toUpperCase(),
						new Integer(tokens[1]));
			}
		} catch (IOException e) {
			throw new PontuacaoException(e.getMessage());
		}
	}

	/**
	 * Recupera a pontuação de um jogador
	 * 
	 * @param nome
	 *        Nome do Jogador.
	 *
	 * @return a pontuação do jogador.
	 */
	@Override
	public Integer getPontuacao(String nome) {
		return pontuacaoMap.get(nome.toUpperCase());
	}
	
	/** Grava a pontuação de uma partida em um arquivo. */
	@Override
	public void gravarPontuacao(String nome) throws PontuacaoException {
		
		// Recupera a pontuação do jogador.
		Integer pontuacao = getPontuacao(nome);
		
		// É informado que o jogador não tem pontuação alguma.
		if (pontuacao == null) {
			pontuacao = 0;
		}
		
		// Coloca no Mapa as vitórias de um jogador. 
		pontuacaoMap.put(nome.toUpperCase(), pontuacao + 1);
		
		// Armazena as entradas do Mapa em um determinado arquivo.
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO_PONTUACAO))) {
			
			// Percorre o mapa, inserindo seus dados em um arquivo.
			for (Map.Entry<String, Integer> entry : pontuacaoMap.entrySet()) {
				
				// Armazena no arquivo as informações da pontuação no formato "nome|pontuação" 
				writer.write(entry.getKey() + "|" + entry.getValue());
				
				// Quebra uma linha.
				writer.newLine();
			}
		} catch (IOException e) {
			throw new PontuacaoException(e.getMessage());
		}
	}
}
