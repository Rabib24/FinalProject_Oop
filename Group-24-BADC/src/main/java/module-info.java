module cse213.group24badc {
    requires javafx.controls;
    requires javafx.fxml;


    opens cse213.group24badc to javafx.fxml;
    exports cse213.group24badc;

    opens cse213.group24badc.Rabib2221005 to javafx.fxml;
    exports cse213.group24badc.Rabib2221005;

    opens cse213.group24badc.Mymuna to javafx.fxml;
    exports cse213.group24badc.Mymuna2110924;
}