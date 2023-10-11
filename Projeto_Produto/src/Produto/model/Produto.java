package Produto.model;

public class Produto {

        private int numero;
        private String nome;
        private String descricao;
        private float valor;
        private boolean disponivel;

        //constructor
        public Produto(int numero, String nome, String descricao, float valor, boolean disponivel) {
                this.numero = numero;
                this.nome = nome;
                this.descricao = descricao;
                this.valor = valor;
                this.disponivel = disponivel;
        }

        //Getter e Setter

        public int getNumero() {
                return numero;
        }

        public void setNumero(int numero) {
                this.numero = numero;
        }

        public String getNome() {
                return nome;
        }

        public void setNome(String nome) {
                this.nome = nome;
        }

        public String getDescricao() {
                return descricao;
        }

        public void setDescricao(String descricao) {
                this.descricao = descricao;
        }

        public float getValor() {
                return valor;
        }

        public void setValor(float valor) {
                this.valor = valor;
        }

        public boolean isDisponivel() {
                return disponivel;
        }

        public void setDisponivel(boolean disponivel) {
                this.disponivel = disponivel;
        }

        public void visualizar(){
                System.out.println("------------------------------");
                System.out.printf("Número do produto: %d%n", getNumero());
                System.out.println("Nome do produto: "+getNome());
                System.out.printf("Valor do produto: R$ %.2f%n", getValor());
        };


}
