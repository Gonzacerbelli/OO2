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
		if(this.nroCuota == 1) {
			amortizacion = (this.getSaldoPendiente() * this.getPrestamo().getInteres()) / (Math.pow((1 + this.getPrestamo().getInteres()), this.getPrestamo().getCantCuotas()) - 1);
		}else {
			amortizacion = (this.getSaldoPendiente() * this.getPrestamo().getInteres()) / (Math.pow((1 + this.getPrestamo().getInteres()), this.getPrestamo().getCantCuotas() - 1 ) - 1);
		}
		return amortizacion;
	}
	
	public double calcularInteresCuota() {
		return this.getSaldoPendiente()*this.getPrestamo().getInteres();
	}
	
	public double calcularValorCuota() {
		return this.getAmortizacion()+this.getInteresCuota();
	}
	
	public double calcularDeudaPendiente() {
		return this.getSaldoPendiente()-this.getAmortizacion();
	}
	
	public double calcularSaldoPendiente() {
		double saldoPendiente = 0;
		if(this.nroCuota == 1) {
			saldoPendiente = this.getPrestamo().getMonto();
		}else {
			saldoPendiente = this.prestamo.getMonto() - this.getAmortizacion();
		}
		return saldoPendiente;
	}

}
