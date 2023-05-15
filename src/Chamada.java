// import da biblioteca da data

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Date;

// iniciando
public class Chamada {
    private GregorianCalendar data;
    private int duracao;

    //construtor
    public Chamada(GregorianCalendar data, int duracao) {
        this.data = data;
        this.duracao = duracao;
    }


    //devolve atributo
    public GregorianCalendar getData() {
        return data;
    }

    public int getDuracao() {
        return duracao;
    }

    //parte que mostra a escrita da chamada realizada, a data formatada

    @Override //uma sobrescrita de um método existente
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); //instanciando obj dateFormat
        String dataFormatada = dateFormat.format(data.getTime()); //formatando uma data em uma representação de string
        return "Chamada realizada em " + dataFormatada + " com duração de " + duracao + " minutos"; //retornando a chamada duração e min.
    }
}