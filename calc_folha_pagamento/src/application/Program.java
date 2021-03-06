package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner in = new Scanner(System.in);
		/*
		 * Fa?a um programa para o c?lculo de uma folha de pagamento, sabendo que os
		 * descontos s?o do Imposto de Renda, que depende do sal?rio bruto (conforme
		 * tabela abaixo) e 3% para o Sindicato e que o FGTS corresponde a 11% do
		 * Sal?rio Bruto, mas n?o ? descontado (? a empresa que deposita). O Sal?rio
		 * L?quido corresponde ao Sal?rio Bruto menos os descontos. O programa dever?
		 * pedir ao usu?rio o valor da sua hora e a quantidade de horas trabalhadas no
		 * m?s. Desconto do IR:
		 * 
		 * Sal?rio Bruto at? 900 (inclusive) - isento 
		 * Sal?rio Bruto at? 1500 (inclusive)- desconto de 5% 
		 * Sal?rio Bruto at? 2500 (inclusive) - desconto de 10% 
		 * Sal?rio Bruto acima de 2500 - desconto de 20%
		 */
		
		double salarioLiquido = 0.0;
		double totalDesconto = 0.0;
		double inss = 0.0;
		double ir = 0.0;
		double fgts = 0.0;
		double salarioBruto = 0.0;
		double valorHora = 0.0;
		int qtidadeHora = 0;
		
		System.out.println();
		System.out.println(
				"<<-----------------------Programa para c?culo de folha de pagamento----------------------->>");
		System.out.println();

		System.out.print("Digite o valor da hora trabalha no m?s: ");
		valorHora = in.nextDouble();
		System.out.print("Digite a quantidade de horas trabalhadas por m?s: ");
		qtidadeHora = in.nextInt();

		salarioBruto = valorHora * qtidadeHora;
		System.out.println();
		System.out.printf("Sal?rio bruto : R$ %.2f%n", salarioBruto);

		if (salarioBruto < 900) {
			System.out.println("Isento de impostos.");
		} else if (salarioBruto <= 1500) {
			System.out.println("Voc? ter? um desconto de 5% do IR.");
			inss = salarioBruto * 10 / 100;
			fgts = salarioBruto * 11 / 100;
			ir = salarioBruto * 5 / 100;
			totalDesconto = ir + inss;
			salarioLiquido = salarioBruto - totalDesconto;
			salarioBruto -= ir;

		} else if (salarioBruto <= 2500) {
			System.out.println("Voc? ter? um desconto de 10% do IR.");
			inss = salarioBruto * 10 / 100;
			fgts = salarioBruto * 11 / 100;
			ir = salarioBruto * 10 / 100;
			totalDesconto = ir + inss;
			salarioLiquido = salarioBruto - totalDesconto;
			salarioBruto -= ir;
		} else {
			System.out.println("Voc? ter? um desconto de 20% do IR.");
			inss = salarioBruto * 10 / 100;
			fgts = salarioBruto * 11 / 100;
			ir = salarioBruto * 20 / 100;
			totalDesconto = ir + inss;
			salarioLiquido = salarioBruto - totalDesconto;
			salarioBruto -= ir;
		}

		System.out.println();
		System.out.println("(-) IR (-)");
		System.out.printf("R$ %.2f%n", ir);
		System.out.println();
		System.out.println("(-) INSS (10%)");
		System.out.printf("R$ %.2f%n", inss);
		System.out.println();
		System.out.println("(-) FGTS (10%)");
		System.out.printf("R$ %.2f%n", fgts);
		System.out.println();
		System.out.println("Total de descontos ");
		System.out.printf("R$ %.2f%n", totalDesconto);
		System.out.println();
		System.out.println("Sal?rio L?quido ");
		System.out.println(salarioLiquido);

		in.close();
	}

}
