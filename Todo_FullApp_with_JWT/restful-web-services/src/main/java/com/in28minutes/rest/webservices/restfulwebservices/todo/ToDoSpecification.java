package com.in28minutes.rest.webservices.restfulwebservices.todo;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class ToDoSpecification implements Specification<ToDo> {

    public ToDoSpecification(SearchCriteria searchcriteria) {
        criteria = searchcriteria;
    }


    private SearchCriteria criteria;

    @Override
    public Specification<ToDo> and(Specification<ToDo> other) {
        return null;
    }

    @Override
    public Specification<ToDo> or(Specification<ToDo> other) {
        return null;
    }

    @Override
    public Predicate toPredicate(Root<ToDo> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

        if (criteria.get_operation().equalsIgnoreCase(">")) {
            return builder.greaterThanOrEqualTo(root.<String>get(criteria.get_key()), criteria.get_value().toString());
        } else if (criteria.get_operation().equalsIgnoreCase("<")) {
            return builder.lessThanOrEqualTo(root.<String>get(criteria.get_key()), criteria.get_value().toString());
        } else if (criteria.get_operation().equalsIgnoreCase("==")) {
            return builder.equal(root.<String>get(criteria.get_key()), criteria.get_value().toString());
        } else if (criteria.get_operation().equalsIgnoreCase(":")) {
            if (root.get(criteria.get_key()).getJavaType() == String.class) {
                return builder.like(root.<String>get(criteria.get_key()), "%" + criteria.get_value() + "%");
            } else {
                return builder.equal(root.get(criteria.get_key()), criteria.get_value());
            }
        }
        return null;
    }
}
