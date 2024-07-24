// index.js
const express = require('express');
const bodyParser = require('body-parser');

const app = express();
const port = 3003;

app.use(bodyParser.json());


let bins = [];


app.post('/bins', (req, res) => {
    const bin = req.body;
    bins.push(bin);
    res.status(201).send(bin);
})

app.get('/bins', (req, res) => {
    res.send(bins);
})

app.


app.listen(port, () => {
    console.log(`Server is running on http://localhost:${port}`);
});