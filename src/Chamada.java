import java.util.GregorianCalendar;

public class Chamada {
    private GregorianCalendar data;
    private int duracao;

    public Chamada(GregorianCalendar data, int duracao){ // Construtor
        this.data = data;
        this.duracao = duracao;
    }

    public GregorianCalendar getData() {
        return data;
    }

    public int getDuracao() {
        return duracao;
    }

    @Override

    public String toString() {
        return "Chamada{" +
                "data=" + data +
                ", duracao=" + duracao +
                '}';
    }
}
