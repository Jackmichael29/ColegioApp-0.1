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

    public void insertar(Curso curso) throws Exception{
        
        try {
            CursoDAO cursoDAO = new CursoDAO();
            cursoDAO.insertar(curso);
        } catch (Exception e) {
            throw e;
        }
        
    }
    
    public void actualizar(Curso curso) throws Exception{  
        
        try {
           CursoDAO cursoDAO = new CursoDAO();
           cursoDAO.modificar(curso); 
        } catch (Exception e) {
            throw e;
        }
        
    }
    
    public void eliminar(int id) throws Exception{  
        
        try {
            CursoDAO cursoDAO = new CursoDAO();
            cursoDAO.eliminar(id);
        } catch (Exception e) {
             throw e;
        }
        
    }
    
    public ArrayList<Curso> buscarPorCurso(String cadena) throws Exception{  
        
        try {
            if(cadena.length()>60){                
               throw new Exception("El argumento no puede exceder de 60 caracteres");                    
            }            
            CursoDAO cursoDAO = new CursoDAO();
            return cursoDAO.buscarPorCurso(cadena);
        } catch (Exception e) {
            throw e;
        }        
    }
    
    public Curso buscarPorId(int id) throws Exception{  
        
        try {
            CursoDAO cursoDAO = new CursoDAO();
            return cursoDAO.buscarPorCursoId(id);
        } catch (Exception e) {
             throw e;
        }        
    }
}
