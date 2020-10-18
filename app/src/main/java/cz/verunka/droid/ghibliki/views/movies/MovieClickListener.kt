package cz.verunka.droid.ghibliki.views.movies

import cz.verunka.droid.ghibliki.db.model.Movie

interface MovieClickListener {

    fun onItemClick(movie: Movie)
}