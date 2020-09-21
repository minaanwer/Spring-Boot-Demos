package test.datetime.example.demo.entity;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import test.datetime.example.demo.entity.SearchCriteria;
import test.datetime.example.demo.entity.SpecificationOf;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor
public class SpecificationsBuilder<T> {
    List<SearchCriteria> searchCriterias;

    public Specification<T> build(){
        Specification<T> result = null;
        for (SearchCriteria searchCriteria: searchCriterias) {
            SpecificationOf<T> specs = new SpecificationOf<T>(searchCriteria);
            result = Objects.requireNonNull(Specification.where(result)).and(specs);
        }
        return result;
    }
}