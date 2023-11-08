from flask import render_template,redirect,session,request, flash
from flask_app import app
from flask_app.models.post import Post

@app.route('/posts',  methods=["POST"]) 
def create_post():
    if not Post.validate_post(request.form):
        print("faile posting")
        return redirect ("/welcome")
    print("in create route")
    print(request.form)
    Post.save(request.form)
    return redirect ("/welcome")


@app.route ('/posts/delete/<post_id>')
def delete_post(post_id):
    print("Deleting post-", post_id)
    Post.delete(post_id)
    return redirect ("/welcome")

