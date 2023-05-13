import java.time.Month;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class PrePago extends Assinante{

    private float creditos;
    private int numRecarga;
    private Recarga[] recargas;
    private Chamada[] chamadas;

    public PrePago(long cpf, String nome, int numero, float creditos, int numRecarga) {
        super(cpf, nome, numero); // chama o contrutor da classe Assinante
        this.recargas = new Recarga[10];
        this.creditos = creditos;
        this.numRecarga = numRecarga;
    }

    public void fazerChamada(GregorianCalendar data, int duracao) {
        double custoChamada = 1.45 * duracao; //Valor da chamada

        if(numChamadas < chamadas.length){ // verifier se ha espaco no vetor para armazer as chamadas
            if(creditos >= recargas.length){ // verifica se o creditos é maior ou igual ao quantidade de recarga
                chamadas[numChamadas] = new Chamada(data, duracao);
                numChamadas++;
                creditos -= custoChamada;
                System.out.println("Chamada realizada com sucesso!!");
            }
            else{
                System.out.println("Saldo insuficiente para realizar a chamada");
            }
            System.out.println("Número de chamadas excedidas");
        }
    }

    public void recarregar(GregorianCalendar data, float valor) {
        if(numRecarga < recargas.length){
            Recarga recarga = new Recarga(data, valor); // cria um objeto recarga com a data e valor

            recargas[numRecarga] = recarga;// armazena a recarga no vetor racarga
            numRecarga++; // atualiza o numero de recargas

            creditos += valor;
        }
        else {
            System.out.println("Não é possivel fazer mais recargas");
        }
    }

    public void imprimirFatura(int mes)  {
        double totalFatura = 0;

        Assinante assinante = new Assinante(getCpf(), null, 0); // dados do assinante
        System.out.println("Dados do Assinante\n" + assinante.toString()); // imprime o toString dos dados

        // Numero de chamadas
        System.out.println("Chamadas");
        int totalChamadas = 0;
        for (Chamada chamada : chamadas) {
            if (chamada.getData().get(GregorianCalendar.MONTH) == mes) { // se o numero de chamadas for no mes da fatura
                System.out.println(chamadas.toString()); // imprime as chamdas do mes
                totalChamadas += chamada.getDuracao() * 1.45; // soma no total da fatura
            }
        }

        // Numero de recargas
        System.out.println("Recargas");
        double totalRecargas = 0;
        for(Recarga recarga : recargas){
            if(recarga.getData().get(Calendar.MONTH) == mes) {
                System.out.println(recarga.toString());
                totalRecargas += recarga.getValor();
            }
        }

        //Imprime o valor das chamadas e recargas no mês
        System.out.println("Valor da fatura: R$" + totalFatura); //impreme o valor total da fatura
        System.out.println("Valor da recargas: R$" + totalRecargas); //impreme o valor total da fatura
        System.out.println("Valor da fatura: R$" + creditos); //impreme os Creditos

        double totalFaturaPrePago = 0;
        if(totalFaturaPrePago > 0){
            System.out.println("Valor total da fatura: R$" + totalFaturaPrePago);
        }
        else {
            System.out.println("Creditos remanescentes: R$" + (-totalFaturaPrePago));
        }
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
