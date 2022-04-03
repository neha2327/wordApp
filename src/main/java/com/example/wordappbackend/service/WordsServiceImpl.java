package com.example.wordappbackend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.wordappbackend.model.Words;
import com.example.wordappbackend.repository.WordsRepository;

@Service
public class WordsServiceImpl implements WordsService {
	
	@Autowired
	WordsRepository wordRepository;

	@Override
	public Words addWord(Words word) {
		Words wordRes =  wordRepository.save(word);
		return wordRes;
	}

	@Override
	public List<Words> getWordList() {
		List<Words> wordList = wordRepository.findAll();
		return wordList;
	}

	@Override
	public Optional<Words> getWordById(int id) {		
		Optional<Words> wordRes = wordRepository.findById(id);			
		return wordRes;
	}

	@Override
	public Optional<Words> updateWords(Words word) {
		Optional<Words> wordRes = wordRepository.findById(word.getId());
		if(wordRes.isPresent()) {
			Words wo = wordRes.get();
			wo.setWord(word.getWord());
			wordRepository.save(wo);		
			
		}		
		return wordRes;
	}

	@Override
	public Optional<Words> deleteWord(int id) {
		Optional<Words> wordRes = wordRepository.findById(id);
		if(wordRes.isPresent()) {
			wordRepository.deleteById(wordRes.get().getId());			
		}
		return wordRes;
	}
	

}
