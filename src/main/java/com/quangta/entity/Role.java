package com.quangta.entity;

import java.util.Set;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Role {
    @Id
    String name;

    String description;

    @ManyToMany
    Set<Permission> permissions;
}
