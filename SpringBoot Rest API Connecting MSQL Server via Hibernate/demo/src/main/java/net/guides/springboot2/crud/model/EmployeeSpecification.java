package net.guides.springboot2.crud.model;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class EmployeeSpecification implements Specification<Employee> {

    public EmployeeSpecification(SearchCriteria searchcriteria) {
        criteria = searchcriteria;
    }


    private SearchCriteria criteria;

    @Override
    public Specification<Employee> and(Specification<Employee> other) {
        return null;
    }

    @Override
    public Specification<Employee> or(Specification<Employee> other) {
        return null;
    }

    @Override
    public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

        if (criteria.get_operation().equalsIgnoreCase(">")) {
            return builder.greaterThanOrEqualTo(root.get(criteria.get_key()), criteria.get_value());
        } else if (criteria.get_operation().equalsIgnoreCase("<")) {
            return builder.lessThanOrEqualTo(root.get(criteria.get_key()), criteria.get_value());
        } else if (criteria.get_operation().equalsIgnoreCase("==")) {
            return builder.equal(root.<String>get(criteria.get_key()), criteria.get_value());
        } else if (criteria.get_operation().equalsIgnoreCase(":")) {
            if (root.get(criteria.get_key()).getJavaType() == String.class) {
                return builder.like(root.get(criteria.get_key()), "%" + criteria.get_value() + "%");
            } else {
                return builder.equal(root.get(criteria.get_key()), criteria.get_value());
            }
        }
        return null;
    }
}
