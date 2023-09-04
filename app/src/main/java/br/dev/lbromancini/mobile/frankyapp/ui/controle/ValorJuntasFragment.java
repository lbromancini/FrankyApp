package br.dev.lbromancini.mobile.frankyapp.ui.controle;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.dev.lbromancini.mobile.frankyapp.R;
import br.dev.lbromancini.mobile.frankyapp.model.Movimentacao;

public class ValorJuntasFragment extends Fragment implements View.OnClickListener{

    private View view = null;

    private EditText nomePonto;
    private EditText angulo_junta1;
    private EditText angulo_junta2;
    private EditText angulo_junta3;

    private Button botao;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        this.view = inflater.inflate(R.layout.fragment_valor_juntas, container, false);
        // Binding
        this.nomePonto = (EditText) view.findViewById(R.id.etNomePonto);
        this.angulo_junta1 = (EditText) view.findViewById(R.id.ndAngulo_junta1);
        this.angulo_junta2 = (EditText) view.findViewById(R.id.ndAngulo_junta2);
        this.angulo_junta3 = (EditText) view.findViewById(R.id.ndAngulo_junta3);

        this.botao = (Button) view.findViewById(R.id.btRealizarMov);
        this.botao.setOnClickListener(this);

        return this.view;

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.btRealizarMov:

                Movimentacao movimentacao = new Movimentacao();

                movimentacao.setNomePonto(this.nomePonto.getText().toString());

                String temp = this.angulo_junta1.getText().toString();
                movimentacao.setAngulo_junta1(Integer.valueOf(temp));

                temp = this.angulo_junta2.getText().toString();
                movimentacao.setAngulo_junta2(Integer.valueOf(temp));

                temp = this.angulo_junta3.getText().toString();
                movimentacao.setAngulo_junta3(Integer.valueOf(temp));

                break;
        }

        // Mensagem de sucesso
        Context context = view.getContext();
        CharSequence text = "salvo com sucesso!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

    }

}