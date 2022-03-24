package com.example.accessingdatamysql

import org.hibernate.*
import javax.persistence.*

@Suppress("unused")
@Entity
data class User(
    var name: String? = null,
    var email: String? = null,
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int? = null
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as User

        return (id != null) && (id == other.id)
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , name = $name , email = $email )"
    }
}
