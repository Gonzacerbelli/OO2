package funciones;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Fecha {
	
	public static int traerAnio(GregorianCalendar f) {
		return f.get(Calendar.YEAR);
	}
	
	public static int traerMes(GregorianCalendar f) {
		return f.get(Calendar.MONTH);
	}
	
	public static int traerDia(GregorianCalendar f) {
		return f.get(Calendar.DAY_OF_MONTH);
	}
	
	public static String traerFechaCorta(GregorianCalendar f) {
		String fechaCorta = "";
		fechaCorta = fechaCorta + Fecha.formatearFecha(Fecha.traerDia(f)) + '/' + Fecha.formatearFecha(Fecha.traerMes(f)) + '/' + Fecha.traerAnio(f);
		return fechaCorta;
	}
	
	private static String formatearFecha(int numero) {
		String resultado = "";
		if(numero < 10) {
			resultado = "0"+numero;
		}
		return resultado;
	}
	
	public static boolean esBisiesto(int anio) {
		boolean bisiesto = false;
		
		if(anio%4==0 && (anio%100!=0 || anio%400==0)) {
			bisiesto = true;
		}
		return bisiesto;
	}
	
	public static boolean esFechaValida(int anio, int mes, int dia) {
		boolean valida = false;
		
		if(anio > 0) {
			switch(mes) {
				case 1: case 3: case 5: case 7: case 8: case 10: case 12:
					if(dia<=31 && dia>0) {
						valida = true;
					}
				break;
				case 4: case 6: case 9: case 11:
					if(dia<=30 && dia>0) {
						valida = true;
					}
				break;
				case 2:
					if(Fecha.esBisiesto(anio)) {
						if(dia<=29 && dia>0) {
							valida = true;
						}
					}else if(dia<=28 && dia>0) {
						valida = true;
					}
				break;
			}
		}
		return valida;
	}
	
	public static GregorianCalendar traerFecha(int anio, int mes, int dia) {
		
		GregorianCalendar fecha = new GregorianCalendar(anio,(mes-1),dia);
		
		return fecha;
		
	}
	
	public static GregorianCalendar traerFecha(String fecha) {
		String dia, mes, anio;
		int dia2, mes2, anio2;
		
		dia = String.valueOf(fecha.charAt(0))+String.valueOf(fecha.charAt(1));
		mes = String.valueOf(fecha.charAt(3))+String.valueOf(fecha.charAt(4));
		anio = String.valueOf(fecha.charAt(6))+String.valueOf(fecha.charAt(7))+String.valueOf(fecha.charAt(8))+String.valueOf(fecha.charAt(9));
		dia2 = Integer.valueOf(dia);
		mes2 = Integer.valueOf(mes);
		anio2 = Integer.valueOf(anio);
		
		GregorianCalendar fecha2;
		fecha2 = Fecha.traerFecha(anio2, mes2, dia2);
		
		return fecha2;
	}
	
	public static String traerFechaCortaHora(GregorianCalendar fecha) {
		String fechaCorta;
		
		fechaCorta = Fecha.traerFechaCorta(fecha);
		fechaCorta = fechaCorta +" "+fecha.get(Calendar.HOUR_OF_DAY)+":"+fecha.get(Calendar.MINUTE)+":"+fecha.get(Calendar.SECOND);
		
		return fechaCorta;
	}
	
	public static GregorianCalendar traerFechaProximo(GregorianCalendar fecha, int cantDias) {
		fecha.add(Calendar.DAY_OF_MONTH, cantDias);
		return fecha;
	}
	
	public static boolean esDiaHabil(GregorianCalendar fecha) {
		boolean habil = false;
		int n = fecha.get(Calendar.DAY_OF_WEEK);
		if(n==2 || n==3 || n==4 || n==5 || n==6) {
			habil = true;
		}
		return habil;
	}
	
	public static String traerDiaDeLaSemana(GregorianCalendar fecha) {
		String dia = "";
		int n = fecha.get(Calendar.DAY_OF_WEEK);
		
		switch(n) {
			case 1: dia = "Domingo";
			break;
			case 2: dia = "Lunes";
			break;
			case 3: dia = "Martes";
			break;
			case 4: dia = "Miércoles";
			break;
			case 5: dia = "Jueves";
			break;
			case 6: dia = "Viernes";
			break;
			case 7: dia = "Sábado";
			break;
		}
		return dia;
	}
	
	public static String traerMesEnLetras(GregorianCalendar fecha) {
		String mes = "";
		int n = traerMes(fecha);
		
		switch(n) {
			case 1: mes = "Enero";
			break;
			case 2: mes = "Febrero";
			break;
			case 3: mes = "Marzo";
			break;
			case 4: mes = "Abril";
			break;
			case 5: mes = "Mayo";
			break;
			case 6: mes = "Junio";
			break;
			case 7: mes = "Julio";
			break;
			case 8: mes = "Agosto";
			break;
			case 9: mes = "Septiembre";
			break;
			case 10: mes = "Octubre";
			break;
			case 11: mes = "Noviembre";
			break;
			case 12: mes = "Diciembre";
			break;
		}
		return mes;
	}
	
	public static String traerFechaLarga(GregorianCalendar fecha) {
		String fechaLarga = "";
		fechaLarga = traerDiaDeLaSemana(fecha) + " " + traerDia(fecha) + " de " + traerMesEnLetras(fecha) + " de " + traerAnio(fecha);
		return fechaLarga;
	}
	
	public static boolean sonFechasIguales(GregorianCalendar fecha, GregorianCalendar fecha1) {
		if(traerFechaCorta(fecha).equals(traerFechaCorta(fecha1))) {
			return true;
		}
		return false;
	}
	
	public static boolean sonFechasHorasIguales(GregorianCalendar fecha, GregorianCalendar fecha1) {
		if(sonFechasIguales(fecha,fecha1) && fecha.get(Calendar.HOUR_OF_DAY)==fecha1.get(Calendar.HOUR_OF_DAY) && fecha.get(Calendar.MINUTE)==fecha1.get(Calendar.MINUTE) && fecha.get(Calendar.SECOND)==fecha1.get(Calendar.SECOND) && fecha.get(Calendar.MILLISECOND)==fecha1.get(Calendar.MILLISECOND)) {
			return true;
		}
		return false;
	}
	
	public static int traerCantDiasDeUnMes(int anio, int mes) {
		int cant = 0;
		switch(mes) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				cant = 31;
			break;
			case 4:
			case 6:
			case 9:
			case 11:
				cant = 30;
			break;
			case 2:
				if(esBisiesto(anio)) {
					cant = 29;
				}else {
					cant = 28;
				}
			break;
		}
		return cant;
	}
}