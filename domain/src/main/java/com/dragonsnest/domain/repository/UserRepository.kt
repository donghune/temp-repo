package com.dragonsnest.domain.repository

import com.dragonsnest.domain.entity.UserEntity
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun fetchUsers(): Flow<List<UserEntity>>
}
