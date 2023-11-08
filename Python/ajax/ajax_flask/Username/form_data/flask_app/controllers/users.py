from flask_app.models.user import User
from flask_app import app
from flask import render_template, jsonify, request, redirect
from flask import jsonify
from flask_app import app

@app.route('/')
def index():
    return render_template('index.html')


@app.route('/users')
def users():
    return jsonify(User.get_all_json())



@app.route('/get_data')
def get_data():
    return jsonify(message="Hello World")


@app.route('/create/user',methods=['POST'])
def create_user():
    print(request.form)
    # write code to save it to our database . . .
    return jsonify(message="Add a user!!!")


