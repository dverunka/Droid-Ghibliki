package cz.verunka.droid.ghibliki.views.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import cz.verunka.droid.ghibliki.R
import cz.verunka.droid.ghibliki.databinding.FragmentMoviesBinding
import cz.verunka.droid.ghibliki.db.model.Movie
import cz.verunka.droid.ghibliki.viewmodels.MoviesViewModel
import kotlinx.android.synthetic.main.fragment_movies.*
import org.koin.android.viewmodel.ext.android.viewModel

class MoviesFragment: Fragment(), IMovieClickListener {

    private val moviesViewModel by viewModel<MoviesViewModel>()
    private lateinit var movieAdapter: MovieAdapter
    private lateinit var binding: FragmentMoviesBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding  = DataBindingUtil.inflate(inflater, R.layout.fragment_movies, container, false)
        val mRootView = binding.root
        binding.lifecycleOwner = this
        return mRootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {

        super.onActivityCreated(savedInstanceState)
        setView()

        binding.viewModel = moviesViewModel

        moviesViewModel.getAllMovies()

        moviesViewModel.movies.observe(viewLifecycleOwner, Observer {

            if (it.isNotEmpty() && it != null) {
                movieAdapter.setMovies(it)
            }
        })
    }

    private fun setView() {

        movieAdapter = MovieAdapter(context, this)
        rv_movies.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        rv_movies.adapter = movieAdapter
        rv_movies.isNestedScrollingEnabled = false
    }

    override fun onItemClick(movie : Movie) {

        // (activity as MainActivity).replaceFragment(MovieDetailFragment.newInstance(movie), R.id.movies_fragment, "movie_detail")
    }
}