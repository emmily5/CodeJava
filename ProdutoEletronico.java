package LP2;

import java.time.LocalDate;

public class ProdutoEletronico extends Produto {
    private LocalDate prazoDeGarantia;
    private String marca;

    public ProdutoEletronico(String nome, double preco, CategoriaProduto categoria, LocalDate prazoDeGarantia, String marca) {
        super(nome, preco, categoria);
        this.prazoDeGarantia = prazoDeGarantia;
        this.marca = marca;
    }

    public LocalDate getPrazoDeGarantia() { return prazoDeGarantia; }
    public void setPrazoDeGarantia(LocalDate prazoDeGarantia) { this.prazoDeGarantia = prazoDeGarantia; }
    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    @Override
    public String toString() {
        return super.toString() + ", ProdutoEletronico{" + "prazoDeGarantia=" + prazoDeGarantia + ", marca='" + marca + '\'' + '}';
    }
}

