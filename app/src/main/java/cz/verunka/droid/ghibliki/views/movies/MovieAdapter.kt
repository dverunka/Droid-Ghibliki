package cz.verunka.droid.ghibliki.views.movies

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import cz.verunka.droid.ghibliki.R
import cz.verunka.droid.ghibliki.databinding.RowMovieBinding
import cz.verunka.droid.ghibliki.db.model.Movie

class MovieAdapter(val context: Context?, val clickListener: MovieClickListener): RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    var movieList: List<Movie> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {

        val viewBinding: RowMovieBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.row_movie, parent, false
        )
        return MovieViewHolder(viewBinding)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.onBind(position)
    }

    fun setMovies(movies: List<Movie>) {
        this.movieList = movies
        notifyDataSetChanged()
    }

    inner class MovieViewHolder(private val viewBinding: RowMovieBinding): RecyclerView.ViewHolder(viewBinding.root) {

        fun onBind(position: Int) {

            val row = movieList[position]
            viewBinding.movie = row
            viewBinding.iMovieClick = clickListener
        }
    }
}