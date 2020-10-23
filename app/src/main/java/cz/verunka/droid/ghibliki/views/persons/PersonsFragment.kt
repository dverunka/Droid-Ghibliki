package cz.verunka.droid.ghibliki.views.persons

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import cz.verunka.droid.ghibliki.R
import cz.verunka.droid.ghibliki.databinding.FragmentPersonsBinding
import cz.verunka.droid.ghibliki.db.model.Person
import cz.verunka.droid.ghibliki.viewmodels.PersonsViewModel
import kotlinx.android.synthetic.main.fragment_persons.*
import org.koin.android.viewmodel.ext.android.viewModel

class PersonsFragment: Fragment(), IPersonClickListener {

    private val personsViewModel by viewModel<PersonsViewModel>()
    private lateinit var personAdapter: PersonAdapter
    private lateinit var binding: FragmentPersonsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding  = DataBindingUtil.inflate(inflater, R.layout.fragment_persons, container, false)
        val mRootView = binding.root
        binding.lifecycleOwner = this
        return mRootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {

        super.onActivityCreated(savedInstanceState)
        setView()

        binding.viewModel = personsViewModel

        personsViewModel.getAllPersons()

        personsViewModel.persons.observe(viewLifecycleOwner, Observer {

            if (it.isNotEmpty() && it != null) {
                personAdapter.setPersons(it)
            }
        })
    }

    private fun setView() {

        personAdapter = PersonAdapter(context, this)
        rv_persons.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        rv_persons.adapter = personAdapter
        rv_persons.isNestedScrollingEnabled = false
    }

    override fun onItemClick(person : Person) {

        /*val bundle = Bundle()
        bundle.putParcelable("person_detail", person)
        findNavController().navigate(R.id.person_detail_destination, bundle)*/
    }
}