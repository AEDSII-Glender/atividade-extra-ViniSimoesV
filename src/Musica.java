import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Musica implements Comparable<Musica> {
	
	// Atributos
	private static int ultimoID = 10_000;
	
	protected int idMusica;
	protected String tituloDaMusica;
	protected String nomeDoArtista;
	protected double duracaoDaMusica;
	
	/**
	 * Inicializador
	 */
	private void init (String tituloDaMusica, String nomeDoArtista, double duracaoDaMusica) {
		if ((tituloDaMusica.length()>=1) && (nomeDoArtista.length()>=1) && (duracaoDaMusica>0.0)) {
			this.tituloDaMusica = tituloDaMusica;
			this.nomeDoArtista = nomeDoArtista;
			this.duracaoDaMusica = duracaoDaMusica;
			idMusica = ultimoID++;
		} else {
			throw new IllegalArgumentException ("Valor inválido.");
		}
	}
	
	
	/**
	 * Construtor
	 */
	private Musica (String tituloDaMusica, String nomeDoArtista, double duracaoDaMusica) {
		init (tituloDaMusica, nomeDoArtista, duracaoDaMusica);
	}
	
	
	/**
	 * Dados em String
	 */
	public String toString() {
		return String.format("IDENTIFICADOR: " + idMusica + "NOME DA MÚSICA: " + tituloDaMusica + "NOME DO ARTISTA: " + nomeDoArtista + "DURAÇÃO: " + duracaoDaMusica);
	}
	
	
	/**
	 * ID da musica
	 */
	public int hashCode () {
		return idMusica;
	}
	
	
	/**
	 * Igualdade de música por código
	 */
    public boolean equals(Object obj){
        try{
            Musica outro = (Musica)obj;
            return this.hashCode() == outro.hashCode();
        }catch (ClassCastException ex){
            return false;
        }
    }
	
	
	/**
	 * Comparar nomes das músicas
	 */
	public int compareTo (Musica outro) {
		return this.tituloDaMusica.compareTo(outro.tituloDaMusica);
	}
	
	
	/**
     * Cria uma musica a partir de uma linha de dados em formato texto. 
     * A linha de dados com a formatação:
     * "tituloDaMusica;nomeDoArtista;duracaoDaMusica;"
     */
    public Musica criarDoTexto(String linha) {
     
    	String[] dadosLinha;
    	String tituloDaMusica;
    	String nomeDoArtista;
    	double duracaoDaMusica;
    	Musica musica;
    	
    	dadosLinha = linha.split(";");
    	tituloDaMusica = dadosLinha[0];
    	nomeDoArtista = dadosLinha[1];
    	duracaoDaMusica = Double.parseDouble(dadosLinha[2].replace(",", "."));
        
		musica = new Musica (tituloDaMusica, nomeDoArtista, duracaoDaMusica);
    	
    	return musica;
    }
	
    
    /**
     * Gerar texto
     */
    public String gerarDadosEmTexto () {
    	String duracaoFormatada = String.format("%.2f", duracaoDaMusica).replaceAll(",", ".");
		
		return String.format("%s;%s;%s", tituloDaMusica, nomeDoArtista, duracaoFormatada);
    }
}
