package io.blancgoat.board.question;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.blancgoat.board.answer.Answer;
import io.blancgoat.board.common.AbstractAuditEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "question")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
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

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "question")
    private List<Answer> answers = new ArrayList<>();

    @Builder(builderMethodName = "generalQuestionBuilder")
    public Question(Long memberId, String title, String description) {
        this.memberId = memberId;
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
