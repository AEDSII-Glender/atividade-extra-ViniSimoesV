import java.util.NoSuchElementException;

public class Pilha<E> {

	private Celula<E> topo;
	private Celula<E> fundo;

	public Pilha() {
		Celula<E> sentinela = new Celula<E>();
		
		fundo = sentinela;
		topo = sentinela;

	}
	
	
	/**
	 * Verifica se vazia
	 * @return
	 */
	public boolean vazia() {
		return fundo == topo;
	}

	
	/**
	 * Inserir na pilha
	 * @param item
	 */
	public void empilhar(E item) {
		topo = new Celula<E>(item, topo);
	}

	
	/**
	 * Remover da pilha
	 * @return
	 */
	public E desempilhar() {
		E desempilhado = consultarTopo();
		topo = topo.getProximo();
		return desempilhado;
	}
	
	
	/**
	 *  Mostrar primeira
	 * @return
	 */
	public E consultarTopo() {
		if (vazia()) {
			throw new NoSuchElementException("Nao há nenhum item na pilha!");
		}

		return topo.getItem();
	}

}