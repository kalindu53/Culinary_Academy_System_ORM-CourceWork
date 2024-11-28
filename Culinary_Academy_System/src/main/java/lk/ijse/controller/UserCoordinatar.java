package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.UserBO;
import lk.ijse.dto.UserDto;
import lk.ijse.entity.User;

import java.util.List;


public class UserCoordinatar {
    UserBO userBo = (UserBO) BOFactory.getBOFactory().getBOType(BOFactory.BOType.USER);


    @FXML
    private PasswordField txtPassword;

    @FXML
    private PasswordField txtPasswordNew;

    @FXML
    private TextField txtUseName;

    @FXML
    private AnchorPane userPane;
    private AnchorPane centerNode2;

    @FXML
    void UpdateOnAction(ActionEvent event) {
        String password = txtPassword.getText();
        String passwordNew = txtPasswordNew.getText();
        String useName = txtUseName.getText();

        boolean isValid = userBo.checkCredentials(useName, password);
        if (isValid) {
            List<User> alluser = userBo.getAll_detail(useName);


            for (User user : alluser) {
                boolean isUpdated = userBo.update(new UserDto(user.getUser_id(), user.getUserName(),passwordNew,user.getUserRole(), user.getUserPhoneNumber(),  user.getUserEmailAddress()));
                if (isUpdated){
                    clear_all();
                    new Alert(Alert.AlertType.INFORMATION, "Successful update! Your new password is: " + passwordNew).show();

                }
                else {
                    clear_all();
                    new Alert(Alert.AlertType.ERROR, "un-successful your password, try Again").show();

                }

            }






       }
        else {
            clear_all();
            new Alert(Alert.AlertType.ERROR, "Invalid credentials!").show();
        }






    }

    private void clear_all() {
        txtPassword.setText("");
        txtPasswordNew.setText("");
        txtUseName.setText("");
    }

    public void setCenterNode(AnchorPane centerNode2) {
        this.centerNode2=centerNode2;
    }
}
