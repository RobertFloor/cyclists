package com.ilionx.cyclists.api;


import com.ilionx.cyclists.model.Cyclist;
import com.ilionx.cyclists.service.CyclistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
