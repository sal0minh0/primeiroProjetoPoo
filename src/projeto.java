import java.util.Scanner;

//classe geral
public class projeto {

        //declarar os variáveis 
        Scanner sc = new Scanner(System.in);
        private int maximo; //maximo do estoque
        private String[] nome; //o produto
        private int[] quantidade; //quantidade de produtos
        private double[] preco; //preço dos produtos
        private String[] validade; //validade dos produtos
        private int indice = 0; //tamanho do vetor
        
//construtor da classe
    public projeto(String[] nome, int[] quantidade, double[] preco, String[] validade, int maximo, int indice){
        this.maximo = maximo;
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
        this.validade = validade;
        this.indice = indice;
    }
    //metodos get e set
    public String[] getNome() {
        return nome;
    }
    public void setNome(String[] nome) {
        this.nome = nome;
    }
    public int[] getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int[] quantidade) {
        this.quantidade = quantidade;
    }
    public double[] getPreco() {
        return preco;
    }
    public void setPreco(double[] preco) {
        this.preco = preco;
    }


    //adicionar Produtos

    public void adicionarProduto() {

        
        
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
            System.out.println();
            System.out.println("Estoque está cheio.");
            System.out.println();
        }
    }

    //remoção de Produtos

    public void removerProduto() {
        System.out.println("Qual o nome do produto que você deseja remover? ");
        String produtoParaRemover = sc.nextLine();

        boolean acharProduto = false;
        for (int i = 0; i < indice; i++) {
            if (nome[i].equals(produtoParaRemover)) {

                for (int j = i; j < indice - 1; j++) {
                    nome[j] = nome[j + 1];
                    quantidade[j] = quantidade[j + 1];
                    preco[j] = preco[j + 1];
                    validade[j] = validade[j + 1];
                }
                indice--;
                System.out.println();
                System.out.println("Produto" + " " + produtoParaRemover + " " + "removido com sucesso.");
                System.out.println();
                acharProduto = true;
                break;
            }
        }

        if (acharProduto == false) {
            System.out.println();
            System.out.println("Produto não encontrado.");
            System.out.println();
        }
    }

    //consulta de Produtos
    public void consultarProdutos() {

        if (indice == 0) {
            System.out.println();
            System.out.println("Sem Produto no estoque, Use a primeira opção para registrar seu produto.");
            System.out.println();

        } else {

        for (int i = 0; i < indice; i++) {
            System.out.println();
            System.out.println("Produto " + (i + 1) + ":");
            System.out.println("Nome: " + nome[i]);
            System.out.println("Quantidade: " + quantidade[i] + " " + nome[i] + "(s)");
            System.out.printf("Preço: R$%.2f\n", preco[i]);
            System.out.println("Validade: " + validade[i]);
            System.out.println();

            }
        }
    }

    //atualizar o produto selecionado

    public void atualizarProduto() {
        System.out.println("Você deseja atualizar qual produto? ");
        String atual = sc.nextLine();

        for (int i = 0; i < indice; i++) {

            if (nome[i].equals(atual)) {

                System.out.println("Trocando as informações...");
                System.out.println("Digite o nome correto do produto: ");
                nome[i] = sc.nextLine();
                System.out.println("Digite o número correto de produtos você deseja adicionar: ");
                quantidade[i] = sc.nextInt();
                sc.nextLine();
                System.out.println("Qual o preço correto do produto?");
                preco[i] = sc.nextDouble();
                sc.nextLine();
                System.out.println("Qual a validade correta do produto?");
                validade[i] = sc.nextLine();
                return;
            }
            if (!nome[i].equals(atual)) {
                System.out.println();
                System.out.println("Produto não encontrado.");
                System.out.println();
                break;
            }
        }

    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //variaveis locais
        int maximo; 
        String[] nome; 
        int[] quantidade; 
        double[] preco; 
        String[] validade; 
        int indice = 0; 

        
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

        projeto objeto = new projeto(nome, quantidade, preco, validade, maximo, indice);

        //interface menu

        while (c == 'i'){

            System.out.println("Menu interativo - Controle de Estoque (escolha uma opção): ");
            System.out.println("1 - Adicionar Produto");
            System.out.println("2 - Remover Produto");
            System.out.println("3 - Consultar Produtos");
            System.out.println("4 - Atualizar Produto");
            System.out.println("5 - Sair");
            int opcao = Integer.parseInt(sc.nextLine());

            System.out.println("Opção escolhida: " + opcao);

            switch (opcao) {
                case 1:

                    objeto.adicionarProduto();
                    break;

                case 2:

                    objeto.removerProduto();
                    break;

                case 3:

                    objeto.consultarProdutos();
                    break;

                case 4:
                    objeto.atualizarProduto();
                    break;

                case 5:

                    c = 's';
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }


        }

        System.out.println("Programa Terminado.");
        sc.close();

    }
}
