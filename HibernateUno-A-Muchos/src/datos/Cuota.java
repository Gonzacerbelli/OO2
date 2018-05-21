package datos;

import java.util.GregorianCalendar;

public class Cuota {

	private int idCuota;
	private int nroCuota;
	private GregorianCalendar fechaVencimiento;
	private double saldoPendiente;
	private double amortizacion;
	private double interesCuota;
	private double cuota;
	private double deuda;
	private boolean cancelada;
	private GregorianCalendar fechaDePago;
	private double punitorios;
	private Prestamo prestamo;
	
	public Cuota() {};

	public Cuota(int nroCuota, Prestamo prestamo) {
		
		this.nroCuota = nroCuota;
		this.prestamo = prestamo;
		this.fechaVencimiento = new GregorianCalendar();
		this.saldoPendiente = calcularSaldoPendiente();
		this.amortizacion = calcularAmortizacion();
		this.interesCuota = calcularInteresCuota();
		this.cuota = calcularValorCuota();
		this.deuda = calcularDeudaPendiente();
		this.cancelada = false;
		this.fechaDePago = null;
		this.punitorios = 0;
	}

	public int getIdCuota() {
		return this.idCuota;
	}

	protected void setIdCuota(int idCuota) {
		this.idCuota = idCuota;
	}

	public int getNroCuota() {
		return nroCuota;
	}

	public void setNroCuota(int nroCuota) {
		this.nroCuota = nroCuota;
	}

	public GregorianCalendar getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(GregorianCalendar fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public double getSaldoPendiente() {
		return saldoPendiente;
	}

	public void setSaldoPendiente(double saldoPendiente) {
		this.saldoPendiente = saldoPendiente;
	}

	public double getAmortizacion() {
		return amortizacion;
	}

	public void setAmortizacion(double amortizacion) {
		this.amortizacion = amortizacion;
	}

	public double getInteresCuota() {
		return interesCuota;
	}

	public void setInteresCuota(double interesCuota) {
		this.interesCuota = interesCuota;
	}

	public double getCuota() {
		return cuota;
	}

	public void setCuota(double cuota) {
		this.cuota = cuota;
	}

	public double getDeuda() {
		return deuda;
	}

	public void setDeuda(double deuda) {
		this.deuda = deuda;
	}

	public boolean isCancelada() {
		return cancelada;
	}

	public void setCancelada(boolean cancelada) {
		this.cancelada = cancelada;
	}

	public GregorianCalendar getFechaDePago() {
		return fechaDePago;
	}

	public void setFechaDePago(GregorianCalendar fechaDePago) {
		this.fechaDePago = fechaDePago;
	}

	public double getPunitorios() {
		return punitorios;
	}

	public void setPunitorios(double punitorios) {
		this.punitorios = punitorios;
	}

	public Prestamo getPrestamo() {
		return prestamo;
	}

	public void setPrestamo(Prestamo prestamo) {
		this.prestamo = prestamo;
	}

	public double calcularAmortizacion() {
		double amortizacion = 0;
		
		if(this.getNroCuota() == 1) {
			amortizacion = (this.getSaldoPendiente() * this.prestamo.getInteres()) / (Math.pow(1 + this.prestamo.getInteres(), this.nroCuota) - 1);
		}else {
			amortizacion = (this.getSaldoPendiente() * this.prestamo.getInteres()) / (Math.pow(1 + this.prestamo.getInteres(), this.nroCuota - 1) - 1);
		}
		System.out.println("\n\nAmortizacion:"+amortizacion+"\n\n");
		return amortizacion;
	}
	
	public double calcularInteresCuota() {
		System.out.println("\n\nInteres cuota:"+this.getSaldoPendiente() * prestamo.getInteres()+"\n\n");
		return this.getSaldoPendiente() * prestamo.getInteres();
	}
	
	public double calcularValorCuota() {
		System.out.println("\n\nValor cuota:"+this.getAmortizacion() + this.getInteresCuota()+"\n\n");
		return this.getAmortizacion() + this.getInteresCuota();
	}
	
	public double calcularDeudaPendiente() {
		this.setSaldoPendiente(calcularSaldoPendiente());
		System.out.println("\n\nDeuda pendiente:"+this.getSaldoPendiente()-this.getAmortizacion()+"\n\n");
		return this.getSaldoPendiente()-this.getAmortizacion();
	}
	
	public double calcularSaldoPendiente() {
		double saldoPendiente = this.getSaldoPendiente();

		if(this.getNroCuota() == 1) {
			if(saldoPendiente == 0) {
				saldoPendiente = this.prestamo.getMonto();
			}else {
				saldoPendiente = saldoPendiente-this.getAmortizacion();
			}
		}else {
			saldoPendiente = this.getSaldoPendiente();
		}
		System.out.println("\n\nSaldo Pendiente:"+saldoPendiente+"\n\n");
		return saldoPendiente;
	}

}
