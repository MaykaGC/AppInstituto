package ProyectoInstituto.modeloBBDD;

public class Alumno {

    private String nombre;
    private String direccion; 
    private String estadoMatricula;

    public Alumno(String nombre, String direccion, String estadoMatricula) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.estadoMatricula = estadoMatricula;
    }


    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getEstadoMatricula() {
        return estadoMatricula;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setEstadoMatricula(String estadoMatricula) {
        this.estadoMatricula = estadoMatricula;
    }

}
