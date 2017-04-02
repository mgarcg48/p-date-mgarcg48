package es.unileon.prg1.Date;

public class Date{
	private int year;
	private int month;
	private int day;

	public Date(){
		this.day=1;
		this.month=1;
		this.year=1990;
	}
	public Date(int day, int month, int year){
		this.day=day;
		this.month=month;
		this.year=year;
	}
	public Date(Date another){
		this.day = another.getDay();
		this.month = another.getMonth();
		this.year = another.getYear();
	}
	public int getDay(){
		return this.day;
	}
	public int getMonth(){
		return this.month;
	}
	public int getYear(){
		return this.year;
	}
	public void setDay(int day){
		this.day = day;
	}
	public void setMonth(int month){
		this.month = month;
	}
	public void setYear(int year){
		this.year = year;
	}
	//metodos isSame con IF
	public boolean isSameYear(Date other){
		if(this.year==other.getYear()){
			return true;
		}else{
			return false;
		}
	}
	public boolean isSameMonth(Date other){
		if(this.month==other.getMonth()){
			return true;
		}else{
			return false;
		}
	}
	public boolean isSameDay(Date other){
		if(this.day==other.getDay()){
			return true;
		}else{
			return false;
		}
	}
	public boolean isSame(Date other){
		return this.isSameDay(other) && this.isSameMonth(other) && this.isSameYear(other);
	}
	
	//metodos isSame sin IF
	public boolean isSameYear1(Date other){
		return this.year == other.getYear();
	}
	public boolean isSameMonth1(Date other){
		return this.month == other.getMonth();
	}
	public boolean isSameDay1(Date other){
		return this.day == other.getDay	();
	}
	//switch
	String getMonthName(int month){
		StringBuffer monthname= new StringBuffer();
		switch (month){
		case 1 :
			monthname.append("Enero");
			break;
		case 2 :
			monthname.append("Febrero");
			break;
		case 3 :
			monthname.append("Marzo");
			break;
		case 4 :
			monthname.append("Abril");
			break;
		case 5 :
			monthname.append("Mayo");
			break;
		case 6 :
			monthname.append("Junio");
			break;
		case 7 :
			monthname.append("Julio");
			break;
		case 8 :
			monthname.append("Agosto");
			break;
		case 9 :
			monthname.append("Septiembre");
			break;
		case 10 :
			monthname.append("Octubre");
			break;
		case 11 :
			monthname.append("Noviembre");
			break;
		case 12 :
			monthname.append("Diciembre");
			break;
		}
		return monthname.toString();
	}
	public String getSeasonName(){
		String name = null;
		switch (this.month){
		case 1:
		case 2: 
		case 3: 
			name = "Invierno";
			break;
		case 4: 
		case 5: 
		case 6:
			name = "Primavera";
			break;
		case 7: // next
		case 8: // next
		case 9:
			name = "Verano";
			break;
		case 10:
		case 11:
		case 12:
			name = "Otoño";
			break;
		}
		return name;
	}
	//tres metodos para saber si el dia del mes es correcto
	//asigna a cada mes un numero de dias, no importan los años bisiestos
	private int daysOfMonth(int month){
		int number = 0;
		switch (month){
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			number = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11: 
			number = 30;
			break;
		case 2:
			number = 28;
			break;
		default:
			number = -1;
		}
		return number;
	}
	//devuelve el numero de dias de un mes
	public int daysOfMonth(){
		return this.daysOfMonth(this.month);
	}
	//comprueba si los dias del mes son correctos
	private boolean isDayRight(int day){
		return ( ( day > 0 ) && (day <= this.daysOfMonth(this.month) ) );
	}
	//meses hasta el final del año
	public String monthsLeft(){
		Date m = new Date(this);
		StringBuffer monthsLeft = new StringBuffer();
		for (int i = this.month; i<=12; i++){
			m.setMonth(i);
			monthsLeft.append(m.getMonthName(i) + " ");
		}
		return monthsLeft.toString();
	}
	//imprime fechas
	public String toString(){
		return this.day + "/" + this.month + "/" + this.year;
	}
	//mañana
	public Date tomorrow(){
		Date tomorrow = null;
		int d, m, y;
				
		d = this.day;
		m = this.month;
		y = this.year;
		
		d++;
		if ( d > this.daysOfMonth(month) ) {
			d = 1;
			m++;
			if ( m > 12 ) {
				m = 1;
				y++;
			}	
		}
		tomorrow = new Date(d, m, y);
		return tomorrow;
	}
	//fechas hasta el final del mes
	public String getDaysLeftOfMonth(){
		Date m = tomorrow();
		StringBuffer daysLeft = new StringBuffer();
		for (int i = m.getDay(); isDayRight(i); i++) {
			m.setDay(i);
			daysLeft.append(m.toString() + " ");
		}
		return daysLeft.toString();
	}
	//meses con el mismo numero de dias que el mes seleccionado
	public String getMonthsSameDays(){
		Date m = new Date(this);
		StringBuffer months = new StringBuffer();
		for ( int i = 1; i <= 12; i++) {
			m.setMonth(i);
			if ( m.daysOfMonth() == this.daysOfMonth() ) {
				months.append(m.getMonthName(i) + " ");
			}
		}
		return months.toString();
	}
	//dias en lo que va de año
	public int daysPast(){
		int dias=0;
		Date m = new Date(1,1,this.year);
		for ( int i = 1; i < this.month; i++ ) {
			dias += m.daysOfMonth();
			m.setMonth(i + 1);
		}
		return dias + this.day;
	}
	//acertar fecha aleatoria
	public int numRandomTriesEqualDate(){
        	int tries, d, m, y;
        	tries = 0;
        	do{
        		m = (int) (Math.random()*12) + 1;
        		d = (int) (Math.random()*this.daysOfMonth(m) ) + 1;
        		y = this.year;
        		tries++;
        	} while ( !this.isSame(new Date(d,m,y) ) );
        	return tries;
  	}
	//nombre del dia
	private String nameOfDay(int day) {
		String dayName;
		switch (day) {
		case 1: 
			dayName = "Lunes";
			break;
		case 2: 
			dayName = "Martes";
			break;
		case 3: 
			dayName = "Miércoles";
			break;
		case 4: 
			dayName = "Jueves";
			break;
		case 5: 
			dayName = "Viernes";
			break;
		case 6: 
			dayName = "Sábado";
			break;
		case 7: 
			dayName = "Domingo";
			break;
		default:
			dayName = "ERROR";
		}
		return dayName;
	}
	public String dayOfWeek(int firstOfJanuary){
		int dayNumber;
		dayNumber = ( daysPast() % 7 + firstOfJanuary ) % 7;
		return nameOfDay(dayNumber);
	}
}
