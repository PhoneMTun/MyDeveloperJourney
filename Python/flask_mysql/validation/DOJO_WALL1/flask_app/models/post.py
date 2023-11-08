from flask_app.config.mysqlconnetions import connectToMySQL
from flask import flash
from flask_app.models.user import User
from flask_app.models.comment import Comment

DB="dojo_wall"
class Post:
    def __init__(self, data):
        self.id = data['id']
        self.content = data['content']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']
        self.user= data['user']
        self.comments= []

    @classmethod
    def save (cls, data):
        print("data passed into create METHOD: ")
        query='''insert into posts(content, user_id) values(%(content)s, %(user_id)s);'''
        return connectToMySQL(DB).query_db(query, data)
    
    @classmethod
    def delete (cls, post_id):
        query='''DELETE FROM posts WHERE id = %(id)s;'''
        return connectToMySQL(DB).query_db(query, {"id": post_id})
    
    # @classmethod
    # def get_all(cls):
    #     query='''select * from posts
    #     join users on posts.user_id=users.id'''
    #     print("in get all method")
    #     results=connectToMySQL(DB).query_db(query)
    #     print(">>>>>>>>>" , results)
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
    #         all_results.append(new_post)
    #     return all_results


    @classmethod

    def get_all(cls):
        query='''SELECT * FROM posts
            JOIN users on posts.user_id = users.id
            LEFT JOIN comments on posts.id = comments.post_id
            LEFT JOIN users as comment_users on comments.user_id = comment_users.id'''
        print("in get all method")
        results=connectToMySQL(DB).query_db(query)
        print(">>>>>>>>>" , results)
        all_posts = {}
        for result in results:

            if result["id"] not in all_posts:
                posting_user = User({
                    "id": result["users.id"],
                    "first_name": result["first_name"],
                    "last_name": result["last_name"],
                    "email": result["email"],
                    "password": result["password"],
                    "created_at": result["created_at"],
                    "updated_at": result["updated_at"]
                })
                post = Post({
                    "id": result["id"],
                    "content": result["content"],
                    "created_at": result["created_at"],
                    "updated_at": result["updated_at"],
                    "user": posting_user
                })
                all_posts[result["id"]] = post

            if result["comments.id"]:
                comment_user = User({
                    "id": result["comment_users.id"],
                    "first_name": result["comment_users.first_name"],
                    "last_name": result["comment_users.last_name"],
                    "email": result["comment_users.email"],
                    "password": result["comment_users.password"],
                    "created_at": result["comment_users.created_at"],
                    "updated_at": result["comment_users.updated_at"]
                })

                comment = Comment({
                    "id": result["comments.id"],
                    "content": result["comments.content"],
                    "created_at": result["comments.created_at"],
                    "updated_at": result["comments.updated_at"],
                    "user": comment_user,
                    "post": all_posts[result["id"]]
                })

                all_posts[result["id"]].comments.append(comment)

        return list(all_posts.values())
    

    @staticmethod
    def validate_post(post):
        is_valid = True
        if len(post['content'])<1:
            flash("Post cant be empty", "post")
            is_valid = False
        return is_valid