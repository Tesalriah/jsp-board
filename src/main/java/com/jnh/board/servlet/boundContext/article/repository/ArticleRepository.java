package com.jnh.board.servlet.boundContext.article.repository;

import com.jnh.board.db.DBConnection;
import com.jnh.board.servlet.boundContext.article.dto.ArticleDto;
import com.jnh.board.servlet.boundContext.article.entity.Article;
import com.jnh.board.servlet.boundContext.base.Container;
import com.jnh.board.servlet.boundContext.member.dto.Member;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ArticleRepository {
    private List<Article> articleList;
    DBConnection dbConnection;

    public ArticleRepository() {
        articleList = new ArrayList<>();
        dbConnection = Container.dbConnection;
    }

    public List<Article> findAll() {
        articleList = new ArrayList<>();
        List<Map<String, Object>> rows =  dbConnection.selectRows("select * from article");

        for(Map<String, Object> row : rows){
            Article article = new Article(row);
            articleList.add(article);
        }

        return articleList;
    }

    public List<ArticleDto> joinMemberFindAll() {
        List<ArticleDto> articleList = new ArrayList<>();
        List<Map<String,Object>> rows = dbConnection.selectRows("""
                SELECT A.id, A.title, A.content, M.username, A.regDate
                FROM `article` as A
                INNER JOIN `member` AS M
                ON A.member_id = M.id
                ORDER BY A.id DESC
                """);
        for(Map<String,Object> row : rows){
            articleList.add(new ArticleDto(row));
        }

        return articleList;
    }

    public ArticleDto joinMemberFindById(long id) {
        Map<String, Object> row = dbConnection.selectRow("""
                SELECT A.id, A.title, A.content, M.username, A.regDate 
                FROM `article` as A
                INNER JOIN `member` AS M
                ON A.member_id = M.id
                WHERE A.id = %d
                """.formatted(id));

        return new ArticleDto(row);
        }

    public long save(String title, String content, Member member) {

        int id = dbConnection.insert("""
                insert into article
                set title = '%s',
                content = '%s',
                member_id = %d,
                regDate = now()
                """.formatted(title, content, member.getId())
        );

        return id;
    }

    public Article findById(long id) {
        Map<String, Object> row = dbConnection.selectRow("select * from article where id = %d".formatted(id));

        Article article = new Article(row);

        return article;
    }

    public void modify(long id, String title, String content) {
        dbConnection.update("""
                update article set title = '%s', content = '%s' where id = %d
                """.formatted(title,content,id));
    }

    public void delete(long id) {
        dbConnection.delete("delete from article where id = %d".formatted(id));
    }
}
