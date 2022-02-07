package io.blancgoat.board.question;

import io.blancgoat.board.question.dto.QuestionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/question")
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping
    public Iterable<Question> getQuestions() {
        return questionService.getQuestions();
    }

    @GetMapping("/{id}")
    public Question getQuestion(@PathVariable Long id) {
        return questionService.getQuestion(id);
    }

    @PostMapping
    public Question postQuestion(@RequestBody QuestionDto.WritePostReq req) {
        return questionService.createQuestion(req);
    }

    @PatchMapping("/{id}")
    public void patchQuestion(@PathVariable Long id, @RequestBody QuestionDto.WritePatchReq req) {
        questionService.updateQuestion(id, req);
    }

    @DeleteMapping("/{id}")
    public void deleteQuestion(@PathVariable Long id) {
        questionService.deleteQuestion(id);
    }
}
