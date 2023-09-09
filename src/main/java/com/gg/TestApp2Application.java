package com.gg;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.openkoreantext.processor.KoreanTokenJava;
import org.openkoreantext.processor.OpenKoreanTextProcessorJava;
import org.openkoreantext.processor.phrase_extractor.KoreanPhraseExtractor;
import org.openkoreantext.processor.tokenizer.KoreanTokenizer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import scala.collection.Seq;

@SpringBootApplication
public class TestApp2Application {

	public static void main(String[] args) {
		SpringApplication.run(TestApp2Application.class, args);
		System.out.println("hi! Main..");
		
		// OKT test
		String text = "한국어 분석 테스트입니다.";
        
        System.out.println("test");
        // Normalize
        CharSequence normalized = OpenKoreanTextProcessorJava.normalize(text);
        
        // Tokenize
		Seq<KoreanTokenizer.KoreanToken> tokens = OpenKoreanTextProcessorJava.tokenize(normalized);
		
		List<KoreanTokenJava> tokenList = OpenKoreanTextProcessorJava.tokensToJavaKoreanTokenList(tokens);

		// Phrase Extraction
		List<KoreanPhraseExtractor.KoreanPhrase> phrases = OpenKoreanTextProcessorJava.extractPhrases(tokens, true, true);
    
        System.out.println(normalized);
		System.out.println(tokens);
		System.out.println(tokenList);
		System.out.println(phrases);
	}

}
