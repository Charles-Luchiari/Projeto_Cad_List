package Produto;

import Produto.controller.ProdutoController;
import Produto.model.Produto;

import javax.imageio.IIOException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public static Scanner leia = new Scanner(System.in);
    public static void main(String[] args){
        ProdutoController produtos = new ProdutoController();

        int opcao, numero;
        float valor;
        String nome, descricao, estaDisponivel;
        boolean disponivel = false;

        System.out.println("\nCriar produtos\n");

        Produto p1 = new Produto(produtos.gerarNumero(), "Tenis", "Uma descrição breve sobre o tenis", 14.95f, true);
        produtos.cadastrar(p1);
        Produto p2 = new Produto(produtos.gerarNumero(), "Bota", "Uma descrição breve sobre o Bota", 10.50f, true);
        produtos.cadastrar(p2);
        Produto p3 = new Produto(produtos.gerarNumero(), "Sapato", "Uma descrição breve sobre o Sapato", 15.95f, true);
        produtos.cadastrar(p3);
        Produto p4 = new Produto(produtos.gerarNumero(), "Chinelo", "Uma descrição breve sobre o Chinelo", 20.99f, true);
        produtos.cadastrar(p4);

        while(true) {
            System.out.println("***************************************************************");
            System.out.println("                 Desafio da Oak Tecnologia                     ");
            System.out.println("***************************************************************");
            System.out.println("                                                               ");
            System.out.println("                 1 - Cadastrar Produto                         ");
            System.out.println("                 2 - Listar todos os produtos                  ");
            System.out.println("                 3 - Buscar produto por número                 ");
            System.out.println("                 4 - Atualizar produto                         ");
            System.out.println("                 5 - Deletar produto                           ");
            System.out.println("                 6 - Sair                                      ");
            System.out.println("                 7 - Ver meus contatos                         ");
            System.out.println("                                                               ");
            System.out.println("***************************************************************");
            System.out.println("Entre com a opção desejada:                                    ");

            try {
                opcao = leia.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\nDigite valores inteiros!");
                leia.nextLine();
                opcao = 0;
            }

            if(opcao == 6) {
                System.out.println("Muito obrigado pela oportunidade! Espero o contato!");
                leia.close();
                System.exit(0);
            }

            switch (opcao) {
                case 1:
                    System.out.println("Cadastrar produto");

                    System.out.println("Digite o nome do produto: ");
                    leia.skip("\\R?");
                    nome = leia.nextLine();

                    System.out.println("Digite a descrição do produto: ");
                    descricao = leia.nextLine();

                    System.out.println("Digite o valor do produto: ");
                    valor = leia.nextFloat();

                    System.out.println("O produto está disponivel?(S/N)");
                    leia.skip("\\R?");
                    estaDisponivel = leia.nextLine();

                    if(estaDisponivel.equalsIgnoreCase("S")){
                        disponivel = true;
                    } else if(estaDisponivel.equalsIgnoreCase("N")){
                        disponivel = false;
                    } else{
                        System.out.println("Digite um valor válido!");
                    }
                    produtos.cadastrar(new Produto(produtos.gerarNumero(), nome, descricao, valor, disponivel));
                    keyPress();
                    break;

                case 2:
                    System.out.println("Listar todos os produtos");
                    produtos.listarTodos();
                    keyPress();
                break;

                case 3:
                    System.out.println("Buscar produto pelo número\n");
                    System.out.println("Digite o número do produto: ");
                    numero = leia.nextInt();
                    produtos.procurarPorNumero(numero);
                    keyPress();
                break;

                case 4:
                    System.out.println("Atualizar produto\n");
                    System.out.println("Digite o numero do produto: ");
                    numero = leia.nextInt();

                    if(produtos.buscarNaCollection(numero) != null){
                        System.out.println("Digite o nome do produto: ");
                        leia.skip("\\R?");
                        nome = leia.nextLine();

                        System.out.println("Digite a descrição do produto: ");

                        descricao = leia.nextLine();

                        System.out.println("Digite o valor do produto: ");
                        valor = leia.nextFloat();

                        System.out.println("O produto está disponivel?(S/N)");
                        leia.skip("\\R?");
                        estaDisponivel = leia.nextLine();

                        if(estaDisponivel.equalsIgnoreCase("S")){
                            disponivel = true;
                        } else if(estaDisponivel.equalsIgnoreCase("N")){
                            disponivel = false;
                        } else{
                            System.out.println("Digite um valor válido!");
                        }
                        produtos.atualizar(new Produto(numero, nome, descricao, valor, disponivel));

                    }else {
                        System.out.println("Produto não encontrado!");
                    }
                    keyPress();
                    break;

                case 5:
                    System.out.println("Deletar produto");
                    System.out.println("Digite o número do produto: ");
                    numero = leia.nextInt();

                    produtos.deletar(numero);
                    keyPress();
                break;
                case 7:
                    System.out.println("Acesse meu Linkedin: https://www.linkedin.com/in/charles-luchiari98/");
                    System.out.println("Acesse meu Github: https://github.com/Charles-Luchiari");
                    System.out.println("Muito obrigado pela oportunidade!");
                    keyPress();
                    break;
            }
        }
    }

    public static void keyPress() {
        try {
            System.out.println("\n\nPressione Enter para continuar!");
            System.in.read();

        } catch (IOException e) {
            System.out.println("Você pressionou uma tecla diferente de Enter!");
        }
    }
}
