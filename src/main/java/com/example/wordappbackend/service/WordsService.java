package com.example.wordappbackend.service;

import java.util.List;
import java.util.Optional;

import com.example.wordappbackend.model.Words;

public interface WordsService {
	
	Words addWord(Words word);
	List<Words> getWordList();
	Optional<Words> getWordById(int id);
	Optional<Words> updateWords(Words word);
	Optional<Words> deleteWord(int id);
}
