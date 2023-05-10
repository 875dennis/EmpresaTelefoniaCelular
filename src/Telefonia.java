
public class Telefonia {
    private PrePago[] prePagos;
    private int numPrePagos;
    private PosPago[] posPagos;
    private int numPosPagos;

    public Telefonia(int maxPrePagos, int maxPosPagos) {

        prePagos = new PrePago[maxPrePagos];
        numPrePagos = 0;
        posPagos = new PosPago[maxPosPagos];
        numPosPagos = 0;

    }
}

