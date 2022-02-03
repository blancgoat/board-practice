package io.blancgoat.board.question;

import io.blancgoat.board.common.AbstractAuditEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "question")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Question extends AbstractAuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "is_delete", nullable = false)
    private Boolean isDelete = false;

    @Column(name = "member_id", nullable = false)
    private Long memberId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(name = "view_count", nullable = false)
    private int viewCount = 0;

    @Column(name = "like_count", nullable = false)
    private int likeCount = 0;

    @Builder(builderMethodName = "generalQuestionBuilder")
    public Question(Long memberId, String title, String description) {
        this.memberId = memberId;
        this.title = title;
        this.description = description;
    }
}
