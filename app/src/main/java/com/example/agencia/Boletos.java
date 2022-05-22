package com.example.agencia;

import java.util.Objects;

public class Boletos {
    // Atributos
    private int numBoleto;
    private String nomCliente;
    private String destino;
    private String tipoViaje;
    private double precio;
    private String fecha;

    // Constructores

    // Constructor Vacio
    public Boletos(){
        this.setNumBoleto(0);
        this.setNomCliente("");
        this.setDestino("");
        this.setTipoViaje("");
        this.setPrecio(0.0);
        this.setFecha("");
    }

    // Constructor de Parametros
    public Boletos(int numBoleto, String nomCliente, String destino, String tipoViaje, double precio, String fecha){
        this.setNumBoleto(numBoleto);
        this.setNomCliente(nomCliente);
        this.setDestino(destino);
        this.setTipoViaje(tipoViaje);
        this.setPrecio(precio);
        this.setFecha(fecha);
    }

    // Constructor Vacio
    public Boletos(Boletos boletos){
        this.setNumBoleto(boletos.getNumBoleto());
        this.setNomCliente(boletos.getNomCliente());
        this.setDestino(boletos.getDestino());
        this.setTipoViaje(boletos.getTipoViaje());
        this.setPrecio(boletos.getPrecio());
        this.setFecha(boletos.getFecha());
    }

    public int getNumBoleto() {
        return numBoleto;
    }

    public void setNumBoleto(int numBoleto) {
        this.numBoleto = numBoleto;
    }

    public String getNomCliente() {
        return nomCliente;
    }

    public void setNomCliente(String nomCliente) {
        this.nomCliente = nomCliente;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getTipoViaje() {
        return tipoViaje;
    }

    public void setTipoViaje(String tipoViaje) {
        this.tipoViaje = tipoViaje;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double calcularSubTotal(){
        double subTotal = 0.0;
        if(Objects.equals(this.tipoViaje, "Sencillo")){ subTotal = this.precio; }
        else if(Objects.equals(this.tipoViaje, "Doble")){ subTotal = this.precio * 1.80; }
        return subTotal;
    }

    public double calcularImpuesto(){
        double impuesto = 0.0;
        impuesto = this.calcularSubTotal() * 0.16;
        return impuesto;
    }

    public double calcularDescuento(int edad){
        double descuento = 0.0;
        if(edad>=60){ descuento = this.calcularSubTotal() * 0.50; }
        return descuento;
    }

    public double calcularTotal(int edad){
        double total = 0.0;
        total = this.calcularSubTotal() + this.calcularImpuesto() - this.calcularDescuento(edad);
        return total;
    }

}
