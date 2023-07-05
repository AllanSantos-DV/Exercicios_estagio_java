import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ManipulationStrings {

    private static final String EMPTY_STRING_ERROR = "Entrada Invalida.";

    public static void separador(){
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
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
    }

    public static String maiorPalindrome(String string) {
        validarEntrada(string);

        Optional<String> longestPalindrome = IntStream.range(0, string.length())
                .mapToObj(i -> IntStream.rangeClosed(i, string.length())
                        .mapToObj(j -> string.substring(i, j)))
                .flatMap(Function.identity())
                .filter(ManipulationStrings::isPalindrome)
                .max(Comparator.comparingInt(String::length));

        return longestPalindrome.orElse("");
    }

    private static boolean isPalindrome(String string) {
        int left = 0;
        int right = string.length() - 1;

        while (left < right) {
            if (string.charAt(left) != string.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static String capitalizeFrase(String string) {
        validarEntrada(string);

        return Arrays.stream(string.split("(?<=\\.\\s)|(?<=\\?\\s)"))
                .map(sentence -> sentence.isEmpty() ? sentence : Character.toUpperCase(sentence.charAt(0)) + sentence.substring(1))
                .collect(Collectors.joining());
    }

    public static String anagramaPalindrome(String string) {
        validarEntrada(string);

        Map<Character, Long> charFrequencyMap = string.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        long oddCount = charFrequencyMap.values()
                .stream()
                .filter(count -> count % 2 != 0)
                .count();

        return oddCount <= 1 ? "true" : "false";
    }

}
