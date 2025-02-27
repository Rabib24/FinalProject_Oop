package cse213.group24badc.Rabib2221005;

import cse213.group24badc.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;



public class FarmerDashboardController{

    private Boolean ShowMenu = true;

    @FXML
    private Pane AgriculturalLoanPage;

    @FXML
    private Label ApplyLoanAddress;

    @FXML
    private TextField ApplyLoanAmmount;

    @FXML
    private TextField ApplyLoanAnnualIncome;

    @FXML
    private TextField ApplyLoanAnualProduction;

    @FXML
    private TextField ApplyLoanBankAccount;

    @FXML
    private TextField ApplyLoanBankName;

    @FXML
    private Label ApplyLoanContact;

    @FXML
    private Label ApplyLoanCropsType;

    @FXML
    private TextField ApplyLoanDuration;

    @FXML
    private TextField ApplyLoanExistingDebts;

    @FXML
    private Label ApplyLoanFarmSize;

    @FXML
    private Label ApplyLoanFullname;

    @FXML
    private TextArea ApplyLoanLoanPurpose;

    @FXML
    private ComboBox<String> ApplyLoanRepaymanetMethod;

    @FXML
    private Label ApplyLoanUsername;

    @FXML
    private Button CloseMenuID;

    @FXML
    private Pane CreateNewReportPage;

    @FXML
    private Label ELFCurrentCrops;

    @FXML
    private Label ELFFertilizer;

    @FXML
    private Label ELFLandArea;

    @FXML
    private Label ELFLandOwnerName;

    @FXML
    private Label ELFSoilType;

    @FXML
    private Label ELFWaterSource;

    @FXML
    private Pane EditLandAndCropArea;

    @FXML
    private Pane EditProfilePage;

    @FXML
    private Label FD_CCrop;

    @FXML
    private Label FD_LandArea;

    @FXML
    private Label FD_TotalReportCounter;

    @FXML
    private Label FD_username;

    @FXML
    private Pane FarmerDashboardHome;

    @FXML
    private Pane LandandCropInfoPage;

    @FXML
    private AnchorPane LeftMenuArea;

    @FXML
    private AnchorPane CenterBody;

    @FXML
    private AnchorPane MenuContainer;

    @FXML
    private Label NReportCreatedDate;

    @FXML
    private TextField NReportCurrentCrop;

    @FXML
    private Label NReportFarmerFullName;

    @FXML
    private Label NReportFarmerUsername;

    @FXML
    private Label NReportLandArea;

    @FXML
    private ComboBox<Boolean> NReportPastIssue;

    @FXML
    private TextField NReportPastIssueTopic;

    @FXML
    private DatePicker NReportPlandedDate;

    @FXML
    private ComboBox<String> NReportProblemType;

    @FXML
    private TextArea NReportReportDetails;

    @FXML
    private ComboBox<Boolean> NReportRquestOfficer;

    @FXML
    private Label NReportSoilType;

    @FXML
    private Button NReportSubmitReport;

    @FXML
    private Label NReportWaterSource;

    @FXML
    private Button OpenMenuID;

    @FXML
    private Label ProfileUpdateReport;

    @FXML
    private ComboBox<String> RequestFieldOfficerExistChoice;

    @FXML
    private Pane RequestFieldOfficerNo;

    @FXML
    private Pane RequestFieldOfficerPage;

    @FXML
    private ComboBox<String> RequestFieldOfficerSelectReport;

    @FXML
    private Pane RequestFieldOfficerYes;

//    @FXML
//    private TableColumn<?, ?> ResourceCategory;
//
//    @FXML
//    private TableColumn<?, ?> ResourceDetails;
//
//    @FXML
//    private TableColumn<?, ?> ResourceName;
//
//    @FXML
//    private TableColumn<?, ?> ResourcePrice;
//
//    @FXML
//    private TableColumn<?, ?> ResourceQuantity;
//
//    @FXML
//    private TableColumn<?, ?> ResourceSelectionRow;
//
//    @FXML
//    private TableColumn<?, ?> ResourceSelectionRow1;
//
//    @FXML
//    private TableView<?> ResourceTable;

    @FXML
    private Pane ResourcesPage;

    @FXML
    private AnchorPane RightContainer;

//    @FXML
//    private TableView<?> SelectedItemRow;
//
//    @FXML
//    private TableColumn<?, ?> SelectedResource;

