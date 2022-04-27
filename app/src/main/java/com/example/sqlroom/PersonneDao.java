package com.example.sqlroom;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PersonneDao {
    @Query("SELECT * FROM personne")
    List<Personne> getAll();
    @Query("SELECT * FROM personne WHERE id IN (:ids)")
    List<Personne> loadAllById(int[] ids);
    @Query("SELECT * FROM personne WHERE first_name LIKE :first LIMIT 1")
    Personne findByName(String first);
    @Insert(onConflict = REPLACE)
    void insert(Personne personne);
    @Query("DELETE  FROM personne WHERE id = :id")
    void delete(int id);
    @Query("UPDATE personne SET first_name =:name WHERE id = :id")
    void update(String name, int id);
}
