# Manipulação de Strings em Java

Este é um projeto de manipulação de strings em Java, que consiste em uma série de funções para resolver diferentes tipos
de problemas relacionados a strings.

## Menu

- ## Execução
    * ### Executar Exercicios no site: [`myCompiler`](https://www.mycompiler.io/view/CYaRYi7XGaS)
        * ***Obervação:*** O exercicio aparesentado no site foi devidamente modificado para ser executado no ambiente do
          site.
    * Clone esse repositorio em sua maquine e execute a classe `TelaApp.java` na sua **IDE** Favorita.
    * Execute **`ManipularStrings.jar`** ou **`ManipularStrings.exe`** na pasta **raiz** desse repositorio.


- ### [Tecnologias](#tecnologias-utilizadas)
- ### [Funções Principais](#funções)
    *  #### ***[1. Inverter Palavras](#inverter-palavras)*** - ***[2. Remover Duplicados](#remover-duplicados)***
    *  #### ***[3. Maior Palindromo](#maior-palindromo)*** - ***[4. Formatar Frase](#formatar-frase)***
    *  #### ***[5. Anagrama Palindromo](#anagrama-palindromo)*** - ***[6. Validar Entrada](#validar-entrada)***
- ### [Teste Com Junit](#testes-junit)
- ### [Interface](#interface-gráfica)
- ### [Observações Gerais](#observações)

## Tecnologias utilizadas

- Java
- JUnit
- Swing

## Funções

Aqui estão as funções em destaque no projeto:

### Inverter Palavras

A função `inverterPalavras` recebe uma string como entrada e retorna uma nova string com as palavras invertidas.

```java 
    public static String inverterPalavras(String sentence){
        return Arrays.stream(sentence.split(" "))
        .reduce((word1,word2)->word2+" "+word1)
        .orElse("");
        }
```

### Remover Duplicados

A função `removerDuplicados` recebe uma string como entrada e retorna uma nova string com os caracteres duplicados
removidos.

```java
    public static String removerDuplicados(String string){
        return string.chars()
        .distinct()
        .collect(StringBuilder::new,(sb,c)->sb.append((char)c),StringBuilder::append)
        .toString();
        }
```

### Maior Palindromo

A função `maiorPalindromo` recebe uma string como entrada e retorna o maior palíndromo encontrado na string.

```java
    public static String maiorPalindromo(String string){
        Optional<String> longestPalindromo=IntStream.range(0,string.length())
        .mapToObj(i->IntStream.rangeClosed(i,string.length())
        .mapToObj(j->string.substring(i,j)))
        .flatMap(Function.identity())
        .filter(s->{
        String reversed=new StringBuilder(s).reverse().toString();
        return s.equals(reversed);
        })
        .max(Comparator.comparingInt(String::length));

        return longestPalindromo.orElse("");
        }
```

### Formatar Frase

A função `formatarFrase` recebe uma string como entrada e retorna uma nova string com a primeira letra de cada palavra
em maiúsculo.

```java
    public static String formatarFrase(String string){
        return Arrays.stream(string.toLowerCase().split("(?<=\\.\\s)|(?<=\\?\\s)|(?<=\\!\\s)|(?<=\\:\\s)"))
        .map(sentence->sentence.isEmpty()?sentence:Character.toUpperCase(sentence.charAt(0))+sentence.substring(1))
        .collect(Collectors.joining());
        }
```

### Anagrama Palindromo

A função `anagramaPalindromo` recebe uma string como entrada e verifica se é possível reorganizar as letras da string
para formar um palíndromo.

```java
    public static String anagramaPalindromo(String string){
        Map<Character, Long> charFrequencyMap=string.chars()
        .mapToObj(c->(char)c)
        .collect(Collectors.toMap(Function.identity(),c->1L,Long::sum));

        long oddCount=charFrequencyMap.values()
        .stream()
        .filter(count->count%2!=0)
        .count();

        return oddCount<=1?"true":"false";
        }
```

### Validar Entrada

A função `validarEntrada` recebe um input(string) e verifica se ele é *nulo* ou *vazio*, em caso de *nulo* ou *vazio*
retorna `String entrada_Invalida`, caso contrario retorna o input(string).

