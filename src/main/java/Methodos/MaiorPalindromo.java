package Methodos;

import java.util.Comparator;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.IntStream;

public class MaiorPalindromo implements ExercicioInterface {
    public static String maiorPalindromo(String string) {
        Optional<String> longestPalindromo = IntStream.range(0, string.length())
                .mapToObj(i -> IntStream.rangeClosed(i, string.length())
                        .mapToObj(j -> string.substring(i, j)))
                .flatMap(Function.identity())
                .filter(s -> {
                    String reversed = new StringBuilder(s).reverse().toString();
                    return s.equals(reversed);
                })
                .max(Comparator.comparingInt(String::length));

        return longestPalindromo.orElse("");
    }

    @Override
    public String executar(String input) {
        return maiorPalindromo(input);
    }
}
