package ProyectoInstituto.modeloBBDD;

public class Matricula {

    private int id;
    private int idAlumno;
    private int idAsignatura;
    private String nombre;
    private double  nota;

    public Matricula(double nota, int idAlumno, int id, int idAsignatura, String nombre) {
        this.nota = nota;
        this.id = id;
        this.idAlumno = idAlumno;
        this.idAsignatura = idAsignatura;
        this.nombre = nombre;
    }







