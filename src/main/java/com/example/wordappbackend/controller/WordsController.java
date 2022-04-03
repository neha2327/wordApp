package com.example.wordappbackend.controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.wordappbackend.model.Words;
import com.example.wordappbackend.service.WordsService;

@CrossOrigin
@RestController
@RequestMapping(value = "/api")
public class WordsController {
	
	private static final Logger log = LoggerFactory.getLogger(WordsController.class);
	
	@Autowired
	WordsService wordsService;
	
	@PostMapping
	public ResponseEntity<Words> addWord(@RequestBody Words words) {
		log.info("adding word {}",words);
		Words wordRes = wordsService.addWord(words);		
		return new ResponseEntity<Words>(wordRes,HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Words>> getWords() {	
		log.info("get list of words");
		List<Words> wordlist = wordsService.getWordList();		
		return new ResponseEntity<List<Words>>(wordlist, HttpStatus.OK);
	}
	
	@GetMapping("/wordById/{id}")
	public ResponseEntity<Words> wordGetById(@PathVariable(value = "id") Integer id) {
		log.info("get word by id");
		Optional<Words> wordRes = wordsService.getWordById(id);
		if(wordRes.isPresent()) {
			return new ResponseEntity<>(wordRes.get(), HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}		
	}
	
	@PutMapping
	public ResponseEntity<Words> updateWord( @RequestBody Words word) {
		log.info("update word");
		Optional<Words> wordRes = wordsService.updateWords(word);
		if(wordRes.isPresent()) {
			return new ResponseEntity<>(wordRes.get(), HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}		
	}
	
	@DeleteMapping("/wordDelete")
	public ResponseEntity<Words> deleteWord(@PathParam(value = "id") Integer id) {
		log.info("delete word");
		Optional<Words> wordRes = wordsService.deleteWord(id);
		if(wordRes.isPresent()) {
			return new ResponseEntity<>(wordRes.get(), HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	

}
