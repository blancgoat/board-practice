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
    public static class WritePostReq {
        private Long memberId;
        private String title;
        private String description;

        @Builder
        WritePostReq(Long memberId, String title, String description) {
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

    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @Getter
    public static class WritePatchReq {
        private String title;
        private String description;

        @Builder
        WritePatchReq(String title, String description) {
            this.title = title;
            this.description = description;
        }

        public Question toEntity() {
            return Question.generalQuestionBuilder()
                    .title(title)
                    .description(description)
                    .build();
        }
    }
}
