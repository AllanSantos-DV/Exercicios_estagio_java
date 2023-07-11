package Methodos;

public class RemoverDuplicado implements ExercicioInterface {
    public static String removerDuplicados(String string) {
        return string.chars()
                .distinct()
                .collect(StringBuilder::new, (sb, c) -> sb.append((char) c), StringBuilder::append)
                .toString();
    }

    @Override
    public String executar(String input) {
        return removerDuplicados(input);
    }
}
