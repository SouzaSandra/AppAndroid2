package com.example.appmobile.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.appmobile.R;

import java.util.List;

import modelo.Cadastro;

public class adapterListarCadastro extends BaseAdapter {

    private Context context;
    private List<Cadastro>cadastroList;

    public adapterListarCadastro(Context context, List<Cadastro> cadastroList){
        this.context = context;
        this.cadastroList = cadastroList;
    }
    @Override
    public int getCount() {
        return this.cadastroList.size();
    }

    @Override
    public Object getItem(int posicao) {
        return this.cadastroList.get(posicao);
    }

    @Override
    public long getItemId(int posicao) {
        return posicao;
    }


    public void removerServico(int posicao){
        this.cadastroList.remove((posicao));
        notifyDataSetChanged();
    }

    @Override
    public View getView(int posicao, View view, ViewGroup viewGroup) {

        View c = View.inflate(this.context, R.layout.layout_cadastro, null);
        TextView nomePes = (TextView) c.findViewById(R.id.nomePes) ;
        TextView endPes = (TextView) c.findViewById(R.id.endPes);
        TextView setSer = (TextView) c.findViewById(R.id.setSer);
        TextView atendSer = (TextView) c.findViewById(R.id.atendSer);


        nomePes.setText(this.cadastroList.get(posicao).getNomeSolicita());
        endPes.setText(this.cadastroList.get(posicao).getEndereco());
        setSer.setText(this.cadastroList.get(posicao).getBairro());
        atendSer.setText(this.cadastroList.get(posicao).getAtendente());

        return null;
    }
}
