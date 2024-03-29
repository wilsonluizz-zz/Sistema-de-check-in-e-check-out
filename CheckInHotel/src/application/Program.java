package application;

	import java.text.ParseException;
	import java.text.SimpleDateFormat;
	import java.util.Date;
	import java.util.Scanner;

import model.entidades.Reserva;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat dataF = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Digite o n�mero do quarto: ");
			int numeroquarto = sc.nextInt();
			System.out.print("Digite a data do check-in (dd/MM/yyy) ");
			Date checkin = dataF.parse(sc.next());
			System.out.print("Digite a data do check-out (dd/MM/yyy) ");
			Date checkout = dataF.parse(sc.next());
			
			Reserva reserva = new Reserva(numeroquarto, checkin, checkout);
			System.out.println("DADOS DA SUA RESERVA: " + reserva);
			
			System.out.println();
			System.out.println("Entre com o dados para atualizar a reserva:");
			
			System.out.print("Digite a data do check-in (dd/MM/yyy) ");
			checkin = dataF.parse(sc.next());
			System.out.print("Digite a data do check-out (dd/MM/yyy) ");
			checkout = dataF.parse(sc.next());
			
			reserva.updateDatas(checkin, checkout);
			System.out.println("DADOS DA SUA RESERVA: " + reserva);
		
		}
		catch(ParseException erro) {
			System.out.println("Formato de data inv�lido");
		}
		catch(DomainException e) {
			System.out.println(e	.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Erro inesperado.");
		}

	
		
		sc.close();

	}

}
