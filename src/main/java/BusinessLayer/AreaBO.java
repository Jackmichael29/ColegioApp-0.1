package BusinessLayer;

import DataAccessLayer.AreaDAO;
import DataAccessLayer.CursoDAO;
import JavaBean.Area;
import JavaBean.Curso;
import java.util.ArrayList;

public class AreaBO {

    public ArrayList<Area> listar() throws Exception {

        try {
            AreaDAO areaDAO = new AreaDAO();
            return areaDAO.listar();
        } catch (Exception e) {
            throw e;
        }

    }

    public void insertar(Area area) throws Exception{
        
        try {
            AreaDAO areaDAO = new AreaDAO();
            System.out.println("insertando");
            areaDAO.insertar(area);
        } catch (Exception e) {
            throw e;
        }
        
    }
    
    public void actualizar(Area area) throws Exception{  
        
        try {
           AreaDAO areaDAO = new AreaDAO();
           areaDAO.actualizar(area); 
        } catch (Exception e) {
            throw e;
        }
        
    }
    
    public void eliminar(int id) throws Exception{  
        
        try {
            AreaDAO areaDAO = new AreaDAO();
            areaDAO.eliminar(id);
        } catch (Exception e) {
             throw e;
        }
        
    }
    
    public ArrayList<Area> listar(String cadena) throws Exception{  
        
        try {
            if(cadena.length()>60){                
               throw new Exception("El argumento no puede exceder de 60 caracteres");                    
            }            
            AreaDAO areaDAO = new AreaDAO();
            return areaDAO.listar();
        } catch (Exception e) {
            throw e;
        }        
    }
}
