package Methodos;

import java.util.Arrays;
import java.util.stream.Collectors;

public class FormatarFrase implements ExercicioInterface {
    public static String formatarFrase(String string) {
        return Arrays.stream(string.toLowerCase().split("(?<=\\.\\s)|(?<=\\?\\s)|(?<=\\!\\s)|(?<=\\:\\s)"))
                .map(sentence -> sentence.isEmpty() ? sentence : Character.toUpperCase(sentence.charAt(0)) + sentence.substring(1))
                .collect(Collectors.joining());
    }

    @Override
    public String executar(String input) {
        return formatarFrase(input);
    }
}
