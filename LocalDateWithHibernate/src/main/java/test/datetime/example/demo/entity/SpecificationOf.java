package test.datetime.example.demo.entity;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import test.datetime.example.demo.entity.SearchCriteria;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@AllArgsConstructor
public class SpecificationOf<T> implements Specification<T> {
    private SearchCriteria criteria;
    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        switch (criteria.getOperation()){
            case Equal:
                if (root.get(criteria.getKey()).getJavaType() == String.class)
                    return criteriaBuilder.like(root.get(criteria.getKey()), "%" + criteria.getValue() + "%");
                else
                    return criteriaBuilder.equal(root.get(criteria.getKey()), criteria.getValue());
            case LessThan:
                return criteriaBuilder.lessThan(root.get(criteria.getKey()), criteria.getValue().toString());
            case GreaterThan:
                return criteriaBuilder.greaterThan(root.get(criteria.getKey()), criteria.getValue().toString());
            case LessThanOrEqual:
                return criteriaBuilder.lessThanOrEqualTo(root.get(criteria.getKey()), criteria.getValue().toString());
            case GreaterThanOrEqual:
                return criteriaBuilder.greaterThanOrEqualTo(root.get(criteria.getKey()), criteria.getValue().toString());
            case EqualIn:
                return criteriaBuilder.in(root.get(criteria.getKey()).in(criteria.getValue()));
            default:
                return null;
        }
    }

}
