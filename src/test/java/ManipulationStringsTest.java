import Methodos.*;
import junit.framework.TestCase;
import org.junit.Test;

public class ManipulationStringsTest {

    static String string1 = "Hello, World! OpenAI is amazing.";
    static String res1 = "amazing. is OpenAI World! Hello,";

    static String string2 = "Hello, World!";
    static String res2 = "Helo, Wrd!";

    static String string3 = "babad";
    static String res3 = "bab";

    static String string4 = "hello. how are you? i'm fine, thank you.";
    static String res4 = "Hello. How are you? I'm fine, thank you.";

    static String string5 = "racecar";
    static String res5 = "true";

    @Test
    public void inverterPalavrasTest() {
        String resultado = InverterPalavas.inverterPalavras(string1);
        TestCase.assertEquals(res1, resultado);
    }

    @Test
    public void removerDuplicadosTest() {
        String resultadoRemocao = RemoverDuplicado.removerDuplicados(string2);
        TestCase.assertEquals(res2, resultadoRemocao);
    }

    @Test
    public void maiorPalindromoTest() {
        String resultadoMaiorPalindromo = MaiorPalindromo.maiorPalindromo(string3);
        TestCase.assertEquals(res3, resultadoMaiorPalindromo);
    }

    @Test
    public void formatarFraseTest() {
        String resultadoFormated = FormatarFrase.formatarFrase(string4);
        TestCase.assertEquals(res4, resultadoFormated);
    }

    @Test
    public void anagramaPalindromoTest() {
        String resultadoAnagramaPalindromo = AnagramaPalindromo.anagramaPalindromo(string5);
        TestCase.assertEquals(res5, resultadoAnagramaPalindromo);
    }

}
