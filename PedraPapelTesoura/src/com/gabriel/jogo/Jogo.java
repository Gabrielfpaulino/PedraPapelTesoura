package com.gabriel.jogo;

import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.Random;

/**
 * CLASSE JOGO - Contém toda a lógica dos modos de jogo
 * Responsabilidade: Gerenciar partidas e rodadas individuais
 *
 * @author Seu Nome
 * @version 1.0
 */

public class Jogo {

    //  Array com as opções possíveis do jogo

    private static final String [] opcoes = {"pedra", "papel", "tesoura"};

    /**
     *  Modo de jogo: Partida única
     * Uma rodada simples entre jogador e computador
     */

    public static void jogarPartidaUnica(Scanner leitura){
        System.out.println("\n==== PARTIDA ÚNICA ====");
        String resultado = jogarRodada(leitura);
        Utils.exibirResultadoFinal(resultado);
    }

    /**
     *  Modo de jogo: Melhor de 3 rodadas
     * Primeiro a ganhar 2 rodadas vence
     */

    public static void jogarMelhorDe3(Scanner leitura){
        System.out.println("\n==== MELHOR DE 3 ====");

        int vitoriasJogadorTemp = 0;
        int vitoriasComputadorTemp = 0;
        int rodada = 1;

        //loop até alguém ganhar 2 rodadas

        while (vitoriasJogadorTemp < 2 && vitoriasComputadorTemp < 2){
            System.out.println("\n---- Rodada " + rodada + " ----");
            String resultado = jogarRodada(leitura);

            // Atualiza placar temporário

            if (resultado.equals("vitoria")){
                vitoriasJogadorTemp++;
                System.out.println("Placar: Voce " + vitoriasJogadorTemp + " x " + vitoriasComputadorTemp + " Computador");
            } else if (resultado.equals("derrota")) {
                vitoriasComputadorTemp ++;
                System.out.println("Placar: Voce" + vitoriasJogadorTemp + " x " + vitoriasComputadorTemp + " Computador");
            }else {
                System.out.println("Placar: Voce " + vitoriasJogadorTemp + " x " + vitoriasComputadorTemp + " Computador");
            }
            rodada ++;
        }

        // 🏁 Exibe o vencedor final

        if (vitoriasJogadorTemp > vitoriasComputadorTemp){
            System.out.println("Parabéns!!! Voce venceu o melhor de 3");
        } else{
            System.out.println("O computador venceu a melhor de 3");
        }
    }

    /**
     * 🎖️ Modo de jogo: Jogar até X vitórias
     * Usuário define quantas vitórias são necessárias para ganhar
     */

    public static void jogarAteXVitorias(Scanner leitura) {
        System.out.println("\n==== JOGAR ATÉ X VITÓRIAS");
        System.out.println("Quantas vitórias para ganhar? ");

        int metaVitorias;
        try {
            metaVitorias = Integer.parseInt(leitura.nextLine());
            if (metaVitorias <= 0) {
                System.out.println("Número deve ser maior que 0!");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Por favor, digite um número válido!");
            return;
        }

        int vitoriasJogadorTemp = 0;
        int vitoriasComputadorTemp = 0;
        int rodada = 1;

        // 🔄 Loop até alguém atingir a meta
        while (vitoriasJogadorTemp < metaVitorias && vitoriasComputadorTemp < metaVitorias) {
            System.out.println("\n---- Rodada " + rodada + " ----");
            String resultado = jogarRodada(leitura);

            //  Atualiza placar

            if (resultado.equals("vitoria")) {
                vitoriasJogadorTemp++;
            } else if (resultado.equals("derrota")) {
                vitoriasComputadorTemp++;
            }

            System.out.println("Placar: Voce " + vitoriasJogadorTemp + " x " + vitoriasComputadorTemp + "Computador");
            System.out.println("Meta: " + metaVitorias + " vitórias");
            rodada++;
        }
        //  Exibe o campeão
        if (vitoriasJogadorTemp >= metaVitorias) {
            System.out.println("\nCampeão! Voce alcançou " + metaVitorias + " vitórias primeiro!");
        } else {
            System.out.println("\nO computador alcançou " + metaVitorias + " vitórias primeiro!");
        }
    }


    /**
     * ️ MÉTODO CORE - Executa uma rodada individual do jogo
     * Contém toda a lógica de uma partida: entrada, validação, IA e resultado
     *
     * @param leitura Scanner para ler entrada do usuário
     * @return String indicando o resultado ("vitoria", "derrota", "empate", "invalido")
     */

    public static String jogarRodada(Scanner leitura) {
        Random random = new Random();

        // 📝 Recebe escolha do jogador
        System.out.print("Sua escolha (🪨 pedra, 📄 papel, ✂️ tesoura): ");
        String jogador = leitura.nextLine().toLowerCase().trim();

        // ✅ Validação da entrada
        if (!Utils.isEscolhaValida(jogador)) {
            System.out.println("❌ Escolha inválida!");
            return "invalido";
        }

        // 🤖 IA do computador faz sua escolha
        String computador = opcoes[random.nextInt(3)];

        // 🎭 Exibe as escolhas com visual bonito
        System.out.println("\n⚔️ === RESULTADO DA RODADA ===");
        System.out.println("Você escolheu: " + Utils.obterEmoji(jogador) + " " + jogador.toUpperCase());
        System.out.println("Computador escolheu: " + Utils.obterEmoji(computador) + " " + computador.toUpperCase());
        System.out.println();

        // 🏆 Determina o vencedor usando as regras do jogo
        String resultado = determinarVencedor(jogador, computador);

        // 📊 Atualiza estatísticas globais
        Estatisticas.atualizarEstatisticas(resultado);

        return resultado;
    }

    /**
     * 🧠 Aplica as regras do jogo para determinar o vencedor
     * Regras: Pedra > Tesoura, Papel > Pedra, Tesoura > Papel
     *
     * @param jogador Escolha do jogador
     * @param computador Escolha do computador
     * @return Resultado da partida
     */
    private static String determinarVencedor(String jogador, String computador) {
        if (jogador.equals(computador)) {
            System.out.println("🤝 EMPATE!");
            return "empate";
        } else if (
                (jogador.equals("pedra") && computador.equals("tesoura")) ||
                        (jogador.equals("papel") && computador.equals("pedra")) ||
                        (jogador.equals("tesoura") && computador.equals("papel"))
        ) {
            System.out.println("🎉 VOCÊ VENCEU!");
            return "vitoria";
        } else {
            System.out.println("😅 VOCÊ PERDEU!");
            return "derrota";
        }
    }
}





















