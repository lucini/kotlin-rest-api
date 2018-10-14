package kotlinrest.com.kotlinrest.repository

import kotlinrest.com.kotlinrest.model.Gender
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface GenderRepository: JpaRepository<Gender, Long>