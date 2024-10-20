package com.example.banquemisrchallenge05.data_layer.remote

import com.example.banquemisrchallenge05.utils.shared_models.Movie
import com.example.e_store.utils.data_layer.remote.shopify.TMDbAPIServices
import com.example.e_store.utils.data_layer.remote.shopify.TMDbRetrofitHelper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class TMDbRemoteDataSourceImpl private constructor() : TMDbRemoteDataSource {

    private val apiService: TMDbAPIServices = TMDbRetrofitHelper.api


    private val TAG = "EShopRemoteDataSourceImpl"

    companion object {
        @Volatile
        private var instance: TMDbRemoteDataSourceImpl? = null

        fun getInstance(): TMDbRemoteDataSourceImpl {
            return instance ?: synchronized(this) {
                instance ?: TMDbRemoteDataSourceImpl().also { instance = it }
            }
        }
    }

    override suspend fun fetchNowPlayingMovies(): Flow<List<Movie>> {
        val movies = apiService.fetchNowPlayingMovies().results

        return flowOf(movies)
    }
}
