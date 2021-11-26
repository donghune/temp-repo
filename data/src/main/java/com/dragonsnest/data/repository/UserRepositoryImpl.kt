package com.dragonsnest.data.repository

import com.amplifyframework.api.graphql.model.ModelQuery
import com.amplifyframework.datastore.generated.model.User
import com.amplifyframework.kotlin.core.Amplify
import com.dragonsnest.data.mapper.toUserEntity
import com.dragonsnest.domain.entity.UserEntity
import com.dragonsnest.domain.repository.UserRepository
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class UserRepositoryImpl : UserRepository {
    override suspend fun fetchUsers(): Flow<List<UserEntity>> {
        return coroutineScope {
            Amplify.API.query(ModelQuery.list(User::class.java))
                .data.items.toList()
                .map { it.toUserEntity() }
                .let { flowOf(it) }
        }
    }
}
