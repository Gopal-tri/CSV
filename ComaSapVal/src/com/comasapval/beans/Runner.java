package com.comasapval.beans;

import java.io.File;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Stream;

class Question {
	String id;
	String question;
	String explanation;
	String answer;

	public Question() {
		super();
		this.id = id;
		this.question = question;
		this.explanation = explanation;
		this.answer = answer;
	}

	public String getId() {
		return id;
	}

	public void setId(String colms) {
		this.id = colms;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", question=" + question + ", explanation=" + explanation + ", answer=" + answer
				+ "]";
	}
}

public class Runner {
	public static void main(String[] args) throws IOException {

		Set<Question> mcQuestion = new HashSet<Question>();
		List<String> lines = Files.readAllLines(Paths.get("D:\\readquestion.csv"));

		for (String line : lines) {
			String colms[] = line.split(",");
			Question question = new Question();
			question.setId(colms[0]);
			question.setQuestion(colms[1]);
			question.setExplanation(colms[2]);
			question.setAnswer(colms[3]);

			mcQuestion.add(question);
		}

		mcQuestion.forEach(System.out::println);
		Stream<Question> sorted = mcQuestion.stream().sorted((o1, o2) -> {
			return o1.id.compareTo(o2.id);
		});
		sorted.forEach(System.out::println);
	}
}
