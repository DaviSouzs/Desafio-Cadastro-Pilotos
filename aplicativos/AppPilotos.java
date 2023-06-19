package aplicativos;

import java.io.IOException;
import java.util.Scanner;

import classes.Aeronave;
import classes.Pessoa;
import classes.Piloto;

public class AppPilotos {
    public static void main(String[] args) throws InterruptedException, IOException {
        final int MAX_ELEMENTOS = 10;
        int opcao, qtdCadastrados=0;
        Pessoa[] pilotos = new Pessoa[MAX_ELEMENTOS];
        Scanner in = new Scanner(System.in);
        //Piloto p = new Piloto();

        do {
            System.out.println("\n****\nMENU\n****\n");
            System.out.println("1 - Cadastrar piloto");
            System.out.println("2 - Listar pilotos cadastrados");
            System.out.println("3 - Localizar piloto pelo CPF");
            System.out.println("4 - Cadastrar aeronave");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            opcao = in.nextInt();
            in.nextLine(); // Tira o ENTER que ficou na entrada na instrução anterior

            if (opcao == 1) {
                // Se não tem mais espaço no vetor, saio do cadastro
                if (qtdCadastrados == MAX_ELEMENTOS) {
                    System.out.println("\nNão há espaço para cadastrar novos pilotos.");
                    voltarMenu(in);
                    continue;
                }
                //Cadastre seu piloto aqui
                Piloto p = new Piloto();
                System.out.println("Informe o nome do piloto");
                p.setNome(in.nextLine());
                System.out.println("Informe o CPF do piloto");
                p.setCpf(in.nextLine());
                System.out.println("Informe o Beve do Piloto");
                p.setBreve(in.nextLine());
                pilotos[qtdCadastrados] = p;
                qtdCadastrados=qtdCadastrados+1;
                System.out.println("\nPiloto cadastrado com sucesso.");
                
                voltarMenu(in);
                }else if (opcao == 2) {
            // Se não tem ninguém cadastrado no vetor, caio fora
            if (qtdCadastrados == 0) {
                System.out.println("\nNão há pilotos cadastrados para exibir.");
                voltarMenu(in);
                continue;
            }
            // Exiba os pilotos aqui
            for (int i = 0; i < qtdCadastrados; i++) {
                Piloto piloto = (Piloto) pilotos[i];
                System.out.println("Piloto encontrado, dados: \n Nome do Piloto: " + piloto.getNome() + " CPF: " + piloto.getCpf() + " Breve: " + piloto.getBreve());
            
            }
            voltarMenu(in);
        
                } else if (opcao == 3) {
                    // Se não tem ninguém cadastrado no vetor, caio fora
                if (qtdCadastrados == 0) {
                System.out.println("\nNão há pilotos cadastrados para exibir.");
                voltarMenu(in);
                continue; }
                
                boolean achou = false;
                System.out.println("Informe o CPF do piloto");
                String cpf = in.nextLine();
                for (int i = 0; i < qtdCadastrados; i++) {
                    if (pilotos[i].getCpf().equals(cpf)) {
                        achou = true;
                        Piloto piloto = (Piloto) pilotos[i];
                        System.out.println("Piloto encontrado, dados: \n Nome do Piloto: " + piloto.getNome() + " CPF: " + piloto.getCpf() + " Breve: " + piloto.getBreve());
                    }
                }
                if (!achou) {
                    System.out.println("Piloto não encontrado");
                }
                   }else if (opcao == 4) {
                    // Se não tem ninguém cadastrado no vetor, caio fora
                    if (qtdCadastrados == 0) {
                        System.out.println("\nSem pilotos, não há como cadastrar uma aeronave");
                        voltarMenu(in);
                        continue;
                    }

                    // Solicite ao usuário o piloto
                    System.out.println("Informe o CPF do piloto:");
                    String cpf = in.nextLine();
                    Piloto acheiPiloto = null;

                    for (int i = 0; i < qtdCadastrados; i++) {
                        Piloto piloto = (Piloto) pilotos[i];

                        if (piloto.getCpf().equals(cpf)) {
                            acheiPiloto = piloto;
                            break;
                        }
                    }

                    if (acheiPiloto == null) {
                        System.out.println("Piloto não encontrado.");
                        voltarMenu(in);
                        continue;
                    }
              
                //Crie a aeronave vinculando-a ao piloto
                Aeronave aeronave = new Aeronave();
                aeronave.setPiloto(acheiPiloto);
                System.out.println("Informe o modelo da Aeronave");
                aeronave.setModelo(in.nextLine());
                System.out.println("Infome o Nº de série da Aeronave:");
                aeronave.setNumeroSerie(in.nextLine());
                System.out.println("\nAeronave cadastrada com sucesso.");
                //Exiba os dados da aeronave
                System.out.println("Modelo: " + aeronave.getModelo() + " Nº Série: " + aeronave.getNumeroSerie() + " Piloto: " + aeronave.getPiloto().getNome() );
                voltarMenu(in);
                continue;
            }
              else if (opcao != 0) {
                System.out.println("\nOpção inválida!");
            }
        } while (opcao != 0);

        System.out.println("Fim do programa!");

        in.close();
    }

    private static void voltarMenu(Scanner in) throws InterruptedException, IOException {
        System.out.println("\nPressione ENTER para voltar ao menu.");
        in.nextLine();

        // Limpa toda a tela, deixando novamente apenas o menu
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            System.out.print("\033[H\033[2J");
        
        System.out.flush();
    }
}