import java.util.Date;

public class PosPago extends Telefonia{ // herda da classe Telefonia

    private float assinatura;

    public PosPago(long cpf, String nome, int numero, float assinatura){

    }

    public void fazerChamada(Date data, int duracao){

    }

    public void imprimirFatura(int mes){

    }

    public float getAssinatura() {
        return assinatura;
    }

    public void setAssinatura(float assinatura) {
        this.assinatura = assinatura;
    }


}
