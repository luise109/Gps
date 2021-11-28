package main.controlador;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import main.modelo.Nmea;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TablaController {

    @FXML
    private TableView<Nmea> tabla;

    @FXML
    private TableColumn<Nmea, Integer> grados;

    @FXML
    private TableColumn<Nmea, Integer> lGrados;

    @FXML
    private TableColumn<Nmea, Integer> lMinutos;

    @FXML
    private TableColumn<Nmea, Integer> lSegundos;

    @FXML
    private TableColumn<Nmea, String> latitud;

    @FXML
    private TableColumn<Nmea, String> longitud;

    @FXML
    private TableColumn<Nmea, Integer> minutos;

    @FXML
    private TableColumn<Nmea, String> nombre;

    @FXML
    private TableColumn<Nmea, Integer> segundos;

    @FXML
    private TableColumn<Nmea, String> lat;

    @FXML
    private TableColumn<Nmea, Integer> lon;

    @FXML
    private TableColumn<Nmea, String> utc;
    private MenuController main;
    MenuController menuController = new MenuController();

    ObservableList<Nmea> list = menuController.leer("GPGGA", 15, menuController.abrirDocumento());

    public TablaController() throws IOException {
    }

    private void cargarTabla(ObservableList <Nmea> lista2) {
        grados.setCellValueFactory(new PropertyValueFactory<Nmea, Integer>("grados"));
        minutos.setCellValueFactory(new PropertyValueFactory<Nmea,Integer>("minutos"));
        segundos.setCellValueFactory(new PropertyValueFactory<Nmea,Integer>("segundos"));
        latitud.setCellValueFactory(new PropertyValueFactory<Nmea,String>("latitud"));
        longitud.setCellValueFactory(new PropertyValueFactory<Nmea,String>("longitud"));
        utc.setCellValueFactory(new PropertyValueFactory<Nmea,String>("utc"));
        nombre.setCellValueFactory(new PropertyValueFactory<Nmea,String>("nombre"));
        lGrados.setCellValueFactory(new PropertyValueFactory<Nmea,Integer>("lgrados"));
        lMinutos.setCellValueFactory(new PropertyValueFactory<Nmea,Integer>("lminutos"));
        lSegundos.setCellValueFactory(new PropertyValueFactory<Nmea,Integer>("lsegundos"));
        lat.setCellValueFactory(new PropertyValueFactory<Nmea,String>("lat"));
        lon.setCellValueFactory(new PropertyValueFactory<Nmea,Integer>("lon"));
        tabla.setItems(lista2);

    }




    @FXML
    private void initialize() throws Exception {

                List<Nmea> lista = new ArrayList();

        char w = 'W';
        char s = 'S';
        int x=1;

        // pone negativos dependiendo de la direccion
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getLatitud().equals(String.valueOf(s))) {
                list.get(i).setLat(list.get(i).getLat() * -1);
            }
            if (list.get(i).getLongitud().equals((String.valueOf(w))) )
            {
                list.get(i).setLon(list.get(i).getLon() * -1);
            }
        }

        //frecuencia de Muestras
        for (int i = 0; i < list.size(); i++) {

            if(1*x == i)
            {
                lista.add(list.get(i));
                x++;
            }
        }

        //Discriminar repetidos
        boolean repetido = false;
        do
        {
            repetido = false;
            for (int i = 1; i < lista.size(); i++) {
                if (lista.get(i).getLsegundos() == lista.get(i-1).getLsegundos()) {
                    if (lista.get(i).getSegundos() == lista.get(i-1).getSegundos()) {
                        lista.remove(i);
                        repetido = true;
                    }
                }

            }
        }while(repetido == true);


        //borrar ultimo elemento

        //dividir entre cantidad total de puntos
        int size = lista.size()/25;

        List <Nmea> lista2 = new ArrayList();
        lista2.add(lista.get(0));
        for(int i = 0; i < 25; i++)
        {
            lista2.add(lista.get(size*i));
        }
        lista2.remove(0);
        lista2.add(lista.get(lista.size()-1));




                cargarTabla(FXCollections.observableArrayList(lista2));

                Mapa mapa = new Mapa();
                mapa.start(lista2);





    }

}
