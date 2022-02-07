package io.blancgoat.board.answer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AnswerService {

    private final AnswerRepository answerRepository;

    @Transactional(readOnly = true)
    public Iterable<Answer> getAnswers() {
        return answerRepository.findAll();
    }
}
