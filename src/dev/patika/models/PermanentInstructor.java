package dev.patika.models;

import javax.persistence.Entity;
import java.util.Objects;


@Entity
public class PermanentInstructor extends Instructor{

    private Float fixedSalary;

    public PermanentInstructor(String name, String address, String phoneNumber, Float fixedSalary) {
        super(name, address, phoneNumber);
        this.fixedSalary = fixedSalary;
    }

    public PermanentInstructor(Float fixedSalary) {
        this.fixedSalary = fixedSalary;
    }

    public PermanentInstructor( ) {
    }

    public Float getFixedSalary() {
        return fixedSalary;
    }

    public void setFixedSalary(Float fixedSalary) {
        this.fixedSalary = fixedSalary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PermanentInstructor that = (PermanentInstructor) o;
        return Objects.equals(fixedSalary, that.fixedSalary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), fixedSalary);
    }

    @Override
    public String toString() {
        return "PermanentInsructor{" +
                "fixedSalary=" + fixedSalary +
                '}';
    }
}
