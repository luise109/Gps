module Gps {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    opens main;
    opens main.controlador;
    opens main.modelo;

}