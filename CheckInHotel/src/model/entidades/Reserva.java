package model.entidades;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;


public class Reserva {
	
	private int numeroDoQuarto;
	private Date checkIn;
	private Date checkOut;
	
	public static SimpleDateFormat dataf = new SimpleDateFormat("dd/MM/YYYY");
	
	public Reserva(int numeroDoQuarto, Date checkIn, Date checkOut) throws DomainException {	
		if(!checkOut.after(checkIn)) {
			throw new DomainException("Erro na reserva: a data de check-out deve "
					+ "ser posterior � data de check-in ");
		}
		this.numeroDoQuarto = numeroDoQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public int getNumeroDoQuarto() {
		return numeroDoQuarto;
	}

	public void setNumeroDoQuarto(int numeroDoQuarto) {
		this.numeroDoQuarto = numeroDoQuarto;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	

	public Date getChaeckOut() {
		return checkOut;
	}
	
	public long duracao() {
		long dif = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS);
	}
	
	public void updateDatas(Date checkIn, Date checkOut) throws DomainException {
		Date now = new Date();
		if(checkIn.before(now) || checkOut.before(now)) {
			throw new DomainException("Erro na reserva: As datas de reserva para atutaliza��o"
					+ " devem ser datas futuras.");
			}
		
		if(!checkOut.after(checkIn)) {
			throw new DomainException("Erro na reserva: a data de check-out deve "
					+ "ser posterior � data de check-in ");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		
		
	}
		
	
	@Override
	public String toString() {
		return " Quarto N� " + numeroDoQuarto + ", Data do Check-In " + dataf.format(checkIn) + 
				", Data do Check-Out " + dataf.format(checkOut) + ", " + duracao() + " noites";
		
	}

	
	
	
	
	

}
