package Methodos;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AnagramaPalindromo implements ExercicioInterface {
    public static String anagramaPalindromo(String string) {
        Map<Character, Long> charFrequencyMap = string.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toMap(Function.identity(), c -> 1L, Long::sum));

        long oddCount = charFrequencyMap.values()
                .stream()
                .filter(count -> count % 2 != 0)
                .count();

        return oddCount <= 1 ? "true" : "false";
    }

    @Override
    public String executar(String input) {
        return anagramaPalindromo(input);
    }
}
