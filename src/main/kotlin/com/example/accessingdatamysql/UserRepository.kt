package com.example.accessingdatamysql

import org.springframework.data.repository.CrudRepository

@Suppress("unused")
interface UserRepository: CrudRepository<User, Int> {
}