package kotlinrest.com.kotlinrest.controller

import kotlinrest.com.kotlinrest.model.Band
import kotlinrest.com.kotlinrest.repository.BandRepository
import kotlinrest.com.kotlinrest.repository.GenderRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class BandController(private val bandRepository: BandRepository,
                     private val genderRepository: GenderRepository) {

    @GetMapping("/bands")
    fun getAllBands(): List<Band> = bandRepository.findAll()

    @PostMapping("/bands")
    fun createNewBand(@Valid @RequestBody band: Band) {
        band.gender?.let { genderRepository.save(it) }
        bandRepository.save(band)
    }

    @GetMapping("bands/{id}")
    fun getBandById(@PathVariable(value = "id") bandId: Long) : ResponseEntity<Band> {
        return bandRepository.findById(bandId).map { band ->
            ResponseEntity.ok(band)
        }.orElse(ResponseEntity.notFound().build())
    }

    @DeleteMapping("bands/{id}")
    fun deleteBandById(@PathVariable(value = "id") bandId: Long) : ResponseEntity<Void> {
        return bandRepository.findById(bandId).map { band ->
            bandRepository.delete(band)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }
}