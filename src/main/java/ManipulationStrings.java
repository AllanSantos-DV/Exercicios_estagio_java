import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ManipulationStrings {

    private static final String EMPTY_STRING_ERROR = "Entrada Invalida.";

    public static void separador() {
        System.out.println("------------------------------------------");
    }

    private static void validarEntrada(String valor) {
        if (valor == null || valor.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_STRING_ERROR);
        }
    }

    public static String inverterPalavras(String sentence) {
        validarEntrada(sentence);

        return Arrays.stream(sentence.split(" "))
                .reduce((word1, word2) -> word2 + " " + word1)
                .orElse("");
    }

    public static String removerDuplicados(String string) {
        validarEntrada(string);

        return string.chars()
                .distinct()
                .collect(StringBuilder::new, (sb, c) -> sb.append((char) c), StringBuilder::append)
                .toString();
    }

    public static String maiorPalindrome(String string) {
        validarEntrada(string);

        Optional<String> longestPalindrome = IntStream.range(0, string.length())
                .mapToObj(i -> IntStream.rangeClosed(i, string.length())
                        .mapToObj(j -> string.substring(i, j)))
                .flatMap(Function.identity())
                .filter(s -> {
                    String reversed = new StringBuilder(s).reverse().toString();
                    return s.equals(reversed);
                })
                .max(Comparator.comparingInt(String::length));

        return longestPalindrome.orElse("");
    }

    public static String capitalizeFrase(String string) {
        validarEntrada(string);

        return Arrays.stream(string.toLowerCase().split("(?<=\\.\\s)|(?<=\\?\\s)|(?<=\\!\\s)|(?<=\\:\\s)"))
                .map(sentence -> sentence.isEmpty() ? sentence : Character.toUpperCase(sentence.charAt(0)) + sentence.substring(1))
                .collect(Collectors.joining());
    }

    public static String anagramaPalindrome(String string) {
        validarEntrada(string);

        Map<Character, Long> charFrequencyMap = string.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toMap(Function.identity(), c -> 1L, Long::sum));

        long oddCount = charFrequencyMap.values()
                .stream()
                .filter(count -> count % 2 != 0)
                .count();

        return oddCount <= 1 ? "true" : "false";
    }

}
