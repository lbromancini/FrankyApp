package br.dev.lbromancini.mobile.frankyapp.ui.controle;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import br.dev.lbromancini.mobile.frankyapp.model.Movimentacao;
import br.dev.lbromancini.mobile.frankyapp.ui.controle.placeholder.PlaceholderContent.PlaceholderItem;
import br.dev.lbromancini.mobile.frankyapp.databinding.FragmentItemBinding;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link br.dev.lbromancini.mobile.frankyapp.model.Movimentacao}.
 * TODO: Replace the implementation with code for your data type.
 */
public class ConMovimentacaoRecyclerViewAdapter extends RecyclerView.Adapter<ConMovimentacaoRecyclerViewAdapter.ViewHolder> {

    private final List<Movimentacao> mValues;

    public ConMovimentacaoRecyclerViewAdapter(List<Movimentacao> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(
                String.valueOf(mValues.get(position).getNomePonto()));
        holder.mContentView.setText(
                String.valueOf(mValues.get(position).getAngulo_junta1()) +
                String.valueOf(mValues.get(position).getAngulo_junta2()) +
                String.valueOf(mValues.get(position).getAngulo_junta3())
        );
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements
            View.OnClickListener {
        public final TextView mIdView;
        public final TextView mContentView;
        public Movimentacao mItem;

        public ViewHolder(FragmentItemBinding binding) {
            super(binding.getRoot());
            mIdView = binding.itemNumber;
            mContentView = binding.content;
            //click dos itens
            binding.getRoot().setOnClickListener(this);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }

        @Override
        public void onClick(View view) {
            //CLICK - pegar posicao que foi clicada
            int adapterposition = this.getLayoutPosition();
            //mostrar posição clicada
            Context context =  view.getContext();
            CharSequence text = mValues.get(adapterposition).getNomePonto();
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

        }


    }
}