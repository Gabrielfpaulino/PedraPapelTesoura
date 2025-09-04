package com.gabriel.jogo;

/**
 * 📊 CLASSE ESTATISTICAS - Gerencia dados e pontuações do jogo
 * Responsabilidade: Armazenar, calcular e exibir estatísticas do jogador
 *
 * @author Seu Nome
 * @version 1.0
 */

public class Estatisticas {
    // 📊 Variáveis para armazenar estatísticas do jogo
    // 'static' = pertencem à classe, mantêm valores entre chamadas
    private static int vitoriasJogador = 0;
    private static int vitoriasComputador = 0;
    private static int empates = 0;
    private static int totalPartidas = 0;

    /**
     * 📈 Atualiza as estatísticas com base no resultado de uma rodada
     *
     * @param resultado Resultado da rodada ("vitoria", "derrota", "empate")
     */
    public static void atualizarEstatisticas(String resultado) {
        totalPartidas++;  // Sempre incrementa o total

        // 🎯 Incrementa contador específico baseado no resultado
        switch (resultado) {
            case "vitoria":
                vitoriasJogador++;
                break;
            case "derrota":
                vitoriasComputador++;
                break;
            case "empate":
                empates++;
                break;
            // Caso "invalido" não conta para estatísticas
        }
    }

    /**
     * 📊 Exibe todas as estatísticas do jogador de forma formatada
     * Inclui totais, percentuais e análise de desempenho
     */
    public static void exibirEstatisticas() {
        System.out.println("\n📊 === SUAS ESTATÍSTICAS ===");

        // 📋 Estatísticas básicas
        System.out.println("🎮 Total de partidas: " + totalPartidas);
        System.out.println("🏆 Suas vitórias: " + vitoriasJogador);
        System.out.println("🤖 Vitórias do computador: " + vitoriasComputador);
        System.out.println("🤝 Empates: " + empates);

        // 📈 Análises avançadas (só se houver partidas)
        if (totalPartidas > 0) {
            double percentualVitorias = calcularPercentualVitorias();
            double percentualEmpates = calcularPercentualEmpates();
            double percentualDerrotas = calcularPercentualDerrotas();

            System.out.println("\n📈 === ANÁLISE DE DESEMPENHO ===");
            System.out.println("🏆 Taxa de vitória: " + String.format("%.1f", percentualVitorias) + "%");
            System.out.println("🤝 Taxa de empate: " + String.format("%.1f", percentualEmpates) + "%");
            System.out.println("😅 Taxa de derrota: " + String.format("%.1f", percentualDerrotas) + "%");

            // 🎭 Mensagem motivacional baseada no desempenho
            exibirMensagemMotivacional(percentualVitorias);
        } else {
            System.out.println("🎯 Ainda não jogou nenhuma partida!");
        }
    }

    /**
     * 🧮 Calcula o percentual de vitórias do jogador
     *
     * @return Percentual de vitórias (0.0 a 100.0)
     */
    private static double calcularPercentualVitorias() {
        if (totalPartidas == 0) return 0.0;
        return (vitoriasJogador * 100.0) / totalPartidas;
    }

    /**
     * 🧮 Calcula o percentual de empates
     *
     * @return Percentual de empates (0.0 a 100.0)
     */
    private static double calcularPercentualEmpates() {
        if (totalPartidas == 0) return 0.0;
        return (empates * 100.0) / totalPartidas;
    }

    /**
     * 🧮 Calcula o percentual de derrotas
     *
     * @return Percentual de derrotas (0.0 a 100.0)
     */
    private static double calcularPercentualDerrotas() {
        if (totalPartidas == 0) return 0.0;
        return (vitoriasComputador * 100.0) / totalPartidas;
    }

    /**
     * 🎭 Exibe mensagem motivacional baseada no desempenho do jogador
     *
     * @param percentualVitorias Taxa de vitória do jogador
     */
    private static void exibirMensagemMotivacional(double percentualVitorias) {
        System.out.println("\n🎭 === AVALIAÇÃO ===");

        if (percentualVitorias >= 70) {
            System.out.println("🌟 EXCELENTE! Você é um mestre em Pedra, Papel, Tesoura!");
        } else if (percentualVitorias >= 60) {
            System.out.println("👏 MUITO BOM! Você está dominando o jogo!");
        } else if (percentualVitorias >= 50) {
            System.out.println("💪 BOM! Você está equilibrado com o computador!");
        } else if (percentualVitorias >= 40) {
            System.out.println("📚 Continue praticando! Você está melhorando!");
        } else {
            System.out.println("🎯 Não desista! A sorte pode mudar a qualquer momento!");
        }
    }

    /**
     * 🔄 Reseta todas as estatísticas para valores iniciais
     * Útil para começar uma nova sessão limpa
     */
    public static void zerarEstatisticas() {
        vitoriasJogador = 0;
        vitoriasComputador = 0;
        empates = 0;
        totalPartidas = 0;
        System.out.println("🔄 Estatísticas zeradas! Nova jornada começando...");
    }

    // 🔍 MÉTODOS GETTERS - Para outros objetos consultarem dados (se necessário)

    /**
     * @return Número total de vitórias do jogador
     */
    public static int getVitoriasJogador() {
        return vitoriasJogador;
    }

    /**
     * @return Número total de vitórias do computador
     */
    public static int getVitoriasComputador() {
        return vitoriasComputador;
    }

    /**
     * @return Número total de empates
     */
    public static int getEmpates() {
        return empates;
    }

    /**
     * @return Número total de partidas jogadas
     */
    public static int getTotalPartidas() {
        return totalPartidas;
    }
}

