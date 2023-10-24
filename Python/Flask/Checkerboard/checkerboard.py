from flask import Flask,render_template

app=Flask(__name__)

@app.route('/')
def noraml():
    return render_template('index.html',row=8,col=8)

@app.route('/<int:x>')
def row(x):
    return render_template('index.html',row=x,col=8)

@app.route('/<int:x>/<int:y>')
def col(x,y):
    return render_template('index.html',row=x,col=y)

@app.route('/<int:x>/<int:y>/<string:color1>/<string:color2>')
def colors(x,y,color1='red',color2='blue'):
    return render_template('index.html',row=x,col=y, color1=color1, color2=color2)


# @app.route('/<int:x>')
# def noraml(x):
#     return render_template('index.html')

if __name__ == '__main__':
    app.run(debug=True)