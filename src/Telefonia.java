import java.util.GregorianCalendar;
import java.util.Scanner;

public class Telefonia {
    private Assinante[] assinantes;
    private int numAssinantes;

    public Telefonia() {
        this.assinantes = new Assinante[30];
        this.numAssinantes = 0;
    }

    public void cadastrarAssinante() {
        Scanner input = new Scanner(System.in);
        System.out.println("Informe o tipo de assinante (1 - Pré-pago; 2 - Pós-pago): ");
        int tipoAssinante = input.nextInt();
        if (tipoAssinante == 1) { // Cadastro de assinante pré-pago
            if (numAssinantes < assinantes.length) { // Verifica se há espaço no vetor
                System.out.println("Informe o CPF do assinante: ");
                Long cpf = input.nextLong();
                System.out.println("Informe o nome do assinante: ");
                String nome = input.next();
                System.out.println("Informe o número do telefone do assinante: ");
                int telefone = input.nextInt();
                float credito = 0;
                int numRecarga = 0;
                assinantes[numAssinantes] = new PrePago(cpf, nome, telefone, credito, numRecarga);
                numAssinantes++; // Incrementa o número de assinantes pré-pagos cadastrados
                System.out.println("Assinante pré-pago cadastrado com sucesso!");
            } else {
                System.out.println("Não há mais espaço para cadastrar assinantes pré-pagos!");
            }
        } else if (tipoAssinante == 2) { // Cadastro de assinante pós-pago
            if (numAssinantes < assinantes.length) { // Verifica se há espaço no vetor
                System.out.println("Informe o CPF do assinante: ");
                Long cpf = input.nextLong();
                System.out.println("Informe o nome do assinante: ");
                String nome = input.next();
                System.out.println("Informe o número do telefone do assinante: ");
                int telefone = input.nextInt();
                System.out.println("Informe a assinatura: ");
                float assinatura = input.nextFloat();
                assinantes[numAssinantes] = new PosPago(cpf, nome, telefone, assinatura);
                numAssinantes++; // Incrementa o número de assinantes pós-pagos cadastrados
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
        for (int i = 0; i < numAssinantes; i++) {
            if (assinantes[i] instanceof PrePago) {
                System.out.println(assinantes[i].toString());
            }
        }
        System.out.println("Assinantes pós-pagos:");
        for (int i = 0; i < numAssinantes; i++) {
            if (assinantes[i] instanceof PosPago)
            System.out.println(assinantes[i].toString());
        }
    }

    public void fazerChamada() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o CPF do assinante pré-pago:");
        long cpf = sc.nextLong();

        Assinante assinante = localizarAssinante(cpf);

        if (assinante != null) {
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

            assinante.fazerChamada(data, duracao);

        } else if (assinante != null) {
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

            assinante.fazerChamada(data, duracao);
        } else {
            System.out.println("Assinante não encontrado.");

        }
    }

    public void fazerRecarga() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o CPF do assinante:");
        long cpf = sc.nextLong();

        Assinante assinante = localizarAssinante(cpf);

        if (assinante != null) {
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

            if (assinante instanceof PrePago) {
                PrePago prePago = (PrePago) assinante;
                prePago.fazerRecarga(data, valor);
            } else if (assinante instanceof PosPago) {
                System.out.println("Não é possível fazer recarga em assinantes pós-pagos.");
            }
        } else {
            System.out.println("Assinante não encontrado.");
        }
    }


    public Assinante localizarAssinante(long cpf) {
        for (int i = 0; i < numAssinantes; i++) {
            if (assinantes[i].getCpf() == cpf) {
                return assinantes[i];
            }
        }
        return null;
    }

    public void imprimirFaturas() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe o mês (Janeiro = 1):");
        int mes = sc.nextInt() -1;
        System.out.println("Informe o ano:");
        int ano = sc.nextInt();
        for (int i = 0; i < numAssinantes; i++) {
            assinantes[i].imprimirFatura(mes, ano);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Telefonia sistema = new Telefonia();
        int opcao;

        do {
            System.out.println("Menu de opções:");
            System.out.println("1. Cadastrar assinante");
            System.out.println("2. Listar assinantes");
            System.out.println("3. Fazer chamada");
            System.out.println("4. Fazer recarga");
            System.out.println("5. Imprimir faturas");
            System.out.println("6. Sair");
            System.out.print("Digite a opção desejada: ");
            opcao = input.nextInt();
            switch (opcao) {
                case 1:
                    sistema.cadastrarAssinante();
                    break;
                case 2:
                    sistema.listarAssinantes();
                    break;
                case 3:
                    sistema.fazerChamada();
                    break;
                case 4:
                    sistema.fazerRecarga();
                    break;
                case 5:
                    sistema.imprimirFaturas();
                    break;
                case 6:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }

            System.out.println();
        } while (opcao != 6);
    }
}
