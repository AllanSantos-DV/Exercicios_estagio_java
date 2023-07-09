public class Main {
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

    public static void main(String[] args) {

        //------ Primeiro Exercicio ------------------------

        String resultado = ManipulationStrings.inverterPalavras(string1);
        System.out.println("Exercicio 1: Reverta a ordem das palavras nas frases, mantendo a ordem das palavras:");
        System.out.println("Entrada: " + string1);
        System.out.println("Resultado Esperado: " + res1);
        System.out.println("Resultado: " + resultado);
        System.out.println(res1.equals(resultado) ? "Resultados Iguais!":"Resultados Diferentes!");
        ManipulationStrings.separador();


        //------ Segundo Exercicio ------------------------

        String resultado2 = ManipulationStrings.removerDuplicados(string2);
        System.out.println("Exercício 2: Remova todos os caracteres duplicados da string abaixo:");
        System.out.println("Entrada: " + string2);
        System.out.println("Resultado Esperado: " + res2);
        System.out.println("Resultado: " + resultado2);
        System.out.println(res2.equals(resultado2) ? "Resultados Iguais!" : "Resultados Diferentes!");
        ManipulationStrings.separador();


        //------ Terceiro Exercicio ------------------------

        String resultado3 = ManipulationStrings.maiorPalindrome(string3);
        System.out.println("Exercício 3: Encontre a substring palíndroma mais longa na string abaixo:");
        System.out.println("Entrada: " + string3);
        System.out.println("Resultado Esperado: " + res3);
        System.out.println("Resultado: " + resultado3);
        System.out.println(res3.equals(resultado3) ? "Resultados Iguais!" : "Resultados Diferentes!");
        ManipulationStrings.separador();


        //------ Quarto Exercicio ------------------------

        String resultado4 = ManipulationStrings.capitalizeFrase(string4);
        System.out.println("Exercício 4: Coloque em maiúscula a primeira letra de cada frase na string:");
        System.out.println("Entrada: " + string4);
        System.out.println("Resultado Esperado: " + res4);
        System.out.println("Resultado: " + resultado4);
        System.out.println(res4.equals(resultado4) ? "Resultados Iguais!" : "Resultados Diferentes!");
        ManipulationStrings.separador();


        //------ Quinto Exercicio ------------------------

        String resultado5 = ManipulationStrings.anagramaPalindrome(string5);
        System.out.println("Exercício 5: Verifique se a string é um anagrama de um palíndromo:");
        System.out.println("Entrada: " + string5);
        System.out.println("Resultado Esperado: " + res5);
        System.out.println("Resultado: " + resultado5);
        System.out.println(res5.equals(resultado5) ? "Resultados Iguais!" : "Resultados Diferentes!");
        ManipulationStrings.separador();
    }
}
