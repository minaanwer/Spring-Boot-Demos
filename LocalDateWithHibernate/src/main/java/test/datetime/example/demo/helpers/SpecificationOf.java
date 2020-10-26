package test.datetime.example.demo.helpers;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
            case DataRange:
                    return  criteriaBuilder.between(root.get("switchDate"),((LocalDate[])criteria.getValue())[0], ((LocalDate[])criteria.getValue())[1]);

            case Between:
                ParameterExpression<LocalDateTime> parameter = criteriaBuilder.parameter(LocalDateTime.class);

                Predicate startDatePredicate = criteriaBuilder.greaterThanOrEqualTo(root.get(criteria.getKeys().get(0)), parameter);
                Predicate endDatePredicate = criteriaBuilder.lessThanOrEqualTo(root.get(criteria.getKeys().get(1)), parameter);

                return criteriaBuilder.and(startDatePredicate, endDatePredicate);

            case myBetween:
                try {
                    return  criteriaBuilder.between(root.get("creationDateTime"),(new SimpleDateFormat("yyyy-MM-dd HH:mm").parse("2019-10-25 15:07")),
                            (new SimpleDateFormat("yyyy-MM-dd HH:mm").parse("2020-10-26 18:07")));
                } catch (ParseException e) {
                    //e.printStackTrace();
                }


            default:
                return null;
        }
    }

}
