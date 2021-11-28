package main.controlador;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import main.Main;
import main.modelo.Nmea;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MenuController {

    @FXML
    public Button gga;

    //funcion para cargar el archivo
    @FXML
    File abrirDocumento() throws IOException {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Buscar Archivo");
            File textFile = null;
            try
            {

                fileChooser.getExtensionFilters().addAll(
                        new FileChooser.ExtensionFilter("TXT", "*.txt")
                );


                textFile = fileChooser.showOpenDialog(null);
                return textFile;
            }catch (Exception e)
            {
                System.out.println("Error al abrir el archivo");
            }



        menuSeleccion();
        return null;
    }

    //vista del menu
    void menuSeleccion() throws IOException {
        Main.popUp("MenuSeleccion","Elige codigo");
    }

    //activar la aplicacion
    @FXML
    void mGga(ActionEvent event) throws IOException {
        tabla();


        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }


    //MostrarValores en la tabla
    ObservableList leer(String cordenada, int n, File textFile) throws IOException {

        List<Nmea> lista = new ArrayList<>();
        char[] nombre = new char[6];
        BufferedReader contenedor = new BufferedReader(new FileReader(textFile));
        String texto;
        String[] partes;
        try
        {
            while((texto=contenedor.readLine()) != null){
                for (int i = 1;i<6;i++){
                    nombre [i-1] = texto.charAt(i);
                }
                if (nombre[0] == cordenada.charAt(0) && nombre[1] == cordenada.charAt(1) && nombre[2] == cordenada.charAt(2) && nombre[3] == cordenada.charAt(3) && nombre[4] == cordenada.charAt(4)){
                    partes = texto.split((","),n);
                    try {
                        Double vLongitud = Double.parseDouble(partes[4].charAt(0) + "" + partes[4].charAt(1) + partes[4].charAt(2));
                        Double vLongitud2 = Double.parseDouble(partes[4].charAt(3) + "" + partes[4].charAt(4) + partes[4].charAt(5) + partes[4].charAt(6) + partes[4].charAt(7) + partes[4].charAt(8) + partes[4].charAt(9));
                        vLongitud2 = vLongitud2 / 60;
                        vLongitud = vLongitud + vLongitud2;
                        int lgrados = vLongitud.intValue();
                        int lminutos = (int) ((vLongitud - lgrados) * 60);
                        int lsegundos = (int) ((((vLongitud - lgrados) * 60) - lminutos) * 60);
                        Double vLatitud = Double.parseDouble((partes[2].charAt(0) + "" + partes[2].charAt(1)));
                        Double vLatitud2 = Double.parseDouble((partes[2].charAt(2) + "" + partes[2].charAt(3) + partes[2].charAt(4) + partes[2].charAt(5) + partes[2].charAt(6) + partes[2].charAt(7) + partes[2].charAt(8) + partes[2].charAt(9)));
                        vLatitud2 = vLatitud2 / 60;
                        vLatitud = vLatitud + vLatitud2;
                        int grados = vLatitud.intValue();
                        int minutos = (int) ((vLatitud - grados) * 60);
                        int segundos = (int) ((((vLatitud - grados) * 60) - minutos) * 60);

                        String latitud = partes[3];
                        String longitud = partes[5];
                        String min = partes[1].charAt(2) + "" + partes[1].charAt(3) + "mm";
                        String seg = partes[1].charAt(4) + "" + partes[1].charAt(5) + "ss";
                        String hrs = partes[1].charAt(0) + "" + partes[1].charAt(1) + "hrs";
                        String utc = hrs + " " + min + " " + seg;
                        String name = partes[0];
                        Nmea nmea = new Nmea(vLatitud,vLongitud,lgrados, lminutos, lsegundos, grados, minutos, segundos, latitud, longitud, utc, name);
                        lista.add(nmea);
                    }
                    catch (Exception e){

                    }

                }

                }
        }catch (IOException e){
            System.out.println("Error al leer");
        }

        contenedor.close();
        ObservableList valores = FXCollections.observableArrayList(lista);
        return valores;
    }


    public void tabla() throws IOException {

        Main.popUp("MostrarValores", "MostrarValores");

    }

}
