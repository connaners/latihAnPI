package com.plete.latihanpi

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_row.view.*

class ApiAdapter(
    val context: Context, var dataList: ArrayList<ApiModel>?): RecyclerView.Adapter<ApiAdapter.ApiViewHolder>() {
    class ApiViewHolder(view: View):RecyclerView.ViewHolder(view){
        val llmain = view.llmain
        val tvName = view.tvName
        val tvAyat = view.tvAyat
        val tvSurat = view.tvSurat
        val tvTempat = view.tvTempat
        val tvJenis = view.tvJenis
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApiViewHolder {
        return ApiViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_row, parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return dataList!!.size
    }

    override fun onBindViewHolder(holder: ApiViewHolder, position: Int) {
        val item = dataList?.get(position)

        holder.tvName.text = "Nama Surat: "+item?.name.toString()
        holder.tvAyat.text = "Jumlah Ayat: "+item?.number_of_ayah.toString()
        holder.tvSurat.text = "Surat KE - "+item?.number_of_surah.toString()
        holder.tvTempat.text = "Diturunkan di Kota "+item?.place.toString()
        holder.tvJenis.text = "Jenis surat "+item?.type.toString()

        if (position % 2 == 0){
            holder.llmain.setBackgroundColor(ContextCompat.getColor(context, R.color.darkYellow))
        } else {
            holder.llmain.setBackgroundColor(ContextCompat.getColor(context, R.color.happy))
        }
    }
}