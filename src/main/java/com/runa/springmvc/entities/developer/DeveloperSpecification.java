package com.runa.springmvc.entities.developer;

import org.springframework.data.jpa.domain.Specification;

public class DeveloperSpecification {
    
    public static Specification<Developer> developerNameStartsWith(final String firstLetter) {
        return (r, cq, cb) -> cb.like(r.get("firstName"), firstLetter + "%");
    }
}

//  public static Specification<Developer> developerNameStartsWith(final String firstLetter) {
//    return new Specification<Developer>() {
//      @Override
//      public Predicate toPredicate(Root<Developer> root,
//                                   CriteriaQuery<?> criteriaQuery,
//                                   CriteriaBuilder criteriaBuilder) {
//        return criteriaBuilder.equal(root.get("firstName"), firstLetter + "%");
//      }
//    };
//  }
//}