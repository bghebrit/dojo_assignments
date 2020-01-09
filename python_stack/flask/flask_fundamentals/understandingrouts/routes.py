from flask import Flask
app = Flask(__name__)

@app.route('/')
def hello():
    return 'Hello World!!'

@app.route('/dojo')
def dojo():
    return 'Dojo'
# @app.route('/<name>')
# def say(name):
#     return ('{}'.format(name))

@app.route('/repeat/<times>/<name>')
def repeat(times , name):
    times = int(times)
    for i in range(times):
        return (name)      

if __name__ == "__main__":
    app.run(debug = True)
