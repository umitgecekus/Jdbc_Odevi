package com.umit.repository;

import com.umit.entity.Post;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PostRepository {
    private CRUD crud;
    public PostRepository(){
        crud = new CRUD();
    }
    private String sql;
    private ResultSet resultSet;
    public boolean save(Post entity) {
        sql = "insert into tblpost (userid,title,postcomment,shareddate,imageurl,likecount,commentcount) " +
                "values('"+entity.getUserid()
                +"','"+entity.getTitle()
                +"','"+entity.getPostcomment()
                +"','"+entity.getShareddate()
                +"','"+entity.getImageurl()
                +"','"+entity.getLikeCount()
                +"','"+entity.getCommentCount()+"')";
        crud.executeUpdate(sql);
        return true;
    }
    public boolean update(Post entity) {
        crud.executeUpdate(sql);
        return true;
    }

    public boolean delete(Long id) {
        crud.executeUpdate(sql);
        return true;
    }
    public List<Post> findAll() {
        sql = "select * from tblpost";
        resultSet = crud.getAllTableRows(sql);
        List<Post> postList = new ArrayList<>();
        try{
            while (resultSet.next()){
                Long id = resultSet.getLong("id");
                Long userid= resultSet.getLong("userid");
                String title = resultSet.getString("title");
                String postcomment = resultSet.getString("postcomment");
                long shareddate = resultSet.getLong("shareddate");
                String imageurl = resultSet.getString("imageurl");
                int likecount = resultSet.getInt("likecount");
                int commentcount = resultSet.getInt("commentcount");
                Post user = new Post(id,userid,title,postcomment,shareddate,imageurl,likecount,commentcount);
                postList.add(user);
            }
            return postList;
        }catch (Exception exception){
            return postList;
        }
    }

}
