package cz.verunka.droid.ghibliki.views.movies

import cz.verunka.droid.ghibliki.db.model.Movie

interface IMovieClickListener {

    fun onItemClick(movie: Movie)
}