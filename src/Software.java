import java.util.Locale;
import java.util.Scanner;

public class Software {
	/**
	* Faz a leitura da tabela inteira a partir da entrada do usuario
	* @param vet Um vetor JA INSTANCIADO
	*/
	public static void lerTabela(int codigo[],String descricao[], double preco[],double quantidade[], double valorEstoque[]){
        @SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
        for (int i = 0; i < codigo.length; i++) {
			System.out.print("Código do "+(i+1)+"° produto: ");
			codigo[i] = sc.nextInt();
			System.out.print("Descrição do "+(i+1)+"° produto: ");
			sc.nextLine();
			descricao[i] = sc.nextLine();
			System.out.print("Preço do "+(i+1)+"° produto: ");
			preco[i] = sc.nextDouble();
			System.out.print("Quantidade no estoque do "+(i+1)+"° produto: ");
			quantidade[i] = sc.nextDouble();
			valorEstoque[i] = (preco[i] * quantidade[i]);
		}
    }
	/**
	 * Imprimi a tabela fornecida anteriormante pelo usuario
	 * @param codigo vetor dos codigos dos produtos
	 * @param descricao vetor das descrições dos produtos
	 * @param preco vetor dos preços dos produtos
	 * @param quantidade vetor das quantidades dos produtos
	 * @param valorEstoque vetor do valor do estoque
	 */
	public static void imprimirTabela(int codigo[],String descricao[], double preco[],double quantidade[], double valorEstoque[]){
        System.out.println("Código - Descrição - Preço - Quantidade");
			for (int i = 0; i < codigo.length; i++) {
				System.out.println(codigo[i] + " " + descricao[i] + " " + preco[i] + " " + quantidade[i]);
			}
    }
	/**
	 * Exibe o menu principal e possibilita a inserção da opção do usuario
	 * @param codigo vetor dos codigos dos produtos
	 * @param descricao vetor das descrições dos produtos
	 * @param preco vetor dos preços dos produtos
	 * @param quantidade vetor das quantidades dos produtos
	 * @param valorEstoque vetor do valor do estoque
	 */
	public static void menuPrincipal(int[] codigo, String[] descricao, double[] preco, double[]quantidade, double valorEstoque[]) {
		System.out.println("\n--- Menu Principal ---");
		System.out.println("1 – Imprimir tabela");
		System.out.println("2 – Pesquisar produto *");
		System.out.println("3 – Mostrar dados do produto mais caro");
		System.out.println("4 – Mostrar código e descrição dos produtos cuja quantidade está abaixo de 10");
		System.out.println("5 – Ativo total do estoque **");
		System.out.println("6 – Efetuar uma venda ***");
		System.out.println("7 – Sair ------------------------------------------------------------------------");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.print("\nOpção desejada? ");
		int N = sc.nextInt();
		if (N == 1) {
			imprimirTabela(codigo, descricao, preco, quantidade, valorEstoque);
			menuPrincipal(codigo, descricao, preco, quantidade, valorEstoque);
		} else if (N == 2) {
			buscaProduto(codigo, descricao, preco, quantidade, valorEstoque);
		} else if (N == 3) {
			maisCaro(codigo, descricao, preco, quantidade, valorEstoque);
		} else if (N == 4) {
			abaixoDe10(codigo, descricao, preco, quantidade, valorEstoque);
		} else if (N == 5) {
			ativoTotal(codigo, descricao, preco, quantidade, valorEstoque);
		} else if (N == 6) {
			efetuarVenda(codigo, descricao, preco, quantidade, valorEstoque);
		} else if (N == 7) {
			System.out.println("Terminal fechado !");
		} else {
			System.err.println("Opção invalida !");
		}
	}
	/**
	 * Exibe na tela os dados do produto mais caro
	 * @param codigo vetor dos codigos dos produtos
	 * @param descricao vetor das descrições dos produtos
	 * @param preco vetor dos preços dos produtos
	 * @param quantidade vetor das quantidades dos produtos
	 * @param valorEstoque vetor do valor do estoque
	 */
	public static void maisCaro(int codigo[], String descricao[], double preco[], double quantidade[], double valorEstoque[]){
    	double maisCaro = 0;
		@SuppressWarnings("unused")
		int cont = 0;
		for (int i = 0; i < preco.length; i++) {
			if (preco[i] > maisCaro) {
				maisCaro = preco[i];
				cont++;
			}
				System.out.println("Produto mais caro: ");
				System.out.println("Código - Descrição - Preço - Quantidade - Valor em estoque");
				System.out.println(codigo[i] + " " + descricao[i] + " " + preco[i] + " " + quantidade[i] + " " + valorEstoque[i]);	
			}
		}
	/**
	 * Busca o produto desejado conforme o codigo do produto fornecido
	 * @param codigo vetor dos codigos dos produtos
	 * @param descricao vetor das descrições dos produtos
	 * @param preco vetor dos preços dos produtos
	 * @param quantidade vetor das quantidades dos produtos
	 * @param valorEstoque vetor do valor do estoque
	 */
	public static void buscaProduto(int codigo[], String descricao[], double preco[], double quantidade[], double valorEstoque[]){
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
            System.out.println("Código do produto:");
            double codigoProduto = sc.nextDouble();			
			for (int i = 0; i < codigo.length; i++) {
				if (codigoProduto == codigo[i]){
					System.out.println("Código - Descrição - Preço - Quantidade - Valor em estoque");
						System.out.println(codigo[i] + " " + descricao[i] + " " + preco[i] + " " + quantidade[i]
								+ " " + valorEstoque[i]);
				} else {
				System.out.println("erro - produto não cadastrado!");
				}
			}
    }
	/**
	 * Mostrar código e descrição dos produtos cuja quantidade está abaixo de 10
	 * @param codigo vetor dos codigos dos produtos
	 * @param descricao vetor das descrições dos produtos
	 * @param preco vetor dos preços dos produtos
	 * @param quantidade vetor das quantidades dos produtos
	 * @param valorEstoque vetor do valor do estoque
	 */
	public static void abaixoDe10(int codigo[], String descricao[], double preco[], double quantidade[], double valorEstoque[]){
				for (int i = 0; i < quantidade.length; i++){
					if (quantidade[i] < 10 ){
						System.out.println("Codigo" + codigo[i] + "\tDescrição" + descricao[i]);
					}
				}
	    }
	/**
	 * Mostra na tela o ativo total do estoque
	 * @param codigo vetor dos codigos dos produtos
	 * @param descricao vetor das descrições dos produtos
	 * @param preco vetor dos preços dos produtos
	 * @param quantidade vetor das quantidades dos produtos
	 * @param valorEstoque vetor do valor do estoque
	 */
	 public static void ativoTotal(int codigo[], String descricao[], double preco[], double quantidade[], double valorEstoque[]){
	      double ativoTotal = 0;
				for(int i = 0; i < codigo.length; i++){
					ativoTotal = quantidade[i] * preco[i];
				}
				System.out.println(ativoTotal);
	    }
	 /**
	  * Efetua a vendo conforme os dados fornecidos pelo usuario
	  * @param codigo vetor dos codigos dos produtos
	  * @param descricao vetor das descrições dos produtos
	  * @param preco vetor dos preços dos produtos
	  * @param quantidade vetor das quantidades dos produtos
	  * @param valorEstoque vetor do valor do estoque
	  */
	 public static void efetuarVenda(int codigo[], String descricao[], double preco[], double quantidade[], double valorEstoque[]){
	        @SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
	     	System.out.println("Código do produto:");
				double codigoVenda = sc.nextDouble();
				int quantantidadeVenda;
				for(int i = 0; i < codigo.length; i++){
					if (codigoVenda != codigo[i]){
						System.out.println("Erro! produto não cadastrado!");
					}
				else {
					System.out.println("Quantidade de produtos:");
					quantantidadeVenda = sc.nextInt();
					    
				for(i = 0; i < quantidade.length; i++){
					if (quantantidadeVenda > quantidade[i]){
						System.out.println("Erro! quantidade em estoque insuficiente.");
					}
					else {
				    System.out.println("Total a pagar:");
				        double valorVenda = 0;
			    	for(i = 0; i < quantidade.length; i++){
			    		valorVenda = quantantidadeVenda * preco[i];
					    }
					    System.out.println("Valor total:" + valorVenda);
				    	}
				    }
			    }   
			}
	    }
	public static void main(String args[]) {	
	
		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);
		Locale.setDefault(new Locale("en", "US"));
		
		int numerodeProdutos, vetcodigo[];
		double vetpreco[], vetquantidade[];
		String vetdescricao[];
		
		System.out.println("Quantos produtos possui sua loja: ");
		numerodeProdutos = sc.nextInt();
		
		vetcodigo = new int[numerodeProdutos];
		vetdescricao = new String[numerodeProdutos];
		vetpreco = new double[numerodeProdutos];
		vetquantidade = new double[numerodeProdutos];
		double vetvalorEstoque[] = new double[numerodeProdutos];
		
		lerTabela(vetcodigo, vetdescricao, vetpreco, vetquantidade, vetvalorEstoque);
		
		int mostraMenu = 0;
		while (mostraMenu != 7){
		menuPrincipal(vetcodigo, vetdescricao, vetpreco, vetquantidade, vetvalorEstoque);
		}
		
		sc.close();
	}
}