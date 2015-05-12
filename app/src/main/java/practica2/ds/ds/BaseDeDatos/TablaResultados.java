package practica2.ds.ds.BaseDeDatos;

/**
 * Created by garcas on 05/05/2015.
 */
public class TablaResultados {
    // Labels table name
    public static final String TABLE = "Resultados";

    // Labels Table Columns names
    public static final String KEY_ID = "id";
    public static final String KEY_fecha = "fecha";
    public static final String KEY_actividad = "actividad";
    public static final String KEY_aciertos = "aciertos";
    public static final String KEY_fallos = "fallos";

    public int id;
    public String fecha;
    public String actividad;
    public int aciertos;
    public int fallos;

}
