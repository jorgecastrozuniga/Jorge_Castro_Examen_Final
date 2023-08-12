package com.example.jorge_castroexamen_final.View

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.jorge_castroexamen_final.Model.Local.Entidades.PlantEntity
import com.example.jorge_castroexamen_final.databinding.ItemListBinding


// Implementacion clase Adapter
class PlantAdapter : RecyclerView.Adapter<PlantAdapter.PlantViewHolder>() {

    // Declaración de variables en el Adapter
    private var plantList = listOf<PlantEntity>()
    private val selectedPlant = MutableLiveData<PlantEntity>()

    // Declaracion de Clase interna ViewHolder, con funciones, inflado vista xml
    inner class PlantViewHolder(private val binding: ItemListBinding) :
        RecyclerView.ViewHolder(binding.root),

        // Implementacion de Glide, variables
        View.OnClickListener {
        fun bind(plant: PlantEntity) {
            Glide.with(binding.imageView).load(plant.imagen).into(binding.imageView)
            binding.tv1.text = "ID Producto " + plant.id.toString()
            binding.tv2.text = plant.nombre
            binding.tv3.text = "Tipo :" + plant.tipo
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            selectedPlant.value = plantList[adapterPosition]
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PlantViewHolder(binding)
    }

    // Implementacion de tamaño
    override fun getItemCount(): Int {
        return plantList.size
    }

    // Implementacion de posicion
    override fun onBindViewHolder(holder: PlantViewHolder, position: Int) {
        val selectedPlant = plantList[position]
        holder.bind(selectedPlant)
    }

    //funcion para seleccionar elemento
    fun elementoSeleccionado(): LiveData<PlantEntity> = selectedPlant

    //funcion para actualizar datos
    fun updateData(list: List<PlantEntity>) {
        plantList = list
        notifyDataSetChanged()
    }
}