package cse213.group24badc;

import cse213.group24badc.Mymuna2110924.DistributorDashboardController;
import cse213.group24badc.Mymuna2110924.FieldOfficerDashboardController;
import cse213.group24badc.Rabib2221005.FarmerDashboardController;
import cse213.group24badc.Rabib2221005.LogisticManagerDashboardController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;

public class MainController {

    @FXML
    private Label AboutAccount;


    @FXML
    private Pane LoginArea;

    @FXML
    private AnchorPane LoginLeftContainer;

    @FXML
    private ComboBox<String> ChoiceUserRole;

    @FXML
    private TextField LoginPassword;

    @FXML
    private TextField UserPassword;

    @FXML
    private AnchorPane LoginRightContainer;

    @FXML
    private TextField LoginUsername;

    @FXML
    private Label Report;

    @FXML
    private Pane SignUpArea1;

    @FXML
    private Pane SignUpArea2;

    @FXML
    private TextField UACity;

    @FXML
    private TextField UAPostCode;

    @FXML
    private TextField UAStreet;

    @FXML
    private TextField USState;

    @FXML
    private Label LoginReportText;

    @FXML
    private TextField UserContact;

    @FXML
    private DatePicker UserDob;

    @FXML
    private TextField UserEmail;

    @FXML
    private TextField GeneratedUsername;

    @FXML
    private TextField UserFulname;

    @FXML
    private ComboBox<String> UserGender;

    @FXML
    private ToggleButton UserLoginOptionBTN;

    @FXML
    private TextField UserNid;

    // Storing Data Start Here

    ArrayList<String> address;
    ArrayList<PW> PWList=new ArrayList<>();
    ArrayList<User> UserList=new ArrayList<>();

    private void SetDemoData(){

        Address address = new Address("Farmer1", "Mirpur1", "Dhaka", "Dhaka", 1216);

        // Create User object
        User Farmer1 = new User("Farmer1", "Farmer", "Farmer 1",
                "Farmer1@g.co", "012345", "77777777778", "Male",
                LocalDate.of(2024, 10, 30), address);

        PW pw1 = new PW("Farmer1", "1234");
        pw1.Save();
        PWList.add(pw1);

        Address address2 = new Address("Logistic1", "Mirpur1", "Dhaka", "Dhaka", 1216);

        User Logistic = new User("Logistic1", "LogisticManager", "LogisticUser 1",
                "Logistic1@g.co", "012345", "77777777778", "Male",
                LocalDate.of(2024, 10, 30), address2);

        PW pw2 = new PW("Logistic1", "1234");
        pw2.Save();
        PWList.add(pw2);

        Address address3 = new Address("Fieldofficer1", "Mirpur10", "Dhaka", "Dhaka", 1217);

        // Create User object
        User FieldOfficer = new User("Fieldofficer1", "FieldOfficer", "Field Officer ABCD",
                "FieldOfficer1@g.co", "012345", "77777777778", "Male",
                LocalDate.of(2024, 10, 30), address);

        PW pw3 = new PW("Fieldofficer1", "1234");
        pw3.Save();
        PWList.add(pw3);

        Address address4 = new Address("Distributor1", "Mirpur10", "Dhaka", "Dhaka", 1217);

        // Create User object
        User Distributor = new User("Distributor1", "Distributor", "Field Officer ABCD",
                "Distributor1@g.co", "012345", "77777777778", "Male",
                LocalDate.of(2024, 10, 30), address);

        PW pw4 = new PW("Distributor1", "1234");
        pw4.Save();
        PWList.add(pw4);

        UserList.add(Farmer1);
        UserList.add(Logistic);
        UserList.add(FieldOfficer);
        UserList.add(Distributor);

    }

    public void initialize() {
        UserGender.getItems().addAll("Male", "Female", "Other");
        ChoiceUserRole.getItems().addAll("Farmer", "Field Officer", "Logistic Manager", "Supplier", "Admin", "Manager");
        UserFulname.textProperty().addListener((observable, oldValue, newValue) -> {
            generateUsername(newValue);
        });


        SetDemoData();
    }

    // Methods Start Here
    @FXML
    void UserLoginChoiceBTN(ActionEvent event) {
        if (LoginArea.isVisible()){;
            SignUpArea1.setVisible(true);
            UserLoginOptionBTN.setText("Log In");
            LoginArea.setVisible(false);
            AboutAccount.setText("Already have an account?");

        }else {
            LoginArea.setVisible(true);
            UserLoginOptionBTN.setText("Sign up");
            SignUpArea1.setVisible(false);
            SignUpArea2.setVisible(false);
            AboutAccount.setText("Create new account?");
        }
    }


