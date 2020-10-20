package cz.verunka.droid.ghibliki.views.persons

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import cz.verunka.droid.ghibliki.R
import cz.verunka.droid.ghibliki.databinding.RowPersonBinding
import cz.verunka.droid.ghibliki.db.model.Person

class PersonAdapter(val context: Context?, val clickListener: IPersonClickListener): RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {

    var personList: List<Person> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {

        val viewBinding: RowPersonBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.row_person, parent, false
        )
        return PersonViewHolder(viewBinding)
    }

    override fun getItemCount(): Int {
        return personList.size
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.onBind(position)
    }

    fun setPersons(persons: List<Person>) {
        this.personList = persons
        notifyDataSetChanged()
    }

    inner class PersonViewHolder(private val viewBinding: RowPersonBinding): RecyclerView.ViewHolder(viewBinding.root) {

        fun onBind(position: Int) {

            val row = personList[position]
            viewBinding.person = row
            viewBinding.iPersonClick = clickListener
        }
    }
}