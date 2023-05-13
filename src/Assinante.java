public class Assinante{
    //Atributos
    private long cpf;
    private String nome;
    private int numero;
    protected int numChamadas; // Ele está definido como protegido, o que permite que seja acessado pelas subclasses de "Assinante".

    // Construtor  (No momento da criação, Getter and Setter é para alteração)
    public Assinante (long cpf, String nome, int numero){
        this.cpf = cpf;
        this.nome = nome;
        this.numero = numero;
    }

    //Métodos
    //Método getCpf, para trazer o CPF
    public long getCpf() { // Retorna o valor do atributo "cpf"
        return cpf;
    }

    //Método toString Retorna uma String com os valores dos atributos "nome", "cpf" e "numero".
    @Override
    public String toString(){
        return "Assinante{" +
                "Nome: " + nome + '\n' +
                "CPF: " + cpf + '\n' +
                "Número: " + numero + '\n' +
                "}";
    }

}
