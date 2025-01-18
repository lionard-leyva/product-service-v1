package com.oneclick.productservice.nala.oop;

public class CertificacionAction extends BaseAction {

    @Override
    public void guardarDatos() {
        String execute = super.execute();
        System.out.println("Execute from CertificacionAction: " + execute);
        System.out.println("Guardando certificacion");
    }
}
