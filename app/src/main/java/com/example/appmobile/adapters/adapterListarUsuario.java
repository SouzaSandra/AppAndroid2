package com.example.appmobile.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.appmobile.R;

import java.util.List;

import modelo.Usuario;

public class adapterListarUsuario extends BaseAdapter {

    private Context context;
    private List<Usuario>usuarioList;

    public adapterListarUsuario(Context context, List<Usuario> servicoList) {
        this.context = context;
        usuarioList = usuarioList;
    }

    @Override
    public int getCount() {
        return this.usuarioList.size();
    }

    @Override
    public Object getItem(int posicao) {
        return this.usuarioList.get(posicao);
    }

    @Override
    public long getItemId(int posicao) {
        return posicao;
    }


    public void removerServico(int posicao){
        this.usuarioList.remove((posicao));
        notifyDataSetChanged();
    }

    @Override
    public View getView(int posicao, View view, ViewGroup viewGroup) {

        View u = View.inflate(this.context, R.layout.layout_usuario, null);

        TextView nomeUs = (TextView) u.findViewById(R.id.nomeUs);
        TextView setServ = (TextView) u.findViewById(R.id.setSer);

        nomeUs.setText(this.usuarioList.get(posicao).getNomeUser());
        setServ.setText(this.usuarioList.get(posicao).getSetor());





        return null;
    }
}
