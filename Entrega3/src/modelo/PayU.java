package modelo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PayU implements PasarelaPago{



	@Override
	public ResultadoBloqueo bloquearCupo(DatosPago informacionTarjeta, double monto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void registrarTransaccion(Transaccion transaccion) throws IOException {
		
		String nombreArchivo = "./Data/PayU";
		registrarEnArchivo(nombreArchivo,transaccion);

	}

	@Override
	public ResultadoPago realizarPago(DatosPago informacionTarjeta, InfoPago informacion) {
		// TODO Auto-generated method stub
		return null;
	}

	

	
	public void registrarEnArchivo(String nombre, Transaccion transaccion) throws IOException
	{
		
		ResultadoPago resultadoPago = transaccion.getResultadoPago(); 
		String resultado = resultadoPago.getMensaje();
		InfoPago datos = transaccion.getInformacion();
		double monto = datos.getMonto();
		String numCuenta = datos.getNumCuenta();
		int numTran = datos.getNumTransaccion();
		DatosPago datosP = transaccion.getTarjeta();
		String num = datosP.getNumero();
		String nombreT = datosP.getNombreTitular();
		
		String nuevaLinea = "\n"+"Resultado: "+resultado+";"+" Datos de transaccion: "+monto+","+numCuenta+","+numTran+";"+" Informacion de pago: "+num+","+nombreT;
		
			
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(nombre, true));
		bufferedWriter.write(nuevaLinea);
		bufferedWriter.newLine();
		bufferedWriter.flush();
		bufferedWriter.close();
			
		
	}


	@Override
	public String darNombre() {
		// TODO Auto-generated method stub
		return "PayU";
	}

}
