
package BusinessLayer;

import DataAccessLayer.ApoderadoDAO;
import JavaBean.Apoderado;
import java.util.ArrayList;

public class ApoderadoBO {
    
    public void insertarApoderado(Apoderado apoderado) throws Exception{
        try {
            ApoderadoDAO ApoderadoDAO = new ApoderadoDAO();
            ApoderadoDAO.insertarApoderado(apoderado);
        } catch (Exception e) {
            throw e;
        }
    }
    public void actualizarApoderado(Apoderado apoderado) throws Exception{
        try {
            ApoderadoDAO ApoderadoDAO = new ApoderadoDAO();
            ApoderadoDAO.actualizarApoderado(apoderado);
        } catch (Exception e) {
            throw e;
        }
    }
    public void eliminarApoderado(int id) throws Exception{
        try {
            ApoderadoDAO ApoderadoDAO = new ApoderadoDAO();
            ApoderadoDAO.eliminarApoderado(id);
        } catch (Exception e) {
            throw e;
        }
    }
    public Apoderado buscarApoderadoPorId(int id) throws Exception{
        try {
            ApoderadoDAO ApoderadoDAO = new ApoderadoDAO();
            return ApoderadoDAO.buscarApoderadoPorId(id);
        } catch (Exception e) {
            throw e;
        }
    }
    public Apoderado buscarApoderadoPorDNI(String dni) throws Exception{
        try {
            ApoderadoDAO ApoderadoDAO = new ApoderadoDAO();
            return ApoderadoDAO.buscarApoderadoPorDNI(dni);
        } catch (Exception e) {
            throw e;
        }
    }
    public ArrayList<Apoderado> buscarApoderadoPorNombre(String nombre) throws Exception{
        try {
            ApoderadoDAO ApoderadoDAO = new ApoderadoDAO();
            return ApoderadoDAO.buscarApoderadoPorNombre(nombre);
        } catch (Exception e) {
            throw e;
        }
    }
}
