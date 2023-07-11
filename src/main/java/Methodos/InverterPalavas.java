package Methodos;

import java.util.Arrays;

public class InverterPalavas implements ExercicioInterface {
    public static String inverterPalavras(String sentence) {
        return Arrays.stream(sentence.split(" "))
                .reduce((word1, word2) -> word2 + " " + word1)
                .orElse("");
    }

    @Override
    public String executar(String input) {
        return inverterPalavras(input);
    }
}