package net.javaguides.springboot.controller;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.model.Sector;
import net.javaguides.springboot.repository.SectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000"})
@RestController
@RequestMapping("/api/v1/sectors")
public class SectorController {

    @Autowired
    private SectorRepository sectorRepository;

    @GetMapping
    public List<Sector> getAllSectors() {
        return sectorRepository.findAll();
    }

    @PostMapping
    public Sector createSector(@RequestBody Sector sector) {
        return sectorRepository.save(sector);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sector> getSectorById(@PathVariable Long id) {
        Sector sector = sectorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Sector not found with id " + id));
        return ResponseEntity.ok(sector);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSector(@PathVariable Long id) {
        Sector sector = sectorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Sector not found with id " + id));
        sectorRepository.delete(sector);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/api/v1/sectors/{id}")
    public ResponseEntity<Sector> updateSector(@PathVariable Long id, @RequestBody Sector
    sectorDetails){
        Sector sector = sectorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sector not exist with id :" +
                id));

        sector.setName(sectorDetails.getName());

        Sector updatedSector = sectorRepository.save(sector);
        return ResponseEntity.ok(updatedSector);
    }


}
