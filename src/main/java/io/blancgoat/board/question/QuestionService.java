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
        return questionRepository.findByIdAndIsDelete(id, false);
    }

    public Question createQuestion(QuestionDto.WritePostReq req) {
        return questionRepository.save(req.toEntity());
    }

    public Long updateQuestion(Long id, QuestionDto.WritePatchReq req) {
        Question question = questionRepository.findById(id).orElseThrow();
        question.updateTitleAndDescription(req.getTitle(), req.getDescription());

        return id;
    }

    public void deleteQuestion(Long id) {
        Question question = questionRepository.findById(id).orElseThrow();
        question.updateIsDeleteToTrue();
    }
}
