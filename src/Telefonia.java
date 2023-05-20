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

    public void listarAssinantes() {
        System.out.println("\nAssinantes pré-pagos:");
        for(int i=0; i<numPrePagos; i++) {
            System.out.println(prePagos[i].toString());
        }
        System.out.println("Assinantes pós-pagos:");
        for(int i=0; i<numPosPagos; i++) {
            System.out.println(posPagos[i].toString());        }
    }

    public void fazerChamada() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o CPF do assinante pré-pago:");
        long cpf = sc.nextLong();

        PrePago assinante_PrePago = localizarPrePago(cpf);
        PosPago assinante_PosPago = localizarPosPago(cpf);

        if (assinante_PrePago != null) {
            System.out.println("Informe a duração da chamada:");
            int duracao = sc.nextInt();
            System.out.println("Informe a data da chamada (dd/mm/aaaa):");
            GregorianCalendar data = new GregorianCalendar();
            System.out.print("Digite o ano (2023): ");
            int ano = sc.nextInt();
            System.out.print("Digite o mês (Janeiro = 1): ");
            int mes = sc.nextInt() - 1; // O mês começa em 0, por isso subtraímos 1
            System.out.print("Digite o dia: ");
            int dia = sc.nextInt();

            data.set(GregorianCalendar.YEAR, ano);
            data.set(GregorianCalendar.MONTH, mes);
            data.set(GregorianCalendar.DAY_OF_MONTH, dia);

            assinante_PrePago.fazerChamada(data, duracao);

        }
        else if (assinante_PosPago != null) {
            System.out.println("Informe a duração da chamada:");
            int duracao = sc.nextInt();
            System.out.println("Informe a data da chamada (dd/mm/aaaa):");
            GregorianCalendar data = new GregorianCalendar();
            System.out.print("Digite o ano (2023): ");
            int ano = sc.nextInt();
            System.out.print("Digite o mês (Janeiro = 1): ");
            int mes = sc.nextInt() - 1; // O mês começa em 0, por isso subtraímos 1
            System.out.print("Digite o dia: ");
            int dia = sc.nextInt();

            data.set(GregorianCalendar.YEAR, ano);
            data.set(GregorianCalendar.MONTH, mes);
            data.set(GregorianCalendar.DAY_OF_MONTH, dia);

            assinante_PosPago.fazerChamada(data, duracao);
        }
        else {
            System.out.println("Assinante não encontrado.");

        }
    }

    public void fazerRecarga() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o CPF do assinante pré-pago:");
        long cpf = sc.nextLong();

        PrePago assinante = localizarPrePago(cpf);
        if (assinante == null) {
            System.out.println("Assinante não encontrado.");
        } else {

            System.out.println("Informe o valor da recarga:");
            float valor = sc.nextFloat();
            System.out.println("Informe a data da recarga (dd/mm/aaaa):");
            GregorianCalendar data = new GregorianCalendar();
            System.out.print("Digite o ano (2023): ");
            int ano = sc.nextInt();
            System.out.print("Digite o mês (Janeiro = 1): ");
            int mes = sc.nextInt() - 1; // O mês começa em 0, por isso subtraímos 1
            System.out.print("Digite o dia: ");
            int dia = sc.nextInt();

            data.set(GregorianCalendar.YEAR, ano);
            data.set(GregorianCalendar.MONTH, mes);
            data.set(GregorianCalendar.DAY_OF_MONTH, dia);

            assinante.fazerRecarga(data, valor);
        }
    }

    public PrePago localizarPrePago(long cpf) {
        for (int i = 0; i < numPrePagos; i++) {
            if (prePagos[i].getCpf() == cpf) {
                return prePagos[i];
            }
        }
        return null;
    }

    public PosPago localizarPosPago(long cpf) {
        for (int i = 0; i < numPosPagos; i++) {
            if (posPagos[i].getCpf() == cpf) {
                return posPagos[i];
            }
        }
        return null;
    }

}
