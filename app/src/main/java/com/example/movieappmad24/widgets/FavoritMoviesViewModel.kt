package com.example.movieappmad24.widgets

import androidx.lifecycle.ViewModel
import com.example.movieappmad24.models.Movie

class FavoriteMoviesViewModel : ViewModel() {
    private val favorites = mutableSetOf<String>() //Set with movie IDs marked as favorit

    fun isFavorite(movieId: String): Boolean {
        return favorites.contains(movieId)
    }

    fun updateFavorites(movieId: String) {
        if (favorites.contains(movieId)) {
            favorites.remove(movieId)
        } else {
            favorites.add(movieId)
        }
        System.out.println("hsd")
    }

    fun getFavoriteMovies(movies: List<Movie>): List<Movie> {
        return movies.filter { it.id in favorites }
    }
}
