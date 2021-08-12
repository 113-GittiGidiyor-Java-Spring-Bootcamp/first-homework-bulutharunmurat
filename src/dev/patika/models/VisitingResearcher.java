package dev.patika.models;

import javax.persistence.Entity;
import java.util.Objects;


@Entity
public class VisitingResearcher extends Instructor{


    private Float hourlySalary;

    public VisitingResearcher(String name, String address, String phoneNumber, Float hourlySalary) {
        super(name, address, phoneNumber);
        this.hourlySalary = hourlySalary;
    }

    public VisitingResearcher(Float hourlySalary) {
        this.hourlySalary = hourlySalary;
    }

    public VisitingResearcher(){

    }

    public Float getHourlySalary() {
        return hourlySalary;
    }

    public void setHourlySalary(Float hourlySalary) {
        this.hourlySalary = hourlySalary;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        VisitingResearcher that = (VisitingResearcher) o;
        return Objects.equals(hourlySalary, that.hourlySalary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), hourlySalary);
    }

    @Override
    public String toString() {
        return "VisitingResearcher{" +
                "hourlySalary=" + hourlySalary +
                '}';
    }
}
