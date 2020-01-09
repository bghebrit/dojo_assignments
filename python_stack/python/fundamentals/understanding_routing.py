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

@app.route('/repeat/<times>/<sname>')
def reapeat(times, sname):
    stimes = int(times)
    for i in range(stimes):
        return (sname)        
if __name__ == "__main__":
    app.run(debug = True)
