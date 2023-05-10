
public class Telefonia {
    private PrePago[] prePagos;
    private int numPrePagos;
    private PosPago[] posPagos;
    private int numPosPagos;

    public Telefonia() {

        prePagos = new PrePago[100];
        numPrePagos = 0;
        posPagos = new PosPago[100];
        numPosPagos = 0;
    }

    public void cadastrarAssinante() {
        Scanner input = new Scanner(System.in);
        System.out.println("Informe o tipo de assinante (1 - Pré-pago; 2 - Pós-pago): ");
        int tipoAssinante = input.nextInt();
        if (tipoAssinante == 1) { // Cadastro de assinante pré-pago
            if (numPrePagos < this.prePagos.length) { // Verifica se há espaço no vetor
                System.out.println("Informe o CPF do assinante: ");
                long cpf = input.next();
                System.out.println("Informe o nome do assinante: ");
                String nome = input.next();
                System.out.println("Informe o número do telefone do assinante: ");
                int telefone = input.next();
                System.out.println("Informe o saldo inicial do assinante: ");
                double saldo = input.nextDouble();
                prePagos[numPrePagos] = new PrePago(cpf, nome, telefone, saldo);
                numPrePagos++; // Incrementa o número de assinantes pré-pagos cadastrados
                System.out.println("Assinante pré-pago cadastrado com sucesso!");
            } else {
                System.out.println("Não há mais espaço para cadastrar assinantes pré-pagos!");
            }
        } else if (tipoAssinante == 2) { // Cadastro de assinante pós-pago
            if (numPosPagos < this.posPagos.length) { // Verifica se há espaço no vetor
                System.out.println("Informe o CPF do assinante: ");
                long cpf = input.next();
                System.out.println("Informe o nome do assinante: ");
                String nome = input.next();
                System.out.println("Informe o número do telefone do assinante: ");
                int telefone = input.next();
                System.out.println("Informe o valor do crédito máximo do assinante: ");
                double creditoMaximo = input.nextDouble();
                posPagos[numPosPagos] = new PosPago(cpf, nome, telefone, creditoMaximo);
                numPosPagos++; // Incrementa o número de assinantes pós-pagos cadastrados
                System.out.println("Assinante pós-pago cadastrado com sucesso!");
            } else {
                System.out.println("Não há mais espaço para cadastrar assinantes pós-pagos!");
            }
        } else {
            System.out.println("Opção inválida!");
        }
    }
}

