import java.util.Calendar;
import java.util.GregorianCalendar;

public class PrePago extends Assinante {

    private float creditos;
    private int numRecarga;
    private Recarga[] recargas;

    public PrePago(long cpf, String nome, int numero, float creditos, int numRecarga) {
        super(cpf, nome, numero); // chama o contrutor da classe Assinante
        this.recargas = new Recarga[10];
        this.creditos = creditos;
        this.numRecarga = numRecarga;
    }

    public void fazerChamada(GregorianCalendar data, int duracao) {
        double custoChamada = 1.45 * duracao; //Valor da chamada

        if (numChamadas < chamadas.length) { // verifier se ha espaco no vetor para armazer as chamadas
            if (creditos >= custoChamada) { // verifica se o creditos é maior ou igual ao custo da chamada de recarga
                this.chamadas[numChamadas] = new Chamada(data, duracao);
                numChamadas++;
                creditos -= custoChamada;
                System.out.println("Chamada realizada com sucesso!!");
            } else {
                System.out.println("Saldo insuficiente para realizar a chamada");
            }

        }
        else
            System.out.println("Número de chamadas excedidas");
    }

    public void fazerRecarga(GregorianCalendar data, float valor) {
        if (numRecarga < recargas.length) {
            Recarga recarga = new Recarga(data, valor); // cria um objeto recarga com a data e valor

            this.recargas[numRecarga] = recarga;// armazena a recarga no vetor racarga
            numRecarga++; // atualiza o numero de recargas

            creditos += valor;
        } else {
            System.out.println("Não é possivel fazer mais recargas");
        }
    }

    public void imprimirFatura(int mes) {

        System.out.println("Dados do Assinante\n" + toString()); // imprime o toString dos dados

        // Numero de chamadas
        System.out.println("Chamadas");
        int totalChamadas = 0;
        for (Chamada chamada : chamadas) {
            if (chamada == null){
                break;
            }
            if (chamada.getData().get(GregorianCalendar.MONTH) == mes) { // se o numero de chamadas for no mes da fatura
                System.out.println(chamada.toString()); // imprime as chamdas do mes
                totalChamadas += chamada.getDuracao() * 1.45; // soma no total da fatura
            }
        }
        System.out.println("\nValor total de chamadas feitas no mês: " + totalChamadas); //imprime o valor total de chamadas feitas no mês
        // Numero de recargas
        System.out.println("Recargas");
        double totalRecargas = 0;
        for (Recarga recarga : recargas) {
            if(recarga == null){
                break;
            }
            if (recarga.getData().get(Calendar.MONTH) == mes) {
                System.out.println(recarga.toString());
                totalRecargas += recarga.getValor();
            }
        }
        //Imprime o valor das chamadas e recargas no mês
        System.out.println("\nValor da recargas: R$" + totalRecargas); //imprime o valor total de recargas
        System.out.println("Crédito restante: R$" + creditos); //imprime os Creditos
    }
}