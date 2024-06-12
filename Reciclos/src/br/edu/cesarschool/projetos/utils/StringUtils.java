package br.edu.cesarschool.projetos.utils;

public class StringUtils {
	private StringUtils() {
		
	}
	public static boolean isVaziaOuNula(String valor) {
		return valor == null || valor.trim().equals("");
	}
}