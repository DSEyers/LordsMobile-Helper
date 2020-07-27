package com.dsetech.lordsmobilehelper.persistance.model;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Accessors(chain = true)    // Setters return 'this' to allow call chaining, default 'void'
@Entity
@Table(name = "player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NonNull
    private String name;

    private String country;
    private String line_id;
    private LocalDate date_created;

    public void setId(long id) {
        this.id = id;
    }
}
