package br.dev.lbromancini.mobile.frankyapp.ui.controle;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import br.dev.lbromancini.mobile.frankyapp.R;
import br.dev.lbromancini.mobile.frankyapp.model.Juntas;

public class ValorJuntasFragment extends Fragment implements View.OnClickListener{

    private View view = null;

    private EditText nomePonto;
    private EditText angulo_junta1;
    private EditText angulo_junta2;
    private EditText angulo_junta3;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ValorJuntasFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ValorJuntasFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ValorJuntasFragment newInstance(String param1, String param2) {
        ValorJuntasFragment fragment = new ValorJuntasFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

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

        return this.view;

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.btRealizarMov:

                Juntas valorJuntas = new Juntas();

                valorJuntas.setNomePonto(this.nomePonto.getText().toString());

                String temp = this.angulo_junta1.getText().toString();
                valorJuntas.setAngulo_junta1(Integer.valueOf(temp));

                temp = this.angulo_junta2.getText().toString();
                valorJuntas.setAngulo_junta2(Integer.valueOf(temp));

                temp = this.angulo_junta3.getText().toString();
                valorJuntas.setAngulo_junta3(Integer.valueOf(temp));

                break;
        }
    }
}