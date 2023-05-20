import java.util.GregorianCalendar;
import java.util.Scanner;

public class Telefonia {

    private PrePago[] prePagos;
    private int numPrePagos;
    private PosPago[] posPagos;
    private int numPosPagos;

    public Telefonia() {
        this.prePagos = new PrePago[15];
        this.numPrePagos = 0;
        this.posPagos = new PosPago[15];
        this.numPosPagos = 0;
    }

    public void cadastrarAssinante() {
        Scanner input = new Scanner(System.in);
        System.out.println("Informe o tipo de assinante (1 - Pré-pago; 2 - Pós-pago): ");
        int tipoAssinante = input.nextInt();
        if(tipoAssinante == 1) { // Cadastro de assinante pré-pago
            if(numPrePagos < prePagos.length) { // Verifica se há espaço no vetor
                System.out.println("Informe o CPF do assinante: ");
                Long cpf = input.nextLong();
                System.out.println("Informe o nome do assinante: ");
                String nome = input.next();
                System.out.println("Informe o número do telefone do assinante: ");
                int telefone = input.nextInt();
                float credito = 0;
                int numRecarga = 0;
                prePagos[numPrePagos] = new PrePago(cpf, nome, telefone, credito, numRecarga);
                numPrePagos++; // Incrementa o número de assinantes pré-pagos cadastrados
                System.out.println("Assinante pré-pago cadastrado com sucesso!");
            } else {
                System.out.println("Não há mais espaço para cadastrar assinantes pré-pagos!");
            }
        } else if(tipoAssinante == 2) { // Cadastro de assinante pós-pago
            if(numPosPagos < posPagos.length) { // Verifica se há espaço no vetor
                System.out.println("Informe o CPF do assinante: ");
                Long cpf = input.nextLong();
                System.out.println("Informe o nome do assinante: ");
                String nome = input.next();
                System.out.println("Informe o número do telefone do assinante: ");
                int telefone = input.nextInt();
                System.out.println("Informe a assinatura: ");
                float assinatura = input.nextFloat();
                posPagos[numPosPagos] = new PosPago(cpf, nome, telefone, assinatura);
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
