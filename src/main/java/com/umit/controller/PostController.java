package com.umit.controller;

import com.umit.entity.Post;
import com.umit.entity.User;
import com.umit.repository.PostRepository;

import java.util.List;

public class PostController {
    public void postlariGoruntule(User user) {
        PostRepository postRepository = new PostRepository();
        List<Post> posts = postRepository.findAll();

        if (!posts.isEmpty()) {
            System.out.println("********** POSTLAR **********");
            for (Post post : posts) {
                System.out.println("Başlık...: " +post.getTitle());
                System.out.println("Aciklama...: " +post.getPostcomment());
                System.out.println("Paylaşım Tarihi...: " +post.getShareddate());
                System.out.println("Resim...: " +post.getImageurl());
                System.out.println("Beğeni Sayısı...: " +post.getLikeCount());
                System.out.println("Yorum Sayısı...: " +post.getCommentCount());
            }
        } else {
            System.out.println("Henüz post bulunmamaktadır.");
        }
    }
}
