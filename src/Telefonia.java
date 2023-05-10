
public class Telefonia {
    private PrePago[] prePagos;
    private int numPrePagos;
    private PosPago[] posPagos;
    private int numPosPagos;
    private int maxPrePagos;
    private int maxPosPagos;

    public Telefonia(int maxPrePagos, int maxPosPagos) {
        this.maxPrePagos = maxPrePagos;
        this.maxPosPagos = maxPosPagos;

        prePagos = new PrePago[maxPrePagos];
        numPrePagos = 0;
        posPagos = new PosPago[maxPosPagos];
        numPosPagos = 0;
    }
}
