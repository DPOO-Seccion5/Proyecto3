package modelo;

import java.io.IOException;

public interface PasarelaPago {
	
	 String darNombre();
	 ResultadoPago realizarPago(DatosPago informacionTarjeta, InfoPago informacion);
	 ResultadoBloqueo bloquearCupo(DatosPago informacionTarjeta, double monto);
	 void registrarTransaccion(Transaccion transaccion) throws IOException;

}
