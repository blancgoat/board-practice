package io.blancgoat.board.question.dto;

import io.blancgoat.board.question.Question;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class QuestionDto {

    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @Getter
    public static class WriteReq {
        private Long memberId;
        private String title;
        private String description;

        @Builder
        WriteReq(Long memberId, String title, String description) {
            this.memberId = memberId;
            this.title = title;
            this.description = description;
        }

        public Question toEntity() {
            return Question.generalQuestionBuilder()
                    .memberId(memberId)
                    .title(title)
                    .description(description)
                    .build();
        }
    }
}
