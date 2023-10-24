from flask import Flask
app=Flask(__name__)
@app.route('/')
def hello_world():
    return 'Hello World!'

@app.route('/dojo')
def dojo():
    return 'Dojo!'

@app.route('/say/<hello>')
def say(hello):
    return f'HI {hello}!'

@app.route('/say/<hello>/<int:num>')
def hello(hello,num):
    return f'HI {hello*num}!'

@app.route('/say/<string:hello>/<int:num>')
def string(hello,num):
    return f'HI {hello*num}!'

@app.route('/say/<int:hello>/<string:num>')
def inte(hello,num):
    return f'HI {hello*num}!'

@app.route('/<path:invalid_url>')
def invalid_route(invalid_url):
    return "Sorry! No response. Try again."

if __name__ == '__main__':
    app.run(debug=True)