package com.Rioa.dao;

import com.Rioa.po.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<Type,Long> {
    Type findTypeByName(String name);
}
