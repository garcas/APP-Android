package practica2.ds.ds.Controlador.Enunciados;

/**
 * Created by Pablo on 22/04/2015.
 */
public abstract class Enunciado {
    int student_ID;
    String enunciado;
    String ruta;
    int tipo;
    String categoria;

    public Enunciado(int student_ID, String enunciado,String ruta, int tipo,String categoria){
        this.student_ID=student_ID;
        this.enunciado = enunciado;
        this.ruta = ruta;
        this.tipo = tipo;
        this.categoria = categoria;
    }
    public int getStudent_ID() {
        return student_ID;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public abstract String getRuta();

    public int getTipo() {
        return tipo;
    }

    public String getCategoria(){
        return categoria;
    }




}
