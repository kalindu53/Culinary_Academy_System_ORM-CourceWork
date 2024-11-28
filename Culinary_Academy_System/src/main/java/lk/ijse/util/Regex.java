package lk.ijse.util;

import javafx.scene.paint.Paint;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
//    public static boolean isTextFieldValid(TextField textField, String text){
//        String filed = "";
//
//        switch (textField){
//            case ID:
//                filed = "^([A-Z][0-9]{3})$";
//                break;
//            case NAME:
//                filed = "^[A-z|\\\\s]{3,}$";
//                break;
//            case EMAIL:
//                filed = "^([A-z])([A-z0-9.]){1,}[@]([A-z0-9]){1,10}[.]([A-z]){2,5}$";
//        }
//
//        Pattern pattern = Pattern.compile(filed);
//
//        if (text != null){
//            if (text.trim().isEmpty()){
//                return false;
//            }
//        }else {
//            return false;
//        }
//
//        Matcher matcher = pattern.matcher(text);
//
//        if (matcher.matches()){
//            return true;
//        }
//        return false;
//    }
//
//    public static boolean setTextColor(TextField textField, javafx.scene.control.TextField txtStudentFirstName) {
//
//        if (Regex.isTextFieldValid(location, textField.getText())){
//            textField.setFocusColor(Paint.valueOf("Green"));
//            textField.setUnFocusColor(Paint.valueOf("Green"));
//            return true;
//        }else {
//            textField.setFocusColor(Paint.valueOf("Red"));
//            textField.setUnFocusColor(Paint.valueOf("Red"));
//            return false;
//        }
//
//    }
//
//    /*public static boolean setTextColor(TextField location, TextField textField){
//        if (Regex.isTextFieldValid(location, textField.getText())){
//            textField.setFocusColor(Paint.valueOf("Green"));
//            textField.setUnFocusColor(Paint.valueOf("Green"));
//            return true;
//        }else {
//            textField.setFocusColor(Paint.valueOf("Red"));
//            textField.setUnFocusColor(Paint.valueOf("Red"));
//            return false;
//        }
//    }*/



    public static boolean isTextFieldValid(TextField textField, String text) {
        String field = "";
        switch (textField) {
            case ID:
                field = "^([A-Z][0-9]{3})$";
                break;
            case NAME:
                field = "^[A-z|\\\\s]{3,}$";
                break;
            case TEL:
                field = "^([+]94{1,3}|[0])([1-9]{2})([0-9]){7}$";
                break;
            case ADDRESS:
                field =  "^([A-z0-9]|[-/,.@+]|\\s){4,}$";
                break;
//            case MAIL:
//                field =  "^([A-z])([A-z0-9.]){1,}[@]([A-z0-9]){1,10}[.]([A-z]){2,5}$";
//                break;
//            case PRICE:
//                field =  "^([0-9]){1,}[.]([0-9]){1,}$";
//                break;
        }
        Pattern pattern = Pattern.compile(field);
        if (text != null) {
            if (text.trim().isEmpty()) {
                return false;
            }
        } else {
            return false;
        }
        Matcher matcher = pattern.matcher(text);
        return matcher.matches();
    }
    public static boolean setTextColor(TextField location, javafx.scene.control.TextField textField) {
        if (Regex.isTextFieldValid(location, textField.getText())) {
            textField.setStyle("-fx-focus-color: green; -fx-unfocus-color: green; border-radius: 10;");
            // textField.setStyle("-fx-control-inner-background: green; -fx-focus-color: green; -fx-unfocus-color: green;");
            return true;
        } else {
            textField.setStyle("-fx-focus-color: red; -fx-unfocus-color: red;");
            //textField.setStyle("-fx-control-inner-background: red; -fx-focus-color: red; -fx-unfocus-color: red;");
            return false;
        }
    }
}



