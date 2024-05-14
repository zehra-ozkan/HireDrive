package org.example.hiredrive.SceneControllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import org.example.hiredrive.advertisement.Filter;
import org.example.hiredrive.users.Company;
import org.example.hiredrive.users.Driver;
import org.example.hiredrive.users.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;


public class DriverSearchController extends SuperSceneController{

    private Driver driver;


    @FXML
    private CheckBox A;

    @FXML
    private CheckBox A1;

    @FXML
    private CheckBox A2;

    @FXML
    private CheckBox B;

    @FXML
    private CheckBox B1;

    @FXML
    private CheckBox BE;

    @FXML
    private CheckBox C1;

    @FXML
    private CheckBox C1E;

    @FXML
    private CheckBox CE;

    @FXML
    private CheckBox D;

    @FXML
    private CheckBox D1;

    @FXML
    private CheckBox D1E;

    @FXML
    private CheckBox DE;

    @FXML
    private RadioButton coldChainCargo;

    @FXML
    private RadioButton dangerousGoodsCargo;

    @FXML
    private RadioButton heavyCargo;

    @FXML
    private RadioButton livestockCargo;

    @FXML
    private RadioButton smallParcelCargo;

    @FXML
    private RadioButton specialHandlingCargo;

    @FXML
    private RadioButton retailCargo;

    @FXML
    private RadioButton valuableCargo;

    @FXML
    private RadioButton vehicleCargo;

    @FXML
    private DatePicker endDateFilter;

    @FXML
    private TitledPane experienceLevelFilter;

    @FXML
    private TitledPane experienceLevelFilter1;

    @FXML
    private Button goMainPageScene;

    @FXML
    private Button logOutBtn;

    @FXML
    private Spinner<Integer> minPointRating;

    @FXML
    private Spinner<Integer> maxPointRating;

    @FXML
    private Button myProfileButton;

    @FXML
    private Circle profilePicCircle;

    @FXML
    private Button searchBtn;

    @FXML
    private Button searchByNameButton;

    @FXML
    private TextField searchByNameTextArea;

    @FXML
    private DatePicker startDateFilter;

    private ArrayList<CheckBox> checkedLicenses;
    private String checkedCargoType;
    private int ratingMin;
    private int ratingMax;
    private LocalDate minDate;
    private LocalDate maxDate;

    @FXML
    void btn_clicked(ActionEvent event) {
        if (event.getSource()== myProfileButton) {
            Stage main = (Stage) myProfileButton.getScene().getWindow();
            createScene("/org/example/hiredrive/Scenes/profilePageDriver.fxml", this);
            main.close();

            setData();

            vehicleCargo.isSelected();
        }else if(event.getSource()== searchBtn){

        }
        else if (event.getSource() == logOutBtn){
            driver = null;
            System.out.println(driver);
            Stage main = (Stage) logOutBtn.getScene().getWindow();
            createScene("/org/example/hiredrive/Scenes/entranceScene.fxml", this);
            main.close();
        }
    }
    public void setData(Object o){
        driver = (Driver) o;
    }



    public void update() {
        myProfileButton.setText(driver.getUsername());
    }

    @Override
    public Driver getUserData(){
        return driver;
    }

    public void setData(){

        checkedLicenses = new ArrayList<CheckBox>();
        Filter filter = new Filter();

        if (A.isSelected()) checkedLicenses.add(A);

        if (A1.isSelected()) checkedLicenses.add(A1);

        if (A2.isSelected()) checkedLicenses.add(A2);

        if (B.isSelected()) checkedLicenses.add(B);

        if (B1.isSelected()) checkedLicenses.add(B1);

        if (BE.isSelected()) checkedLicenses.add(BE);

        if (C1.isSelected()) checkedLicenses.add(C1);

        if (C1E.isSelected()) checkedLicenses.add(C1E);

        if (CE.isSelected()) checkedLicenses.add(CE);

        if (D.isSelected()) checkedLicenses.add(D);

        if (D1.isSelected()) checkedLicenses.add(D1);

        if (D1E.isSelected()) checkedLicenses.add(D1E);

        if (DE.isSelected()) checkedLicenses.add(DE);

        if (coldChainCargo.isSelected()) filter.setCargoType(coldChainCargo.getText());

        if (dangerousGoodsCargo.isSelected()) filter.setCargoType(dangerousGoodsCargo.getText());

        if (heavyCargo.isSelected()) filter.setCargoType(heavyCargo.getText());

        if (livestockCargo.isSelected()) filter.setCargoType(livestockCargo.getText());

        if (smallParcelCargo.isSelected()) filter.setCargoType(smallParcelCargo.getText());

        if (specialHandlingCargo.isSelected()) filter.setCargoType(specialHandlingCargo.getText());

        if (retailCargo.isSelected()) filter.setCargoType(retailCargo.getText());

        if (valuableCargo.isSelected()) filter.setCargoType(valuableCargo.getText());

        if (vehicleCargo.isSelected()) filter.setCargoType(vehicleCargo.getText());

        ratingMin = (Integer) minPointRating.getValue();
        ratingMax = (Integer) maxPointRating.getValue();

        minDate = startDateFilter.getValue();
        maxDate = endDateFilter.getValue();


        filter.setLicenses(getSelectedLicenseNames(checkedLicenses));

        filter.setMinRate(ratingMin);
        filter.setMaxRate(ratingMax);
        filter.setMinDeadline(Date.valueOf(minDate));
        filter.setMaxDeadline(Date.valueOf(maxDate));

    }

    private ArrayList<String> getSelectedLicenseNames(ArrayList<CheckBox> checkedLicenses) {
        ArrayList<String> selectedLicenses = new ArrayList<>();
        for (CheckBox checkBox : checkedLicenses) {
            selectedLicenses.add(checkBox.getText());
        }
        return selectedLicenses;
    }




    /*public ArrayList<CheckBox> getCheckedLicenses(){
        return checkedLicenses;
    }

    public ArrayList<CheckBox> getCheckedCargoType(){
        return checkedCargoType
    }

    public int getRatingMin(){
        return ratingMin;
    }
    public int getRatingMax(){
        return ratingMax;
    }
    public LocalDate getMinDate(){
        return minDate;
    }

    public LocalDate getMaxDate(){
        return minDate;
    }*/






}
