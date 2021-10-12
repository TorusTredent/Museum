package sample.service.imp;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.animations.Shake;
import sample.controller.ControllerHelper;
import sample.repository.ChangeBalanceRepository;
import sample.service.ChangeBalanceService;

public class ChangeBalanceServiceImp implements ChangeBalanceService {

    @Override
    public void addBalance(String newBalance) {
        ChangeBalanceRepository.addBalance(newBalance);
        System.out.println("Изменение выполнено успешно");
    }


    @Override
    public boolean checkBalanceTextField(TextField textField) {
        String str = textField.getText();
        if (str == null || str.isEmpty()) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                Shake shake = new Shake(textField);
                shake.playAnim();
                return false;
            }
        }
        return true;
    }

    @Override
    public void returnToPersonalAreaW(Button button) {
        ControllerHelper.closeWindow(button);
    }
}
