/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayer;

import DataAccessLayer.AlumnoApoderadoDAO;
import JavaBean.alumnoApoderado;

public class AlumnoApoderadoBO {
    
    public void insertarMatricula(alumnoApoderado alumnoApo) throws Exception{
        try {
            AlumnoApoderadoDAO AlumnoApoderadoDAO = new AlumnoApoderadoDAO();
            AlumnoApoderadoDAO.insertarMatricula(alumnoApo);
        } catch (Exception e) {
            throw e;
        }
    }
    public void actualizarApoderado(alumnoApoderado alumnoApo) throws Exception{
        try {
            AlumnoApoderadoDAO AlumnoApoderadoDAO = new AlumnoApoderadoDAO();
            AlumnoApoderadoDAO.actualizarApoderado(alumnoApo);
        } catch (Exception e) {
            throw e;
        }
    }
    public void eliminarApoderado(int id) throws Exception{
        try {
            AlumnoApoderadoDAO AlumnoApoderadoDAO = new AlumnoApoderadoDAO();
            AlumnoApoderadoDAO.eliminarApoderado(id);
        } catch (Exception e) {
            throw e;
        }
    }
    public alumnoApoderado buscarApoderadoPorAlumnoId(int id) throws Exception{
        try {
            AlumnoApoderadoDAO alumnoApoderadoDAO = new AlumnoApoderadoDAO();
            return alumnoApoderadoDAO.buscarApoderadoPorAlumnoId(id);
        } catch (Exception e) {
            throw e;
        }
    }
}
