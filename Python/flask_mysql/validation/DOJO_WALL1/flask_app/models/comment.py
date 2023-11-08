from flask_app.config.mysqlconnetions import connectToMySQL
from flask import flash
import re


DB="dojo_wall"
class Comment:
    def __init__(self, data):
        self.id = data['id']
        self.content = data['content']
        self.post = data['post']
        self.user = data['user']

    @classmethod
    def save (cls, data):
        print("data passed into create METHOD: ")
        query='''insert into comments(content, user_id, post_id) values(%(content)s, %(user_id)s, %(post_id)s);'''
        return connectToMySQL(DB).query_db(query, data)
    
    # @classmethod
    # def get_all(cls):
    #     query='''SELECT * FROM posts
    #         JOIN users on posts.user_id = users.id
    #         LEFT JOIN comments on posts.id = comments.post_id
    #         LEFT JOIN users as comment_users on comments.user_id = comment_users.id'''
    #     print("in get all method")
    #     results=connectToMySQL(DB).query_db(query)
    #     # print(">>>>>>>>>" , results)
    #     all_results=[]
    #     for result in results:
    #         posting_user=User({
    #             "id": result["users.id"],
    #             "first_name": result["first_name"],
    #             "last_name": result["last_name"],
    #             "email": result["email"],
    #             "password": result["password"],
    #             "created_at": result["created_at"],
    #             "updated_at": result["updated_at"]
    #         })
    #         new_post= Post({
    #             "id": result["id"],
    #             "content": result["content"],
    #             "created_at": result["created_at"],
    #             "updated_at": result["updated_at"],
    #             "user": posting_user
    #         })
    #         new_comment= Comment({
    #             "id": result["id"],
    #             "content": result["content"],
    #             "created_at": result["created_at"],
    #             "updated_at": result["updated_at"],
    #             "user": posting_user,
    #             "post": new_post

    #         })

    #         all_results.append(new_comment)
    #     return all_results