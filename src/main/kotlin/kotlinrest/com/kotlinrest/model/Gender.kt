package kotlinrest.com.kotlinrest.model

import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
data class Gender (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @get: NotBlank
    val name: String = "",

    @JsonManagedReference
    @OneToMany(mappedBy = "gender", cascade = arrayOf(CascadeType.ALL), fetch = FetchType.EAGER)
    var bands: List<Band> = emptyList()
)