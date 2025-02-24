package ProyectoInstituto.modeloBBDD;

public class Asignatura {

    String nombreAsignatura;
    int curso;

    public Asignatura(String nombreAsignatura, String curso) {
        this.nombreAsignatura = nombreAsignatura;
        this.curso = Integer.parseInt(String.valueOf(curso));
    }

    public String getNombreAsignatura() {
        return nombreAsignatura;
    }

    public int getCurso() {
        return curso;
    }
}
