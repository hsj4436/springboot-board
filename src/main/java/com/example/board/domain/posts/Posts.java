package com.example.board.domain.posts;

import com.example.board.domain.reply.Reply;
import com.example.board.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @ColumnDefault("0")
    private Long count;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @OneToMany(mappedBy = "posts", fetch = FetchType.EAGER)
    private List<Reply> reply;

    @CreationTimestamp
    private Timestamp createDate;

    @Builder
    public Posts(String title, String content, User user) {
        this.title = title;
        this.content = content;
        /**
         * this.count = 0L일 때 객체 생성 문제 없음
         * 이를 주석처리하고 count를 set하지 않은 채로 객체 생성 시 count는 null이 됨
         * count에 @ColumnDefault를 붙여놨기 때문에, null로 들어가면 에러가 발생할 것
         */
        this.count = 0L;
        this.user = user;
    }
}


