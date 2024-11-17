package com.chein.task6.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@Data
@Accessors(chain = true)
public class Builder implements Comparable<Builder> {
    private String name;
    private String surname;
    private LocalDate birthDay;

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, birthDay);
    }

    @Override
    public boolean equals(Object o){
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Builder builder = (Builder) o;
        return Objects.equals(name, builder.name) && Objects.equals(surname, builder.surname)
                && Objects.equals(birthDay, builder.birthDay);
    }

    @Override
    public int compareTo(Builder o){
        if (this.equals(o)){
            return 0;
        }
        return this.surname.compareTo(o.surname);
    }
}
