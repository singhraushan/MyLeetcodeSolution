package com.rau.leetcode.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;


public class AlepLab {
    public static void main(String[] args) {

        List<BlogPost> postList = new ArrayList<>();
        postList.add(new BlogPost("title1", "author1", BlogPostType.NEWS, 15));
        postList.add(new BlogPost("title2", "author1", BlogPostType.GUIDE, 10));
        postList.add(new BlogPost("title3", "author1", BlogPostType.NEWS, 18));
        postList.add(new BlogPost("title4", "author2", BlogPostType.REVIEW, 25));
        postList.add(new BlogPost("title5", "author2", BlogPostType.GUIDE, 15));

        Map<Tuple, List<BlogPost>> groupByTypeAndAuthorPost = postList.stream()
                .collect(Collectors.groupingBy(post -> new Tuple(post.getType(), post.getAuthor())));

        for (Map.Entry<Tuple, List<BlogPost>> entry : groupByTypeAndAuthorPost.entrySet()) {
            System.out.print("key: "+entry.getKey()+" values: ");
            entry.getValue().stream().forEach(System.out::println);
            System.out.println();
        }

    }
}

class BlogPost {
    String title;
    String author;
    BlogPostType type;
    int likes;

    public BlogPost(String title, String author, BlogPostType type, int likes) {
        this.title = title;
        this.author = author;
        this.type = type;
        this.likes = likes;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public BlogPostType getType() {
        return type;
    }

    public int getLikes() {
        return likes;
    }

    @Override
    public String toString() {
        return "BlogPost{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", type=" + type +
                ", likes=" + likes +
                '}';
    }
}

class Tuple {
    BlogPostType type;
    String author;

    public Tuple(BlogPostType type, String author) {
        this.type = type;
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tuple)) return false;
        Tuple tuple = (Tuple) o;
        return type == tuple.type &&
                author.equals(tuple.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, author);
    }

    @Override
    public String toString() {
        return "Tuple{" +
                "type=" + type +
                ", author='" + author + '\'' +
                '}';
    }
}

enum BlogPostType {
    NEWS, REVIEW, GUIDE
}