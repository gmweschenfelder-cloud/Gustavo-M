import java.util.Random;
import java.util.Scanner;

public class Simulador_Fut {
    public final static Scanner TECLADO = new Scanner(System.in);

    public final static int[] t0 = new int[7];
    public final static int[] t1 = new int[7];
    public static int quem_ganhou = 0;
    public static int posicaoBola = 3;
    public static int posseDaBola = 0;
    public static String nomeTime;
    public static String nomeTimeAdversario;

    public static int golsTime0;
    public static int golsTime1;
    public static int disputasVencidasTime0 = 0;
    public static int disputasVencidasTime1 = 0;
    public static int chutesTime0 = 0;
    public static int chutesTime1 = 0;

    public static void imprimir(String texto) {
        System.out.println(texto);

    }

    public static int lerInteiro() {
        int valor;
        valor = TECLADO.nextInt();
        return valor;
    }

    public static double lerDouble() {
        double valor;
        valor = TECLADO.nextDouble();
        return valor;
    }

    public static String lerString() {
        return TECLADO.nextLine();

    }

    public static void times() {
        System.out.println("Flamengo: ");
        System.out.println("Grêmio: ");
        System.out.println("Palmeiras: ");
        System.out.println("Botafogo: ");
        System.out.println("São Paulo: ");
        System.out.println("Mirassol: ");
        System.out.println("Fluminense: ");
        System.out.println("Atlético Mineiro: ");
        System.out.println("Santos: ");
        System.out.println("Sport: ");
        System.out.println("Vasco: ");
        System.out.println("Vitória: ");
        System.out.println("Bahia: ");
        System.out.println("Ceará: ");
        System.out.println("Fortaleza: ");
        System.out.println("Juventude: ");
        System.out.println("Cruzeiro: ");
        System.out.println("Bragantino: ");
        System.out.println("Corinthians: ");
        System.out.println("Internacional: ");
        System.out.println("=================================");
        TECLADO.nextLine();

        System.out.println("ESCOLHA SEU TIME: ");
        nomeTime = TECLADO.nextLine();

        System.out.println("Escolha o time adversário: ");
        nomeTimeAdversario = TECLADO.nextLine();

    }

    public static void escolherTime0() {
        System.out.println("=======" + nomeTime + "===========");

        while (true) {

            int somaA = 0;
            System.out.println("Digite as forças dos jogadores, a soma deve ser 21");

            for (int i = 0; i < t0.length; i++) {

                System.out.printf(" Digite os pontos que você quer no " + nomeTime + ": jogador %d\n", i);
                t0[i] = lerInteiro();
                somaA += t0[i];

            }
            if (somaA == 21) {
                break;
            } else {
                System.out.println("Digite novamente, você passou do limite!");
            }
        }

    }

    public static void escolherTime1() {
        System.out.println("======" + nomeTimeAdversario + "========");

        while (true) {

            int somaB = 0;
            System.out.println("Digite as forças dos jogadores, a soma deve ser 21");

            for (int j = 0; j < t1.length; j++) {
                System.out.printf(" Digite os pontos que você quer no " + nomeTimeAdversario + ": jogador %d\n", j);
                t1[j] = lerInteiro();
                somaB += t1[j];
            }

            if (somaB == 21) {
                break;
            } else {
                System.out.println("Digite novamente, você passou do limite!");

            }
        }

    }

    public static void menu() {

        while (true) {

            int opcoes = 0;
            System.out.println("===== Menu principal ========");

            System.out.println("[1] Jogar: ");
            System.out.println("[2] Ver instruções: ");
            System.out.println("[3] Sair: ");
            opcoes = lerInteiro();

            if (opcoes == 1) {
                times();
                escolherTime0();
                escolherTime1();
                iniciarJogo();

            } else if (opcoes == 2) {
                System.out.println(
                        "Escolha seu time , o time adversário , selecione os pontos lembrando a soma deve ser 21 nem > nem < e aí só acompanhar a simulação que vai estar acontecendo.");

            } else if (opcoes == 3) {
                System.out.println("Valeu por jogar e testar esse jogo.");
                break;
            }

            else {
                System.out.println("Essa opção não existe , tente novamente! ");

            }
        }
    }

