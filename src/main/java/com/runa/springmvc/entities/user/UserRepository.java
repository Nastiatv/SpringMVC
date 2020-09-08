package com.runa.springmvc.entities.user;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.sql.DataSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository implements IUserRepository {

    private JdbcTemplate jdbcTemplate;

    @PersistenceContext
    protected EntityManager entityManager;

    public UserRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void saveOrUpdate(User user) {
        if (user.getId() > 0) {
            String sql = "UPDATE users SET name=?, email=?, address=?, WHERE id=?";
            jdbcTemplate.update(sql, user.getName(), user.getEmail(),
                    user.getAddress(), user.getId());
        } else {
            String sql = "INSERT INTO users (name, email, address) VALUES (:name, :email, :address)";
            Map<String, String> params = new HashMap<>();
            params.put("name", user.getName());
            params.put("email", user.getEmail());
            params.put("address", user.getAddress());
            jdbcTemplate.update(sql, params);
        }
    }

    @Override
    public void delete(Long userId) {
        String sql = "DELETE FROM users WHERE id=?";
        jdbcTemplate.update(sql, userId);
    }

    @Override
    public List<User> getAll() {
        try {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<User> cq = cb.createQuery(User.class);
            Root<User> rootEntry = cq.from(User.class);
            cq.select(rootEntry);
            TypedQuery<User> result = entityManager.createQuery(cq);
            return result.getResultList();
        } catch (NoResultException e) {
            return Collections.emptyList();
        }
    }

    @Override
    public User get(Long userId) {
        String sql = "SELECT * FROM users where id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{userId}, new BeanPropertyRowMapper<User>(User.class));
    }
}
