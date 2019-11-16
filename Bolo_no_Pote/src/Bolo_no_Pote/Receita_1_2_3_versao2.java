package Bolo_no_Pote;

import java.util.Scanner;

public class Receita_1_2_3_versao2 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

		// Declaração de variáveis

		int cont = 0;

		String[] Ingredientes_Receita_1 = { "Açucar", "Margarina", "Ovos", "Farinha de Trigo", "Leite Condensado",
				"creme de leite", "Leite Ninho", "Morango" };
		int[] Quant_Ingredientes = new int[8];
		float[] Valor_Ingredientes = new float[8];
		float[] Quant_Fixa_Receita_1 = { 300, 300, 4, 300, 300, 300, 100, 20 };
		float[] Valor_Total_Cada_Ingred_Receita_1 = new float[8];
		float Valor_Total_Receita_Sem_Embalagem = 0;
		int Qtde_Embalagem = 15;
		float Preco_Unit_Embalagem, Total_Embalagem = 0;
		float Valor_Total_Receita_Com_Embalagem = 0;
		float Custo_Max_Pote = 2;
		float Preco_Min_Venda_Pote = 5;
		float Valor_Pote_Unit = 0;
		float Lucro = 0;
		float perc_Lucro = 0;
		int escolha;
		int codigo;

		// float[] Valor_Total_Massa = new float[4];

		// Alguns print's apenas para visualizar melhor algumas saídas
		System.out.println("\n======================================================================");
		System.out.println("\n============== ADR - SISTEMAS E SOLUÇÕES EM TECNOLOGIA ===============");// Nome da
																										// empresa
		System.out.println("\n============================ BOLO NO POTE ============================");// Nome do
																										// produto
		System.out.println("\n=============================== OPÇÕES ===============================");
		System.out.println("\n1) LEITE NINHO COM MORANGO\n2) DOIS AMORES\n3) MARACUJÁ");// Lista de opções de receitas
		System.out.printf("\nEscolha uma das opções acima: ");

		// Validação para a escolha da receita

		escolha = 0;
		do {
			boolean teste = false;
			do {
				try {
					escolha = Integer.parseInt(teclado.next());
					teste = true;
				} catch (Exception erro) {
					System.err.println("Opção inválida, digite de 1 a 3 > ");

				}
			} while (teste == false);
			if (escolha != 1 && escolha != 2 && escolha != 3) {
				System.err.printf("Ops !!! - Opção inválida, Digite de 1 a 3 > ");

			}

		} while (escolha != 1 && escolha != 2 && escolha != 3);

		if (escolha == 1) {
			System.out.println();
			System.out.printf("OK, você escolheu LEITE NINHO COM MORANGO!");
			System.out.println();

			// Gerando a lista de ingredientes da receita 1

			System.out.println("\n------------Lista de Ingredientes---------");
			for (int i = 0; i < Ingredientes_Receita_1.length; i++) {
				System.out.printf("%d ) %s\n", i + 1, Ingredientes_Receita_1[i]);

			}
			System.out.println();

			// Percorrendo a lista e validando o código escolhido pelo usuário

			for (int i = 0; i < Ingredientes_Receita_1.length; i++) {

				System.out.printf("Informe o código de um ingrediente: ");

				codigo = 0;
				do {

					boolean teste1 = false;
					do {
						try {
							codigo = Integer.parseInt(teclado.next());
							teste1 = true;

						} catch (Exception erro1) {
							System.err.println("Código inválido, digite de 1 a 8 > ");
						}

					} while (teste1 == false);

					if (codigo != 1 && codigo != 2 && codigo != 3 && codigo != 4 && codigo != 5 && codigo != 6
							&& codigo != 7 && codigo != 8) {
						System.err.printf("Ops !!! - Código inválido, Digite de 1 a 8 > ");

					}
				} while (codigo != 1 && codigo != 2 && codigo != 3 && codigo != 4 && codigo != 5 && codigo != 6
						&& codigo != 7 && codigo != 8);

				System.out.printf("Informe a quantidade de %s.................> ", Ingredientes_Receita_1[codigo - 1]);

				// Validando a quantidade de ingredientes para que não seja negativa ou maior
				// que 100000

				Quant_Ingredientes[codigo - 1] = 0;
				do {
					boolean teste2 = false;
					do {
						try {
							Quant_Ingredientes[codigo - 1] = Integer.parseInt(teclado.next());
							teste2 = true;
						} catch (Exception erro3) {
							System.err.printf("Quantidade inválida, por favor, digite novamente: ");
						}

					} while (teste2 == false);

					if (Quant_Ingredientes[codigo - 1] <= 0 || Quant_Ingredientes[i] > 100000) {

						System.err.printf("Quantidade inválida, Por favor, digite quantidade entre 1 a 100000: ");
					}

				} while (Quant_Ingredientes[i] <= 0 && Quant_Ingredientes[i] > 100000);

				System.out.printf("Informe o valor do(a) %s........>", Ingredientes_Receita_1[codigo - 1]);

				Valor_Ingredientes[codigo - 1] = 0;
				do {
					boolean teste3 = false;
					do {
						try {
							Valor_Ingredientes[codigo - 1] = Float.parseFloat(teclado.next().replace(",", "."));
							teste3 = true;
						} catch (Exception erro3) {
							System.err.printf("Preço inválido, por favor, digite novamente: ");

						}

					} while (teste3 == false);

					if (Valor_Ingredientes[codigo - 1] <= 0 || Valor_Ingredientes[codigo - 1] > 100000)

					{
						System.err.printf("Preço inválido, por favor digite novamente um valor entre 1 e 100000: ");
					}

				} while (Valor_Ingredientes[codigo - 1] <= 0 || Valor_Ingredientes[codigo - 1] > 100000);

				// Calculando o valor total de cada ingrediente

				Valor_Total_Cada_Ingred_Receita_1[codigo
						- 1] = (Valor_Ingredientes[codigo - 1] / Quant_Ingredientes[codigo - 1])
								* Quant_Fixa_Receita_1[codigo - 1];

			}

			// Calculando o valor da embalagem separadamente

			System.out.printf("Informe o valor de cada embalagem: ");
			Preco_Unit_Embalagem = teclado.nextFloat();
			Total_Embalagem = Qtde_Embalagem * Preco_Unit_Embalagem;

			System.out.println("\n=====================================================================");
			System.out.printf("Valor unitário de cada ingrediente com base nos valores informados:");
			System.out.println("\n=====================================================================");
			for (int i = 0; i < Ingredientes_Receita_1.length; i++) {

				// Imprimindo os totais de cada ingredientes separadamente

				System.out.printf("%.4f > %s\n", Valor_Total_Cada_Ingred_Receita_1[i], Ingredientes_Receita_1[i]);
				Valor_Total_Receita_Sem_Embalagem += Valor_Total_Cada_Ingred_Receita_1[i];
			}

			// Calculando o valor total da receita com embalagem
			// Calculando o valor unitário de cada pote de bolo
			// Calculando o lucro em reais e em percentagem

			Valor_Total_Receita_Com_Embalagem += Valor_Total_Receita_Sem_Embalagem + Total_Embalagem;
			Valor_Pote_Unit = Valor_Total_Receita_Com_Embalagem / Qtde_Embalagem;
			Lucro = Preco_Min_Venda_Pote - Valor_Pote_Unit;
			perc_Lucro = (Lucro / Preco_Min_Venda_Pote) * 100;

			System.out.printf("\n=================== RESULTADO DE SUA PESQUISA =======================\n");
			System.out.printf("%.4f > Valor total da receita sem embalagem\n", Valor_Total_Receita_Sem_Embalagem);
			System.out.println("=====================================================================");
			System.out.printf("%.4f > Valor total de 15 embalagens\n", Total_Embalagem);
			System.out.println("=====================================================================");
			System.out.printf("%.4f > Valor total da receita com embalagem\n", Valor_Total_Receita_Com_Embalagem);
			System.out.println("=====================================================================");
			System.out.printf("%.2f > Valor unitário do Bolo no Pote\n", Valor_Pote_Unit);
			System.out.println("=====================================================================");
			System.out.printf("%.2f > Valor mínimo de venda unitário do Bolo no Pote\n", Preco_Min_Venda_Pote);
			System.out.println("=====================================================================");
			System.out.printf("%.2f > Valor do lucro em R$\n", Lucro);
			System.out.println("=====================================================================");
			System.out.printf("%.2f %% > Valor do lucro em percentagem\n", perc_Lucro);
			System.out.println("=====================================================================");

			// Verificando se o valor de custo final do produto está abaixo do solicitado

			if (Valor_Pote_Unit <= Custo_Max_Pote) {
				System.out.printf("======================== RECEITA 1 - APROVADA =======================\n");
			} else {
				System.out.printf("======================= RECEITA 1 - REPROVADA =======================\n");
			}
		}
		teclado.close();
	}

}
