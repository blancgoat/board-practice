package io.blancgoat.board.question;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    Question findByIdAndIsDelete(Long id, Boolean isDelete);
}
