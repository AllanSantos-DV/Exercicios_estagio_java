import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ManipulationStringsTest {
    @Test
    public void inverterPalavrasTest(){
        String frase1 = "Hello, World! OpenAI is amazing.";
        String resultado = ManipulationStrings.inverterPalavras(frase1);
        String resultadoEsperado = "amazing. is OpenAI World! Hello,";
        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    public void removerDuplicadosTest(){
        String frase2 = "Hello, World!";
        String resultadoRemocao = ManipulationStrings.removerDuplicados(frase2);
        String resultadoEsperado = "Helo, Wrd!";
        assertEquals(resultadoEsperado, resultadoRemocao);
    }

    @Test
    public void maiorPalindromeTest(){
        String palavraPalindroma = "babad";
        String resultadoMaiorPalindrome = ManipulationStrings.maiorPalindrome(palavraPalindroma);
        String resultadoEsperado = "bab";
        assertEquals(resultadoEsperado, resultadoMaiorPalindrome);
    }

    @Test
    public void capitalizeFraseTest(){
        String frase3 = "hello. how are you? i'm fine, thank you.";
        String resultadoCapitalized = ManipulationStrings.capitalizeFrase(frase3);
        String resultadoEsperado = "Hello. How are you? I'm fine, thank you.";
        assertEquals(resultadoEsperado, resultadoCapitalized);
    }

    @Test
    public void anagramaPalindromeTest(){
        String palavra = "racecar";
        String resultadoAnagramaPalindrome = ManipulationStrings.anagramaPalindrome(palavra);
        String resultadoEsperado = "true";
        assertEquals(resultadoEsperado, resultadoAnagramaPalindrome);
    }
}
