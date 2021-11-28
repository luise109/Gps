package main.controlador;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import main.modelo.Nmea;
import java.util.ArrayList;
import java.util.List;

public class Mapa {

    public void start(List<Nmea> lista) throws Exception {


            Stage stage = new Stage();
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    WebEngine webEngine = new WebEngine();
                    final WebView webView = new WebView();
                    webEngine = webView.getEngine();
                    webEngine.loadContent("<!DOCTYPE html>\n" +
                            "\n" +
                            "<html>\n" +
                            "<head>\n" +
                            "    <title>Manejo de Mapas</title>\n" +
                            "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
                            "    <script type=\"text/javascript\" src=\"https://maps.google.com/maps/api/js?key=AIzaSyBVkEOsj1jMH_4NTp6I-RjY9RbR9ZM6jdA\"></script>\n" +
                            "    <script type=\"text/javascript\">\n" +
                            "        function mostrar_mapa(centinela){\n" +
                            "            //Ubicación inicial del mapa.\n" +
                            "            var ubicacion = new google.maps.LatLng(16.614813, -93.090915); //Latitud y Longitud\n" +
                            "            //Parámetros Iniciales\n" +
                            "            var opciones={zoom:15, //acercamiento\n" +
                            "                center: ubicacion,\n" +
                            "                mapTypeId: google.maps.MapTypeId.SATELLITE //Las posibles opciones son ROADMAP/SATELLITE/HYBRID/TERRA\n" +
                            "            };\n" +
                            "\n" +
                            "            //Creacion del mapa\n" +
                            "            var map = new google.maps.Map(document.getElementById(\"mapa\"),opciones);\n" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "        }\n" +
                            "\n" +
                            "        function initMap() {\n" +
                            "\n" +
                            "            var waypoints = [\n" +
                            "                {location: {lat:" + lista.get(1).getLat() + ", lng:" + lista.get(1).getLon() +"}, stopover: true},\n" +
                            "                {location: {lat:" + lista.get(2).getLat() + ", lng:" + lista.get(2).getLon() +"}, stopover: true},\n" +
                            "                {location: {lat:" + lista.get(3).getLat() + ", lng:" + lista.get(3).getLon() +"}, stopover: true},\n" +
                            "                {location: {lat:" + lista.get(4).getLat() + ", lng:" + lista.get(4).getLon() +"}, stopover: true},\n" +
                            "                {location: {lat:" + lista.get(5).getLat() + ", lng:" + lista.get(5).getLon() +"}, stopover: true},\n" +
                            "                {location: {lat:" + lista.get(6).getLat() + ", lng:" + lista.get(6).getLon() +"}, stopover: true},\n" +
                            "                {location: {lat:" + lista.get(7).getLat() + ", lng:" + lista.get(7).getLon() +"}, stopover: true},\n" +
                            "                {location: {lat:" + lista.get(8).getLat() + ", lng:" + lista.get(8).getLon() +"}, stopover: true},\n" +
                            "                {location: {lat:" + lista.get(9).getLat() + ", lng:" + lista.get(9).getLon() +"}, stopover: true},\n" +
                            "                {location: {lat:" + lista.get(10).getLat() + ", lng:" + lista.get(10).getLon() +"}, stopover: true},\n" +
                            "                {location: {lat:" + lista.get(11).getLat() + ", lng:" + lista.get(11).getLon() +"}, stopover: true},\n" +
                            "                {location: {lat:" + lista.get(12).getLat() + ", lng:" + lista.get(12).getLon() +"}, stopover: true},\n" +
                            "                {location: {lat:" + lista.get(13).getLat() + ", lng:" + lista.get(13).getLon() +"}, stopover: true},\n" +
                            "                {location: {lat:" + lista.get(14).getLat() + ", lng:" + lista.get(14).getLon() +"}, stopover: true},\n" +
                            "                {location: {lat:" + lista.get(15).getLat() + ", lng:" + lista.get(15).getLon() +"}, stopover: true},\n" +
                            "                {location: {lat:" + lista.get(16).getLat() + ", lng:" + lista.get(16).getLon() +"}, stopover: true},\n" +
                            "                {location: {lat:" + lista.get(17).getLat() + ", lng:" + lista.get(17).getLon() +"}, stopover: true},\n" +
                            "                {location: {lat:" + lista.get(18).getLat() + ", lng:" + lista.get(18).getLon() +"}, stopover: true},\n" +
                            "                {location: {lat:" + lista.get(19).getLat() + ", lng:" + lista.get(19).getLon() +"}, stopover: true},\n" +
                            "                {location: {lat:" + lista.get(20).getLat() + ", lng:" + lista.get(20).getLon() +"}, stopover: true},\n" +
                            "                {location: {lat:" + lista.get(21).getLat() + ", lng:" + lista.get(21).getLon() +"}, stopover: true},\n" +
                            "                {location: {lat:" + lista.get(22).getLat() + ", lng:" + lista.get(22).getLon() +"}, stopover: true},\n" +
                            "                {location: {lat:" + lista.get(23).getLat() + ", lng:" + lista.get(23).getLon() +"}, stopover: true},\n" +
                            "            ];\n" +
                            "\n" +
                            "            var objConfigDS = {\n" +
                            "                origin: new google.maps.LatLng("+lista.get(0).getLat()+", "+ lista.get(0).getLon()+"),\n" +
                            "                destination: new google.maps.LatLng("+lista.get(lista.size()-1).getLat()+","+ lista.get(lista.size()-1).getLon() +"),\n" +
                            "                travelMode: google.maps.TravelMode.DRIVING,\n" +
                            "                waypoints: waypoints\n" +
                            "            };\n" +
                            "\n" +
                            "            gMapa = new google.maps.Map(document.getElementById(\"mapa\"), {\n" +
                            "                zoom: 15,\n" +
                            "                center: objConfigDS.origin\n" +
                            "            });\n" +
                            "\n" +
                            "            var objConfigDR = {\n" +
                            "                map: gMapa,\n" +
                            "                suppressMarkers: false,\n" +
                            "                draggable: true,\n" +
                            "                getClickable: true\n" +
                            "            }\n" +
                            "\n" +
                            "        var ds = new google.maps.DirectionsService();\n" +
                            "        var dr = new google.maps.DirectionsRenderer(objConfigDR);\n" +
                            "\n" +
                            "            ds.route(objConfigDS, function(result, status) {\n" +
                            "            if (status == google.maps.DirectionsStatus.OK) {\n" +
                            "                dr.setDirections(result);\n" +
                            "            }\n" +
                            "        });\n" +
                            "        }\n" +
                            "\n" +
                            "    </script>\n" +
                            "</head>\n" +
                            "<center>\n" +
                            "    <body onload=\"mostrar_mapa(0)\">\n" +
                            "\n" +
                            "\n" +
                            "    <div id=\"mapa\" style=\"width: 1280px; height: 720px; border: 1px groove #006600;\"></div>\n" +
                            "    <input type=\"button\" value=\"Reiniciar Mapa\" onclick=\"mostrar_mapa(0)\"/>\n" +
                            "    <input type=\"button\" value=\"Trazar Ruta\" onclick=\"initMap()\"/>\n" +
                            "    </body>\n" +
                            "</center>\n" +
                            "</html>");

                    //mostrar mapa
                    webEngine.getTitle();
                    // crear el Scene
                    stage.setTitle("Gugul Maps");
                    Scene scene = new Scene(webView,1300,800, Color.web("#666970"));
                    stage.setScene(scene);
                    // mostrar la ventana
                    stage.show();

                }
            });


    }


}