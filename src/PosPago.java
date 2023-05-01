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
        double totalFatura = assinatura;

        Assinante assinante = new Assinante(getCpf(), null, 0); // dados do assinante
        System.out.println("Dados do Assinante\n" + assinante.toString()); // imprime o toString dos dados

        for (int i = 0; i < numChamadas; i++){
            if(chamadas[i].getData().get(GregorianCalendar.MONTH) == mes); // se o numero de chamadas for no mes da fatura
            System.out.println(chamadas[i].toString()); // imprime as chamdas do mes
            totalFatura += chamadas[i].getDuracao() * 1.04; // soma no total da fatura
        }

        System.out.println("Valor da fatura: R$" + totalFatura); //impreme o valor total da fatura

    }

    public float getAssinatura() {
        return assinatura;
    }

    public void setAssinatura(float assinatura) {
        this.assinatura = assinatura;
    }


}
