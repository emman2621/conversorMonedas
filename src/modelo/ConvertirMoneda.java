package modelo;

import com.google.gson.JsonObject;

public class ConvertirMoneda {
    private ConsultaMoneda consultaMoneda;


    public ConvertirMoneda(ConsultaMoneda consultaMoneda) {
        this.consultaMoneda = consultaMoneda;
    }



    public double covertirMoneda(String moneda, String monedaConvertir, double monto) throws Exception{
        JsonObject tarifas = consultaMoneda.buscarMoneda(moneda);

        if (!tarifas.has(monedaConvertir)) {
            throw new IllegalArgumentException("Moneda destino no soportada: " + monedaConvertir);
        }

        double tarifa = tarifas.get(monedaConvertir).getAsDouble();
        return monto*tarifa;
    }


}
