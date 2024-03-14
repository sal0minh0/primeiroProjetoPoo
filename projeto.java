import java.util.Scanner;

public class projeto {

    public double adicionarProduto(double preço, int quantidade){
        return produto;
    }
    public double removerProduto(double preço, int quantidade){
        return produto;
    }
    public static void consultarProduto(String consulta){
        return consulta;
    }
    public static void atualizarProduto(String atual){
        return atual;

    }
    
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);

        String menu = sc.nextLine();
        
        switch(menu){

            case "Adicionar Produto":
            adicionarProduto();
            case "Remover Produto":
            removerProduto();
            case "Consultar Produto":
            consultarProduto();
            case "Atualizar Produto":
            atualizarProduto();

        }

    }
}