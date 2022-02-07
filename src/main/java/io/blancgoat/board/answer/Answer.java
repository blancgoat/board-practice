package io.blancgoat.board.answer;

import io.blancgoat.board.common.AbstractAuditEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "answer")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Answer extends AbstractAuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "is_delete", nullable = false)
    private Boolean isDelete = false;

    @Column(name = "member_id", nullable = false)
    private Long memberId;

    @Column(name = "question_id", nullable = false)
    private Long questionId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(name = "like_count", nullable = false)
    private int likeCount = 0;

    @Builder(builderMethodName = "generalAnswerBuilder")
    public Answer(Long memberId, Long questionId, String title, String description) {
        this.memberId = memberId;
        this.questionId = questionId;
        this.title = title;
        this.description = description;
    }

    public void updateTitleAndDescription(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public void updateIsDeleteToTrue() {
        this.isDelete = true;
    }
}