    @FXML
    private Label SelectedResourceItems;

//    @FXML
//    private TableColumn<?, ?> SelectedResourcePrice;
//
//    @FXML
//    private TableColumn<?, ?> SelectedResourceQuantity;

    @FXML
    private Label SelectedResourceTotalPrice;

    @FXML
    private TextField UACity;

    @FXML
    private TextField UAPostCode;

    @FXML
    private TextField UAStreet;

    @FXML
    private TextField USState;

    @FXML
    private TextField UserContact;

    @FXML
    private DatePicker UserDob;

    @FXML
    private TextField UserEmail;

    @FXML
    private TextField UserFulname;

    @FXML
    private TextField UserFulname2;

    @FXML
    private TextField UserFulname21;

    @FXML
    private TextField UserFulname22;

    @FXML
    private TextField UserFulname23;

    @FXML
    private TextField UserFulname24;

    @FXML
    private ComboBox<String> UserGender;

    @FXML
    private TextField UserNid;

    @FXML
    private Label WeatherAleartSection;

    @FXML
    private Label WeatherCloudCoverage;

    @FXML
    private Label WeatherCurTemp;

    @FXML
    private Pane WeatherForecastPage;

    @FXML
    private Label WeatherHuminidity;

    @FXML
    private Label WeatherRainProbability;

    @FXML
    private Label WeatherSunRise;

    @FXML
    private Label WeatherSunset;

    @FXML
    private Label WeatherWindDirection;

    @FXML
    private Label WeatherWindSpeed;

    @FXML
    private Button backButtonID;


    @FXML
    public void  initialize(User Farmer) {
        FD_username.setText(Farmer.getUsername());

    }


    @FXML
    void CloseMenuBTN(ActionEvent event) {
        MenuContainer.setVisible(false);
        LeftMenuArea.setMaxWidth(34);
        ShowMenu = false;
        OpenMenuID.setVisible(true);
        CloseMenuID.setVisible(false);
    }
    @FXML
    void OpenMenuBTN(ActionEvent event) {
        LeftMenuArea.setMaxWidth(280);
        MenuContainer.setVisible(true);
        ShowMenu = true;
        OpenMenuID.setVisible(false);
        CloseMenuID.setVisible(true);
    }

    @FXML
    void backButton(ActionEvent event) {

    }

    @FXML
    void ApplyFieldOfficer(ActionEvent event) {

    }

    @FXML
    void ApplyForLoan(ActionEvent event) {

    }

    @FXML
    void CloseEditLandAndCropArea(ActionEvent event) {

    }


    @FXML
    void CreateNewReportPageBtn(ActionEvent event) {
        switchToPane(CenterBody, CreateNewReportPage);
    }
    @FXML
    void ShowLoanPage(ActionEvent event) {
        switchToPane(CenterBody, AgriculturalLoanPage);
    }

    @FXML
    void RequestFieldOfficerBTN(ActionEvent event) {
        switchToPane(CenterBody, RequestFieldOfficerPage);
    }

    @FXML
    void CreteAccountNext(ActionEvent event) {

    }


    @FXML
    void RequestResourceApplyBTN(ActionEvent event) {

    }

    @FXML
    void ResourcePageBtn(ActionEvent event) {
        switchToPane(CenterBody, RequestFieldOfficerPage);

    }

    @FXML
    void ShowCreateReportPage(ActionEvent event) {
        switchToPane(CenterBody, CreateNewReportPage);
    }

    @FXML
    void ShowWeatherForecastsPage(ActionEvent event) {
        switchToPane(CenterBody, WeatherForecastPage);
    }

    @FXML
    void UploadBankStatement(ActionEvent event) {

    }

    @FXML
    void UploadFarmDocument(ActionEvent event) {

    }

    @FXML
    void UploadNID(ActionEvent event) {

    }
    @FXML
    void EditFarmerProfile(ActionEvent event) {
        switchToPane(CenterBody, EditProfilePage);
    }
    @FXML
    void OpenLandCropInfoPage(ActionEvent event) {
        switchToPane(CenterBody, LandandCropInfoPage);
    }


    @FXML
    void OpenReportPage(ActionEvent event) {
        switchToPane(CenterBody, LandandCropInfoPage);
    }


    @FXML
    private void switchToPane(AnchorPane mainPane, Pane targetPane) {
        // Loop through all child nodes in the main AnchorPane
        for (var node : mainPane.getChildren()) {
            if (node instanceof Pane) {
                // Hide all panes
                node.setVisible(false);
            }
        }
        // Show the target pane
        targetPane.setVisible(true);
    }


}