package com.jnh.board.servlet.boundContext.article.repository;

import com.jnh.board.db.DBConnection;
import com.jnh.board.servlet.boundContext.article.dto.Article;
import com.jnh.board.servlet.boundContext.base.Container;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.LongStream;

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

    public long save(String title, String content) {
        int id = dbConnection.insert("""
                insert into article
                set title = '%s',
                content = '%s'
                """.formatted(title, content)
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
