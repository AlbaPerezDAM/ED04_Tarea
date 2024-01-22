package cuentas;

public class CCuenta {


    private String nombre;
    private String cuenta;
    private double saldo;
    private double tipoInterés;

    public CCuenta()
    {
    }

    public CCuenta(String nom, String cue, double sal, double tipo)
    {
        nombre =nom;
        cuenta=cue;
        saldo=sal;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo (double saldo){
        this.saldo = saldo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre (String nombre) {
        this.nombre = nombre;
    }
    public String getCuenta(){
        return cuenta;
    }
    public void setCuenta (String cuenta) {
        this.cuenta = cuenta;
    }
    public double getTipoInterés(){
        return tipoInterés;
    }
    public void setTipoInterés(double tipoInterés) {
        this.tipoInterés = tipoInterés;
    }
    public double estado()
    {
        return getSaldo();
    }

    public void ingresar(double cantidad) throws Exception
    {
        if (cantidad<0)
            throw new Exception("No se puede ingresar una cantidad negativa");
        setSaldo(getSaldo() + cantidad);
    }

    public void retirar(double cantidad) throws Exception
    {
        if (cantidad <= 0)
            throw new Exception ("No se puede retirar una cantidad negativa");
        if (estado()< cantidad)
            throw new Exception ("No se hay suficiente saldo");
        setSaldo(getSaldo() - cantidad);
    }

    public void operativa_cuenta (CCuenta cuenta, float cantidad) throws Exception
    {
        double saldoActual;

            saldoActual = cuenta.getSaldo();
            System.out.println("El saldo actual es"+ saldoActual );

        try {
            cuenta.retirar(cantidad);
        } catch (Exception e) {
        System.out.print("Fallo al retirar");
        }
        try {
            System.out.println("Ingreso en cuenta");
            cuenta.ingresar(cantidad);
        } catch (Exception e) {
            System.out.print("Fallo al ingresar");
        }
    }
}