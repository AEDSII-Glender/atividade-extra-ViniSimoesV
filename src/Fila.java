import java.util.NoSuchElementException;

public class Fila<E> {

	private Celula<E> frente;
	private Celula<E> tras;
	
	Fila() {
		Celula<E> sentinela = new Celula<E>();
		frente = tras = sentinela;
	}
	
	
	/**
	 * verifica se vazia
	 * @return
	 */
	public boolean vazia() {
		return (frente == tras);
	}
	
	
	/**
	 * Inserir na fila
	 * @param item
	 */
	public void enfileirar(E item) {
		Celula<E> novaCelula = new Celula<E>(item);
		
		tras.setProximo(novaCelula);
		tras = tras.getProximo();
	}
	
	
	/**
	 * remover da fila
	 * @return
	 */
	public E desenfileirar() {
		E item = null;
		Celula<E> primeiro;
		
		item = consultarPrimeiro();
		
		primeiro = frente.getProximo();
		frente.setProximo(primeiro.getProximo());
		
		primeiro.setProximo(null);
			
		// Caso o item desenfileirado seja também o último da fila.
		if (primeiro == tras)
			tras = frente;
		
		return item;
	}
	
	public E consultarPrimeiro() {
		if (vazia()) {
			throw new NoSuchElementException("Erro. Fila está vazia.");
		}

		return frente.getProximo().getItem();

	}
	
	public void imprimir() {
		
		Celula<E> aux;
		
		if (vazia())
			System.out.println("Erro. Fila está vazia.");
		else {
			aux = this.frente.getProximo();
			while (aux != null) {
				System.out.println(aux.getItem());
				aux = aux.getProximo();
			}
		} 	
	}
}