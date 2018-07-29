package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Classe que contem metodos de validacao usados pelo sistema
 * 
 * @author José Guilheme - Matricula: 117210370
 * @author Mariana Nascimento - Matricula: 117210416
 * @author Siuanny Barbosa - Matriucla: 117210395
 * @author Thayanne Sousa - Matricula: 117210414
 * 
 *         UFCG/2018.1 - Laboratório de Programação 2 - Projeto de Laboratorio
 *         (Lista pra mim)
 */
public class Validator {

	/**
	 * Verifica se número é positivo
	 * 
	 * @param num número a ser comparado
	 * @param mensagem mensagem que deve ser incluída na exceção
	 * @return boolean retorna se for positivo
	 * @exception IllegalArgumentException se for negativo
	 */
	public static boolean ehPositivo(double num, String mensagem){
		if(num <= 0)
			throw new IllegalArgumentException(mensagem);
		return true;
	}
	
	/**
	 * Verifica se um campo de texto não é nulo e nem vazio
	 * 
	 * @param campo texto a ser validado
	 * @return boolean retorna verdadeiro se não for vazio ou nulo
	 * @exception IllegalArgumentException se o campo for nulo ou vazio
	 */
	public static boolean campoValido(String campo, String mensagem){
		if(campo == null || campo.trim().isEmpty())
			throw new IllegalArgumentException(mensagem);
		return true;
	}
	
	/**
	 * Verifica se a categoria é válida pros tipos conhecidos
	 * 
	 * @param categoria categoria a ser verficida
	 * @param mensagem mensagem que vai ser retorna se houver erro
	 * @exception IllegalArgumentException caso seja passado uma categoria inválida
	 */
	public static boolean categoriaValida(String categoria, String mensagem){
		for (CategoriaEnum c : CategoriaEnum.values()) {
			if (c.toString().equals(categoria.toLowerCase())) {
				return true;
			}
		}
		throw new IllegalArgumentException(mensagem);
	}
	
	/**
	 * Verifica se campo eh uma data valida
	 * 
	 * @param data campo a ser verificado
	 * @param mensagem mensagem de erro a ser retornado se nao for valido
	 * @exception IllegalArgumentException caso seja passado uma categoria inválida
	 */
	public static void dataValida(String data, String mensagem){
		String dateFormat = "dd/MM/yyyy";
		try {
			DateFormat df = new SimpleDateFormat(dateFormat);
            df.setLenient(false);
            df.parse(data);
        } catch (ParseException e) {
        		throw new IllegalArgumentException(mensagem);
        }
	}

	/**
	 * Verifica se a operacao de atualizacao da lista de compras eh valida.
	 * 
	 * @param operacao
	 *            operacao que sera realizada
	 * @param msg
	 *            mensagem que sera lancada
	 * @return valor booleano
	 */
	public static void operacaoValida(String operacao, String msg) {
		if (!(operacao.equals("adiciona") || operacao.equals("diminui")))
			throw new IllegalArgumentException(msg);
	}
	
	/**
	 * Verifica se o id de um item eh valido.
	 * 
	 * @param id
	 *            identificacao do item
	 * @param msg
	 * @return valor booleano
	 */
	public static void idValido(int id, String msg) {
		if (id < 1)
			throw new IllegalArgumentException(msg);
	}
	
}
