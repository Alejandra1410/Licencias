/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Oficial;
import Controller.Controller;
import Dao.Dao;
import Model.Oficial.Oficial;
import View.View;
import java.util.List;

public class OficialController implements Controller<Oficial> {

    private View view;
    private Dao dao;

    public OficialController(View view, Dao dao) {
        this.view = view;
        this.dao = dao;
    }

    @Override
    public boolean create(Oficial oficial) {
        if (dao.create(oficial)) {
            view.displayMessage("Oficial creado correctamente");
            return true;
        } else {
            view.displayMessage("Error al agregar el oficial");
            return false;
        }
    }

    @Override
    public Oficial read(String id) {
        Oficial official = (Oficial) dao.read(id);
        if (official == null) {
            view.displayMessage("Oficial no encontrado");
            return null;
        }
        view.display(official);
        return official;
    }

    @Override
    public List<Oficial> readAll() {
        List<Oficial> officials = (List<Oficial>) dao.readAll();
        return officials;
    }

    @Override
    public boolean update(Oficial oficial) {
        if (dao.update(oficial)) {
            view.displayMessage("Oficial actualizado correctamente");
            return true;
        } else {
            view.displayMessage("Error al actualizar el oficial");
            return false;
        }
    }

    @Override
    public boolean delete(Oficial oficial) {
        if (dao.delete(oficial)) {
            view.displayMessage("Oficial eliminado correctamente");
            return true;
        } else {
            view.displayMessage("Error al eliminar el oficial");
            return false;
        }
    }

}