    public static void iniciarJogo() {
        // obter ou ler os times;

        // String[] nomeTimes = {"Time Bao 0", "Time dos times 1"};
        // Obs: Sempre time 0 fica na pos 0 e time 1 fica n pos 1

        // 0 -> Zag Esq
        // 1 -> Zag Dir
        // 2 -> Ponta Esq
        // 3 -> Meio
        // 4 -> Pont Dir
        // 5 -> Atac Esq
        // 6 -> Atac Dir

        int[][] campo = new int[2][7];
        // o campo tem 2 linha e 7 colunas;
        // cada linha é um time
        // as colunas sao as posicoes dos jogadors no campo

        // posicionar os jadores no campo
        campo[0][0] = t0[0];
        campo[1][0] = t1[6];

        campo[0][1] = t0[1];
        campo[1][1] = t1[5];

        campo[0][2] = t0[2];
        campo[1][2] = t1[4];

        campo[0][3] = t0[3];
        campo[1][3] = t1[3];

        campo[0][4] = t0[4];
        campo[1][4] = t1[2];

        campo[0][5] = t0[5];
        campo[1][5] = t1[1];

        campo[0][6] = t0[6];
        campo[1][6] = t1[0];

        System.out.println("========GOL=============");

        System.out.printf(nomeTime + ":  [%d]  [%d]\n", t0[0], t0[1]);

        System.out.printf(nomeTime + ": [%d] [%d] [%d]\n", t0[2], t0[3], t0[4]);

        System.out.printf(nomeTime + ":   [%d] [%d]\n", t0[5], t0[6]);

        System.out.println("===============O===============");

        System.out.printf(nomeTimeAdversario + ": [%d]  [%d]\n", t1[6], t1[5]);

        System.out.printf(nomeTimeAdversario + ": [%d] [%d] [%d]\n", t1[2], t1[3], t1[4]);

        System.out.printf(nomeTimeAdversario + ":   [%d] [%d]\n", t1[1], t1[0]);

        System.out.println("=========GOL=============");

        posseDaBola = 0;
        posicaoBola = 3;

        golsTime0 = 0;
        golsTime1 = 0;
        int soma = 0;

        int disputa = 0;
        int quem_ganhou = 0;

        for (int tempo = 1; tempo <= 90; tempo++) {

            if (posicaoBola < 5) {
                quem_ganhou = disputaJogadores(campo[0][posicaoBola], campo[1][posicaoBola]);
                posseDaBola = quem_ganhou;
            }

            if (quem_ganhou == 0) {
                disputasVencidasTime0++;

            } else {
                disputasVencidasTime1++;
            }

            posicaoBola = movimentarBola(quem_ganhou, posicaoBola);
            System.out.println("a bola esta na posiçao " + posicaoBola + "  no minuto " + tempo);

            reimprimir(posicaoBola, posseDaBola);

            if (tempo == 45) {
                System.out.println("=======================");
                System.out.println("Fim do Primeiro Tempo!");
                System.out.println(" O placar ao final do primeiro tempo: " + nomeTime + " " + golsTime0 + " X " + golsTime1 + " " + nomeTimeAdversario);

            }

        }
        System.out.println("Fim de jogo!");
        System.out.println(
                " O placar final: " + nomeTime + " " + golsTime0 + " X " + golsTime1 + " " + nomeTimeAdversario);
        if (golsTime0 > golsTime1) {
            System.out.println(nomeTime + " foi o vencedor dessa partida! ");

        } else if (golsTime1 > golsTime0) {
            System.out.println(nomeTimeAdversario + " foi o vencedor dessa partida! ");

        } else {
            System.out.println("Empate!");

        }
        System.out.println("===== Estatísticas =====");
        System.out.println(nomeTime + " - Gols: " + golsTime0 + ", Chutes: " + chutesTime0 + ", Disputas vencidas: "+ disputasVencidasTime0);
        System.out.println(nomeTimeAdversario + " - Gols: " + golsTime1 + ", Chutes: " + chutesTime1 + ", Disputas vencidas: " + disputasVencidasTime1);

        // disputa de bola-V

        // quem ganho?-V

        // movimentar a bola-V
        // foi pro gol? -V
        // chutar... foi gol?-V
        // se foi aumento gols-V
        // bola volta para o meio-V

        // atualizar a posicao da bola-v

        // reimprimir o campo com a bola no lugar atualizado-V

        // imprimi fim e placar final-V
    }

