from flask import Flask, render_template
app = Flask(__name__)
@app.route('/')
def hello():
    return render_template('index.html', times = 3)

@app.route('/play/<times>')
def boxes(times):
    times = int(times)
    return render_template('index.html', times=times , color='blue')


@app.route('/play/<times>/<color>')
def beautifull(times, color):
    times = int(times)
    return render_template('index.html', times=times, color= 'color')
if __name__ == '__main__':
    app.run(debug =True) 