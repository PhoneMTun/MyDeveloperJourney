from flask import render_template, request,redirect
from flask_app import app
from flask_app.models.author import Author
from flask_app.models.book import Book

@app.route('/books')
def books():
    return render_template('books.html', books=Book.get_all())

@app.route('/create/book', methods=['POST'])
def add_book():
    print(request.form)
    Book.add_book(request.form)
    return redirect ('/books')

@app.route('/books/<int:id>')
def show_book(id):
    data={'id': id}
    return render_template('book_show.html', book=Book.get_by_id(data), unfavorited_authors=Author.unfavorited_authors(data))

@app.route('/join/author', methods=['POST'])
def join_author():
    print(request.form)
    Author.add_favorites(request.form)
    return redirect (f'/books/{request.form["book_id"]}')