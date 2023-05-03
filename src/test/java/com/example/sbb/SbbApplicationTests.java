package com.example.sbb;

import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDateTime;


import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SbbApplicationTests {
	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private AnswerRepository answerRepository;
	@Transactional
	@Test
	void testJpa() {
		Optional<Question> oq = this.questionRepository.findById(4);
		// 질문 4번을 oq 에 삽입
		assertTrue(oq.isPresent());
		// oq 에 데이터값이 있는지 확인
		Question q = oq.get();
		// oq 의 데이터를 전체조회

		List<Answer> answerList = q.getAnswerList();
		// q에 넣은 질문의 질문리스트를 앤서리스트에 넣음.
		assertEquals(1, answerList.size());
		// 앤서리스트의 사이즈가 1인지 확인
		assertEquals("네 자동으로 생성됩니다.", answerList.get(0).getContent());
		// 앤서리스트의 컨텐츠가 '네 자동으로 생성됩니다.'가 맞는지 확인
	}

}
