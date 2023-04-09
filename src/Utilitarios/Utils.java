package Utilitarios;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Utils {

	static NumberFormat formatandoValoreres = new DecimalFormat("R$ #,###0.00");
	
	public static  String doubleParaString(double valor) {
		return formatandoValoreres.format(valor);
	}
}
