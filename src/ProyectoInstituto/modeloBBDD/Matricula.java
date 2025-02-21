package ProyectoInstituto.modeloBBDD;

public class Matricula {


    private int idAlumno;
    private int id;
    private double nota;

    public Matricula(double v, int idAlumno, int id, double nota) {
        this.idAlumno = idAlumno;
        this.id = id;
        this.nota = nota;
    }


    public int getIdAlumno() {
        return idAlumno;
    }

    public int getId() {
        return id;
    }

    public double getNota() {
        return nota;
    }


    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
}






