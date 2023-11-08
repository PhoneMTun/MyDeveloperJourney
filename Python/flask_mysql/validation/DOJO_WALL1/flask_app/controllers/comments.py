from flask import render_template,redirect,session,request, flash
from flask_app import app
from flask_app.models.comment import Comment

@app.route('/posts/<post_id>/comments',  methods=["POST"]) 
def create_comment(post_id):
    print("in create route")
    print("xxxxxxxxxxxxxxxxxxxxxxx",request.form, post_id)
    data = {
        "content": request.form['content'],
        "user_id": session['user_id'],
        "post_id": post_id
    }
    Comment.save(data)
    return redirect ("/welcome")