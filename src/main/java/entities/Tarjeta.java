package main.java.entities;

import javax.persistence.Entity;

@Entity
public class Tarjeta extends BaseEntity{

    private int numero;

    private double valor;

    public Tarjeta() {
        super();   
    }
    public Tarjeta(int numero)
    {
    	this.numero=numero;
    	valor=0;
    }

    public int darNumero(){
        return numero;
    }

    public void setNumero(int numero){
        this.numero=numero;
    }

    public double getValor(){
        return valor;
    }

    public void setValor(double valor)
    {
        this.valor=valor;
    }
}
