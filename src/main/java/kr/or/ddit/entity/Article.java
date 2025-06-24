package kr.or.ddit.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


// 1. 엔티티 선언
// 해당 클래스가 엔티티임을 선언합니다.
// Entity는 JPA에서 제공하는 어노테이션으로, 해당 어노테이션이 붙은 클래스를 기반으로
// db에 테이블이 생성됩니다.
// 테이블 이름은 클래스 이름과 동일하게 Article를 생성됩니다.
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Getter
@Entity
public class Article {


    // PK와 같은 대표값을 id로 선언합니다.
    // 대표값은 사람으로 치면 주민번호와 같습니다.
    // Article 엔티티 중에서 제목과 내용이 같을 때, 대표값 id로 다른 게시글임을 확인할
    // 수 있습니다.
    // @Id : Entity 의 대표값 설정
    // @GeneratedValue : 자동 생성 가능(PK는 번호값으로 자동증가의 값으로 활용)
    // - strategy = GenerationType.IDENTITY : 중복되지 않는 pk 번호를 만들어서 자동 생성해준다.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // dto 코드를 작성할 때와 같이 title,content 필드를 선언합니다.
    // 두 필드로 db에서 인식할 수 있도록 @Colum을 붙인다.
    // title 필드 선언, db 테이블의 title 열과 연결됩니다.
    @Column
    private  String title;
    // content 필드 선언, db 테이블의 content 열과 연결됩니다.
    @Column
    private String content;

    public void pacth(Article article) {
        if(article.title!=null){
            this.title=article.getTitle();
        }
        if(article.content!=null){
            this.content=article.getContent();
        }
    }
}
