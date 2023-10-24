from flask import render_template, request,redirect
from flask_app import app
from flask_app.models.author import Author
from flask_app.models.book import Book


@app.route('/')
def index():
    return redirect('/authors')

@app.route('/authors')
def authors():
    return render_template('authors.html', authors=Author.get_all())

@app.route('/create/author', methods=['POST'])
def add_author():
    print(request.form)
    Author.add_author(request.form)
    return redirect ('/authors')

@app.route('/authors/<int:id>')
def show_author(id):
    data={'id': id}
    return render_template('author_show.html', author=Author.get_by_id(data), unfavorited_books=Book.unfavorited_books(data))


@app.route('/join/book', methods=['POST'])
def join_book():
    print(request.form)
    Author.add_favorites(request.form)
    return redirect (f'/authors/{request.form["author_id"]}')