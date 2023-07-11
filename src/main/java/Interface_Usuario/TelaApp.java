package Interface_Usuario;

import javax.swing.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import Methodos.ExercicioInterface;
import Methodos.*;
import Test.TestUnitRunner;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TelaApp extends JFrame {
    private JPanel tela_App;
    private JComboBox<String> exercicio_Combox;
    private JTextField input_Text;
    private JTextField resultado_Text;
    private JButton executar_Button;
    private JButton button_Testes;
    private JButton fechar_Testes;
    private JLabel exercicio_Label;
    private JLabel input_Label;
    private JLabel resultado_Label;
    private JTextArea resultado_Test;
    private JScrollPane scrollResultadoText;

    private final Map<String, ExercicioInterface> funcoesExercicios;

    ImageIcon imageIcon = new ImageIcon("../../img/java.png");

    public TelaApp() {

        setTitle("Exercícios");
        setIconImage(imageIcon.getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(tela_App);

        button_Testes.addActionListener(e -> {
            fechar_Testes.setVisible(true);
            scrollResultadoText.setVisible(true);
            JUnitCore junit = new JUnitCore();
            Result result = junit.run(TestUnitRunner.class);

            String resultadoTestes = """
                    Executando inverterPalavrasTest...
                    Executando removerDuplicadosTest...
                    Executando maiorPalindromeTest...
                    Executando capitalizeFraseTest...
                    Executando anagramaPalindromeTest...

                    """;

            String resultadoFinal = result.wasSuccessful()
                    ? "Todos os testes foram executados com sucesso!"
                    : "Alguns testes falharam:\n" + result.getFailures().stream()
                    .map(Failure::toString)
                    .collect(Collectors.joining("\n"));

            resultado_Test.setText(resultadoTestes + resultadoFinal);
        });

        fechar_Testes.addActionListener(e -> {
            resultado_Test.setText("");
            scrollResultadoText.setVisible(false);
            fechar_Testes.setVisible(false);
        });

        funcoesExercicios = new LinkedHashMap<>();
        funcoesExercicios.put("Inverter Palavras", new InverterPalavas());
        funcoesExercicios.put("Remover Duplicados", new RemoverDuplicado());
        funcoesExercicios.put("Maior Palindrome", new MaiorPalindromo());
        funcoesExercicios.put("Formatar Frase", new FormatarFrase());
        funcoesExercicios.put("Anagrama Palindrome", new AnagramaPalindromo());

        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        funcoesExercicios.keySet().forEach(model::addElement);
        exercicio_Combox.setModel(model);

        executar_Button.addActionListener(e -> {
            String exercicioSelecionado = (String) exercicio_Combox.getSelectedItem();
            String inputUsuario = input_Text.getText();
            if (ValidarEntrada.entrada_Invalida.equals(ValidarEntrada.validarEntrada(inputUsuario))) {
                resultado_Text.setText(ValidarEntrada.entrada_Invalida);
                return;
            }
            ExercicioInterface exercicioInterface = funcoesExercicios.get(exercicioSelecionado);
            String resultado = exercicioInterface.executar(inputUsuario);
            resultado_Text.setText(resultado);
        });

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TelaApp::new);
    }
}
