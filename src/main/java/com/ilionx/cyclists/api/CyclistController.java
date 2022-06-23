package com.ilionx.cyclists.api;


import com.ilionx.cyclists.model.Cyclist;
import com.ilionx.cyclists.service.CyclistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cyclists")
public class CyclistController {

    @Autowired
    private CyclistService cyclistService;

    @GetMapping
    public ResponseEntity<List<Cyclist>> findAllCyclists() {
        return ResponseEntity.ok(this.cyclistService.findAll());
    }

    @PostMapping
    public ResponseEntity<Cyclist> create(@RequestBody Cyclist cyclist) {
        // eventueel ResponseEntity.created(...) maar dat behandelen we later evt.
        return ResponseEntity.ok(cyclistService.save(cyclist));
    }

    @GetMapping("{id}")
    public ResponseEntity<Cyclist> findById (@PathVariable Long id) {
        Optional<Cyclist> optionalCyclist = this.cyclistService.findById(id);
        if (optionalCyclist.isPresent()) {
            return new ResponseEntity<>(optionalCyclist.get(), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping ("{id}")
    public ResponseEntity<Cyclist> deleteById (@PathVariable Long id) {
        Optional<Cyclist> optionalCyclist = this.cyclistService.findById(id);
        if (optionalCyclist.isPresent()) {
            this.cyclistService.deleteById(id);
            return new ResponseEntity<>(optionalCyclist.get(), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Cyclist> updateCyclistById (@PathVariable Long id, @RequestBody Cyclist desiredCyclist) {
        Optional<Cyclist> optionalCyclist = this.cyclistService.findById(id);
        if (optionalCyclist.isPresent()) {
            // later geleerd dat dit werk eigenlijk in de Service hoort.
            Cyclist target = optionalCyclist.get();
            target.setName(desiredCyclist.getName());
            target.setTeam(desiredCyclist.getTeam());
            target.setRanking(desiredCyclist.getRanking());

            return new ResponseEntity<>(this.cyclistService.save(target), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/name/{name}")
    public List<Cyclist> findByName (@PathVariable String name) {
        return this.cyclistService.findByName(name);

    }
}
