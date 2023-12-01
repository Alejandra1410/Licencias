/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao.Oficial;

import Dao.Dao;
import DaoBD.DaoBD;
import PersonaDTO.DtoOficial;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author wendy
 */
public class DaoBDOficial implements Dao<DtoOficial>{

    @Override
    public boolean create(DtoOficial obj) {
        if (obj == null) {
            return false;
        }
        DaoBD bd = new DaoBD();
     bd.createStatement("call OficialInsert(?,?,?,?,?,?)"); // Nombre del procedimiento almacenado
        bd.set(1, obj.getCedula());
        bd.set(2, obj.getNombre());
        bd.set(3, obj.getFechaNacimiento());
        bd.set(4, obj.getTelefono());
        bd.set(5, obj.getCorreo());
        bd.set(6, obj.getContrasena()); // Asegúrate de que OficialDTO tiene este método

        return bd.execute(false);
    }
    @Override
    public DtoOficial read(String id) {
        List<DtoOficial> oficial = new ArrayList<>();
        DaoBD bd = new DaoBD();
        try {
            bd.createStatement("call SelectAll()");
            if (bd.execute(true)) {
                while (bd.getData().next()) {
                    String cedula = bd.getData().getString(1);
                    String nombre = bd.getData().getString(2);
                    Date fechaNacimiento = bd.getData().getDate(3);
                    String telefono = bd.getData().getString(4);
                    String correo = bd.getData().getString(5);
                    String contrasena = bd.getData().getString(6);
                    oficial.add(new DtoOficial());
                }
            }
        } catch (SQLException e) {
            System.out.println("Error readAll");
        }

        return 
    }

    @Override
    public List<DtoOficial> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(DtoOficial obj) {
          if (obj == null) {
            return false;
        }
        DaoBD bd = new DaoBD();
     bd.createStatement("call OficialUpdate(?,?,?,?,?,?)"); 
        bd.set(1, obj.getCedula());
        bd.set(2, obj.getNombre());
        bd.set(3, obj.getFechaNacimiento());
        bd.set(4, obj.getTelefono());
        bd.set(5, obj.getCorreo());
        bd.set(6, obj.getContrasena()); 
        return bd.execute(false);
    }

    @Override
    public boolean delete(DtoOficial obj) {
        if (obj== null) {
            return false;
        }
        DaoBD bd = new DaoBD();
        bd.createStatement("call delete oficial(?)");
        bd.set(1, obj.getCedula());
        return bd.execute(false);
    }
    
}
