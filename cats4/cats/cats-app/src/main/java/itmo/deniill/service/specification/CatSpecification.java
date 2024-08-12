package itmo.deniill.service.specification;

import itmo.deniill.dao.entities.Cat;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

import static itmo.deniill.service.specification.CastToType.castToRequiredType;

public class CatSpecification {
    public static Specification<Cat> createSpecification(CatFilter input) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get(String.valueOf(input.getField())),
                        castToRequiredType(root.get(String.valueOf(input.getField())).getJavaType(),
                                input.getValue()));
    }

    public static Specification<Cat> getSpecificationFromFilters(List<CatFilter> filter){
        if(filter == null || filter.isEmpty()){
            return null;
        }
        Specification<Cat> specification = createSpecification(filter.getFirst());
        filter.remove(filter.getFirst());
        for (CatFilter input : filter) {
            specification = specification.and(createSpecification(input));
        }
        return specification;
    }
}
