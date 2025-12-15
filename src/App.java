import java.nio.charset.Charset;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.function.Function;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class App {

	/** Nome do arquivo de dados. O arquivo deve estar localizado na raiz do projeto */
    static String nomeArquivoDados;
    
    /** Scanner para leitura de dados do teclado */
    static Scanner teclado;

    /** Quantidade de musicas cadastradas atualmente na lista */
    static int quantasMusicas = 0;
    
    Fila<Musica> playList;
    playList = new Fila<Musica>();
    
    Musica musica;
    
    static void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /** Gera um efeito de pausa na CLI. Espera por um enter para continuar */
    static void pausa() {
        System.out.println("Digite enter para continuar...");
        teclado.nextLine();
    }

    /** Cabeçalho principal da CLI do sistema */
    static void cabecalho() {
        System.out.println("============SPOTIFY============");
    }
   
    static <T extends Number> T lerOpcao(String mensagem, Class<T> classe) {
        
    	T valor;
        
    	System.out.println(mensagem);
    	try {
            valor = classe.getConstructor(String.class).newInstance(teclado.nextLine());
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException 
        		| InvocationTargetException | NoSuchMethodException | SecurityException e) {
            return null;
        }
        return valor;
    }
    
    /** Imprime o menu principal, lê a opção do usuário e a retorna (int).
     * @return Um inteiro com a opção do usuário.
    */
    static int menu() {
        cabecalho();
        System.out.println("1 - Adicionar Música");
        System.out.println("2 - Remover Música");
        System.out.println("3 - Adicionar para fila");
        System.out.println("4 - Ordenar Playlist");
        System.out.println("5 - Reproduzir Música na ordem");
        System.out.println("6 - Reproduzir Música no aleatório");
        System.out.println("7 - Exibir playlist");
        System.out.println("0 - Sair");
        System.out.print("Digite sua opção: ");
        return Integer.parseInt(teclado.nextLine());
    }
    
    
    /**
     * Caminhar musicas
     */
    public static void caminharOpcoes (String nomeArquivoDados) {
    	Scanner arquivo = null;
    	String linha;
    	
    	arquivo = new Scanner(new File(nomeArquivoDados), Charset.forName("UTF-8"));
    	
    	
    	while (arquivo.hasNextLine()) {
    		linha = arquivo.Musica.criarDoTexto();
    		System.out.println(linha);
    	}
    	arquivo.close();
    }
    
    /**
     * Adicionar musica na playlist por ID
     */
    public void adicionarNaPlaylist () {
    	nomeArquivoDados = "musica.txt";
    	teclado = new Scanner(System.in, Charset.forName("UTF-8"));
    	int id;
    	
    	System.out.println ("Escolha uma das opções (ID): ");
    	caminharOpcoes(nomeArquivoDados);
    	
    	id = Integer.(teclado);
    	
    	// buscar por id
    	
    	this.musica = musica;
    	playList.enfileirar(this.musica);
    }

    /**
     * Exibir Playlist
     * @param musica
     */
    private static void exibirPlaylist() {
    	Fila<Musica> playList;
        playList.imprimir();
    }
    
    
	public static void main(String[] args) {
		teclado = new Scanner(System.in, Charset.forName("UTF-8"));
        nomeArquivoDados = "musica.txt";
        
        int opcao = -1;
      
        do{
            opcao = menu();
            switch (opcao) {
                case 1 -> caminharOpcoes(nomeArquivoDados);
                case 2 -> exibirPlaylist();
                case 3 -> exibirPlaylist();
                case 4 -> exibirPlaylist();
                case 5 -> exibirPlaylist();
                case 6 -> exibirPlaylist();
            }
            pausa();
        }while(opcao != 0);       

        teclado.close();    
    }
}