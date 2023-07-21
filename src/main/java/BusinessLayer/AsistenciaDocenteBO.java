/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLayer;

import DataAccessLayer.AsistenciaDocenteDAO;
import JavaBean.AsistenciaDocente;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author LAB-USR-HUAN-A0305
 */
public class AsistenciaDocenteBO {
    public void insertar(AsistenciaDocente asistenciadocente) throws Exception{
        try {
            AsistenciaDocenteDAO asistenciadocenteDAO = new AsistenciaDocenteDAO();
            asistenciadocenteDAO.insertar(asistenciadocente);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void insertarIngreso(AsistenciaDocente asistenciadocente) throws Exception{
        try {
            AsistenciaDocenteDAO asistenciadocenteDAO = new AsistenciaDocenteDAO();
            asistenciadocenteDAO.insertarIngreso(asistenciadocente);
        } catch (Exception e) {
            System.out.println("quepasa aqui");
            System.out.println(e);
            throw e;
        }
    }
    
    public void insertarSalida(int id, LocalDate fecha, Time hora) throws Exception{
        try {
            AsistenciaDocenteDAO asistenciadocenteDAO = new AsistenciaDocenteDAO();
            asistenciadocenteDAO.insertarSalida(id, fecha, hora);
        } catch (Exception e) {
            System.out.println("quepasa aqui");
            System.out.println(e);
            throw e;
        }
    }
    
    public void actualizar(AsistenciaDocente asistenciadocente) throws Exception{
        try{
            AsistenciaDocenteDAO asistenciadocenteDAO = new AsistenciaDocenteDAO();
            asistenciadocenteDAO.actualizar(asistenciadocente);
        }catch(Exception e){
            throw e;
        }
        
    }
    
    public void eliminar(int i) throws Exception{
        try {
            AsistenciaDocenteDAO asistenciadocenteDAO = new AsistenciaDocenteDAO();
            asistenciadocenteDAO.eliminar(i);
        } catch (Exception e) {
            throw e;
        }
    }
    
    
    public AsistenciaDocente buscarAsistenciaDocentePorDocenteId(int id) throws Exception{
        try {
            AsistenciaDocenteDAO asistenciadocenteDAO = new AsistenciaDocenteDAO();
            return asistenciadocenteDAO.buscarPorDocenteId(id);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public AsistenciaDocente buscarPorFecha(int id) throws Exception{
        try {
            AsistenciaDocenteDAO asistenciadocenteDAO = new AsistenciaDocenteDAO();
            return asistenciadocenteDAO.buscarPorDocenteIdyFecha(id);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public ArrayList<AsistenciaDocente> asistenciaDocenteListar() throws Exception{
        try {
            AsistenciaDocenteDAO asistenciadocenteDAO = new AsistenciaDocenteDAO();
            return asistenciadocenteDAO.asistenciaDocenteListar();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public ArrayList<AsistenciaDocente> asistenciaDocenteListarPorHoy() throws Exception{
        try {
            AsistenciaDocenteDAO asistenciadocenteDAO = new AsistenciaDocenteDAO();
            return asistenciadocenteDAO.asistenciaDocenteListarPorHoy();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public ArrayList<AsistenciaDocente> asistenciaDocenteListarPorHoy2() throws Exception{
        try {
            AsistenciaDocenteDAO asistenciadocenteDAO = new AsistenciaDocenteDAO();
            return asistenciadocenteDAO.asistenciaDocenteListarPorHoy2();
        } catch (Exception e) {
            throw e;
        }
    }
    
}
