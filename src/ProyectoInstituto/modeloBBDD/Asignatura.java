package ProyectoInstituto.modeloBBDD;

public class Asignatura {

    String nombreAsignatura;
    int curso;

    public Asignatura(String nombreAsignatura, int curso) {
        this.nombreAsignatura = nombreAsignatura;
        this.curso = curso;
    }

    public String getNombreAsignatura() {
        return nombreAsignatura;
    }

    public int getCurso() {
        return curso;
    }
}
