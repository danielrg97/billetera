package model;

public class Billetera {
    //Instancia unica
    private static Billetera billetera;

    private Long dinero=0L;

    //Constructor privado para no crear mas de 1 instancia
    private Billetera(){}

    /**
     * Metodo para obtener instancia de billetera
     * @return instancia
     */
    public static Billetera getInstance(){
        if(billetera==null){
            billetera = new Billetera();
        }
        return billetera;
    }

    /**
     * Metodo para ingresar dinero a la billetera
     * @param dinero
     * @return saldo total
     */
    public Long agregarDinero(Long dinero){
        this.dinero += dinero;
        System.out.printf("\033[32m \nINFO: Se agregaron %d $. \nSaldo actual: %d $ \033[30m", dinero, this.dinero);
        return this.dinero;
    }

    /**
     * Metodo para retirar dinero de la billetera
     * @param dinero
     * @return
     */
    public Long retirarDinero(Long dinero){
        if(dinero <= this.dinero){
            this.dinero -= dinero;
            System.out.printf("\033[32m \nINFO: Se retiraron %d $. \nSaldo actual: %d $ \033[30m", dinero, this.dinero);
            return this.dinero;
        }else{
            System.out.println("\033[31m \nINFO: Fondos insuficientes. \033[30m");
            return this.dinero;
        }
    }

    /**
     * Metodo para consultar el dinero que hay en la billetera
     * @return
     */
    public Long consultarSaldo(){
        System.out.printf("\033[31m \nINFO: Saldo actual: %d $. \033[30m", this.dinero);
        return this.dinero;
    }

}
