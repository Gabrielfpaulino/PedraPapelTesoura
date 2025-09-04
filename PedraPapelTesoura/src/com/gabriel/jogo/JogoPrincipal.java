package com.gabriel.jogo;
import java.sql.SQLOutput;
import java.util.Scanner;

/**
 *  CLASSE PRINCIPAL - Ponto de entrada do programa
 * Responsabilidade: Controlar o fluxo principal e o menu
 *
 * @author Gabriel Fernandes Paulino
 * @version 1.0
 */
public class JogoPrincipal {
    /**
     * Método main - Executado automaticamente pela JVM
     * Controla o loop principal do programa e o menu de opções
     */
    public static void main(String[] args) {
        //  Scanner para ler entrada do usuário

        Scanner leitura = new Scanner(System.in);

        //  Exibe tela de boas-vindas
        Utils.exibirBoasVindas();

        // variavel para controlar o menu
        int opcaoMenu;

        // loop principal do programa

        do {
            opcaoMenu = Utils.exibirMenu(leitura);

            // processa a opção escolhida pelo úsuario
            switch (opcaoMenu) {
                case 1:
                    Jogo.jogarPartidaUnica(leitura);
                    break;
                case 2:
                    Jogo.jogarMelhorDe3(leitura);
                    break;
                case 3:
                    Jogo.jogarAteXVitorias(leitura);
                    break;
                case 4:
                    Estatisticas.exibirEstatisticas();
                    break;
                case 5:
                    Estatisticas.zerarEstatisticas();
                case 0:
                    System.out.println("Obrigado por jogar! Até a próxima");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
            // ⏸️ Pausa para o usuário ler o resultado

            if (opcaoMenu != 0) {
                System.out.println("\nPressione Enter para continuar....");
                leitura.nextLine();
            }
        } while (opcaoMenu != 0) ;
        //  Libera recursos do Scanner
                leitura.close();
                System.out.println("Programa finalizado!");
            }
        }






















