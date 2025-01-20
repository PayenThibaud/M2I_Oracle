package org.example.exo4;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ArticleService {

    private final Map<Integer, Article> articles = new ConcurrentHashMap<>();

    public ArticleService() {
        articles.put(1, new Article(1, "Article 1"));
        articles.put(2, new Article(2, "Article 2"));
        articles.put(3, new Article(3, "Article 3"));
    }

    public Flux<Article> getAllArticle() {
        return Flux.fromIterable(articles.values());
    }
}
