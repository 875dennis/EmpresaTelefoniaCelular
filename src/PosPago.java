import java.net.StandardSocketOptions;
import java.util.GregorianCalendar;

public class PosPago extends Assinante{ // herda da classe Assinante

    private float assinatura;

    public PosPago(long cpf, String nome, int numero, float assinatura){
        super(cpf, nome, numero); // chama os atributos da classe Assinante
        this.assinatura = assinatura;
        this.numChamadas = 0; // igualando a zero a variavel que numChmadas que esta na classe Assinante
    }

    public void fazerChamada(GregorianCalendar data, int duracao){
        if(numChamadas < chamadas.length) { // Verifica se ainda tem espaço no vetor
            chamadas[numChamadas] = new Chamada(data, duracao); // instancia nova chamada com a data e hora
            numChamadas++;
            double valorChamada = duracao * 1.04; // multiplica a duracao das chamadas
            System.out.println("O valor da chamada foi: R$" + valorChamada);
        }
        else {
            System.out.println("Não foi possivel realizar a chamada!");
        }
    }

    public void imprimirFatura(int mes){
        double totalFaturaPosPago = 0;

        System.out.println("Dados do Assinante\n" + toString()); // imprime o toString dos dados

        for (Chamada chamada : chamadas){ //Inicia um loop for-each que percorre o vetor "chamadas" do tipo Chamada
            if (chamada == null){
                break;
            }
            if (chamada.getData().get(GregorianCalendar.MONTH) == mes); // se o numero de chamadas for no mes da fatura
            System.out.println(chamada.toString()); // imprime as chamdas do mes
            System.out.println("Valor total dessa chamada: " + chamada.getDuracao()*1.04);
            totalFaturaPosPago += chamada.getDuracao() * 1.04; // soma no total da fatura
        }

        System.out.println("Valor da fatura: R$" + totalFaturaPosPago); //impreme o valor total da fatura

    }

}