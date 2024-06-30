package de.telran.mylibraryapp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Building {

    private int id;
    private String name;
    private String address;
    private boolean hasReadingRoom;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Building building = (Building) o;
        return id == building.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public static List<Building> buildingList = new ArrayList<>(List.of(
            new Building(1, "Christ's College", "St Andrew's St, Cambridge CB2 3BU", true),
            new Building(2, "Churchill College", "Storey's Way, Cambridge CB3 0DS", true),
            new Building(3, "Clare College", "Trinity Ln, Cambridge CB2 1TL", true),
            new Building(4, "Clare Hall", "Herschel Rd, Cambridge CB3 9AL", true),
            new Building(5, "Corpus Christi College", "Trumpington St, Cambridge CB2 1RH", true),
            new Building(6, "Darwin College", "Silver St, Cambridge CB3 9EU", true),
            new Building(7, "Downing College", "Regent St, Cambridge CB2 1DQ", true),
            new Building(8, "Emmanuel College", "St Andrew's St, Cambridge CB2 3AP", true),
            new Building(9, "Fitzwilliam College", "Storey's Way, Cambridge CB3 0DG", true),
            new Building(10, "Girton College", "Girton, Cambridge CB3 0JG", true),
            new Building(11, "Gonville and Caius College", "Trinity St, Cambridge CB2 1TA", true),
            new Building(12, "Homerton College", "Hills Rd, Cambridge CB2 8PH", true),
            new Building(13, "Hughes Hall", "Wollaston Rd, Cambridge CB1 2EW", true),
            new Building(14, "Jesus College", "Jesus Ln, Cambridge CB5 8BL", true),
            new Building(15, "King's College", "King's Parade, Cambridge CB2 1ST", true),
            new Building(16, "Lucy Cavendish College", "Lady Margaret Rd, Cambridge CB3 0BU", true),
            new Building(17, "Magdalene College", "Magdalene St, Cambridge CB3 0AG", true),
            new Building(18, "Murray Edwards College", "Huntingdon Rd, Cambridge CB3 0DF", true),
            new Building(19, "Newnham College", "Sidgwick Ave, Cambridge CB3 9DF", true),
            new Building(20, "Pembroke College", "Trumpington St, Cambridge CB2 1RF", true),
            new Building(21, "Peterhouse", "Trumpington St, Cambridge CB2 1RD", true),
            new Building(22, "Queens' College", "Silver St, Cambridge CB3 9ET", true),
            new Building(23, "Robinson College", "Grange Rd, Cambridge CB3 9AN", true),
            new Building(24, "Selwyn College", "Grange Rd, Cambridge CB3 9DQ", true),
            new Building(25, "Sidney Sussex College", "Sidney St, Cambridge CB2 3HU", true),
            new Building(26, "St Catharine's College", "Trumpington St, Cambridge CB2 1RL", true),
            new Building(27, "St Edmund's College", "Mount Pleasant, Cambridge CB3 0BN", true),
            new Building(28, "St John's College", "St John's St, Cambridge CB2 1TP", true),
            new Building(29, "Trinity College", "Trinity St, Cambridge CB2 1TQ", true),
            new Building(30, "Trinity Hall", "Trinity Ln, Cambridge CB2 1TJ", true),
            new Building(31, "Wolfson College", "Barton Rd, Cambridge CB3 9BB", true)
    ));
}
