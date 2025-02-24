package ProyectoInstituto.modeloBBDD;

import java.sql.*;
import java.util.ArrayList;

public class InstitutoDAO extends ArrayList<Object> {

    private static final String URL = "jdbc:mysql://localhost:3306/instituto";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    /* OPCIONES DE OPERACIONES EN LA BASE DE DATOS */


    //al hacer consultas debemos devolver objetos de la capa modelo
    //en la capa modelo estará Alumno
    public static ArrayList<Alumno> selectAlumnos() {
        ArrayList<Alumno> alumnos = new ArrayList<>();
        try (Connection conn = connect()) {
            String query = "SELECT * FROM alumnos ORDER BY nombre ASC";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            //resultset = conjunto de resultados, igual que cursores en android

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String direccion = rs.getString("direccion");
                String estado_matricula = rs.getString("estadoMatricula");
                Alumno alumno = new Alumno(nombre, direccion, estado_matricula);
                alumnos.add(alumno);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return alumnos;
    }

    //INSERTAR ALUMNO
    public static int ingresarAlumno(Alumno alum) {
        int resultado = 0;
        try (Connection conn = connect()) {
            //insertamos en la base de datos
            String query = "INSERT INTO alumnos (nombre, direccion, estado_matricula) VALUES (?,?,?)";  //se ponen tantas interrogaciones como valores tengamos
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, alum.getNombre());
            stmt.setString(1, alum.getDireccion());
            stmt.setString(1, alum.getEstadoMatricula());
            //Se usa para CRUD y retorna el numero de filas si es mayor de uno o igual "se ha insertado correctamente"
            //sino retorna un 0, es decir, no se ha insertado nada
            resultado = stmt.executeUpdate();
            stmt.executeUpdate();
            System.out.println("Alumno insertado correctamente.");

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return resultado;

    }

    //ELIMINAR ALUMNO
    public static int eliminarAlumno(int idAlumno) throws SQLException {
        int resultado = 0;
        try (Connection conn = connect()) {
            //Eliminamos de la base de datos
            String query = "DELETE FROM alumnos where idAlumno = ?";


        }
        return resultado;

    }

    //SELECCIONAR ASIGNATURA
    public static ArrayList<Asignatura> selectAsignatura() {
        ArrayList<Asignatura> asignaturas = new ArrayList<>();
        try (Connection conn = connect()) {
            String query = "SELECT * FROM asignaturas ORDER BY nombre ASC";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String nombreAsignatura = rs.getString("nombreAsignatura");
                String curso = rs.getString("curso");
                Asignatura asignatura = new Asignatura(nombreAsignatura, curso);
                asignaturas.add(asignatura);

            }
        } catch (SQLException e) {

            e.printStackTrace();

        }
        return asignaturas;
    }

    //INSERTAR ASIGNATURA
    public static int insertarAsignatura(Asignatura asig) {
        int resultado = 0;
        try (Connection conn = connect()) {
            String query = "INSERT INTO asignaturas (nombreAsignatura, curso) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, asig.getNombreAsignatura());
            stmt.setInt(2, asig.getCurso());
            stmt.executeUpdate();
            System.out.println("Asignatura insertada correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }


    /*public static ArrayList<Alumno> selectAlumnos() {
        ArrayList<Alumno> alumnos = new ArrayList<>();
        try (Connection conn = connect()) {
            String query = "SELECT * FROM alumnos ORDER BY nombre ASC";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            //resultset = conjunto de resultados, igual que cursores en android

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String direccion = rs.getString("direccion");
                String estado_matricula = rs.getString("estadoMatricula");
                Alumno alumno = new Alumno(nombre, direccion, estado_matricula);
                alumnos.add(alumno);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return alumnos;
    }*/





    //SELECCIONAR MATRICULAS
    public static ArrayList<Matricula> selectMatriculas(int idAlumno, int idAsignatura, int curso, double nota ) {
        ArrayList<Matricula> matriculas = new ArrayList<>();
        try (Connection conn = connect()) {
            //String query = "SELECT mat.id, asig.nombre AS nombreAsignatura, mat.nota, mat.id_asignatura FROM matriculas mat JOIN asignaturas asig ON mat.id_asignatura = asig.id WHERE mat.id_alumno = ?";
           String query = "SELECT matricula.id, alumno.nombre, b.nombre_asigntura, matricula.curso, matricula.curso, m.nota from matriculas" +
                   "on  inner join alumnos a on m.idAlumno = a.idAlumno" +
                   "inner join asignatura b on m.id_asignatura = b.idAsignatura";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, idAlumno);
            stmt.setInt(2, idAsignatura);
            stmt.setInt(3, curso);
            stmt.setDouble(4, nota);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int idAlumno = rs.getInt("idAlumno");
                int idAsignatura = rs.getInt("id_asignatura");
                int curso = rs.getInt("curso");
                double nota = rs.getDouble("nota");
                Matricula mat = new Matricula(idAlumn, idAsignatura, curso, nota);
                matriculas.add(mat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return matriculas;
    }






    //INSERTAR MATRICULA
    public static int insertarMatricula(int idAlumno, int idAsignatura, double nota, int curso) {
        int resultado = 0;
        try (Connection conn = connect()) {
            String query = "INSERT INTO matriculas (id_Alumno, id_Asignatura, nota, curso) VALUES (?, ?, ?,?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, idAlumno);
            stmt.setInt(2, idAsignatura);
            stmt.setDouble(3, nota);
            stmt.setInt(4, curso);
            stmt.executeUpdate();
            System.out.println("Matrícula insertada correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultado;
    }


    public static double[] obtenerMejorPeorNota(int idAlumno) {
        double[] notas = new double[2];
        try (Connection conn = connect()) {
            String query = "SELECT MAX(nota) AS mejorNota, MIN(nota) AS peorNota FROM matriculas WHERE id_alumno = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, idAlumno);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                notas[0] = rs.getDouble("mejorNota");
                notas[1] = rs.getDouble("peorNota");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return notas;
    }


    public static double obtenerNotaMedia(int idAlumno) {
        double notaMedia = 0.0;

        try (Connection conn = connect()) {
            String query = "SELECT AVG(nota) AS notaMedia FROM matriculas WHERE id_alumno = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, idAlumno);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                notaMedia = rs.getDouble("notaMedia");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return notaMedia;
    }

}
