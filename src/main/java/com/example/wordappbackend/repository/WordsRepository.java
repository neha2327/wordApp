package com.example.wordappbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.wordappbackend.model.Words;

public interface WordsRepository extends JpaRepository<Words, Integer> {

}
