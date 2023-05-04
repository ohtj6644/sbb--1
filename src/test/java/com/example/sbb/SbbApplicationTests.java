package com.example.sbb;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.Optional;

import com.example.sbb.sbb.Answer.Answer;
import com.example.sbb.sbb.Answer.AnswerRepository;
import com.example.sbb.sbb.Question.Question;
import com.example.sbb.sbb.Question.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class SbbApplicationTests {

	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private AnswerRepository answerRepository;

	@Test
	void testJpa() {
		Optional<Question> oq = this.questionRepository.findById(2);
		// 답변달 질문번호 1번을 oq 옵셔널에 저장
		assertTrue(oq.isPresent());
		// oq 값이 비어있지 않은지 확인
		Question q = oq.get();
		// oq 데이터 값을 q에 저장

		Answer a = new Answer();
		//앤서 에이 는 뉴엔서
		a.setContent("네 자동으로 생성됩니다.");
		// 에이의 카운트에 답변 저장
		a.setQuestion(q);  // 어떤 질문의 답변인지 알기위해서 Question 객체가 필요하다.
		// 에이의 퀘스쳔에 q 를 저장
		a.setCreateDate(LocalDateTime.now());
		// 에이의 데이트타임에 현재시간 저장
		this.answerRepository.save(a);
		// 저장된 a 값을 앤서 테이블에 저장
	}
}