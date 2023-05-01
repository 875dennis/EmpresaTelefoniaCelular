import java.util.Date;
import java.util.GregorianCalendar;

public class PosPago extends Assinante{ // herda da classe Telefonia

    private float assinatura;
    private Chamada[] chamadas; // Vetor de chamada

    public PosPago(long cpf, String nome, int numero, float assinatura){
        super(cpf, nome, numero); // chama os atributos da classe Assinante
        this.assinatura = assinatura;
        this.chamadas = new Chamada[100]; // vetor com 100 chamadas
        numChamadas = 0; // igualando a zero a variavel que numChmadas que esta na classe Assinante
    }

    public void fazerChamada(GregorianCalendar data, int duracao){
        if(numChamadas < 100) { // Verifica se ainda tem espaço no vetor
            Chamada novaChamada = new Chamada(data, duracao); // instancia nova chamada com a data e hora
            chamadas[numChamadas] = novaChamada; // armazena as chamadas no vetor
            numChamadas++;
            double valorChamada = duracao * 1.04; // multiplica a duracao das chamadas
            System.out.println("O valor da chamada foi: R$" + valorChamada);
        }
        else {
            System.out.println("Não foi possivel realizar a chamada!");
        }
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
