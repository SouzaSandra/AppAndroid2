package com.example.appmobile.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.appmobile.R;

import java.util.List;

import modelo.Servico;

public class adapterListaServico extends BaseAdapter {

    private Context context;
    private List<Servico> servicoList;

    public adapterListaServico(Context context, List<Servico> servicoList) {
        this.context = context;
        this.servicoList = servicoList;
    }


    @Override
    public int getCount() {
        return this.servicoList.size();
    }

    @Override
    public Object getItem(int posicao) {
        return this.servicoList.get(posicao);
    }

    @Override
    public long getItemId(int posicao) {
        return posicao;
    }

    public void removerSolicitacao(int posicao){

    }
     public void removerServico(int posicao){
         this.servicoList.remove((posicao));
         notifyDataSetChanged();
     }

    @Override
    public View getView(int posicao, View view, ViewGroup viewGroup) {
        View s = View.inflate(this.context, R.layout.layout_servico, null);
        TextView nomeSolic = (TextView) s.findViewById(R.id.nomeSolic);
        TextView endSolic = (TextView) s.findViewById(R.id.endSolic);
        TextView atendSolic = (TextView) s.findViewById(R.id.atendSolic);

        nomeSolic.setText(this.servicoList.get(posicao).getEncarregado());
        endSolic.setText(this.servicoList.get(posicao).getLocal());
        atendSolic.setText(this.servicoList.get(posicao).getAtendente());

        return null;
    }


}











