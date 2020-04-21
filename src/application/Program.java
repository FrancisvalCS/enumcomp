package application;
import java.util.Scanner;
import java.util.Locale;
import entities.*;
import entities.enums.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Program {

	public static void main(String[] args) throws ParseException{
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Entre com o nome do departamento:");
		String departmentName = sc.nextLine();
		
		System.out.print("Entre com os dados do trabalhador: ");
		System.out.print("Nome: ");
		String workerName = sc.nextLine();
		System.out.print("Nível: ");
		String workerLevel = sc.nextLine();
		System.out.print("Salário Base: ");
		double baseSalary = sc.nextDouble();
		
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));
		
		System.out.println("Quantos contratos terá o trabalhador? ");
		int n = sc.nextInt();
		for(int i=1; i<=n;i++ ) {
			System.out.println("Infomre os dados do contrato #"+i);
			System.out.println("Data (DD/MM/YYYY): ");
			Date contractDate = sdf.parse(sc.next());
			System.out.println("Valor por hora: ");
			double valuePerHour = sc.nextDouble();
			System.out.println("Duração (horas): ");
			int hours = sc.nextInt();
			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			worker.addContract(contract);
		}
		System.out.println();
		System.out.print("Informe o mês e o ano para calcular a renda (MM/YYYY):");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0,2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		System.out.println("Nome: "+ worker.getName());
		System.out.println("Departamento: "+ worker.getDepartment().getName());
		System.out.println("Renda para: "+ monthAndYear +" : "+String.format("%.2f",worker.income(year, month)));
		
		sc.close();

	}

}