    public static int disputaJogadores(int j0, int j1) {
        int soma = 0;
        soma = j0 + j1;

        int sorteio = (int) (Math.random() * soma);

        if (sorteio < j0) {
            return 0;

        } else {
            return 1;
        }

    }

    public static int moverBolaAleatoriamente(int[] opcoes) {
        return opcoes[(int) (Math.random() * opcoes.length)];
    }

    public static int movimentarBola(int quem_ganhou, int posicaoBola) {

        if (posseDaBola == 0) {
            if (posicaoBola == 0) {
                int[] mover = { 1, 2 };
                int novaPosicao = moverBolaAleatoriamente(mover);
                posicaoBola = novaPosicao;

            } else if (posicaoBola == 1) {
                int[] mover = { 0, 3 };
                int novaPosicao = moverBolaAleatoriamente(mover);
                posicaoBola = novaPosicao;
            } else if (posicaoBola == 2) {
                int[] mover = { 3, 5 };
                int novaPosicao = moverBolaAleatoriamente(mover);
                posicaoBola = novaPosicao;
            } else if (posicaoBola == 3) {
                int[] mover = { 2, 4, 5, 6 };
                int novaPosicao = moverBolaAleatoriamente(mover);
                posicaoBola = novaPosicao;

            } else if (posicaoBola == 4) {
                int[] mover = { 3, 6 };
                int novaPosicao = moverBolaAleatoriamente(mover);
                posicaoBola = novaPosicao;
            } else if (posicaoBola == 5 || posicaoBola == 6) {
                chutesTime0++;
                // chute a gol
                if (Math.random() < 0.5) {
                    // gol
                    golsTime0++;
                    System.out.println("GOL DO " + nomeTime);
                    System.out.println("Placar: " + nomeTime + " " + golsTime0 + " X " + golsTime1 + " " + nomeTimeAdversario);
                    posicaoBola = 3;
                    posseDaBola = 1;
                } else {
                    posicaoBola = 4;

                }
            }

        } else if (posseDaBola == 1) {

            if (posicaoBola == 0) {
                int[] mover = { 2, 1 };
                int novaPosicao = moverBolaAleatoriamente(mover);
                posicaoBola = novaPosicao;
            } else if (posicaoBola == 1) {
                int[] mover = { 3, 0 };
                int novaPosicao = moverBolaAleatoriamente(mover);
                posicaoBola = novaPosicao;
            } else if (posicaoBola == 2) {
                int[] mover = { 5, 3 };
                int novaPosicao = moverBolaAleatoriamente(mover);
                posicaoBola = novaPosicao;
            } else if (posicaoBola == 3) {
                int[] mover = { 6, 5, 4, 2 };
                int novaPosicao = moverBolaAleatoriamente(mover);
                posicaoBola = novaPosicao;
            } else if (posicaoBola == 4) {
                int[] mover = { 6, 3 };
                int novaPosicao = moverBolaAleatoriamente(mover);
                posicaoBola = novaPosicao;
            } else if (posicaoBola == 5 || posicaoBola == 6) {
                chutesTime1++;
                // chute a gol
                if (Math.random() < 0.5) {
                    // gol
                    golsTime1++;
                    System.out.println("GOL DO " + nomeTimeAdversario);
                    System.out.println(
                            "Placar: " + nomeTime + " " + golsTime0 + " X " + golsTime1 + " " + nomeTimeAdversario);
                    posicaoBola = 3;
                    posseDaBola = 0;
                } else {
                    posicaoBola = 2;

                }
            }

        }

        return posicaoBola;
    }

