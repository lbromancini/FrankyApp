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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.android.material.snackbar.Snackbar;

import org.json.JSONException;
import org.json.JSONObject;

import br.dev.lbromancini.mobile.frankyapp.R;
import br.dev.lbromancini.mobile.frankyapp.model.Movimentacao;

public class ValorJuntasFragment extends Fragment implements View.OnClickListener, Response.ErrorListener,  Response.Listener{

    private View view = null;

    private EditText nomePonto;
    private EditText angulo_junta1;
    private EditText angulo_junta2;
    private EditText angulo_junta3;

    private Button botao;

    //volley
    private RequestQueue requestQueue;
    private JsonObjectRequest jsonObjectReq;


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
    // aaaaaa

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

                //Chamar WebService
                jsonObjectReq = new JsonObjectRequest(
                        Request.Method.POST,
                        "http://10.0.2.2/e4p/controle_robo.php",
                        movimentacao.toJsonObject(), this, this);
                requestQueue.add(jsonObjectReq);
                break;
        }

        // Mensagem de sucesso
        Context context = view.getContext();
        CharSequence text = "salvo com sucesso!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Snackbar mensagem = Snackbar.make(view,
                "Ops! Houve um problema ao realizar o cadastro: " +
                        error.toString(),Snackbar.LENGTH_LONG);
        mensagem.show();
    }

    @Override
    public void onResponse(Object response) {
        try {
            //instanciando objeto para manejar o JSON que recebemos
            JSONObject jason = new JSONObject(response.toString());
            //context e text são para a mensagem na tela o Toast
            Context context = view.getContext();
            //pegando mensagem que veio do json
            CharSequence mensagem = jason.getString("message");
            //duração da mensagem na tela
            int duration = Toast.LENGTH_SHORT;
            //verificando se salvou sem erro para limpar campos da tela
            if (jason.getBoolean("success")){
                //campos texto
                this.nomePonto.setText("");
                //selecionando primiro item dos spinners
                this.angulo_junta1.setSelection(0);
                this.angulo_junta2.setSelection(0);
                this.angulo_junta3.setSelection(0);
            }
            //mostrando a mensagem que veio do JSON
            Toast toast = Toast.makeText (context, mensagem, duration);
            toast.show();

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

    }
}