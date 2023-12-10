package modelo;

public class InfoPago {
	
	
	private double monto;
	private String numCuenta;
	private int numTransaccion;
	
	
	public InfoPago(double monto, String numCuenta, int numTransaccion) {
		super();
		this.monto = monto;
		this.numCuenta = numCuenta;
		this.numTransaccion = numTransaccion;
	}


	public double getMonto() {
		return monto;
	}


	public void setMonto(double monto) {
		this.monto = monto;
	}


	public String getNumCuenta() {
		return numCuenta;
	}


	public void setNumCuenta(String numCuenta) {
		this.numCuenta = numCuenta;
	}


	public int getNumTransaccion() {
		return numTransaccion;
	}


	public void setNumTransaccion(int numTransaccion) {
		this.numTransaccion = numTransaccion;
	}
	
	
	
	
	
	
	

}
