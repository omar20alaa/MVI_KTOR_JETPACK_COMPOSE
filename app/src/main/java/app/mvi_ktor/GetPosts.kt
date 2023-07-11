package app.mvi_ktor

import app.mvi_ktor.ui.network.PostApi
import app.mvi_ktor.ui.network.model.Post
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetPosts(
    private val postApi: PostApi
) {

    fun execute(): Flow<DataState<List<Post>>> {
        return flow {
            emit(DataState.Loading(true))
            try {
                val posts = postApi.getPosts()
                emit(DataState.Success(posts))
            } catch (e: Exception) {
                e.printStackTrace()
                emit(DataState.Error(UIComponent.Toast(e.message ?: "Unknown Error")))
            }finally {
                emit(DataState.Loading(false))
            }
        }
    }

}