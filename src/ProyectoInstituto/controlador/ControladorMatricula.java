package ProyectoInstituto.controlador;

import ProyectoInstituto.modeloBBDD.Alumno;
import ProyectoInstituto.modeloBBDD.Asignatura;
import ProyectoInstituto.modeloBBDD.InstitutoDAO;
import ProyectoInstituto.modeloBBDD.Matricula;

import java.util.List;

public class ControladorMatricula {


    public List<Matricula> obtenerMatricula() {
        List<Matricula> lista = InstitutoDAO.selectMatriculas();
        return lista;

    }

    public int insertarMatricula(int idAlumno, int idAsignatura, int curso, double nota) {
        Matricula matric = new Matricula(idAlumno, idAsignatura, curso, nota);
        int resultado = InstitutoDAO.insertarMatricula(idAlumno, idAsignatura, nota, curso);
        return resultado;
    }


}



