package com.example.bdmary;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdaptador extends RecyclerView.Adapter<RecyclerViewAdaptador.ViewHolder> {
    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView codigo, nombre, carrera;


        public ViewHolder(View itemView){
            super(itemView);
            codigo=(TextView)itemView.findViewById(R.id.tvCodigo);
            nombre=(TextView)itemView.findViewById(R.id.tvNombre);
            carrera=(TextView)itemView.findViewById(R.id.tvCarrera);

        }
    }

    public List<estudianteModelo> estudianteModelolist;

    public RecyclerViewAdaptador(List<estudianteModelo> estudianteModelolist){
        this.estudianteModelolist=estudianteModelolist;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_estudiante,parent, false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
        holder.codigo.setText(estudianteModelolist.get(position).getCodigo());
        holder.nombre.setText(estudianteModelolist.get(position).getNombre());
        holder.carrera.setText(estudianteModelolist.get(position).getCarrera());

    }

    @Override
    public int getItemCount() {
        return estudianteModelolist.size();
    }
}
