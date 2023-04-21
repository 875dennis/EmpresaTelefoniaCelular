import java.util.Date;

public class PrePago extends Telefonia{

    private float creditos;
    private int numRecarga;

    public PrePago(long cpf, String nome, int numero) {

    }

    public void recarregar(Date data, float valor) {

    }

    public void fazerChamada(Date data, int duracao) {

    }

    public void imprimirFatura(int mes) {

    }

    public float getCreditos() {
        return creditos;
    }

    public void setCreditos(float creditos) {
        this.creditos = creditos;
    }

    public int getNumRecarga() {
        return numRecarga;
    }

    public void setNumRecarga(int numRecarga) {
        this.numRecarga = numRecarga;
    }

}
