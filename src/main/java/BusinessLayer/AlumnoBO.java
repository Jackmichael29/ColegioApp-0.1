package BusinessLayer;

import DataAccessLayer.AlumnoDao;
import JavaBean.Alumno;
import java.util.ArrayList;

public class AlumnoBO {

    public void insertar(Alumno alumno) throws Exception {

        try {
            AlumnoDao alumnoDAO = new AlumnoDao();
            alumnoDAO.insertar(alumno);
        } catch (Exception e) {
            throw e;
        }

    }

    public void actualizar(Alumno alumno) throws Exception {

        try {
            AlumnoDao alumnoDAO = new AlumnoDao();
            alumnoDAO.actualizar(alumno);
        } catch (Exception e) {
            throw e;
        }

    }

    public void eliminar(int id) throws Exception {

        try {
            AlumnoDao alumnoDAO = new AlumnoDao();
            alumnoDAO.eliminar(id);
        } catch (Exception e) {
            throw e;
        }

    }

    public ArrayList<Alumno> buscarPorAlumno(String cadena) throws Exception {

        try {
            AlumnoDao alumnoDAO = new AlumnoDao();
            return alumnoDAO.buscarPorAlumno(cadena);
        } catch (Exception e) {
            throw e;
        }
    }

    public Alumno buscarPorDNI(String dni) throws Exception {

        try {
            AlumnoDao alumnoDAO = new AlumnoDao();
            return alumnoDAO.buscarPorDNI(dni);
        } catch (Exception e) {
            throw e;
        }
    }

    public Alumno buscarPorId(int id) throws Exception {

        try {
            AlumnoDao alumnoDAO = new AlumnoDao();
            return alumnoDAO.buscarPorId(id);
        } catch (Exception e) {
            throw e;
        }
    }

    
    public ArrayList<Alumno> listar() throws Exception {

        try {
            AlumnoDao alumnoDAO = new AlumnoDao();
            return alumnoDAO.buscarPorAlumno("");
        } catch (Exception e) {
            throw e;
        }
    }
}
