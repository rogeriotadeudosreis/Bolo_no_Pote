package Bolo_no_Pote;

import java.util.Scanner;

public class Receitas_1_2_3 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		//Declaração de variáveis

		int cont = 0;
		String[] Ingredientes_Massa = { "Açucar", "Margarina", "Ovos", "Farinha de Trigo" };
		int[] Quant_Ingredientes = new int[4];
		double[] Valor_Ingredientes = new double[4];
		double[] Valor_Massa = new double[4];
		int[] Quant_Fixa_Receita = { 300, 300, 4, 300 };
		int escolha;
		String[] Recheio_Receita_1 = { "Leite Condensado", "creme de leite", "Leite Ninho", "Morango" };
		int[] Quant_recheio_receita_1 = new int[4];
		double[] Valor_recheio_receita_1 = new double[4];
		double[] Total_recheio_receita_1 = new double[4];
		int[] Quant_Fixa_Recheio_Receita_1 = { 300, 300, 100, 20 };
		int[] cod_Ingrediente = new int [4]; 
		double [][] total_Ingredientes = new double[2][4];

		System.out.println("======================================================================");
		System.out.println("===============ADS - SISTEMAS E SOLUÇÕES EM TECNOLOGIA================");
		System.out.println();
		System.out.println("=============================BOLO NO POTE=============================");
		System.out.println();
		System.out.println("1) LEITE NINHO COM MORANGO\n2) DOIS AMORES\n3) MARACUJÁ");
		System.out.println();
		System.out.printf("Escolha uma das opções acima: ");

		//Uma pequena validação para a escolha dos ingredientes
		escolha = 0;
		do {
			boolean teste= false;
			do {
				try {
					escolha = Integer.parseInt(teclado.nextLine());
					teste = true;
				} catch (Exception e) {
					System.out.println("O dado informado não é um número, digite de 1 a 3 > ");
				}
			}while(teste==false);
			if (escolha != 1 && escolha != 2 && escolha != 3) {
				System.out.printf("Ops !!! - Opção inválida, Digite de 1 a 3 > ");

			}

		} while (escolha != 1 && escolha != 2 && escolha != 3);

		if (escolha == 1) {
			System.out.println();
			System.out.printf("OK, você escolheu LEITE NINHO COM MORANGO!");
			System.out.println();

			// Abaixo temos o cálculo da massa, que será igual para todas as receitas

			for (int i = 0; i < Ingredientes_Massa.length; i++) {

				System.out.printf("Informe a quantidade de %s.................>", Ingredientes_Massa[i]);
				
				
				
				
				Quant_Ingredientes[i] = 0;
				do {
					boolean teste = false;
						
					do {
						try {
							
							
							Quant_Ingredientes[i] = Integer.parseInt(teclado.next());
							teste =true;
						} catch (Exception e) {
							
							System.out.printf("O valor informado não é válido");
						}
						
						
						
						
					}while (teste == false);
													
							
						
					
					
					
					
				}while (Quant_Ingredientes[i] < 0);
				
				
				
				
				
				
				
				System.out.printf("Informe o valor da quantidade de %s........>", Ingredientes_Massa[i]);
				Valor_Ingredientes[i] = teclado.nextDouble();
				Valor_Massa[i] = (Valor_Ingredientes[i] / Quant_Ingredientes[i]) * Quant_Fixa_Receita[i];
			}
			System.out.println("=====================================================================");
			System.out.printf("\nValor de cada ingrediente com base em sua informação:");
			System.out.println();
			for (int i = 0; i < Ingredientes_Massa.length; i++) {

				System.out.printf("%.4f > %s\n", Valor_Massa[i], Ingredientes_Massa[i]);
			}
			System.out.println("=====================================================================");

			// Aqui temos o cálculo do recheio da receita escolhida, nesse caso a > 1

			for (int i = 0; i < Quant_Fixa_Recheio_Receita_1.length; i++) {
				System.out.printf("Agora informe a quantidade de %s........>", Recheio_Receita_1[i]);
				Quant_recheio_receita_1[i] = teclado.nextInt();
				System.out.printf("Informe o valor da quantidade de %s........>", Recheio_Receita_1[i]);
				Valor_recheio_receita_1[i] = teclado.nextDouble();
				Total_recheio_receita_1[i] = (Valor_recheio_receita_1[i] / Quant_recheio_receita_1[i])
						* Quant_Fixa_Recheio_Receita_1[i];

			}
			System.out.println("=====================================================================");
			System.out.printf("\nValor de cada recheio com base em sua informação:");
			System.out.println();
			for (int i = 0; i < Recheio_Receita_1.length; i++) {

				System.out.printf("%.4f > %s\n", Total_recheio_receita_1[i], Recheio_Receita_1[i]);
			}
			System.out.println("=====================================================================");
		}

		teclado.close();
	}
}
