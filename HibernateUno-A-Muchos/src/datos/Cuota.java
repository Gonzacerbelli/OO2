package datos;

import java.util.GregorianCalendar;

import funciones.Fecha;

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

	public Cuota(int nroCuota, GregorianCalendar fechaVencimiento, double saldoPendiente, double amortizacion,
			double interesCuota, double cuota, double deuda, boolean cancelada, GregorianCalendar fechaDePago,
			double punitorios) {
		this.nroCuota = nroCuota;
		this.fechaVencimiento = fechaVencimiento;
		this.saldoPendiente = saldoPendiente;
		this.amortizacion = amortizacion;
		this.interesCuota = interesCuota;
		this.cuota = cuota;
		this.deuda = deuda;
		this.cancelada = cancelada;
		this.fechaDePago = fechaDePago;
		this.punitorios = punitorios;
	}

	protected int getIdCuota() {
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

	public double calcularAmortizacion() {
		return (this.getSaldoPendiente() * prestamo.getInteres()) / (Math.pow(1 + prestamo.getInteres(), prestamo.getCantCuotas() - this.nroCuota - 1) - 1);
	}
	
	public double calcularInteresCuota() {
		return this.getSaldoPendiente() * prestamo.getInteres();
	}
	
	public double calcularValorCuota() {
		return this.calcularAmortizacion() + this.calcularInteresCuota();
	}
	
	public double calcularSaldoPendiente() {
		return this.getSaldoPendiente() - this.calcularAmortizacion();
	}

}
