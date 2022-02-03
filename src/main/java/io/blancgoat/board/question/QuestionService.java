package io.blancgoat.board.question;

import io.blancgoat.board.question.dto.QuestionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;

    public Iterable<Question> getQuestions() {
        return questionRepository.findAll();
    }

    public Question getQuestion(Long id) {
        return questionRepository.findById(id).orElseThrow();
    }

    public void createQuestion(QuestionDto.WriteReq req) {
        questionRepository.save(req.toEntity());
    }
}
