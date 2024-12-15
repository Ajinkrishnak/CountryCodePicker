package com.ak.adapter
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.ak.countrypicker.databinding.ItemCountryBinding
import com.ak.model.CountryItem
import java.util.*

class CountryListAdapter(
    private val listener: OnItemClickListener
) :
    RecyclerView.Adapter<CountryListAdapter.ViewHolder>() , Filterable {
    private var list = mutableListOf<CountryItem>()
    var mFilteredList: List<CountryItem>

    init {
        mFilteredList = list
    }
    inner class ViewHolder(val binding: ItemCountryBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCountryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(mFilteredList[position]) {
            holder.binding.tvCountryName.text = countryName
            holder.binding.tvCountryCode.text = phoneCode
            flagImage?.let { holder.binding.ivFlag.setImageResource(it) }
            holder.binding.root.setOnClickListener {
                listener.onSelectItem(mFilteredList[position])
            }
        }
    }

    fun newList(newList: List<CountryItem>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    override fun getFilter(): Filter {

        return object : Filter() {
            override fun performFiltering(charSequence: CharSequence): Filter.FilterResults {

                val charString = charSequence.toString()

                if (charString.isEmpty()) {

                    mFilteredList = list
                } else {

                    val filteredList = ArrayList<CountryItem>()

                    for (model in list) {

                        if (model.countryName!!.lowercase(Locale.ROOT)
                                .contains(charString.lowercase(Locale.ROOT)) || model.countryName.uppercase(
                                Locale.ROOT
                            )
                                .contains(charString.lowercase(Locale.ROOT)) ||
                            model.phoneCode?.lowercase(Locale.ROOT)
                                ?.startsWith(charString.lowercase(Locale.ROOT)) == true || model.phoneCode?.uppercase(
                                Locale.ROOT
                            )
                                ?.startsWith(charString.lowercase(Locale.ROOT)) == true
                        ) {
                            filteredList.add(model)
                        }
                    }
                    mFilteredList = filteredList
                }

                val filterResults = Filter.FilterResults()
                filterResults.values = mFilteredList
                return filterResults
            }

            override fun publishResults(
                charSequence: CharSequence,
                filterResults: FilterResults
            ) {
                mFilteredList = filterResults.values as List<CountryItem>
                notifyDataSetChanged()
            }
        }
    }

    override fun getItemCount(): Int {
        return mFilteredList.size
    }

    interface OnItemClickListener {
        fun onSelectItem(item: CountryItem)
    }
}