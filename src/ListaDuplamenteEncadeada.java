public class ListaDuplamenteEncadeada<E> {
	
	// Atributos
	private Celula<E> primeiro;
	private Celula<E> ultimo;
	private int tamanho;
	
	public ListaDuplamenteEncadeada() {
		Celula<E> sentinela = new Celula<>();
		
		this.primeiro = this.ultimo = sentinela;
		this.tamanho = 0;
	}
	
	
	/**
	 * Verifica se vazia
	 */
	public boolean vazia() {
		return (this.primeiro == this.ultimo);
	}
	
	
	/**
	 * Inserir no final da Lista
	 * @param novo
	 */
	public void inserirFinal(E novo) {	
		Celula<E> novaCelula = new Celula<>(novo, this.ultimo, null);
		
		this.ultimo.setProximo(novaCelula);	
		this.ultimo = novaCelula;
		
		this.tamanho++;
	}
	
	
	/**
	 * Remover no final
	 * @return
	 */
	public E removerFinal() {		
		Celula<E> removida, penultima;
		
		if (vazia())
			throw new IllegalStateException("Erro. A lista já está vazia.");

		removida = this.ultimo;
			
		penultima = this.ultimo.getAnterior();
		penultima.setProximo(null);
		
		removida.setAnterior(null);
			
		this.ultimo = penultima;
			
		this.tamanho--;
			
		return (removida.getItem());
	}
}
