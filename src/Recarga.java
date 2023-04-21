import java.util.Date;

public class Recarga {

    private Date data;
    private float valor;

    public Recarga(Date data, float valor){

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
