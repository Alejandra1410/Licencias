package Controller.Oficial;

import Controller.Controller;
import Dao.Dao;
import Model.Oficial.Oficial;
import PersonaDTO.DtoOficial;
import View.View;

import java.util.ArrayList;
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
        if (oficial != null) {
            DtoOficial oficialDto = new DtoOficial(
                    oficial.getSalario(),
                    oficial.getContrasena(),
                    oficial.getCedula(),
                    oficial.getNombre(),
                    oficial.getFechaNacimiento(),
                    oficial.getTelefono(),
                    oficial.getCorreo()
            );

            if (dao.create(oficialDto)) {
                view.displayMessage("Oficial creado correctamente");
                return true;
            } else {
                view.displayMessage("Error al agregar el oficial");
                return false;
            }
        } else {
            view.displayMessage("Datos del oficial no proporcionados");
            return false;
        }
    }

    @Override
    public Oficial read(String cedula) {
        DtoOficial oficialDto = (DtoOficial) dao.read(cedula);
        if (oficialDto == null) {
            view.displayMessage("Oficial no encontrado");
            return null;
        }
        Oficial oficial = new Oficial(
                oficialDto.getSalario(),
                oficialDto.getContrasena(),
                oficialDto.getCedula(),
                oficialDto.getNombre(),
                oficialDto.getFechaNacimiento(),
                oficialDto.getTelefono(),
                oficialDto.getCorreo()
        );
        view.display(oficial);
        return oficial;
    }

    @Override
    public List<Oficial> readAll() {
        List<DtoOficial> oficialDTOs = (List<DtoOficial>) dao.readAll();
        List<Oficial> officials = new ArrayList<>();
        for (DtoOficial dto : oficialDTOs) {
            officials.add(new Oficial(
                    dto.getSalario(),
                    dto.getContrasena(),
                    dto.getCedula(),
                    dto.getNombre(),
                    dto.getFechaNacimiento(),
                    dto.getTelefono(),
                    dto.getCorreo()
            ));
        }
        return officials;
    }

    @Override
    public boolean update(Oficial oficial) {
        DtoOficial oficialDto = new DtoOficial(
                oficial.getSalario(),
                oficial.getContrasena(),
                oficial.getCedula(),
                oficial.getNombre(),
                oficial.getFechaNacimiento(),
                oficial.getTelefono(),
                oficial.getCorreo()
        );
        if (dao.update(oficialDto)) {
            view.displayMessage("Oficial actualizado correctamente");
            return true;
        } else {
            view.displayMessage("Error al actualizar el oficial");
            return false;
        }
    }

    @Override
    public boolean delete(Oficial oficial) {
        DtoOficial oficialDto = new DtoOficial(
                oficial.getSalario(),
                oficial.getContrasena(),
                oficial.getCedula(),
                oficial.getNombre(),
                oficial.getFechaNacimiento(),
                oficial.getTelefono(),
                oficial.getCorreo()
        );
        if (dao.delete(oficialDto)) {
            view.displayMessage("Oficial eliminado correctamente");
            return true;
        } else {
            view.displayMessage("Error al eliminar el oficial");
            return false;
        }
    }

    public boolean autenticarOficial(String cedula, String contrasena) {
        DtoOficial oficialDto = (DtoOficial) dao.read(cedula);
        if (oficialDto != null && oficialDto.getContrasena().equals(contrasena)) {
            view.displayMessage("Autenticación exitosa.");
            return true;
        } else {
            view.displayMessage("Credenciales incorrectas.");
            return false;
        }
    }

    public boolean cambiarContrasenaOficial(String cedula, String contrasenaActual, String nuevaContrasena) {
        DtoOficial oficialDtoActual = (DtoOficial) dao.read(cedula);
        if (oficialDtoActual != null && oficialDtoActual.getContrasena().equals(contrasenaActual)) {
            // Crear un nuevo DTO con la contraseña actualizada
            DtoOficial oficialDtoNuevo = new DtoOficial(
                    oficialDtoActual.getSalario(),
                    nuevaContrasena, // Nueva contraseña
                    oficialDtoActual.getCedula(),
                    oficialDtoActual.getNombre(),
                    oficialDtoActual.getFechaNacimiento(),
                    oficialDtoActual.getTelefono(),
                    oficialDtoActual.getCorreo()
            );
            if (dao.update(oficialDtoNuevo)) {
                view.displayMessage("Contraseña actualizada correctamente.");
                return true;
            } else {
                view.displayMessage("Error al actualizar la contraseña.");
            }
        } else {
            view.displayMessage("Credenciales incorrectas.");
        }
        return false;
    }
}
