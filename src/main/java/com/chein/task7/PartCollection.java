package com.chein.task7;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class PartCollection<T> {

    public PartCollection<T> prev;

    public PartCollection<T> next;
    public T value;
    public PartCollection(T value, PartCollection<T> next, PartCollection<T> prev){
        this.value = value;
        this.next = next;
        this.prev = prev;
    }

    public PartCollection(T value) {
        this(value, null, null);
    }

    public PartCollection() {
        this(null, null, null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PartCollection<T> that = (PartCollection<T>) o;
        return Objects.equals(value, that.value);
    }
    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
