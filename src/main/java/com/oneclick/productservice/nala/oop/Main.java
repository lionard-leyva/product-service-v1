package com.oneclick.productservice.nala.oop;

public class Main {
    public static void main(String[] args) {
        BaseAction certificacionAction = new CertificacionAction();
        certificacionAction.execute();
        certificacionAction.guardarDatos();
    }
}
