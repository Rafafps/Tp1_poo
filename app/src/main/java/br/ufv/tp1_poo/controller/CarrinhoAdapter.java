package br.ufv.tp1_poo.controller;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import br.ufv.tp1_poo.R;
import br.ufv.tp1_poo.model.Produto;

public class CarrinhoAdapter extends RecyclerView.Adapter<CarrinhoAdapter.ViewHolder> {

    private final List<Produto> listaProdutos;
    private final OnItemRemovedListener onItemRemovedListener;

    public interface OnItemRemovedListener {
        void onItemRemoved(int position);
    }

    public CarrinhoAdapter(List<Produto> listaProdutos, OnItemRemovedListener listener) {
        this.listaProdutos = listaProdutos;
        this.onItemRemovedListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_carrinho, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Produto produto = listaProdutos.get(position);

        // Configura os dados do produto
        holder.nomeProduto.setText(produto.getNome());
        holder.precoProduto.setText(String.format("R$ %.2f", produto.calculaPreco()));
        holder.quantidadeProduto.setText(String.valueOf(produto.getQuantidade()));

        // Exemplo de como carregar a imagem (se aplicável)
        holder.imagemProduto.setImageResource(R.drawable.imagem_carregando);

        // Botão de remover produto
        holder.btnRemoverProduto.setOnClickListener(v -> {
            if (onItemRemovedListener != null) {
                onItemRemovedListener.onItemRemoved(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaProdutos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nomeProduto, precoProduto, quantidadeProduto;
        ImageView imagemProduto;
        ImageButton btnRemoverProduto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nomeProduto = itemView.findViewById(R.id.nomeProduto);
            precoProduto = itemView.findViewById(R.id.precoProduto);
            quantidadeProduto = itemView.findViewById(R.id.quantidadeProduto);
            imagemProduto = itemView.findViewById(R.id.imagemProduto);
            btnRemoverProduto = itemView.findViewById(R.id.btnRemoverProduto);
        }
    }
}