    @FXML
    String LogInCheckBTN(ActionEvent event) throws IOException {
        if (CheckValidation("Login")) {
            String UserN = LoginUsername.getText();
            String UserP = LoginPassword.getText();
            boolean loginSuccessful = false;

            for (PW pw : PWList) {
                if (pw.getUserName().equals(UserN)) {
                    if (LoginPassword.getText().equals(pw.getPassword())) {
                        LoginReportText.setText("Login Success. User: " + pw.getUserName() + " | Password: " + pw.getPassword());
                        loginSuccessful = true;

                        // Update logged-in status
                        UserList.stream()
                                .filter(user -> user.getUsername().equals(UserN))
                                .forEach(user -> user.setLoggedIn(true));

                        // Get the user data and role
                        User UserData = findUser(UserList, pw.getUserName()).orElse(null);
                        String UserROLE = UserData.getRole();

                        FXMLLoader loader = null;
                        try {
                            switch (UserROLE) {
                                case "Farmer":
                                    loader = new FXMLLoader(getClass().getResource("/cse213/group24badc/Rabib2221005/FarmerDashboard.fxml"));
                                    break;

                                case "LogisticManager":
                                    loader = new FXMLLoader(getClass().getResource("/cse213/group24badc/Rabib2221005/LogisticManagerDashboard.fxml"));
                                    break;

                                case "FieldOfficer":
                                    loader = new FXMLLoader(getClass().getResource("/cse213/group24badc/Mymuna/FieldOfficerDashboard.fxml"));
                                    break;

                                case "Distributor":
                                    loader = new FXMLLoader(getClass().getResource("/cse213/group24badc/Mymuna/DistributorDashboard.fxml"));
                                    break;

                                default:
                                    loader = new FXMLLoader(getClass().getResource("/cse213/group24badc/LoginPage.fxml"));
                            }

                            // Load the FXML file and get the controller
                            Scene scene = new Scene(loader.load(), 1350, 650);
                            Object controller = loader.getController();

                            // Initialize the controller with user data
                            if (controller instanceof FarmerDashboardController farmerController) {
                                farmerController.initialize(UserData);
                            } else if (controller instanceof LogisticManagerDashboardController logisticController) {
                                logisticController.initialize(UserData);
                            } else if (controller instanceof FieldOfficerDashboardController fieldController) {
                                fieldController.initialize(UserData);
                            } else if (controller instanceof DistributorDashboardController distributorController) {
                                distributorController.initialize(UserData);
                            }

                            // Set the scene
                            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            stage.setScene(scene);
                            stage.show();

                        } catch (IOException e) {
                            e.printStackTrace(); // Log the error for debugging
                        }
                        return pw.getUserName();
                    }
                }
            }

            if (!loginSuccessful) {
                LoginReportText.setText("Login Failed. Check Username and Password!");
            }
        } else {
            LoginReportText.setText("Login Failed. Please fill in all required fields.");
            for (User user1 : UserList) {
                System.out.println(user1.UserInfo());
            }
            System.out.println("Password: 1234");
        }


        return "No User Found";
    }


    private boolean CheckValidation(String TopicName) {
        if (Objects.equals(TopicName, "Login")) {
            return !LoginUsername.getText().isEmpty() && !LoginPassword.getText().isEmpty();
        }

        if (Objects.equals(TopicName, "SignUp")) {
            return !UserFulname.getText().isEmpty() && !UserPassword.getText().isEmpty() && !UserEmail.getText().isEmpty() && !UserContact.getText().isEmpty() && !UserNid.getText().isEmpty() && UserDob.getValue() != null && UserGender.getValue() != null && !UAStreet.getText().isEmpty() && !UACity.getText().isEmpty() && !USState.getText().isEmpty() && !UAPostCode.getText().isEmpty() && ChoiceUserRole.getValue() != null;
        }
        return false;

    };

    @FXML
    void CreteAccountNext(ActionEvent event) {

        if (CheckValidation("SignUp")) {
            String Fullname = UserFulname.getText();
            String Email = UserEmail.getText();
            String Contact = UserContact.getText();
            String Gender = UserGender.getValue();
            LocalDate Dob = UserDob.getValue();
            String Nid = UserNid.getText();
            String username = GeneratedUsername.getText();
            String Role = ChoiceUserRole.getValue();
            String Street = UAStreet.getText();
            String City = UACity.getText();
            String State = USState.getText();

            int PostCode = Integer.parseInt(UAPostCode.getText());

            Address UAddress = new Address();
            UAddress.setUserName(username);
            UAddress.setStreet( Street);
            UAddress.setCity(City);
            UAddress.setState(State);
            UAddress.setPostalCode(PostCode);

            User user = new User(username,Role, Fullname, Email, Contact, Nid, Gender, Dob, UAddress);

            UserList.add(user);

            PW CreatePW = new PW(username, UserPassword.getText());
            CreatePW.Save();
            PWList.add(CreatePW);

            SignUpArea1.setVisible(false);
            SignUpArea2.setVisible(true);

        } else  {
            System.out.println("Something error");
        }

        for (User user1 : UserList) {
            System.out.println(user1.UserInfo());
        }
    }

    @FXML
    private void generateUsername(String fullName) {
        if (fullName == null || fullName.isBlank()) {
            GeneratedUsername.setText("");
            return;
        }
        // Replace spaces with underscores
        String username = UserFulname.getText().trim().replace(" ", "_");
        // Generate a random number
        Random random = new Random();
        int randomInt = random.nextInt(100);
        // Set the generated username
        GeneratedUsername.setText(username + "_" + randomInt);
    };

    public Optional<User> findUser(ArrayList<User> UserList, String username) {
        return UserList.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst();
    }

}