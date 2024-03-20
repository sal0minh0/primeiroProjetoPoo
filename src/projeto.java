import java.util.Scanner;

public class projeto {
    static Scanner sc = new Scanner(System.in);

        static int maximo; //maximo do estoque
        static String[] nome; //o produto
        static int[] quantidade; //quantidade de produtos
        static double[] preco; //preço dos produtos
        static String[] validade; //validade dos produtos
        static int indice = 0; //tamanho do vetor


    //adiciona Produtos

    public static void adicionarProduto() {


        if (indice < maximo) {
            System.out.println("Qual o nome desse produto? ");
            nome[indice] = sc.nextLine();
            System.out.println("Quantos desse produto você deseja adicionar? ");
            quantidade[indice] = sc.nextInt();
            sc.nextLine();
            System.out.println("Qual o preço do produto? ");
            preco[indice] = sc.nextDouble();
            sc.nextLine();
            System.out.println("Qual a validade do produto? ");
            validade[indice] = sc.nextLine();
            indice++;
        } else {
            System.out.println("Estoque está cheio.");
        }
    }

    //consulta de Produtos
    public static void consultarProdutos() {

        if (indice == 0) {
            System.out.println();
            System.out.println("Sem Produto no estoque, Use a primeira opção para registrar seu produto.");
            System.out.println();
        } else {

        for (int i = 0; i < indice; i++) {
            System.out.println();
            System.out.println("Produto " + (i + 1) + ":");
            System.out.println("Nome: " + nome[i]);
            System.out.println("Quantidade: " + quantidade[i]);
            System.out.println("Preço: " + preco[i]);
            System.out.println("Validade: " + validade[i]);
            System.out.println();
            }
        }
    }

    public static void main(String[] args) {

        //interface para iniciar
        System.out.println("Digite 'i' para iniciar e outro digito para sair.");
        char c = sc.next().charAt(0);
        sc.nextLine();
        System.out.println("Informe o numero máximo de produtos:");
        maximo = sc.nextInt();
        sc.nextLine();
        if (maximo <= 0) {
            System.out.println("O estoque deve ser um número positivo maior que zero.");
            return;
        }

        //criando os vetores

        nome = new String[maximo];
        quantidade = new int[maximo];
        preco = new double[maximo];
        validade = new String[maximo];

        //interface menu

        while (c == 'i'){

            System.out.println("Menu interativo - Controle de Estoque (escolha uma opção): ");
            System.out.println("1 - Adicionar Produto");
            System.out.println("2 - Consultar Produto");
            System.out.println("3 - Remover Produto");
            System.out.println("4 - Atualizar Produto");
            System.out.println("5 - Sair");
            int opcao = Integer.parseInt(sc.nextLine());

            System.out.println("Opção escolhida: " + opcao);

            switch (opcao) {
                case 1:
                    adicionarProduto();
                    break;
                    
                case 2:
                    consultarProdutos();
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
            break;

        }

        System.out.println("Programa Terminado.");
        sc.close();

    }
}
