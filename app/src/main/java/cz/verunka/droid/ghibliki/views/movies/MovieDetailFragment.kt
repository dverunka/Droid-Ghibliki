package cz.verunka.droid.ghibliki.views.movies

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
import cz.verunka.droid.ghibliki.databinding.FragmentMovieDetailBinding
import cz.verunka.droid.ghibliki.db.model.Movie
import cz.verunka.droid.ghibliki.services.extensions.TAG

class MovieDetailFragment: Fragment() {

    companion object {
        @JvmStatic
        fun newInstance(data: Movie) = MovieDetailFragment().apply {
            arguments = Bundle().apply {
                putParcelable("movie_row", data)
            }
        }
    }

    private var movie: Movie? = null
    private lateinit var binding: FragmentMovieDetailBinding

    override fun onAttach(context: Context) {

        super.onAttach(context)
        movie =  arguments?.getParcelable("movie_row")
        Log.d(TAG, movie?.title.toString())
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding  = DataBindingUtil.inflate(inflater,
            R.layout.fragment_movie_detail, container, false)
        val mRootView = binding.root
        binding.lifecycleOwner = this
        return mRootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {

        super.onActivityCreated(savedInstanceState)
        enableBackButton()
        binding.movie = movie
    }

    private fun enableBackButton() {
        (activity as? AppCompatActivity)?.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as? AppCompatActivity)?.supportActionBar?.setHomeButtonEnabled(true)
    }
}