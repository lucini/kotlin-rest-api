package kotlinrest.com.kotlinrest.repository

import kotlinrest.com.kotlinrest.model.Band
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BandRepository : JpaRepository<Band, Long>