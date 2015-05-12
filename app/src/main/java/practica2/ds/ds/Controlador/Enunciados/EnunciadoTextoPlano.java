package practica2.ds.ds.Controlador.Enunciados;

/**
 * Created by Pablo on 22/04/2015.
 */
public class EnunciadoTextoPlano extends Enunciado {


    public EnunciadoTextoPlano(int student_ID, String enunciado, String ruta, int tipo, String categoria) {
        super(student_ID, enunciado, ruta, tipo, categoria);
    }

    @Override
    public String getRuta() {
        return null;
    }
}
