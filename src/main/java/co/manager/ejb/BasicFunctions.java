package co.manager.ejb;

import javax.ejb.Stateless;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jguisao
 */
@Stateless
public class BasicFunctions {
    private static final Logger CONSOLE = Logger.getLogger(BasicFunctions.class.getSimpleName());

    public int getDigitoDian(String nitParam) {
        if (nitParam == null || (nitParam.trim()).isEmpty()) {
            CONSOLE.log(Level.WARNING, "La cadena del NIT es nula o vacía.");
            return 0;
        }

        nitParam = nitParam.trim();
        int indiceRaya = nitParam.indexOf("-");
        String nitInterno = indiceRaya > 0 ? nitParam.substring(0, indiceRaya) : nitParam;

        try {
            long longValidacion = Long.parseLong(nitInterno);
        } catch (Exception ex) {
            CONSOLE.log(Level.SEVERE, "El nit contiene caracteres no numéricos. Valor recibido: " + nitParam, ex);
            return 0;
        }

        String nitVector[] = nitInterno.split("(?<=.)");
        int valorCalculado = 0;
        int aux = nitVector.length - 1;

        for (int i = 0; i < nitVector.length; i++) {
            switch (i) {
                case 0:
                    valorCalculado += 3 * Integer.parseInt(nitVector[aux - 0]);
                    break;
                case 1:
                    valorCalculado += 7 * Integer.parseInt(nitVector[aux - 1]);
                    break;
                case 2:
                    valorCalculado += 13 * Integer.parseInt(nitVector[aux - 2]);
                    break;
                case 3:
                    valorCalculado += 17 * Integer.parseInt(nitVector[aux - 3]);
                    break;
                case 4:
                    valorCalculado += 19 * Integer.parseInt(nitVector[aux - 4]);
                    break;
                case 5:
                    valorCalculado += 23 * Integer.parseInt(nitVector[aux - 5]);
                    break;
                case 6:
                    valorCalculado += 29 * Integer.parseInt(nitVector[aux - 6]);
                    break;
                case 7:
                    valorCalculado += 37 * Integer.parseInt(nitVector[aux - 7]);
                    break;
                case 8:
                    valorCalculado += 41 * Integer.parseInt(nitVector[aux - 8]);
                    break;
                case 9:
                    valorCalculado += 43 * Integer.parseInt(nitVector[aux - 9]);
                    break;
                case 10:
                    valorCalculado += 47 * Integer.parseInt(nitVector[aux - 10]);
                    break;
                case 11:
                    valorCalculado += 53 * Integer.parseInt(nitVector[aux - 11]);
                    break;
                case 12:
                    valorCalculado += 59 * Integer.parseInt(nitVector[aux - 12]);
                    break;
                case 13:
                    valorCalculado += 67 * Integer.parseInt(nitVector[aux - 13]);
                    break;
                case 14:
                    valorCalculado += 71 * Integer.parseInt(nitVector[aux - 14]);
                    break;
            }
        }

        int modulo = valorCalculado % 11;

        if (modulo >= 2) {
            modulo = 11 - modulo;
        }
        return modulo;
    }
}