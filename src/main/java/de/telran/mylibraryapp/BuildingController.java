package de.telran.mylibraryapp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/buildings")
public class BuildingController {

    @GetMapping
    public List<Building> getAll() {
        return Building.buildingList;
    }


    @GetMapping("/searchById")
    public ResponseEntity<Building> getBildById(@RequestParam Integer id) {
        Optional<Building> building = Building.buildingList.stream().filter(b -> b.getId() == id).findAny();
        if (building.isPresent()) {
            return new ResponseEntity<>(building.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping
    public ResponseEntity<Building> addBuilding(@RequestBody Building building) {
        Building.buildingList.add(building);
        return new ResponseEntity<>(building, HttpStatus.CREATED);
    }


    @PutMapping
    public ResponseEntity<Building> updateBuilding(@RequestBody Building building) {
        if (Building.buildingList.contains(building)) {
            int index = Building.buildingList.indexOf(building);
            Building.buildingList.set(index, building);
            return new ResponseEntity<>(building, HttpStatus.OK);
        } else {
            Building.buildingList.add(building);
            return new ResponseEntity<>(building, HttpStatus.CREATED);
        }
    }


    @DeleteMapping
    public ResponseEntity<?> deleteById(@RequestParam Integer id) {
        Building.buildingList.removeIf(building -> building.getId() == id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


    @GetMapping("/serchByName")
    public List<Building> getBuildingByName(@RequestParam String name) {
        return Building.buildingList.stream().filter(b -> b.getName().startsWith(name)).toList();
    }

    @PatchMapping("/deleteAllZipCodes")
    public ResponseEntity<?> deleteAllZipCodes() {
        for (Building building : Building.buildingList) {
            Matcher m = Pattern.compile("(.+)\\s([A-Z]{2}\\d\\s\\d[A-Z]{2})")
                    .matcher(building.getAddress());
            if (m.find()) {
                building.setAddress(m.group(1));
            }
        }
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    // Рабочий вариант, но "в лоб"
//    @PatchMapping("/deleteAllZipCodes")
//    public ResponseEntity<?> deleteAllZipCodes() {
//        Building.buildingList.stream().forEach(building -> building.setAddress(building.getAddress().substring(0, building.getAddress().length() - 8)));
//        return new ResponseEntity<>(HttpStatus.ACCEPTED);
//    }
}
