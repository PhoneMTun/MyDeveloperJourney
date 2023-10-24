from flask_app.config.mysqlconnections import connectToMySQL
from flask_app.models import book
class Author:
    def __init__(self, data):
        self.id = data['id']
        self.name = data['name']
        self.favourite_books=[]
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']
        self.favorite_books=[]

    @classmethod
    def get_all(cls):
        query="SELECT * from authors;"
        results= connectToMySQL('books_schema').query_db(query)
        authors=[]
        for author in results:
            authors.append(cls(author))
        return authors
    
    @classmethod
    def add_author(cls, data):
        query="INSERT INTO authors(name) values (%(name)s);"
        return connectToMySQL('books_schema').query_db(query,data)

    @classmethod
    def unfavorited_authors(cls,data):
        query = "SELECT * FROM authors WHERE authors.id NOT IN ( SELECT author_id FROM favorites WHERE book_id = %(id)s );"
        authors = []
        
        results = connectToMySQL('books_schema').query_db(query,data)
        for row in results:
            authors.append(cls(row))
        return authors
    
    @classmethod
    def add_favorites(cls, data):
        query= "INSERT INTO favorites(author_id, book_id) values (%(author_id)s,%(book_id)s);"
        return connectToMySQL('books_schema').query_db(query,data)
    

    @classmethod
    def get_by_id(cls,data):
        query = "SELECT * FROM authors LEFT JOIN favorites ON authors.id = favorites.author_id LEFT JOIN books ON books.id = favorites.book_id WHERE authors.id = %(id)s;"
        results = connectToMySQL('books_schema').query_db(query,data)

        author = cls(results[0])

        for row in results:
            if row['books.id'] == None:
                break
            data = {
                "id": row['books.id'],
                "title": row['title'],
                "num_of_pages": row['num_of_pages'],
                "created_at": row['books.created_at'],
                "updated_at": row['books.updated_at']
            }
            author.favorite_books.append(book.Book(data))
        return author
