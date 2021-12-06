package sample.service.imp;

import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import sample.controller.ControllerHelper;
import sample.entity.Exhibition;
import sample.entity.TableClassAdmin;
import sample.repository.AdminRepository;

public class AdminServiceImp {

    private final AdminRepository adminRepository = new AdminRepository();

    public ObservableList<TableClassAdmin> getDateFrDb(ObservableList<TableClassAdmin> exhibitionList) {
        return adminRepository.getData(exhibitionList);
    }

    public void openAdminExhibitionWindow(Button button) {
        String window = "/sample/view/personal/admin/WindowAdminNewExhibition.fxml";
        ControllerHelper.updateWindow(button, window);
    }

    public void addExhibition(String name, String cost, String date) {
        adminRepository.addExhibition(new Exhibition(name, date, Integer.parseInt(cost)));
    }

    public void openAdminW(Button button) {
        String window = "/sample/view/personal/admin/WindowAdmin.fxml";
        ControllerHelper.updateWindow(button, window);
    }

    public boolean isExistExhibitionId(String id) {
        return adminRepository.getExhibitionIdById(Integer.parseInt(id)) != 0;
    }

    public void deleteExhibitionById(String id){
        adminRepository.deleteExhibitionById(Integer.parseInt(id));
    }

    public void logOut(Button button) {
        String window = "/sample/view/singIn/WindowSingUp.fxml";
        ControllerHelper.updateWindow(button, window);
    }
}
