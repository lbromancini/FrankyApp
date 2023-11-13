package br.dev.lbromancini.mobile.frankyapp.model;

import org.json.JSONException;
import org.json.JSONObject;

public class Movimentacao {

    // atributos
    private String nomePonto;
    private int angulo_junta1;
    private int angulo_junta2;
    private int angulo_junta3;

    // métodos
    public String getNomePonto() {return nomePonto;}
    public void setNomePonto(String nomePonto) {this.nomePonto = nomePonto;}
    public int getAngulo_junta1() {return angulo_junta1;}
    public void setAngulo_junta1(int angulo_junta1) {this.angulo_junta1 = angulo_junta1;}
    public int getAngulo_junta2() {return angulo_junta2;}
    public void setAngulo_junta2(int angulo_junta2) {this.angulo_junta2 = angulo_junta2;}
    public int getAngulo_junta3() {return angulo_junta3;}
    public void setAngulo_junta3(int angulo_junta3) {this.angulo_junta3 = angulo_junta3;}

    public Movimentacao(JSONObject jp) {
        try {
            this.setNomePonto((String) jp.getString("nomePonto"));


            this.setAngulo_junta1( jp.getInt("angulo_junta1"));


            this.setAngulo_junta2(jp.getInt("angulo_junta2"));


            this.setAngulo_junta3(jp.getInt("angulo_junta3"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public Movimentacao() {
        this.setNomePonto("");
        this.setAngulo_junta1(0);
        this.setAngulo_junta2(0);
        this.setAngulo_junta3(0);
    }

    public JSONObject toJsonObject() {
        JSONObject json = new JSONObject();
        try {
            json.put("nomePonto", this.nomePonto);
            json.put("angulo_junta1", this.angulo_junta1);
            json.put("angulo_junta2", this.angulo_junta2);
            json.put("angulo_junta3", this.angulo_junta3);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json;
    }
}

