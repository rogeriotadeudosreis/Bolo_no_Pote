package Bolo_no_Pote;

import java.util.Scanner;

public class Receita_1_2_3_versao2 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

		// Declaração de variáveis

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
		System.out.println("\n                ADR - SISTEMAS E SOLUÇÕES EM TECNOLOGIA               ");// Nome da
																										// empresa
		System.out.println("\n                      ORÇAMENTOS & VIABILIDADES                             ");// Nome do
																										// produto
		System.out.println("\n=============================== OPÇÕES ===============================");
		System.out.println("\n1) BOLO NO POTE - LEITE NINHO COM MORANGO\n2) BOLO NO POTE - CHOCOLATE\n3) BOLO NO POTE - MARACUJÁ");// Lista de opções de receitas
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

			System.out.println("\n----------- Lista de Ingredientes ---------");
			for (int i = 0; i < Ingredientes_Receita_1.length; i++) {
				System.out.printf("%d ) %s\n", i + 1, Ingredientes_Receita_1[i]);

			}
			System.out.println();

			// Percorrendo a lista e validando o código escolhido pelo usuário

			for (int i = 0; i < Ingredientes_Receita_1.length; i++) {
				do {
					System.out.printf("Código do ingrediente.........: ");

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
					if (Quant_Ingredientes[codigo - 1] != 0) {
						System.out.printf("Esse ingrediente já foi digitado\n");
					}
				} while (Quant_Ingredientes[codigo - 1] != 0);

				// Validando se o código ja foi digitado antes

				System.out.printf("Quantidade de %s.........: ", Ingredientes_Receita_1[codigo - 1]);

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

				System.out.printf("Valor do(a) %s........R$ ", Ingredientes_Receita_1[codigo - 1]);

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

			System.out.printf("Valor de cada embalagem: ");
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
			perc_Lucro = ((Preco_Min_Venda_Pote / Valor_Pote_Unit) - 1) * 100;

			System.out.printf("\n=================== RESULTADO DE SUA PESQUISA =======================\n\n");
			System.out.printf("Valor total da receita sem embalagem.....R$ %.4f\n\n", Valor_Total_Receita_Sem_Embalagem);
			
			System.out.printf("Valor total de 15 embalagens.............R$ %.4f\n\n", Total_Embalagem);
			
			System.out.printf("Valor total da receita com embalagem.....R$ %.4f\n\n", Valor_Total_Receita_Com_Embalagem);
			
			System.out.printf("Valor unitário do Bolo no Pote...........R$ %.2f\n\n", Valor_Pote_Unit);

			System.out.printf("Valor de venda unitário do Bolo no Pote..R$ %.2f\n\n", Preco_Min_Venda_Pote);
			
			System.out.printf("Valor do lucro em .......................R$ %.2f\n\n", Lucro);
			
			System.out.printf("Valor do lucro em percentagem.............: %.2f %%\n\n", perc_Lucro);
			System.out.println("========================================================================\n");

			// Verificando se o valor de custo final do produto está abaixo do solicitado

			if (Valor_Pote_Unit <= Custo_Max_Pote) {
				System.out.printf("======================== RECEITA 1 - APROVADA =======================\n");
			} else {
				System.out.printf("======================= RECEITA 1 - REPROVADA =======================\n");
			}
		}

		if (escolha == 2) {

			String[] Ingredientes_Receita_2 = { "Açucar", "Margarina", "Ovos", "Farinha de Trigo", "Leite Condensado",
					"creme de leite", "chocolate em pó" };
			int[] Quant_Ingredientes2 = new int[7];
			float[] Valor_Ingredientes2 = new float[7];
			float[] Quant_Fixa_Receita_2 = { 300, 300, 4, 300, 300, 300, 100 };
			float[] Valor_Total_Cada_Ingred_Receita_2 = new float[7];
			float Valor_Total_Receita_Sem_Embalagem2 = 0;
			int Qtde_Embalagem2 = 15;
			float Preco_Unit_Embalagem2, Total_Embalagem2 = 0;
			float Valor_Total_Receita_Com_Embalagem2 = 0;
			float Custo_Max_Pote2 = 2;
			float Preco_Min_Venda_Pote2 = 4;
			float Valor_Pote_Unit2 = 0;
			float Lucro2 = 0;
			float perc_Lucro2 = 0;

			System.out.println();
			System.out.printf("OK, você escolheu CHOCOLATE!");
			System.out.println();

			// Gerando a lista de ingredientes da receita 2

			System.out.println("\n----------- Lista de Ingredientes ---------");
			for (int i = 0; i < Ingredientes_Receita_2.length; i++) {
				System.out.printf("%d ) %s\n", i + 1, Ingredientes_Receita_2[i]);

			}
			System.out.println();

			// Percorrendo a lista e validando o código escolhido pelo usuário

			for (int i = 0; i < Ingredientes_Receita_2.length; i++) {
				do {
					System.out.printf("Informe o código de um ingrediente: ");

					codigo = 0;
					do {

						boolean teste1 = false;
						do {
							try {
								codigo = Integer.parseInt(teclado.next());
								teste1 = true;

							} catch (Exception erro1) {
								System.err.println("Código inválido, digite de 1 a 7 > ");
							}

						} while (teste1 == false);

						if (codigo != 1 && codigo != 2 && codigo != 3 && codigo != 4 && codigo != 5 && codigo != 6
								&& codigo != 7) {
							System.err.printf("Ops !!! - Código inválido, Digite de 1 a 7 > ");

						}
					} while (codigo != 1 && codigo != 2 && codigo != 3 && codigo != 4 && codigo != 5 && codigo != 6
							&& codigo != 7);
					if (Quant_Ingredientes2[codigo - 1] != 0) {
						System.out.printf("Esse ingrediente já foi digitado\n");
					}
				} while (Quant_Ingredientes2[codigo - 1] != 0);

				// Validando se o código ja foi digitado antes

				System.out.printf("Informe a quantidade de %s.................> ", Ingredientes_Receita_2[codigo - 1]);

				// Validando a quantidade de ingredientes para que não seja negativa ou maior
				// que 100000

				Quant_Ingredientes2[codigo - 1] = 0;
				do {
					boolean teste2 = false;
					do {
						try {
							Quant_Ingredientes2[codigo - 1] = Integer.parseInt(teclado.next());
							teste2 = true;
						} catch (Exception erro3) {
							System.err.printf("Quantidade inválida, por favor, digite novamente: ");
						}

					} while (teste2 == false);

					if (Quant_Ingredientes2[codigo - 1] <= 0 || Quant_Ingredientes2[i] > 100000) {

						System.err.printf("Quantidade inválida, Por favor, digite quantidade entre 1 a 100000: ");
					}

				} while (Quant_Ingredientes2[i] <= 0 && Quant_Ingredientes2[i] > 100000);

				System.out.printf("Informe o valor do(a) %s........>", Ingredientes_Receita_2[codigo - 1]);

				Valor_Ingredientes2[codigo - 1] = 0;
				do {
					boolean teste3 = false;
					do {
						try {
							Valor_Ingredientes2[codigo - 1] = Float.parseFloat(teclado.next().replace(",", "."));
							teste3 = true;
						} catch (Exception erro3) {
							System.err.printf("Preço inválido, por favor, digite novamente: ");

						}

					} while (teste3 == false);

					if (Valor_Ingredientes2[codigo - 1] <= 0 || Valor_Ingredientes2[codigo - 1] > 100000)

					{
						System.err.printf("Preço inválido, por favor digite novamente um valor entre 1 e 100000: ");
					}

				} while (Valor_Ingredientes2[codigo - 1] <= 0 || Valor_Ingredientes2[codigo - 1] > 100000);

				// Calculando o valor total de cada ingrediente

				Valor_Total_Cada_Ingred_Receita_2[codigo
						- 1] = (Valor_Ingredientes2[codigo - 1] / Quant_Ingredientes2[codigo - 1])
								* Quant_Fixa_Receita_1[codigo - 1];

			}

			// Calculando o valor da embalagem separadamente

			System.out.printf("Informe o valor de cada embalagem: ");
			Preco_Unit_Embalagem2 = teclado.nextFloat();
			Total_Embalagem2 = Qtde_Embalagem2 * Preco_Unit_Embalagem2;

			System.out.println("\n=====================================================================");
			System.out.printf("Valor unitário de cada ingrediente com base nos valores informados:");
			System.out.println("\n=====================================================================");
			for (int i = 0; i < Ingredientes_Receita_2.length; i++) {

				// Imprimindo os totais de cada ingredientes separadamente

				System.out.printf("%.4f > %s\n", Valor_Total_Cada_Ingred_Receita_2[i], Ingredientes_Receita_2[i]);
				Valor_Total_Receita_Sem_Embalagem2 += Valor_Total_Cada_Ingred_Receita_2[i];
			}

			// Calculando o valor total da receita com embalagem
			// Calculando o valor unitário de cada pote de bolo
			// Calculando o lucro em reais e em percentagem

			Valor_Total_Receita_Com_Embalagem2 += Valor_Total_Receita_Sem_Embalagem2 + Total_Embalagem2;
			Valor_Pote_Unit2 = Valor_Total_Receita_Com_Embalagem2 / Qtde_Embalagem2;
			Lucro2 = Preco_Min_Venda_Pote2 - Valor_Pote_Unit2;
			perc_Lucro2 = ((Preco_Min_Venda_Pote2 / Valor_Pote_Unit2) - 1) * 100;

			System.out.printf("\n=================== RESULTADO DE SUA PESQUISA =======================\n");
			System.out.printf("%.4f > Valor total da receita sem embalagem\n", Valor_Total_Receita_Sem_Embalagem2);
			System.out.println("=====================================================================");
			System.out.printf("%.4f > Valor total de 15 embalagens\n", Total_Embalagem2);
			System.out.println("=====================================================================");
			System.out.printf("%.4f > Valor total da receita com embalagem\n", Valor_Total_Receita_Com_Embalagem2);
			System.out.println("=====================================================================");
			System.out.printf("%.2f > Valor unitário do Bolo no Pote\n", Valor_Pote_Unit2);
			System.out.println("=====================================================================");
			System.out.printf("%.2f > Valor mínimo de venda unitário do Bolo no Pote\n", Preco_Min_Venda_Pote2);
			System.out.println("=====================================================================");
			System.out.printf("%.2f > Valor do lucro em R$\n", Lucro2);
			System.out.println("=====================================================================");
			System.out.printf("%.2f %% > Valor do lucro em percentagem\n", perc_Lucro2);
			System.out.println("=====================================================================");

			// Verificando se o valor de custo final do produto está abaixo do solicitado

			if (Valor_Pote_Unit2 <= Custo_Max_Pote2) {
				System.out
						.printf("======================== RECEITA 2 - CHOCOLATE - APROVADA =======================\n");
			} else {
				System.out
						.printf("======================= RECEITA 2 - CHOCOLATE - REPROVADA =======================\n");
			}

		}

		if (escolha == 3) {

			String[] Ingredientes_Receita_3 = { "Açucar", "Margarina", "Ovos", "Farinha de Trigo", "Suco de maracujá",
					"Amido de Milho", "Leite", "Manteiga" };
			int[] Quant_Ingredientes3 = new int[8];
			float[] Valor_Ingredientes3 = new float[8];
			float[] Quant_Fixa_Receita_3 = { 500, 300, 10, 300, 240, 5, 200, 50 };
			float[] Valor_Total_Cada_Ingred_Receita_3 = new float[8];
			float Valor_Total_Receita_Sem_Embalagem3 = 0;
			int Qtde_Embalagem3 = 15;
			float Preco_Unit_Embalagem3, Total_Embalagem3 = 0;
			float Valor_Total_Receita_Com_Embalagem3 = 0;
			float Custo_Max_Pote3 = 2;
			float Preco_Min_Venda_Pote3 = 3.80f;
			float Valor_Pote_Unit3 = 0;
			float Lucro3 = 0;
			float perc_Lucro3 = 0;

			System.out.println();
			System.out.printf("OK, você escolheu MARACUJÁ!");
			System.out.println();

			// Gerando a lista de ingredientes da receita 2

			System.out.println("\n----------- Lista de Ingredientes ---------");
			for (int i = 0; i < Ingredientes_Receita_3.length; i++) {
				System.out.printf("%d ) %s\n", i + 1, Ingredientes_Receita_3[i]);

			}
			System.out.println();

			// Percorrendo a lista e validando o código escolhido pelo usuário

			for (int i = 0; i < Ingredientes_Receita_3.length; i++) {
				do {
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
					if (Quant_Ingredientes3[codigo - 1] != 0) {
						System.out.printf("Esse ingrediente já foi digitado\n");
					}
				} while (Quant_Ingredientes3[codigo - 1] != 0);

				// Validando se o código ja foi digitado antes

				System.out.printf("Informe a quantidade de %s.................> ", Ingredientes_Receita_3[codigo - 1]);

				// Validando a quantidade de ingredientes para que não seja negativa ou maior
				// que 100000

				Quant_Ingredientes3[codigo - 1] = 0;
				do {
					boolean teste2 = false;
					do {
						try {
							Quant_Ingredientes3[codigo - 1] = Integer.parseInt(teclado.next());
							teste2 = true;
						} catch (Exception erro3) {
							System.err.printf("Quantidade inválida, por favor, digite novamente: ");
						}

					} while (teste2 == false);

					if (Quant_Ingredientes3[codigo - 1] <= 0 || Quant_Ingredientes3[i] > 100000) {

						System.err.printf("Quantidade inválida, Por favor, digite quantidade entre 1 a 100000: ");
					}

				} while (Quant_Ingredientes3[i] <= 0 && Quant_Ingredientes3[i] > 100000);

				System.out.printf("Informe o valor do(a) %s........>", Ingredientes_Receita_3[codigo - 1]);

				Valor_Ingredientes3[codigo - 1] = 0;
				do {
					boolean teste3 = false;
					do {
						try {
							Valor_Ingredientes3[codigo - 1] = Float.parseFloat(teclado.next().replace(",", "."));
							teste3 = true;
						} catch (Exception erro3) {
							System.err.printf("Preço inválido, por favor, digite novamente: ");

						}

					} while (teste3 == false);

					if (Valor_Ingredientes3[codigo - 1] <= 0 || Valor_Ingredientes3[codigo - 1] > 100000)

					{
						System.err.printf("Preço inválido, por favor digite novamente um valor entre 1 e 100000: ");
					}

				} while (Valor_Ingredientes3[codigo - 1] <= 0 || Valor_Ingredientes3[codigo - 1] > 100000);

				// Calculando o valor total de cada ingrediente

				Valor_Total_Cada_Ingred_Receita_3[codigo
						- 1] = (Valor_Ingredientes3[codigo - 1] / Quant_Ingredientes3[codigo - 1])
								* Quant_Fixa_Receita_3[codigo - 1];

			}

			// Calculando o valor da embalagem separadamente

			System.out.printf("Informe o valor de cada embalagem: ");
			Preco_Unit_Embalagem3 = teclado.nextFloat();
			Total_Embalagem3 = Qtde_Embalagem3 * Preco_Unit_Embalagem3;

			System.out.println("\n=====================================================================");
			System.out.printf("Valor unitário de cada ingrediente com base nos valores informados:");
			System.out.println("\n=====================================================================");
			for (int i = 0; i < Ingredientes_Receita_3.length; i++) {

				// Imprimindo os totais de cada ingredientes separadamente

				System.out.printf("%.4f > %s\n", Valor_Total_Cada_Ingred_Receita_3[i], Ingredientes_Receita_3[i]);
				Valor_Total_Receita_Sem_Embalagem3 += Valor_Total_Cada_Ingred_Receita_3[i];
			}

			// Calculando o valor total da receita com embalagem
			// Calculando o valor unitário de cada pote de bolo
			// Calculando o lucro em reais e em percentagem

			Valor_Total_Receita_Com_Embalagem3 += Valor_Total_Receita_Sem_Embalagem3 + Total_Embalagem3;
			Valor_Pote_Unit3 = Valor_Total_Receita_Com_Embalagem3 / Qtde_Embalagem3;
			Lucro3 = Preco_Min_Venda_Pote3 - Valor_Pote_Unit3;
			perc_Lucro3 = ((Preco_Min_Venda_Pote3 /Valor_Pote_Unit3)-1 ) * 100;

			System.out.printf("\n=================== RESULTADO DE SUA PESQUISA =======================\n");
			System.out.printf("%.4f > Valor total da receita sem embalagem\n", Valor_Total_Receita_Sem_Embalagem3);
			System.out.println("=====================================================================");
			System.out.printf("%.4f > Valor total de 15 embalagens\n", Total_Embalagem3);
			System.out.println("=====================================================================");
			System.out.printf("%.4f > Valor total da receita com embalagem\n", Valor_Total_Receita_Com_Embalagem3);
			System.out.println("=====================================================================");
			System.out.printf("%.2f > Valor unitário do Bolo no Pote\n", Valor_Pote_Unit3);
			System.out.println("=====================================================================");
			System.out.printf("%.2f > Valor mínimo de venda unitário do Bolo no Pote\n", Preco_Min_Venda_Pote3);
			System.out.println("=====================================================================");
			System.out.printf("%.2f > Valor do lucro em R$\n", Lucro3);
			System.out.println("=====================================================================");
			System.out.printf("%.2f %% > Valor do lucro em percentagem\n", perc_Lucro3);
			System.out.println("=====================================================================");

			// Verificando se o valor de custo final do produto está abaixo do solicitado

			if (Valor_Pote_Unit3 <= Custo_Max_Pote3) {
				System.out.printf("======================== RECEITA 3 - MARACUJÁ - APROVADA =======================\n");
			} else {
				System.out.printf("======================= RECEITA 3 - MARACUJÁ - REPROVADA =======================\n");
			}
		}
		teclado.close();
	}

}
