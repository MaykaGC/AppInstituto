package ProyectoInstituto.modeloBBDD;

public class Matricula {


    private int idAlumno;
    private int idAsignatura;
    private int curso;
    private double nota;

    public Matricula(int idAlumno, int idAsignatura, int curso, double nota) {
        this.idAlumno = idAlumno;
        this.idAsignatura = idAsignatura;
        this.curso = curso;
        this.nota = nota;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public int getIdAsignatura() {
        return idAsignatura;
    }

    public int getCurso() {
        return curso;
    }

    public double getNota() {
        return nota;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public void setIdAsignatura(int idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }
}





