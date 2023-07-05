public class Main {
    public static void main(String[] args) {
        //------ Primeiro Exercicio ------------------------

        String frase1 = "Hello, World! OpenAI is amazing.";
        String resultado = ManipulationStrings.inverterPalavras(frase1);
        ManipulationStrings.separador();
        System.out.println("Exercicio 1: Reverta a ordem das palavras nas frases, mantendo a ordem das palavras:");
        System.out.println("Entrada: " + frase1);
        System.out.println("Resultado: " + resultado);
        ManipulationStrings.separador();


        //------ Segundo Exercicio ------------------------

        String frase2 = "Hello, World!";
        String resultadoRemocao = ManipulationStrings.removerDuplicados(frase2);
        System.out.println("Exercicio 2: Remova todos os caracteres duplicados da string abaixo:");
        System.out.println("Entrada: " + frase2);
        System.out.println("Resultado: " + resultadoRemocao);
        ManipulationStrings.separador();


        //------ Terceiro Exercicio ------------------------

        String palavraPalindroma = "babad";
        String resultadoMaiorPalindrome = ManipulationStrings.maiorPalindrome(palavraPalindroma);
        System.out.println("Exercicio 3: Encontre a substring palindroma mais longa na string abaixo:");
        System.out.println("Entrada: " + palavraPalindroma);
        System.out.println("Resultado: " + resultadoMaiorPalindrome);
        ManipulationStrings.separador();


        //------ Quarto Exercicio ------------------------

        String frase3 = "hello. how are you? i'm fine, thank you.";
        String resultadoCapitalized = ManipulationStrings.capitalizeFrase(frase3);
        System.out.println("Exercicio 4: Coloque em maiúscula a primeira letra de cada frase na string:");
        System.out.println("Entrada: " + frase3);
        System.out.println("Resultado: " + resultadoCapitalized);
        ManipulationStrings.separador();


        //------ Quinto Exercicio ------------------------

        String palavra = "racecar";
        String resultadoAnagramaPalindrome = ManipulationStrings.anagramaPalindrome(palavra);
        System.out.println("Exercicio 5: Verifique se a string é um anagrama de um palindromo:");
        System.out.println("Entrada: " + palavra);
        System.out.println("Resultado: " + resultadoAnagramaPalindrome);
        ManipulationStrings.separador();

    }
}
