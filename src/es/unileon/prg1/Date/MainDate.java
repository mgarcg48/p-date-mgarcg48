package es.unileon.prg1.Date;

public class MainDate{

	public static void main(String args[]){
		Date fecha = new Date(27, 03, 2017);	
		System.out.println("marco");
		System.out.println(fecha.toString());
		System.out.println(fecha.getDaysLeftOfMonth());
		System.out.println(fecha.getMonthsSameDays());
		System.out.println(fecha.daysPast());
	}

}
