package main.modelo;

public class Nmea <E> {

    private Double lat;
    private Double lon;
    private int lgrados;
    private int lminutos;
    private int lsegundos;
    private int grados;
    private int minutos;
    private int segundos;
    private String latitud;
    private String longitud;
    private String utc;
    private String nombre;

    public Nmea() {
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Nmea(Double lat, Double lon, int lgrados, int lminutos, int lsegundos, int grados, int minutos, int segundos, String latitud, String longitud, String utc, String nombre) {
        this.lat = lat;
        this.lon = lon;
        this.lgrados = lgrados;
        this.lminutos = lminutos;
        this.lsegundos = lsegundos;
        this.grados = grados;
        this.minutos = minutos;
        this.segundos = segundos;
        this.latitud = latitud;
        this.longitud = longitud;
        this.utc = utc;
        this.nombre = nombre;
    }

    public Nmea(int lgrados, int lminutos, int lsegundos, int grados, int minutos, int segundos, String latitud, String longitud, String utc, String nombre) {
        this.lgrados = lgrados;
        this.lminutos = lminutos;
        this.lsegundos = lsegundos;
        this.grados = grados;
        this.minutos = minutos;
        this.segundos = segundos;
        this.latitud = latitud;
        this.longitud = longitud;
        this.utc = utc;
        this.nombre = nombre;
    }

    public int getLgrados() {
        return lgrados;
    }

    public void setLgrados(int lgrados) {
        this.lgrados = lgrados;
    }

    public int getLminutos() {
        return lminutos;
    }

    public void setLminutos(int lminutos) {
        this.lminutos = lminutos;
    }

    public int getLsegundos() {
        return lsegundos;
    }

    public void setLsegundos(int lsegundos) {
        this.lsegundos = lsegundos;
    }

    public int getGrados() {
        return grados;
    }

    public void setGrados(int grados) {
        this.grados = grados;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getUtc() {
        return utc;
    }

    public void setUtc(String utc) {
        this.utc = utc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
