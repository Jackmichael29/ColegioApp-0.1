/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package JavaBean;

import DataAccessLayer.AreaDAO;
import java.util.ArrayList;

/**
 *
 * @author black
 */
public class Prueba7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Area area = new Area();
        area.setArea_id(1);
        area.setArea_nombre("AreaPrueba");
        
        ArrayList<Area> areas = new ArrayList<>();
        
        AreaDAO areaDAO = new AreaDAO();
        try {
            area = areaDAO.buscarPorId(1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
            System.out.println(area.getArea_id()+"-"+area.getArea_nombre());
    }
    
}
