package com.sunnylow.todo.repository;

import com.sunnylow.todo.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;
import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

	List<Category> findCategoryByUserId(Long userId);

//	@Query("select c from Category c inner join Todo t on t.category.id = c.id where t.startDate >= :startDate and t.startDate <= :endDate and c.user.id = :userId")
//	List<Category> findAllTodoByCategoriesForToday(
//			@Param("startDate") ZonedDateTime startDate,
//			@Param("endDate") ZonedDateTime endDate,
//			@Param("userId") Long userId
//			);

}
