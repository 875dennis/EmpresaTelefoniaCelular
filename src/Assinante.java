public class Assinante{
    private long cpf;
    private String nome;
    private int numero;
    protected int numChamadas; // Ele está definido como protegido, o que permite que seja acessado pelas subclasses de "Assinante".

    public Assinante (long cpf, String nome, int numero){ // Construtor
        this.cpf = cpf;
        this.nome = nome;
        this.numero = numero;
    }

    public long getCpf() { // Retorna o valor do atributo "cpf"
        return cpf;
    }

    @Override
    public String toString(){ // Retorna uma String com os valores dos atributos "nome", "cpf" e "numero".
        return "Assinante{" +
                "Nome: " + nome + '\n' +
                "CPF: " + cpf + '\n' +
                "Número: " + numero + '\n' +
                "}";
    }

}