```java
    public static String entrada_Invalida="Entrada Invalida";

public static String validarEntrada(String valor){
        return(valor==null||valor.isEmpty())?entrada_Invalida:valor;
        }
```

## Testes Junit

#### TestUnitRunner

A classe TestUnitRunner contém os seguintes métodos:

- `inverterPalavrasTest(String frase)`: Este método recebe uma frase como entrada e retorna a frase com as palavras
  invertidas.
- `removerDuplicadoTest(String palavra)`: Este método recebe uma palavra como entrada e retorna a palavra sem caracteres
  duplicados.
- `maiorPalindromoTest(String frase)`: Este método recebe uma frase como entrada e retorna o maior palíndromo na frase.
- `formatarFraseTest(String frase)`: Este método recebe uma frase como entrada e retorna a frase com as palavras
  capitalizadas e sem espaços extras.
- `anagramaPalindromoTest(String palavra)`: Este método recebe uma palavra como entrada e retorna se a palavra é um
  anagrama de um palíndromo.

* #### Variaveis utilizadas

```java
    static String string1="Hello, World! OpenAI is amazing.";
static String res1="amazing. is OpenAI World! Hello,";

static String string2="Hello, World!";
static String res2="Helo, Wrd!";

static String string3="babad";
static String res3="bab";

static String string4="hello. how are you? i'm fine, thank you.";
static String res4="Hello. How are you? I'm fine, thank you.";

static String string5="racecar";
static String res5="true";
```

* #### Métodos Utilizados

```java
    @Test
public void inverterPalavrasTest(){
        String resultado=InverterPalavas.inverterPalavras(string1);
        assertEquals(res1,resultado);
        }

@Test
public void removerDuplicadosTest(){
        String resultadoRemocao=RemoverDuplicado.removerDuplicados(string2);
        assertEquals(res2,resultadoRemocao);
        }

@Test
public void maiorPalindromoTest(){
        String resultadoMaiorPalindromo=MaiorPalindromo.maiorPalindromo(string3);
        assertEquals(res3,resultadoMaiorPalindromo);
        }

@Test
public void formatarFraseTest(){
        String resultadoFormated=FormatarFrase.formatarFrase(string4);
        assertEquals(res4,resultadoFormated);
        }

@Test
public void anagramaPalindromoTest(){
        String resultadoAnagramaPalindromo=AnagramaPalindromo.anagramaPalindromo(string5);
        assertEquals(res5,resultadoAnagramaPalindromo);
        }
```

## Interface Gráfica

O projeto inclui uma interface gráfica feita em Swing para facilitar a execução das funções. Para executar a interface,
basta executar a classe `TelaApp`.

* A interface possui:
    * Menu suspenso feito com `JComboBox` para a selecção do exercicio.
    * Input feito com `JTextField` para receber string do usuario.
    * Botão **Executar** feito com `JButton` para executar o exercicio selecionado usando o **Input** como parametro do
      exercicio.
    * Saida feita com `JTextField` para mostrar o resultado do exercicio executado. ( Permitido a copia do **Resultado
      ** )
    * Botão **Executar Testes Junit** feito com `JButton` para executar os testes **Junit**.
    * Saida dos Testes feita com `JTextArea` para exibir o resultado dos testes **Junit**. ( Visivel apos interação com
      botão **Executar Testes Junit** )
    * Botão **Fechar Testes** feito com `JButton` para fechar a saida de testes **Junit**. ( Visivel apos interação com
      botão **Executar Testes Junit** )

        - #### Tela inicial
          <img src="/src/img/TelaApp.png" alt="Tela Inicio" title="Tela Incio">

## Observações

- Os exercicios foram resolvidos utilizando a linguagem Java na versão 17 do JDK.
- Para todos os desafios, foi assumido que a entrada contém apenas caracteres alfabéticos, espaços e sinais de
  pontuação.
- A saída para cada desafio é retornada como uma string.
- No Exercicio 4 **( Formatar Frase )** foi assumido que na ***saida*** a Frase devera somente ter a primeira letra de
  cada palavra em maiusculo.