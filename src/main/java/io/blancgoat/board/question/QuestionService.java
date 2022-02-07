package io.blancgoat.board.question;

import io.blancgoat.board.question.dto.QuestionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class QuestionService {

    private final QuestionRepository questionRepository;

    @Transactional(readOnly = true)
    public Iterable<Question> getQuestions() {
        return questionRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Question getQuestion(Long id) {
        return questionRepository.findByIdAndIsDelete(id, false);
    }

    @Transactional
    public Question createQuestion(QuestionDto.WritePostReq req) {
        return questionRepository.save(req.toEntity());
    }

    @Transactional
    public Long updateQuestion(Long id, QuestionDto.WritePatchReq req) {
        Question question = questionRepository.findById(id).orElseThrow();
        question.updateTitleAndDescription(req.getTitle(), req.getDescription());

        return id;
    }

    @Transactional
    public void deleteQuestion(Long id) {
        Question question = questionRepository.findById(id).orElseThrow();
        question.updateIsDeleteToTrue();
    }
}
