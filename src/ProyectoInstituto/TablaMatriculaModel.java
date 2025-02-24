package ProyectoInstituto;

import ProyectoInstituto.controlador.ControladorMatricula;
import ProyectoInstituto.modeloBBDD.Asignatura;
import ProyectoInstituto.modeloBBDD.InstitutoDAO;
import ProyectoInstituto.modeloBBDD.Matricula;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TablaMatriculaModel extends AbstractTableModel {

    public final static int ID_ALUMNO = 0;
    public final static int ID_ASIGNATURA = 1;
    public final static int CURSO = 2;
    public final static double NOTA = 3;

    public final static String [] nombreColumnas = {"Id Alumno", "Id Asignatura", "Curso", "Nota"};

    ControladorMatricula controladorMatricula = new ControladorMatricula();

    public List<Matricula> matriculas;
    public TablaMatriculaModel(){matriculas = obtenerMatricula();}

    private List<Matricula> obtenerMatricula(){
        List<Matricula> lista = controladorMatricula.obtenerMatricula();
        return controladorMatricula.obtenerMatricula();
    }


    @Override
    public int getRowCount() {
        return matriculas.size();
    }

    @Override
    public int getColumnCount() {
        return nombreColumnas.length;
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        Matricula matri = matriculas.get(fila);
        if (columna == ID_ALUMNO){
            return matri.getIdAlumno();
        } else if (columna == ID_ASIGNATURA) {
            return matri.getIdAsignatura();
        } else if (columna == CURSO) {
            return matri.getCurso();
        } else if (columna == NOTA) {
            return matri.getNota();
        }
        return null;
    }
    @Override
    public String getColumnName (int columna){
        return nombreColumnas[columna];
    }
}
