package br.edu.cesarschool.projetos.utils;

public class ValidaPlaca {
    public static boolean validarPlaca(String placa) {
        if (placa == null || placa.isEmpty()) {
            return false;
        }

        placa = placa.replace("-", "").toUpperCase();

        return placa.matches("[A-Z]{3}[0-9]{4}") || 
        		placa.matches("[A-Z]{3}[0-9][A-Z][0-9]{2}");
    }
}
