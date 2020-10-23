package cz.verunka.droid.ghibliki.views.persons

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import cz.verunka.droid.ghibliki.R
import cz.verunka.droid.ghibliki.databinding.FragmentPersonDetailBinding
import cz.verunka.droid.ghibliki.db.model.Person
import cz.verunka.droid.ghibliki.services.extensions.TAG

class PersonDetailFragment: Fragment() {

    companion object {
        @JvmStatic
        fun newInstance(data: Person) = PersonDetailFragment().apply {
            arguments = Bundle().apply {
                putParcelable("person_detail", data)
            }
        }
    }

    private var person: Person? = null
    private lateinit var binding: FragmentPersonDetailBinding

    override fun onAttach(context: Context) {

        super.onAttach(context)
        person = arguments?.getParcelable("person_detail")
        Log.d(TAG, person?.name.toString())
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding  = DataBindingUtil.inflate(inflater,
            R.layout.fragment_person_detail, container, false)
        val mRootView = binding.root
        binding.lifecycleOwner = this
        return mRootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {

        super.onActivityCreated(savedInstanceState)
        enableBackButton()
        binding.person = person
    }

    private fun enableBackButton() {
        (activity as? AppCompatActivity)?.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as? AppCompatActivity)?.supportActionBar?.setHomeButtonEnabled(true)
    }
}