    public static void reimprimir(int posicaoBola, int posseDaBola) {
        if (posicaoBola == 3 && posseDaBola == 0) {
            System.out.println("============GOL=============");

            System.out.printf(nomeTime + ":  [%d]  [%d]\n", t0[0], t0[1]);

            System.out.printf(nomeTime + ": [%d] [%d]O [%d]\n", t0[2], t0[3], t0[4]);

            System.out.printf(nomeTime + ":   [%d] [%d]\n", t0[5], t0[6]);

            System.out.println("=============================");

            System.out.printf(nomeTimeAdversario + ":   [%d]  [%d]\n", t1[6], t1[5]);

            System.out.printf(nomeTimeAdversario + ":  [%d] [%d] [%d]\n", t1[2], t1[3], t1[4]);

            System.out.printf(nomeTimeAdversario + ":    [%d] [%d]\n", t1[1], t1[0]);

            System.out.println("==============GOL=============");
        }
        if (posicaoBola == 1 && posseDaBola == 0) {
            System.out.println("============GOL=============");

            System.out.printf(nomeTime + ":  [%d]  [%d]O\n", t0[0], t0[1]);

            System.out.printf(nomeTime + ": [%d] [%d] [%d]\n", t0[2], t0[3], t0[4]);

            System.out.printf(nomeTime + ":   [%d] [%d]\n", t0[5], t0[6]);

            System.out.println("=============================");

            System.out.printf(nomeTimeAdversario + ":   [%d]  [%d]\n", t1[6], t1[5]);

            System.out.printf(nomeTimeAdversario + ":  [%d] [%d] [%d]\n", t1[2], t1[3], t1[4]);

            System.out.printf(nomeTimeAdversario + ":    [%d] [%d]\n", t1[1], t1[0]);

            System.out.println("==============GOL=============");

        }

        if (posicaoBola == 0 && posseDaBola == 0) {
            System.out.println("============GOL=============");

            System.out.printf(nomeTime + ":  [%d]O  [%d]\n", t0[0], t0[1]);

            System.out.printf(nomeTime + ": [%d] [%d] [%d]\n", t0[2], t0[3], t0[4]);

            System.out.printf(nomeTime + ":   [%d] [%d]\n", t0[5], t0[6]);

            System.out.println("=============================");

            System.out.printf(nomeTimeAdversario + ":   [%d]  [%d]\n", t1[6], t1[5]);

            System.out.printf(nomeTimeAdversario + ":  [%d] [%d] [%d]\n", t1[2], t1[3], t1[4]);

            System.out.printf(nomeTimeAdversario + ":    [%d] [%d]\n", t1[1], t1[0]);

            System.out.println("==============GOL=============");

        }
        if (posicaoBola == 2 && posseDaBola == 0) {
            System.out.println("============GOL=============");

            System.out.printf(nomeTime + ":  [%d]  [%d]\n", t0[0], t0[1]);

            System.out.printf(nomeTime + ": [%d]O [%d] [%d]\n", t0[2], t0[3], t0[4]);

            System.out.printf(nomeTime + ":   [%d] [%d]\n", t0[5], t0[6]);

            System.out.println("=============================");

            System.out.printf(nomeTimeAdversario + ":   [%d]  [%d]\n", t1[6], t1[5]);

            System.out.printf(nomeTimeAdversario + ":  [%d] [%d] [%d]\n", t1[2], t1[3], t1[4]);

            System.out.printf(nomeTimeAdversario + ":    [%d] [%d]\n", t1[1], t1[0]);

            System.out.println("==============GOL=============");

        }
        if (posicaoBola == 4 && posseDaBola == 0) {
            System.out.println("============GOL=============");

            System.out.printf(nomeTime + ":  [%d]  [%d]\n", t0[0], t0[1]);

            System.out.printf(nomeTime + ": [%d] [%d] [%d]O\n", t0[2], t0[3], t0[4]);

            System.out.printf(nomeTime + ":   [%d] [%d]\n", t0[5], t0[6]);

            System.out.println("=============================");

            System.out.printf(nomeTimeAdversario + ":   [%d]  [%d]\n", t1[6], t1[5]);

            System.out.printf(nomeTimeAdversario + ":  [%d] [%d] [%d]\n", t1[2], t1[3], t1[4]);

            System.out.printf(nomeTimeAdversario + ":    [%d] [%d]\n", t1[1], t1[0]);

            System.out.println("==============GOL=============");

        }

        if (posicaoBola == 5 && posseDaBola == 0) {
            System.out.println("============GOL=============");

            System.out.printf(nomeTime + ":  [%d]  [%d]\n", t0[0], t0[1]);

            System.out.printf(nomeTime + ": [%d] [%d] [%d]\n", t0[2], t0[3], t0[4]);

            System.out.printf(nomeTime + ":   [%d]O [%d]\n", t0[5], t0[6]);

            System.out.println("=============================");

            System.out.printf(nomeTimeAdversario + ":   [%d]  [%d]\n", t1[6], t1[5]);

            System.out.printf(nomeTimeAdversario + ":  [%d] [%d] [%d]\n", t1[2], t1[3], t1[4]);

            System.out.printf(nomeTimeAdversario + ":    [%d] [%d]\n", t1[1], t1[0]);

            System.out.println("==============GOL=============");

        }

        if (posicaoBola == 6 && posseDaBola == 0) {
            System.out.println("============GOL=============");

            System.out.printf(nomeTime + ":  [%d]  [%d]\n", t0[0], t0[1]);

            System.out.printf(nomeTime + ": [%d] [%d] [%d]\n", t0[2], t0[3], t0[4]);

            System.out.printf(nomeTime + ":   [%d] [%d]O\n", t0[5], t0[6]);

            System.out.println("=============================");

            System.out.printf(nomeTimeAdversario + ":   [%d]  [%d]\n", t1[6], t1[5]);

            System.out.printf(nomeTimeAdversario + ":  [%d] [%d] [%d]\n", t1[2], t1[3], t1[4]);

            System.out.printf(nomeTimeAdversario + ":    [%d] [%d]\n", t1[1], t1[0]);

            System.out.println("==============GOL=============");

        }

        if (posicaoBola == 0 && posseDaBola == 1) {
            System.out.println("============GOL=============");

            System.out.printf(nomeTime + ":  [%d]  [%d]\n", t0[0], t0[1]);

            System.out.printf(nomeTime + ": [%d] [%d] [%d]\n", t0[2], t0[3], t0[4]);

            System.out.printf(nomeTime + ":   [%d] [%d]\n", t0[5], t0[6]);

            System.out.println("=============================");

            System.out.printf(nomeTimeAdversario + ":   [%d]  [%d]\n", t1[6], t1[5]);

            System.out.printf(nomeTimeAdversario + ":  [%d] [%d] [%d]\n", t1[2], t1[3], t1[4]);

            System.out.printf(nomeTimeAdversario + ":    [%d] [%d]O\n", t1[1], t1[0]);

            System.out.println("==============GOL=============");

        }
        if (posicaoBola == 1 && posseDaBola == 1) {
            System.out.println("============GOL=============");

            System.out.printf(nomeTime + ":  [%d]  [%d]\n", t0[0], t0[1]);

            System.out.printf(nomeTime + ": [%d] [%d] [%d]\n", t0[2], t0[3], t0[4]);

            System.out.printf(nomeTime + ":   [%d] [%d]\n", t0[5], t0[6]);

            System.out.println("=============================");

            System.out.printf(nomeTimeAdversario + ":   [%d]  [%d]\n", t1[6], t1[5]);

            System.out.printf(nomeTimeAdversario + ":  [%d] [%d] [%d]\n", t1[2], t1[3], t1[4]);

            System.out.printf(nomeTimeAdversario + ":    [%d]O [%d]\n", t1[1], t1[0]);

            System.out.println("==============GOL=============");

        }
        if (posicaoBola == 2 && posseDaBola == 1) {
            System.out.println("============GOL=============");

            System.out.printf(nomeTime + ":  [%d]  [%d]\n", t0[0], t0[1]);

            System.out.printf(nomeTime + ": [%d] [%d] [%d]\n", t0[2], t0[3], t0[4]);

            System.out.printf(nomeTime + ":   [%d] [%d]\n", t0[5], t0[6]);

            System.out.println("=============================");

            System.out.printf(nomeTimeAdversario + ":   [%d]  [%d]\n", t1[6], t1[5]);

            System.out.printf(nomeTimeAdversario + ":  [%d]O [%d] [%d]\n", t1[2], t1[3], t1[4]);

            System.out.printf(nomeTimeAdversario + ":    [%d] [%d]\n", t1[1], t1[0]);

            System.out.println("==============GOL=============");

        }
        if (posicaoBola == 3 && posseDaBola == 1) {
            System.out.println("============GOL=============");

            System.out.printf(nomeTime + ":  [%d]  [%d]\n", t0[0], t0[1]);

            System.out.printf(nomeTime + ": [%d] [%d] [%d]\n", t0[2], t0[3], t0[4]);

            System.out.printf(nomeTime + ":   [%d] [%d]\n", t0[5], t0[6]);

            System.out.println("=============================");

            System.out.printf(nomeTimeAdversario + ":   [%d]  [%d]\n", t1[6], t1[5]);

            System.out.printf(nomeTimeAdversario + ":  [%d] [%d]O [%d]\n", t1[2], t1[3], t1[4]);

            System.out.printf(nomeTimeAdversario + ":    [%d] [%d]\n", t1[1], t1[0]);

            System.out.println("==============GOL=============");

        }
        if (posicaoBola == 4 && posseDaBola == 1) {
            System.out.println("============GOL=============");

            System.out.printf(nomeTime + ":  [%d]  [%d]\n", t0[0], t0[1]);

            System.out.printf(nomeTime + ": [%d] [%d] [%d]\n", t0[2], t0[3], t0[4]);

            System.out.printf(nomeTime + ":   [%d] [%d]\n", t0[5], t0[6]);

            System.out.println("=============================");

            System.out.printf(nomeTimeAdversario + ":   [%d]  [%d]\n", t1[6], t1[5]);

            System.out.printf(nomeTimeAdversario + ":  [%d] [%d] [%d]O\n", t1[2], t1[3], t1[4]);

            System.out.printf(nomeTimeAdversario + ":    [%d] [%d]\n", t1[1], t1[0]);

            System.out.println("==============GOL=============");

        }
        if (posicaoBola == 5 && posseDaBola == 1) {
            System.out.println("============GOL=============");

            System.out.printf(nomeTime + ":  [%d]  [%d]\n", t0[0], t0[1]);

            System.out.printf(nomeTime + ": [%d] [%d] [%d]\n", t0[2], t0[3], t0[4]);

            System.out.printf(nomeTime + ":   [%d] [%d]\n", t0[5], t0[6]);

            System.out.println("=============================");

            System.out.printf(nomeTimeAdversario + ":   [%d]  [%d]O\n", t1[6], t1[5]);

            System.out.printf(nomeTimeAdversario + ":  [%d] [%d] [%d]\n", t1[2], t1[3], t1[4]);

            System.out.printf(nomeTimeAdversario + ":    [%d] [%d]\n", t1[1], t1[0]);

            System.out.println("==============GOL=============");

        }

        if (posicaoBola == 6 && posseDaBola == 1) {
            System.out.println("============GOL=============");

            System.out.printf(nomeTime + ":  [%d]  [%d]\n", t0[0], t0[1]);

            System.out.printf(nomeTime + ": [%d] [%d] [%d]\n", t0[2], t0[3], t0[4]);

            System.out.printf(nomeTime + ":   [%d] [%d]\n", t0[5], t0[6]);

            System.out.println("=============================");

            System.out.printf(nomeTimeAdversario + ":   [%d]O  [%d]\n", t1[6], t1[5]);

            System.out.printf(nomeTimeAdversario + ":  [%d] [%d] [%d]\n", t1[2], t1[3], t1[4]);

            System.out.printf(nomeTimeAdversario + ":    [%d] [%d]\n", t1[1], t1[0]);

            System.out.println("==============GOL=============");

        }

    }

    public static void main(String[] args) {
        menu();

    }

}
