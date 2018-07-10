package model;

/**
 * Classe responsável por registrar e armazenar dados de um item do 
 * tipo: Por unidade. Herda da classe ItemCompravel
 * 
 * @author José Guilheme - Matricula: 117210370
 * @author Mariana Nascimento - Matricula: 117210395
 * @author Siuanny Barbosa - Matriucla: 
 * @author Thayanne Sousa - Matricula:
 * UFCG/2018.1 - Laboratório de Programação 2 - Projeto de Laboratorio (Lista pra mim)
 */
public class ItemPorUnidade extends ItemCompravel {

	private int unidade;

	/**
	 * Construtor de ItemPorUnidade, herdando codigo da classe pai.
	 * 
	 * @param nome
	 *          nome do item
	 * @param categoria
	 * 			categoria do item
	 * @param unidades
	 * 			quantidade de itens comprados
	 * @param localDeCompra
	 * 			local da compra do produto
	 * @param preco
	 * 			preco do item
	 * @param base
	 * 			base para gerar o id do item
	 */
	public ItemPorUnidade(String nome, int id, String categoria, int unidades, String localDeCompra, double preco) {
		super(nome, id, categoria, localDeCompra, preco);
		this.unidade = unidades;
	}
	
	/**
	 * Responsavel por pegar aqunatidade comprada do item.
	 * @return int - representando a quantidade do item
	 */
	public int getUnidade() {
		return unidade;
	}
	
	private String localPreco() {
		String localPreco = "";
		for (String localDeCompra : mapaDePrecos.keySet()) {
			localPreco += localDeCompra + ", " + String.format("R$ %.2f", (mapaDePrecos.get(localDeCompra))) + ";";
		}
		return localPreco;
	}
	
	/**
	 * Responsavel por retornar a represnetação em String de um ItemPorUnidade.
	 * @return String - representando um ItemPorUnidade
	 */
	@Override
	public String toString() {
		return id + ". " + nome + ", " + categoria + ", " +  "Preco: <" + localPreco() + ">" ;
	}
}
