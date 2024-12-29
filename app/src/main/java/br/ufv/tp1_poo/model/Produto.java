package br.ufv.tp1_poo.model;

import org.json.JSONObject;
import java.io.Serializable;

public abstract class Produto implements Serializable {
    private int preco;
    private String nome;
    private int quantidade;
    private String descricao;
    private String imagem;
    private String categoria;
    private String observacao;
    private String tamanho;

    public Produto(int preco, String nome, int quantidade, String descricao, String imagem,
                   String categoria, String observacao, String tamanho) {
        this.preco = preco;
        this.nome = nome;
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.imagem = imagem;
        this.categoria = categoria;
        this.observacao = observacao;
        this.tamanho = tamanho;
    }

    // Getters e Setters
    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    // Método abstrato para ser implementado pelas subclasses
    public abstract String getTamanhoFormatado();

    // Método para calcular o preço total
    public int calculaPreco() {
        return this.preco * this.quantidade;
    }

    public static Produto fromJson(JSONObject jsonObject) {
        try {
            int preco = jsonObject.optInt("preco", 0);
            String nome = jsonObject.optString("nome", "Sem nome");
            int quantidade = jsonObject.optInt("quantidade", 1);
            String descricao = jsonObject.optString("descricao", "Sem descrição");
            String imagem = jsonObject.optString("imagem", "");
            String categoria = jsonObject.optString("categoria", "Sem categoria");
            String observacao = jsonObject.optString("observacao", "Sem observação");
            String tamanho = jsonObject.optString("tamanho", "Único");

            // Escolher subclasse com base na categoria
            switch (categoria.toLowerCase()) {
                case "vegetariano":
                    return new Vegetariano(preco, nome, quantidade, descricao, imagem, categoria, observacao, tamanho);
                case "bebida":
                    return new Bebida(preco, nome, quantidade, descricao, imagem, categoria, observacao, tamanho);
                case "vegano":
                    return new Vegano(preco, nome, quantidade, descricao, imagem, categoria, observacao, tamanho);
                case "acréscimos":
                    return new Acrescimos(preco, nome, quantidade, descricao, imagem, categoria, observacao, tamanho);
                case "congelado":
                    return new Congelado(preco, nome, quantidade, descricao, imagem, categoria, observacao, tamanho);
                default:
                    throw new IllegalArgumentException("Categoria desconhecida: " + categoria);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Retorna null em caso de erro
        }
    }


    @Override
    public String toString() {
        return "Produto{" +
                "preco=" + preco +
                ", nome='" + nome + '\'' +
                ", quantidade=" + quantidade +
                ", descricao='" + descricao + '\'' +
                ", imagem='" + imagem + '\'' +
                ", categoria='" + categoria + '\'' +
                ", observacao='" + observacao + '\'' +
                ", tamanho='" + tamanho + '\'' +
                '}';
    }
}