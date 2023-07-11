package Methodos;

public class ValidarEntrada {
    public static String entrada_Invalida = "Entrada Invalida";

    public static String validarEntrada(String valor) {
        return (valor == null || valor.isEmpty()) ? entrada_Invalida : valor;
    }
}