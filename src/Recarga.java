import java.util.Date;
import java.util.GregorianCalendar;

public class Recarga {

    private Date data;
    private float valor;

    public Recarga(GregorianCalendar data, float valor){

    }

    public Date getData() {
        return data;
    }

    public float getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Recarga{" +
                "data=" + data +
                ", valor=" + valor +
                '}';
    }
}
