# Manipulação de Strings em Java

Este repositório contém a resolução dos Exercicios de manipulação de strings usando a linguagem Java (versão JDK 11).

Cada desafio foi resolvido em uma função independente que recebe uma String  e retorna a saída como uma string.

## Menu

- Exercicios
  - [**Exercicio 1:** *Reverter a ordem das palavras nas frases, mantendo a ordem das palavras.*](#exercicio-1)
  - [**Exercicio 2:** *Remover todos os caracteres duplicados da string.*](#exercicio-2)
  - [**Exercicio 3:** *Encontrar a substring palíndroma mais longa.*](#exercicio-3)
  - [**Exercicio 4:** *Colocar em maiúscula a primeira letra de cada frase na string.*](#exercicio-4)
  - [**Exercicio 5:** *Verificar se a string é um anagrama de um palíndromo.*](#exercicio-5)
- Testes com JUnit
  - [**Exercicio 1:** *Reverter a ordem das palavras nas frases, mantendo a ordem das palavras.*](#teste-exercicio-1)
  - [**Exercicio 2:** *Remover todos os caracteres duplicados da string.*](#teste-exercicio-2)
  - [**Exercicio 3:** *Encontrar a substring palíndroma mais longa.*](#teste-exercicio-3)
  - [**Exercicio 4:** *Colocar em maiúscula a primeira letra de cada frase na string.*](#teste-exercicio-4)
  - [**Exercicio 5:** *Verificar se a string é um anagrama de um palíndromo.*](#teste-exercicio-5)
- [Observações](#observações)

## Exercicio 1

**Descrição: Reverter a ordem das palavras nas frases, mantendo a ordem das palavras.**

Este exercício consiste em inverter a ordem das palavras em uma frase, mantendo a ordem das palavras individuais. As palavras da frase são separadas e, em seguida, dispostas em ordem inversa, preservando a ordem das palavras em si.

#### Resolução:
A função `inverterPalavras` recebe uma frase como entrada. A frase é dividida em palavras, usando o espaço como delimitador. Em seguida, as palavras são invertidas e concatenadas novamente, preservando a ordem das palavras individuais.

```
    public static String inverterPalavras(String sentence) {
        validarEntrada(sentence);

        return Arrays.stream(sentence.split(" "))
                .reduce((word1, word2) -> word2 + " " + word1)
                .orElse("");
    }
```

## Exercicio 2

**Descrição: Remover todos os caracteres duplicados da string**
Neste exercício, o objetivo é remover todos os caracteres duplicados de uma string. Cada caractere na string é verificado e apenas a primeira ocorrência de cada caractere é mantida, removendo as duplicatas.

#### Resolução:
A função `removerDuplicados` recebe uma string como entrada. A string é convertida em uma sequência de caracteres. Em seguida, os caracteres duplicados são removidos, mantendo apenas a primeira ocorrência de cada caractere. Os caracteres únicos são concatenados novamente em uma nova string.

```
    public static String removerDuplicados(String string) {
        validarEntrada(string);

        return string.chars()
                .distinct()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
    }
```

## Exercicio 3

**Descrição: Encontrar a substring palíndroma mais longa**
O objetivo deste exercício é encontrar a maior substring palindrômica em uma string. Uma substring palindrômica é uma sequência de caracteres que permanece a mesma, tanto lida da esquerda para a direita quanto da direita para a esquerda.

#### Resolução:
A função `maiorPalindrome` recebe uma string como entrada. A função gera todas as substrings possíveis da string original e verifica se cada substring é um palíndromo com a função `isPalindrome`. A maior substring palindrômica é retornada como resultado.

```
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

```
```

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
```

## Exercicio 4

**Descrição: Colocar em maiúscula a primeira letra de cada frase na string.**

Neste exercício, a tarefa é transformar a primeira letra de cada frase em uma string em maiúscula. As frases são identificadas com base em pontuações como ponto final (.) ou ponto de interrogação (?), e a primeira letra de cada frase é convertida para maiúscula.

#### Resolução:
A função `capitalizeFrase` recebe uma string como entrada. A string é dividida em frases, usando os pontos finais (.) e pontos de interrogação (?) como delimitadores. Em seguida, a primeira letra de cada frase é convertida para maiúscula. As frases modificadas são concatenadas novamente em uma nova string.

```
    public static String capitalizeFrase(String string) {
        validarEntrada(string);

        return Arrays.stream(string.split("(?<=\\.\\s)|(?<=\\?\\s)"))
                .map(sentence -> sentence.isEmpty() ? sentence : Character.toUpperCase(sentence.charAt(0)) + sentence.substring(1))
                .collect(Collectors.joining());
    }
```

## Exercicio 5

**Descrição: Verificar se a string é um anagrama de um palíndromo.**

O objetivo deste exercício é determinar se uma string é um anagrama de um palíndromo. Um palíndromo é uma sequência de caracteres que permanece a mesma quando lida da esquerda para a direita e da direita para a esquerda. Para que uma string seja um anagrama de um palíndromo, todos os caracteres na string devem ter um número par de ocorrências, exceto no máximo um caractere, que pode ter um número ímpar de ocorrências.

#### Resolução:
A função `anagramaPalindrome` recebe uma string como entrada. A função verifica se a string é um anagrama de um palíndromo. Para isso, conta-se o número de ocorrências de cada caractere na string. Se a string tiver no máximo um caractere com número ímpar de ocorrências, ela é considerada um anagrama de um palíndromo. O resultado é retornado como *"true"* ou *"false"*.

```
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
```

## Testes realizados com JUnit

Foram implementados testes utilizando o framework de testes JUnit para validar as soluções dos desafios.
Os testes podem ser encontrados no módulo Test na classe `ManipulationStringsTest`.

## Teste Exercicio 1
```
    public void inverterPalavrasTest(){
        String frase1 = "Hello, World! OpenAI is amazing.";
        String resultado = ManipulationStrings.inverterPalavras(frase1);
        String resultadoEsperado = "amazing. is OpenAI World! Hello,";
        assertEquals(resultadoEsperado, resultado);
    }
```

## Teste Exercicio 2
```
    public void removerDuplicadosTest(){
        String frase2 = "Hello, World!";
        String resultadoRemocao = ManipulationStrings.removerDuplicados(frase2);
        String resultadoEsperado = "Helo, Wrd!";
        assertEquals(resultadoEsperado, resultadoRemocao);
    }
```

## Teste Exercicio 3
```
    public void maiorPalindromeTest(){
        String palavraPalindroma = "babad";
        String resultadoMaiorPalindrome = ManipulationStrings.maiorPalindrome(palavraPalindroma);
        String resultadoEsperado = "bab";
        assertEquals(resultadoEsperado, resultadoMaiorPalindrome);
    }
```

## Teste Exercicio 4
```
    public void capitalizeFraseTest(){
        String frase3 = "hello. how are you? i'm fine, thank you.";
        String resultadoCapitalized = ManipulationStrings.capitalizeFrase(frase3);
        String resultadoEsperado = "Hello. How are you? I'm fine, thank you.";
        assertEquals(resultadoEsperado, resultadoCapitalized);
    }
```

## Teste Exercicio 5
```
    public void anagramaPalindromeTest(){
        String palavra = "racecar";
        String resultadoAnagramaPalindrome = ManipulationStrings.anagramaPalindrome(palavra);
        String resultadoEsperado = "true";
        assertEquals(resultadoEsperado, resultadoAnagramaPalindrome);
    }
```

## Observações

- Os exercicios foram resolvidos utilizando a linguagem Java na versão 11 do JDK.
- Para todos os desafios, foi assumido que a entrada contém apenas caracteres alfabéticos, espaços e sinais de pontuação.
- A saída para cada desafio é retornada como uma string.
