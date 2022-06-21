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
    public List<Cyclist> findAllCyclists() {
        return this.cyclistService.findAll();
    }

    @PostMapping
    public Cyclist create(@RequestBody Cyclist cyclist) {
        return cyclistService.save(cyclist);
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

    @PutMapping("{id}")
    public ResponseEntity<Cyclist> updateCyclistById (@PathVariable Long id, @RequestBody Cyclist desiredCyclist) {
        Optional<Cyclist> optionalCyclist = this.cyclistService.findById(id);
        if (optionalCyclist.isPresent()) {
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
}
