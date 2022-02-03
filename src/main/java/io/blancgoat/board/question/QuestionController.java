package io.blancgoat.board.question;

import io.blancgoat.board.question.dto.QuestionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/question")
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping
    public Iterable<Question> questions() {
        return questionService.getQuestions();
    }

    @GetMapping("/{id}")
    public Question question(@PathVariable Long id) {
        return questionService.getQuestion(id);
    }

    @Transactional
    @PostMapping
    public void question(@RequestBody QuestionDto.WriteReq req) {
        questionService.createQuestion(req);
    }
}
