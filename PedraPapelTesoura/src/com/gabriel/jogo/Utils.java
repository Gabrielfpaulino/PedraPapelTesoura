package com.gabriel.jogo;
import java.util.Scanner;
/**
 * 🔧 CLASSE UTILS - Métodos utilitários e auxiliares
 * Responsabilidade: Funções reutilizáveis, validações e interface com usuário
 */

public class Utils {
    // 🎲 Constantes do jogo
    private static final String[] OPCOES_VALIDAS = {"pedra", "papel", "tesoura"};

    /**
     * 🎊 Exibe a tela de boas-vindas com as regras do jogo
     * Primeira coisa que o usuário vê ao executar o programa
     */
    public static void exibirBoasVindas() {
        System.out.println("🎮=== SUPER PEDRA, PAPEL, TESOURA ===🎮");
        System.out.println("🪨 Pedra vence Tesoura");
        System.out.println("📄 Papel vence Pedra");
        System.out.println("✂️ Tesoura vence Papel");
        System.out.println("=====================================");
        System.out.println("✨ Desenvolvido em Java com ❤️");
        System.out.println("🚀 Pronto para começar? Vamos jogar!");
    }

    /**
     * 📋 Exibe o menu principal e captura a opção do usuário
     * Inclui tratamento de erro para entradas inválidas
     *
     * @param leitura Scanner para ler entrada do usuário
     * @return Número da opção escolhida pelo usuário
     */
    public static int exibirMenu(Scanner leitura) {
        System.out.println("\n📋 === MENU PRINCIPAL ===");
        System.out.println("1. 🎯 Partida única");
        System.out.println("2. 🏆 Melhor de 3");
        System.out.println("3. 🎖️ Jogar até X vitórias");
        System.out.println("4. 📊 Ver estatísticas");
        System.out.println("5. 🔄 Zerar estatísticas");
        System.out.println("0. 🚪 Sair");
        System.out.print("Escolha uma opção: ");

        // 🛡️ Tratamento de erro para entrada não numérica
        try {
            return Integer.parseInt(leitura.nextLine());
        } catch (NumberFormatException e) {
            return -1; // Retorna valor inválido para ser tratado no switch
        }
    }

    /**
     * ✅ Valida se a escolha do usuário é uma opção válida do jogo
     *
     * @param escolha Texto digitado pelo usuário
     * @return true se é válida, false caso contrário
     */
    public static boolean isEscolhaValida(String escolha) {
        if (escolha == null || escolha.trim().isEmpty()) {
            return false;
        }

        String escolhaLower = escolha.toLowerCase().trim();

        // 🔍 Verifica se está nas opções válidas
        for (String opcao : OPCOES_VALIDAS) {
            if (opcao.equals(escolhaLower)) {
                return true;
            }
        }

        return false;
    }

    /**
     * 🎭 Retorna o emoji correspondente a cada opção do jogo
     * Torna a interface mais visual e divertida
     *
     * @param opcao Nome da opção ("pedra", "papel", "tesoura")
     * @return Emoji correspondente à opção
     */
    public static String obterEmoji(String opcao) {
        if (opcao == null) {
            return "❓";
        }

        switch (opcao.toLowerCase().trim()) {
            case "pedra":
                return "🪨";
            case "papel":
                return "📄";
            case "tesoura":
                return "✂️";
            default:
                return "❓";
        }
    }

    /**
     * 🏁 Exibe mensagem final para partidas únicas
     * Personaliza a mensagem baseada no resultado
     *
     * @param resultado Resultado da partida ("vitoria", "derrota", "empate")
     */
    public static void exibirResultadoFinal(String resultado) {
        System.out.println("\n🏁 === PARTIDA FINALIZADA ===");

        switch (resultado) {
            case "vitoria":
                System.out.println("🎊 Parabéns! Você é o vencedor!");
                System.out.println("🌟 Excelente jogada!");
                break;
            case "derrota":
                System.out.println("🤖 O computador venceu desta vez!");
                System.out.println("💪 Na próxima você consegue!");
                break;
            case "empate":
                System.out.println("🤝 Foi um empate!");
                System.out.println("🎯 Que tal tentar novamente?");
                break;
            default:
                System.out.println("❓ Resultado inesperado!");
                break;
        }
    }

    /**
     * 🎨 Exibe uma linha decorativa para separar seções
     * Melhora a organização visual da saída
     */
    public static void exibirLinhaSeparadora() {
        System.out.println("═══════════════════════════════════════");
    }

    /**
     * ⏸️ Pausa o programa e aguarda o usuário pressionar Enter
     * Útil para dar tempo ao usuário ler informações importantes
     *
     * @param leitura Scanner para capturar o Enter
     */
    public static void pausarPrograma(Scanner leitura) {
        System.out.println("\nPressione Enter para continuar...");
        leitura.nextLine();
    }

    /**
     * 🎲 Gera uma dica aleatória sobre estratégia do jogo
     * Adiciona elemento educativo e divertido
     *
     * @return Dica aleatória como String
     */
    public static String obterDicaAleatoria() {
        String[] dicas = {
                "🧠 Dica: Observe os padrões do computador!",
                "🎯 Dica: Pedra é popular entre iniciantes!",
                "✂️ Dica: Tesoura é menos escolhida, pode surpreender!",
                "📄 Dica: Papel é a escolha mais equilibrada!",
                "🎲 Dica: Às vezes a aleatoriedade é sua melhor estratégia!",
                "🏆 Dica: Mantenha a calma e confie na sua intuição!",
                "🤖 Dica: O computador é realmente aleatório, sem truques!"
        };

        int indice = (int) (Math.random() * dicas.length);
        return dicas[indice];
    }

    /**
     * 📊 Formata um número decimal para exibição com uma casa decimal
     *
     * @param numero Número a ser formatado
     * @return String formatada com 1 casa decimal
     */
    public static String formatarPercentual(double numero) {
        return String.format("%.1f", numero);
    }

    /**
     * 🎮 Exibe créditos e informações sobre o desenvolvedor
     * Útil para projetos que vão para portfólio
     */
    public static void exibirCreditos() {
        System.out.println("\n🌟 === CRÉDITOS ===");
        System.out.println("💻 Desenvolvido por: [Seu Nome]");
        System.out.println("📅 Data: 2025");
        System.out.println("☕ Feito com Java");
        System.out.println("❤️ Feito com dedicação para aprender programação");
        System.out.println("🔗 GitHub: [seu-usuario]/pedra-papel-tesoura");
    }
}
